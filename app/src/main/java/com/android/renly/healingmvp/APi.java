package com.android.renly.healingmvp;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APi {

    @POST("login")
    Call<ResponseBody> doLogin(@Path("email") String email, @Path("password") String password);
}
