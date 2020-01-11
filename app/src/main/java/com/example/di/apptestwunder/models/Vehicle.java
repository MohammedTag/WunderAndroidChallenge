package com.example.di.apptestwunder.model;

import com.google.gson.annotations.SerializedName;

public class Vehicle {



    @SerializedName("carId")
    private Integer carId = 0;
    @SerializedName("address")
    private String address = "";
    @SerializedName("lat")
    private double lat ;
    @SerializedName("lon")
    private double lon ;
    @SerializedName("fuelLevel")
    private int fuelLevel;
    @SerializedName("title")
    private String title = "";
    @SerializedName("isClean")
    private Boolean isClean;
    @SerializedName("isDamaged")
    private Boolean isDamaged;
    @SerializedName("licencePlate")
    private String licencePlate = "";
    @SerializedName("vehicleStateId")
    private Integer vehicleStateId = 0;
    @SerializedName("hardwareId")
    private String hardwareId = "";
    @SerializedName("vehicleTypeId")
    private Integer vehicleTypeId = 0;
    @SerializedName("pricingTime")
    private String pricingTime = "";
    @SerializedName("pricingParking")
    private String pricingParking = "";
    @SerializedName("isActivatedByHardware")
    private Boolean isActivatedByHardware;
    @SerializedName("locationId")
    private Integer locationId = 0;
    @SerializedName("zipCode")
    private String zipCode = "";
    @SerializedName("city")
    private String city = "";
    @SerializedName("reservationState")
    private Integer reservationState = 0;
    @SerializedName("damageDescription")
    private String damageDescription = "";
    @SerializedName("vehicleTypeImageUrl")
    private String vehicleTypeImageUrl = "";



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }


    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }
}
