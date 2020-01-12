package com.example.assignment.wunder.network;

public class ApiUtil {

    public static final String BASE_URL =  "https://s3.eu-central-1.amazonaws.com/wunderfleet-recruiting-dev/";

    public static GetDataService getDataService(){
        return RetrofitInstance.getClient(BASE_URL).create(GetDataService.class);
    }
}
