package com.example.assignment.wunder.models;

import android.util.Log;

import com.example.assignment.wunder.network.ApiUtil;
import com.example.assignment.wunder.presenters.map_presenter.mapViewListeners;


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
