package com.android.renly.healingmvp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import static android.content.ContentValues.TAG;

public class MainActivity extends Activity {

    @BindView(R.id.water)
    LinearLayout water;
    @BindView(R.id.waterman)
    LinearLayout waterman;
    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        TestOkHttp();
        TestRetrofit();
    }


    private void TestRetrofit() {
        // 初始化okhttp
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(9, TimeUnit.SECONDS) // 设置连续超时9s
                .readTimeout(10, TimeUnit.SECONDS) // 设置读取超时10s
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NetConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        APi mApi = retrofit.create(APi.class);
//        retrofit2.Call<ResponseBody> call = mApi.doLogin("1147158321@qq.com", "zl11471583210");
//        call.enqueue(new retrofit2.Callback<ResponseBody>() {
//            @Override
//            public void onResponse(retrofit2.Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
//                Log.e("print","onResponse");
//                try {
//                    tv.setText(response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(retrofit2.Call<ResponseBody> call, Throwable t) {
//                Log.e("print","onFailure " + t.getMessage());
//            }
//        });

//        retrofit.create(APi.class)
        mApi
                .doLogin("1147158321@qq.com", "zl11471583210")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBody -> tv.setText(responseBody.string()), throwable -> Log.e("print",throwable.getMessage()));
    }

    private String post() throws IOException {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(NetConfig.REQUEST_URL)
                .get()
                .build();
        // 同步
        Response response = client.newCall(request).execute();
//         异步，此方法不适合异步
//        Response response = client.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(Call call, IOException e) {
//                Log.e(TAG,"getResponse fail " + e.getMessage());
//            }
//
//            @Override
//            public void onResponse(Call call, Response response) throws IOException {
//                Log.e(TAG,"getResponse success " + response.body().string());
//            }
//        });
        return response.body().string();
    }

    private void TestOkHttp() {
        Observable.create((ObservableOnSubscribe<String>) emitter -> emitter.onNext(post()))
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(String s) {
                        tv.setText(s);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @OnClick({R.id.water, R.id.waterman})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.water:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.waterman:
                break;
        }
    }
}
