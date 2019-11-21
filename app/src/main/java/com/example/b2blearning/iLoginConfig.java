package com.example.b2blearning;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import retrofit2.http.POST;
import retrofit2.http.Query;


//Creating interface to communicate with server.
public interface iLoginConfig {
    @POST("/api/users/login")
    Call<User> directions(@Query("email") String email, @Query("password") String password);
    //Call<User>getUser(@Path("login?email=cicrano@interncommerce.com&password=654321")String user);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://abi-bus-api.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}


