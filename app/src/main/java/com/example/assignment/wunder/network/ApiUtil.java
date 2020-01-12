package com.example.assignment.wunder.network;

public class ApiUtil {

    public static final String BASE_URL = "https://s3.eu-central-1.amazonaws.com/wunderfleet-recruiting-dev/";
    public static final String RENT_CAR_END_POINT = "https://4i96gtjfia.execute-api.eu-central-1.amazonaws.com/default/wunderfleet-recruiting-mobile-dev-quick-rental";
    public static GetDataService getDataService() {
        return RetrofitInstance.getClient(BASE_URL).create(GetDataService.class);
    }
}
