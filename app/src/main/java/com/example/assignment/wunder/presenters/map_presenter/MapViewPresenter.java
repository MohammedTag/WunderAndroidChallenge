package com.example.assignment.wunder.presenters.map_presenter;



import com.example.assignment.wunder.models.MapModel;
import com.example.assignment.wunder.models.Vehicle;
import com.example.assignment.wunder.views.map_view.mapView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;


public class MapViewPresenter implements mapViewListeners {
    private mapView view;
    private MapModel model;

    public MapViewPresenter(mapView view) {
        this.view = view;
        model = new MapModel(this);

    }

    public void getCarsFeed(){
        model.getCarsFeed();
    }

    @Override
    public void onCarsFeedSuccess(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
        view.showSuccess(call, response);
    }

    @Override
    public void onCarsFeedFailed(Call<List<Vehicle>> call, Throwable t) {
        view.showError(call, t);
    }
}
