package com.example.assignment.wunder.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Mohammed Sayed Taguldeen on 11,January,2020
 * Cairo, Egypt.
 */
public class RentedVehicleModel {
    @SerializedName("carId")
    private int carId = 0;
    @SerializedName("cost")
    private int cost = 0;
    @SerializedName("reservationId")
    private int reservationId = 0;
    @SerializedName("drivenDistance")
    private int drivenDistance = 0;
    @SerializedName("licencePlate")
    private String licencePlate = "";
    @SerializedName("startAddress")
    private String startAddress = "";
    @SerializedName("userId")
    private int userId = 0;
    @SerializedName("isParkModeEnabled")
    private Boolean isParkModeEnabled;
    @SerializedName("damageDescription")
    private String damageDescription = "";
    @SerializedName("fuelCardPin")
    private String fuelCardPin = "";
    @SerializedName("endTime")
    private int endTime = 0;
    @SerializedName("startTime")
    private int startTime = 0;

}
