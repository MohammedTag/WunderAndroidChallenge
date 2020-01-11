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
public class RentCarModel implements Callback<RentedVehicleModel> {

        private CarInfoViewListeners listener;

        public RentCarModel(CarInfoViewListeners listener) {
            this.listener = listener;
        }


        public void getRentCar(Integer carID) {

            RentCarBody rentCarBody = new RentCarBody();
            rentCarBody.setCarId(carID);
            ApiUtil.getDataService().rentCar(rentCarBody,"Bearer df7c313b47b7ef87c64c0f5f5cebd6086bbb0fa").enqueue(this);

        }

        @Override
        public void onResponse(Call<RentedVehicleModel> call, Response<RentedVehicleModel> response) {
            listener.onRentCarSuccess(call, response);
        }

        @Override
        public void onFailure(Call<RentedVehicleModel> call, Throwable t) {
            listener.onRentCarFailed(call, t);
        }
    }
