package com.example.di.apptestwunder.views.car_details_view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.di.apptestwunder.R;
import com.example.di.apptestwunder.models.Vehicle;
import com.example.di.apptestwunder.presenters.car_info_presenter.CarInfoViewPresenter;
import com.example.di.apptestwunder.utils.Util;

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

    private ImageView CarImage;
    private TextView carIdTv;
    private TextView titleTv;
    private TextView cleanStatusTv;
    private TextView damageStatusTv;
    private TextView licenseTv;
    private TextView fuelLevelTv;
    private TextView vehicleStateIdTv;
    private TextView hardwareIdTv;
    private TextView vehicleTypeIdTv;
    private TextView pricingTimeTv;
    private TextView pricingParkingTv;
    private TextView isActivatedByHardwareTv;
    private TextView locationIdTv;
    private TextView addressTv;
    private TextView zipCodeTv;
    private TextView cityTv;
    private TextView latTv;
    private TextView lonTv;
    private TextView reservationStateTv;
    private TextView damageDescriptionTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* CarImage = findViewById(R.id.car_id);*/
        carIdTv = findViewById(R.id.car_id);
        titleTv = findViewById(R.id.title);
        cleanStatusTv = findViewById(R.id.clean_status);
        damageStatusTv = findViewById(R.id.damage_status);
        licenseTv = findViewById(R.id.license);
        fuelLevelTv = findViewById(R.id.fuel_level);
        vehicleStateIdTv = findViewById(R.id.vehicle_state_id);
        hardwareIdTv = findViewById(R.id.hardware_id);
        vehicleTypeIdTv = findViewById(R.id.vehicle_type_Id);
        pricingTimeTv = findViewById(R.id.pricing_time);
        pricingParkingTv = findViewById(R.id.pricing_parking);
        isActivatedByHardwareTv = findViewById(R.id.is_activated_by_hardware);
        locationIdTv = findViewById(R.id.location_id);
        addressTv = findViewById(R.id.address);
        zipCodeTv = findViewById(R.id.zip_code);
        cityTv = findViewById(R.id.city);
        latTv = findViewById(R.id.lat);
        lonTv = findViewById(R.id.lon);
        reservationStateTv = findViewById(R.id.reservationState);
        damageDescriptionTv = findViewById(R.id.damageDescription);


        presenter = new CarInfoViewPresenter(this);

        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading Data...");
        mDialog.setCancelable(false);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setIndeterminate(true);
        mDialog.show();

        Intent it = getIntent();
        carId = it.getStringExtra("CAR_ID");
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

        if (response.isSuccessful() && response.body() != null) {
            carIdTv.setText(response.body().getCarId());
            titleTv.setText(response.body().getTitle());
            cleanStatusTv.setText(response.body().getClean().toString());
            damageStatusTv.setText(response.body().getDamaged().toString());
            licenseTv.setText(response.body().getLicencePlate());
            fuelLevelTv.setText(response.body().getFuelLevel());
            vehicleStateIdTv.setText(response.body().getVehicleStateId());
            hardwareIdTv.setText(response.body().getHardwareId());
            vehicleTypeIdTv.setText(response.body().getVehicleTypeId());
            pricingTimeTv.setText(response.body().getPricingTime());
            pricingParkingTv.setText(response.body().getPricingParking());
            isActivatedByHardwareTv.setText(response.body().getActivatedByHardware().toString());
            locationIdTv.setText(response.body().getLocationId());
            addressTv.setText(response.body().getAddress());
            zipCodeTv.setText(response.body().getZipCode());
            cityTv.setText(response.body().getCity());
            latTv.setText(response.body().getLat().toString());
            lonTv.setText(response.body().getLon().toString());
            reservationStateTv.setText(response.body().getReservationState().toString());
            damageDescriptionTv.setText(response.body().getDamageDescription());

        }

        mDialog.dismiss();
    }

    @Override
    public void onCarInfoFailed(Call<Vehicle> call, Throwable t) {
        mDialog.dismiss();
        Toast.makeText(this, "Get list repo failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
