package com.example.di.apptestwunder.view.car_details_view;

import com.example.di.apptestwunder.model.Vehicle;
import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Mohammed Sayed Taguldeen on 11,January,2020
 * Cairo, Egypt.
 */
public interface CarDetailsView {
    void onCarInfoSuccess(Call<Vehicle> call, Response<Vehicle> response);
    void onCarInfoFailed(Call<Vehicle> call, Throwable t);


}
