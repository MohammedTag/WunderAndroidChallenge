package com.example.di.apptestwunder.network;


import com.example.di.apptestwunder.models.RentCarBody;
import com.example.di.apptestwunder.models.RentCarModel;
import com.example.di.apptestwunder.models.RentedVehicleModel;
import com.example.di.apptestwunder.models.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;


public interface GetDataService {
    @GET("cars.json")
    Call<List<Vehicle>> getInforData();

    @GET("cars/{car_id}")
    Call<Vehicle> getVehicleDetails(@Path("car_id") String carID);

    @POST("default/wunderfleet-recruiting-mobile-dev-quick-rental")
    Call<RentedVehicleModel> rentCar(@Body RentCarBody rentCarBody, @Header("Authorization") String authorization);
}
