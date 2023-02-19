package ru.ecole39.ext.api;

import android.content.Context;
import android.util.Log;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.ecole39.ext.api.models.requests.PasswordAuthRequest;
import ru.ecole39.ext.api.models.requests.RefreshTokenRequest;
import ru.ecole39.ext.api.models.responses.AuthResponse;
import ru.ecole39.ext.api.retrofit.APIService;
import ru.ecole39.ext.api.storage.StorageManager;
import ru.ecole39.ext.api.utils.Utils;

public class ApiImpl {
    public final static String API_ENDPOINT = "http://192.168.1.64:8080/api/";

    protected final Context context;
    protected final OkHttpClient client;
    protected final APIService apiService;
    protected StorageManager storageManager;

    protected String systemId;

    public ApiImpl(Context context) {
        this.context = context;
        this.storageManager = new StorageManager(context);

        client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request original = chain.request();

            // Настраиваем запросы
            Request request = original.newBuilder()
                    .header("Accept", "application/json")
                    .header("Authorization", "Bearer " + storageManager.getAccessToken())
                    .method(original.method(), original.body())
                    .build();

            Response response = chain.proceed(request);

            if(response.code() == 401) {
                if(!refreshToken()) {
                    Log.e("APIService", "Failed to refresh tokens");
                }
            }

            return response;
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(API_ENDPOINT)
                .build();

        this.apiService = retrofit.create(APIService.class);
    }

    public String getSystemId() {
        if(this.systemId == null) {
            this.systemId = Utils.getSystemId(this.context);
        }

        return this.systemId;
    }

    protected boolean refreshToken() {
        RefreshTokenRequest refreshTokenRequest = new RefreshTokenRequest(
                getSystemId(),
                storageManager.getRefreshToken()
        );

        AuthResponse authResponse;
        try {
            authResponse = apiService.refreshToken(refreshTokenRequest).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        storageManager
                .putRefreshToken(authResponse.refreshToken)
                .putAccessToken(authResponse.accessToken);

        return true;
    }

    public AuthResponse login(String username, String password) {
        PasswordAuthRequest passwordAuthRequest = new PasswordAuthRequest(
                getSystemId(),
                username,
                password
        );

        AuthResponse authResponse;
        try {
            authResponse = apiService.login(passwordAuthRequest).execute().body();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return authResponse;
    }

    public APIService getApiService() {
        return apiService;
    }
}
