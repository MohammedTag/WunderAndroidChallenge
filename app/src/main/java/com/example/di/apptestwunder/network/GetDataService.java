package com.example.di.apptestwunder.network;


import com.example.di.apptestwunder.model.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface GetDataService {
    @GET("cars.json")
    Call<List<Vehicle>> getInforData();

    @GET("cars/{car_id}")
    Call<Vehicle> getVehicleDetails(@Path("car_id") String carID);

}
