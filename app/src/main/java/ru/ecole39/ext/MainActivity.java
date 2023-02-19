package ru.ecole39.ext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import ru.ecole39.ext.api.ApiImpl;
import ru.ecole39.ext.api.models.requests.PasswordAuthRequest;
import ru.ecole39.ext.api.models.responses.User;

public class MainActivity extends AppCompatActivity {
    ApiImpl api;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        api = new ApiImpl(this);

        new Thread() {
            @Override
            public void run() {
                User user = api.login("Зайцев", "dnR`e!2B43").user;
                System.out.println(user.name);
            }
        }.start();


    }
}