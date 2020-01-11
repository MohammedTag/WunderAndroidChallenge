package com.example.di.apptestwunder.presenter.car_info_presenter;

import com.example.di.apptestwunder.model.CarDetailsModel;
import com.example.di.apptestwunder.model.Vehicle;
import com.example.di.apptestwunder.view.car_details_view.CarDetailsView;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Mohammed Sayed Taguldeen on 11,January,2020
 * Cairo, Egypt.
 */
public class CarInfoViewPresenter implements CarInfoViewListeners {

    private CarDetailsView view;
    private CarDetailsModel model;

    public CarInfoViewPresenter(CarDetailsView view) {
        this.view = view;
        model = new CarDetailsModel(this);

    }

    public void getCarsDetails(String carID){
        model.getCarsinfo(carID);
    }

    @Override
    public void onCarInfoSuccess(Call<Vehicle> call, Response<Vehicle> response) {
        
    }

    @Override
    public void onCarInfoFailed(Call<Vehicle> call, Throwable t) {

    }
}
