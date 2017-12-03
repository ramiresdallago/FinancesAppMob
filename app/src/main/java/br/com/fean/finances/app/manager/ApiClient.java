package br.com.fean.finances.app.manager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://10.0.0.10:9090/FinancesApp/rest/";

    private static Retrofit retrofitGson = null;
    private static Retrofit retrofitJackson = null;

    public static Retrofit getClientWithGson() {
        if (retrofitGson == null) {
            retrofitGson = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitGson;
    }

    public static Retrofit getClientWithJackson() {
        if (retrofitJackson == null) {
            retrofitJackson = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();
        }
        return retrofitJackson;
    }

}
