package com.android.renly.healingmvp;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APi {
    @GET("comments")
    Call<List<Comment>> getComments();

    @POST("login")
    Call<ResponseBody> doLogin(@Query("email") String email, @Query("password") String password);
}
