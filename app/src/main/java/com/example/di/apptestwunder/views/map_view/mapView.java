package com.example.di.apptestwunder.view.map_view;

import com.example.di.apptestwunder.model.Vehicle;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;


public interface mapView {
    void showSuccess(Call<List<Vehicle>> call, Response<List<Vehicle>> response);
    void showError(Call<List<Vehicle>> call, Throwable t);
}
