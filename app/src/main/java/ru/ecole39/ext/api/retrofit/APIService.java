package ru.ecole39.ext.api.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.ecole39.ext.api.models.requests.PasswordAuthRequest;
import ru.ecole39.ext.api.models.requests.RefreshTokenRequest;
import ru.ecole39.ext.api.models.responses.AuthResponse;
import ru.ecole39.ext.api.models.responses.DiaryDay;
import ru.ecole39.ext.api.models.responses.JournalDay;

public interface APIService {
    @POST("auth")
    Call<AuthResponse> login(@Body PasswordAuthRequest passwordAuthRequest);

    @POST("auth")
    Call<AuthResponse> refreshToken(@Body RefreshTokenRequest refreshTokenRequest);

    @GET("get_student_diary")
    Call<DiaryDay[]> getStudentDiary(@Query("from_date") String fromDate);

    @GET("get_student_diary")
    Call<DiaryDay[]> getStudentDiary(@Query("from_date") String fromDate, @Query("to_date") String toDate);

    @GET("get_student_journal_data")
    Call<JournalDay[]> getStudentJournalData();
}
