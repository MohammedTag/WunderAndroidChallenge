package com.example.di.apptestwunder.view.car_details_view;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.di.apptestwunder.R;
import com.example.di.apptestwunder.adapter.VehiclesListAdapter;
import com.example.di.apptestwunder.model.Vehicle;
import com.example.di.apptestwunder.presenter.car_info_presenter.CarInfoViewPresenter;
import com.example.di.apptestwunder.presenter.map_presenter.MapViewPresenter;
import com.example.di.apptestwunder.util.Util;
import com.example.di.apptestwunder.view.map_view.mapView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by Mohammed Sayed Taguldeen on 11,January,2020
 * Cairo, Egypt.
 */
public class MainActivity extends AppCompatActivity implements CarDetailsView {

    private ProgressDialog mDialog;
    private CarInfoViewPresenter presenter;

    private String carId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new CarInfoViewPresenter(this);

        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading Data...");
        mDialog.setCancelable(false);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setIndeterminate(true);
        mDialog.show();

        Intent it = getIntent();
        carId = it.getStringExtra ( "CAR_ID" );
        initView();
    }

    void initView() {
        if (Util.isNetworkAvailable(this)) {
            presenter.getCarsDetails(carId);
        } else {
            Toast.makeText(this, "No connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCarInfoSuccess(Call<Vehicle> call, Response<Vehicle> response) {

        response.body();
        mDialog.dismiss();
    }

    @Override
    public void onCarInfoFailed(Call<Vehicle> call, Throwable t) {
        Toast.makeText(this, "Get list repo failed", Toast.LENGTH_SHORT).show();
    }
}
