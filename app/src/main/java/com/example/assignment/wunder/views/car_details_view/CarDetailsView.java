package com.example.assignment.wunder.views.car_details_view;

import com.example.assignment.wunder.models.RentedVehicleModel;
import com.example.assignment.wunder.models.Vehicle;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Mohammed Sayed Taguldeen on 11,January,2020
 * Cairo, Egypt.
 */
public interface CarDetailsView {
    void onCarInfoSuccess(Call<Vehicle> call, Response<Vehicle> response);
    void onCarInfoFailed(Call<Vehicle> call, Throwable t);

    void onRentCarSuccess(Call<RentedVehicleModel> call, Response<RentedVehicleModel> response);
    void onRentCarFailed(Call<RentedVehicleModel> call, Throwable t);

}
