package com.example.di.apptestwunder.models;

import android.util.Log;

import com.example.di.apptestwunder.network.ApiUtil;
import com.example.di.apptestwunder.presenters.map_presenter.mapViewListeners;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MapModel implements Callback<List<Vehicle>> {

    private mapViewListeners listener;

    public MapModel(mapViewListeners listener) {
        this.listener = listener;
    }


    public void getCarsFeed(){
        ApiUtil.getDataService().getInforData().enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
        Log.wtf("URL Called Model", call.request().url() + "");
        listener.onCarsFeedSuccess(call, response);
    }

    @Override
    public void onFailure(Call<List<Vehicle>> call, Throwable t) {
        listener.onCarsFeedFailed(call, t);
    }
}
