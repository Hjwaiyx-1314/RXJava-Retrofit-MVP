package api;

import com.example.administrator.rx.BuildConfig;

import java.util.concurrent.TimeUnit;

import api.converter.FastJsonConverterFactory;
import api.converter.StringConverterFactory;
import api.interceptor.LoggingInterceptor;
import base.BaseUrl;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;

/**
 * Created by hjw on 2018/8/8 0008.
 * 邮箱：786567342@qq.com
 * 电话：13221002723
 */

public class ApiManager {

    private static ApiSevers getSyncBean;

    public static ApiSevers getBean() {
        if (getSyncBean == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(BaseUrl.SYNCURL)
                    .addConverterFactory(FastJsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            getSyncBean = retrofit.create(ApiSevers.class);
        }

        return getSyncBean;
    }


    private static ApiSevers getPhone;

    public static ApiSevers getPhone() {
        if (getPhone == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .client(getClient())
                    .baseUrl(BaseUrl.PHONE)
                    .addConverterFactory(StringConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            getPhone = retrofit.create(ApiSevers.class);
        }

        return getPhone;
    }



    //构造client
    private static OkHttpClient getClient() {
        OkHttpClient.Builder client = new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            client.addInterceptor(new LoggingInterceptor());
        }
        return client.build();
    }
}
