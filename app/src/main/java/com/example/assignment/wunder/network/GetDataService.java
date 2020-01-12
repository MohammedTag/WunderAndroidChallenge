package com.example.assignment.wunder.network;


import com.example.assignment.wunder.models.RentCarBody;
import com.example.assignment.wunder.models.RentedVehicleModel;
import com.example.assignment.wunder.models.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface GetDataService {
    @GET("cars.json")
    Call<List<Vehicle>> getInforData();

    @GET("cars/{car_id}")
    Call<Vehicle> getVehicleDetails(@Path("car_id") String carID);

    @POST("default/wunderfleet-recruiting-mobile-dev-quick-rental")
    @Headers({"Authorization: Bearer df7c313b47b7ef87c64c0f5f5cebd6086bbb0fa"})
    Call<RentedVehicleModel> rentCar(@Body RentCarBody rentCarBody);
}
