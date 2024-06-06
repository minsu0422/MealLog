package com.example.meallog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // Base URL을 설정합니다.
    String BASE_URL = "http://api.nongsaro.go.kr/";

    @GET("service/recomendDiet/mainCategoryList")
    Call<MainCategoryResponse> getMainCategoryList(
            @Query("key") String apiKey
    );

    @GET("service/recomendDiet/recomendDietList")
    Call<DietListResponse> getDietList(
            @Query("key") String apiKey,
            @Query("dietSeCode") String dietSeCode
    );

    @GET("service/recomendDiet/recomendDietDtl")
    Call<DietDetailResponse> getDietDetail(
            @Query("key") String apiKey,
            @Query("cntntsNo") String cntntsNo
    );
}

