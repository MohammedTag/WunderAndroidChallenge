package com.example.di.apptestwunder.views.map_view;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.di.apptestwunder.R;
import com.example.di.apptestwunder.models.Vehicle;
import com.example.di.apptestwunder.presenters.map_presenter.MapViewPresenter;
import com.example.di.apptestwunder.utils.Util;
import com.example.di.apptestwunder.views.car_details_view.MainActivity;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.HashMap;
import java.util.List;

import retrofit2.Response;


public class MapsFragmentActivity extends AppCompatActivity implements OnMapReadyCallback, mapView {

    private static final int REQUEST_ACCESS_COARSE_LOCATION = 1;
    private GoogleMap mMap;

    private MapViewPresenter presenter;

    boolean doubleBackToExitPressedOnce = false;

    private HashMap<String, Integer> CarIdentifier = new HashMap<String, Integer>();

    double currentLongitude;
    double currentLatitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        presenter = new MapViewPresenter(this);

        initView();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);


        mMap.setOnMyLocationButtonClickListener(new GoogleMap.OnMyLocationButtonClickListener() {
            @Override
            public boolean onMyLocationButtonClick() {

                LatLng latLng = new LatLng(currentLatitude, currentLongitude);

                MarkerOptions marker2 = new MarkerOptions();

                marker2.position(latLng);
                mMap.addMarker(marker2);
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 14f));

                return false;
            }
        });

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                onMarkerClickLogic(marker);
                return true;
            }
        });

    }

    private void onMarkerClickLogic(Marker marker) {

        if (doubleBackToExitPressedOnce) {
             String title = marker.getTitle();
            Integer carId = CarIdentifier.get(title);
            Intent carDetailsIntent = new Intent(this, MainActivity.class);
            carDetailsIntent.putExtra("CAR_ID", carId);
            this.startActivity(carDetailsIntent);
        } else {

            this.doubleBackToExitPressedOnce = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 5000);
            marker.showInfoWindow();
        }

    }

    private void setMarkerSelected(Vehicle i) {
        MarkerOptions marker2 = new MarkerOptions();
        marker2.title(i.getTitle());
        marker2.snippet(i.getAddress());
        LatLng x = new LatLng(i.getLat(), i.getLon());
        marker2.position(x);
        mMap.addMarker(marker2).showInfoWindow();
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_ACCESS_COARSE_LOCATION) {
            int grantResultsLength = grantResults.length;
            if (grantResultsLength > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "Permission Granted. Please click button again to continue.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "Permission denied.", Toast.LENGTH_LONG).show();
            }
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    void initView() {
        if (Util.isNetworkAvailable(this)) {
            presenter.getCarsFeed();
        } else {
            Toast.makeText(this, "No connection", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void showSuccess(retrofit2.Call<List<Vehicle>> call, Response<List<Vehicle>> response) {
        List<Vehicle> vehicles = response.body();

        MarkerOptions marker = new MarkerOptions();

        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getTitle() != null) {
                marker.title(vehicles.get(i).getTitle());
            }
            if (vehicles.get(i).getAddress() != null) {
                marker.snippet(vehicles.get(i).getCarId().toString());
            }
            if (vehicles.get(i).getLat() != null && vehicles.get(i).getLon() != null) {
                marker.position(new LatLng(vehicles.get(i).getLat(), vehicles.get(i).getLon()));
            }
            mMap.addMarker(marker);

            CarIdentifier.put(marker.getTitle(), vehicles.get(i).getCarId());

        }

        for (int i = 0; i < vehicles.size(); i++) {

            setMarkerSelected(vehicles.get(i));
        }

    }

    @Override
    public void showError(retrofit2.Call<List<Vehicle>> call, Throwable t) {
        Toast.makeText(this, "Get list repo failed", Toast.LENGTH_SHORT).show();
    }
}
