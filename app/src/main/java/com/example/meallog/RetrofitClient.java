package com.example.meallog;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.nongsaro.go.kr/";

    // Retrofit 인스턴스를 반환하는 정적 메서드
    public static Retrofit getRetrofitInstance() {
        // retrofit 객체가 아직 생성되지 않았다면 생성
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
