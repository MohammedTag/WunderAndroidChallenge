package com.example.di.apptestwunder.views.car_details_view;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.di.apptestwunder.R;
import com.example.di.apptestwunder.models.RentedVehicleModel;
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

    private Integer carId;

    ImageView CarImage;
    TextView carIdTv, titleTv, cleanStatusTv, damageStatusTv, licenseTv, fuelLevelTv, vehicleStateIdTv,
            hardwareIdTv, vehicleTypeIdTv, pricingTimeTv, pricingParkingTv,
            isActivatedByHardwareTv, locationIdTv, addressTv, zipCodeTv, cityTv, latTv, lonTv, reservationStateTv, damageDescriptionTv;
    Button rentCarActionBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* CarImage = findViewById(R.id.car_id);*/
        carIdTv = findViewById(R.id.car_Identifire);
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


        rentCarActionBtn = findViewById(R.id.rent_car_button);


        presenter = new CarInfoViewPresenter(this);

        mDialog = new ProgressDialog(this);
        mDialog.setMessage("Loading Data...");
        mDialog.setCancelable(false);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setIndeterminate(true);
        mDialog.show();

        Intent it = getIntent();
        carId = it.getIntExtra("CAR_ID", 1);

        rentCarActionBtn.setText("Rent Car");
        rentCarActionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.rentCar(carId);
            }
        });
        initView();
    }

    void initView() {
        if (Util.isNetworkAvailable(this)) {
            presenter.getCarsDetails(carId.toString());
        } else {
            Toast.makeText(this, "No connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onCarInfoSuccess(Call<Vehicle> call, Response<Vehicle> response) {

        if (response.isSuccessful() && response.body() != null) {


//            carIdTv.setText(response.body().getCarId());
            titleTv.setText(response.body().getTitle());
            cleanStatusTv.setText(String.valueOf(response.body().getClean()));
            damageStatusTv.setText(String.valueOf(response.body().getDamaged()));
            licenseTv.setText(response.body().getLicencePlate());
//            fuelLevelTv.setText(response.body().getFuelLevel());
//            vehicleStateIdTv.setText(response.body().getVehicleStateId());
            hardwareIdTv.setText(response.body().getHardwareId());
//            vehicleTypeIdTv.setText(response.body().getVehicleTypeId());
            pricingTimeTv.setText(response.body().getPricingTime());
            pricingParkingTv.setText(response.body().getPricingParking());
            isActivatedByHardwareTv.setText(String.valueOf(response.body().getActivatedByHardware()));
//            locationIdTv.setText(response.body().getLocationId());
            addressTv.setText(response.body().getAddress());
            zipCodeTv.setText(response.body().getZipCode());
            cityTv.setText(response.body().getCity());
            latTv.setText(String.valueOf(response.body().getLat()));
            lonTv.setText(String.valueOf(response.body().getLon()));
            reservationStateTv.setText(String.valueOf(response.body().getReservationState()));
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
    public void onRentCarSuccess(Call<RentedVehicleModel> call, Response<RentedVehicleModel> response) {
        if (response.isSuccessful() && response.body() != null) {
            Toast.makeText(this, "Car Has Been Rented Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRentCarFailed(Call<RentedVehicleModel> call, Throwable t) {
        Toast.makeText(this, "Couldn't rent car", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
