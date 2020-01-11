package com.example.assignment.wunder.models;

import com.example.assignment.wunder.network.ApiUtil;
import com.example.assignment.wunder.presenters.car_info_presenter.CarInfoViewListeners;

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


    public void getCarsinfo(String carID) {
        ApiUtil.getDataService().getVehicleDetails(carID).enqueue(this);

    }

    @Override
    public void onResponse(Call<Vehicle> call, Response<Vehicle> response) {
        listener.onCarInfoSuccess(call, response);
    }

    @Override
    public void onFailure(Call<Vehicle> call, Throwable t) {
        listener.onCarInfoFailed(call, t);
    }
}
