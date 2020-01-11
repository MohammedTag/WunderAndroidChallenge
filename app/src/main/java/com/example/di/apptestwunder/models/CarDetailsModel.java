package com.example.di.apptestwunder.models;

import com.example.di.apptestwunder.network.ApiUtil;
import com.example.di.apptestwunder.presenters.car_info_presenter.CarInfoViewListeners;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mohammed Sayed Taguldeen on 11,January,2020
 * Cairo, Egypt.
 */
public class CarDetailsModel implements Callback<Vehicle> {

    private CarInfoViewListeners listener;

    public CarDetailsModel(CarInfoViewListeners listener) {
        this.listener = listener;
    }


    public void getCarsinfo(String carID){
        ApiUtil.getDataService().getVehicleDetails(carID).enqueue(this);

    }
    @Override
    public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {

    }

    @Override
    public void onFailure(Call<Vehicle> call, Throwable t) {

    }
}
