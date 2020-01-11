package com.example.di.apptestwunder.presenters.car_info_presenter;

import com.example.di.apptestwunder.models.RentedVehicleModel;
import com.example.di.apptestwunder.models.Vehicle;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Mohammed Sayed Taguldeen on 11,January,2020
 * Cairo, Egypt.
 */
public interface CarInfoViewListeners {
    void onCarInfoSuccess(Call<Vehicle> call, Response<Vehicle> response);
    void onCarInfoFailed(Call<Vehicle> call, Throwable t);

    void onRentCarSuccess(Call<RentedVehicleModel> call, Response<RentedVehicleModel> response);
    void onRentCarFailed(Call<RentedVehicleModel> call, Throwable t);
}
