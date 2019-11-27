package com.example.b2blearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private EditText emailView;
    private EditText passwordView;
    private boolean check;
    public static final int request = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailView = findViewById(R.id.login);
        passwordView = findViewById(R.id.password);



        //Instantiating login button.
        Button login = (Button)findViewById(R.id.loginBtn);

        //Enabling button click and it's functionality.
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                iLoginConfig login = iLoginConfig.retrofit.create(iLoginConfig.class);

                String email = emailView.getText().toString();
                String password = passwordView.getText().toString();
                check = Utility.loginCheck(email, password, getBaseContext());


                if(check){
                    login.directions(email, password).enqueue(new Callback<User>() {
                        @Override
                        public void onResponse(Call<User> call, Response<User> response) {

                            int code = response.code();
                            if (code == 200) {
                                User user = response.body();
                                String name = user.name;
                                Toast.makeText(getBaseContext(), "Login response " + code + ": Successful! Welcome", Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(v.getContext(), HomeActivity.class);
                                intent.putExtra("User_Name", name);
                                startActivity(intent);
                                //startActivity(intent);
                                //intent.putExtra("User_Name", String.valueOf(name));

                            } else {
                                Toast.makeText(getBaseContext(), "Login response : Error " + code + ", incorrect credentials", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<User> call, Throwable t) {
                            Toast.makeText(getBaseContext(), "Error " + t.getMessage(), Toast.LENGTH_LONG).show();

                        }
                    });

                }

            }

        });
    }
}