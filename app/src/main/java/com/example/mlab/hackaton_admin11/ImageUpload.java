package com.example.mlab.hackaton_admin11;

/**
 * Created by mlab on 8/25/2017.
 */

public class ImageUpload {

    //Data members
    public String placeName;
    public  String placeInfo;
    public String placeAddress;
    public   String placeCell;
    public   String placeHours;
    public   String placeWebsite;
    public  String placeLongitude;
    public  String placeLatitude;
    private String urI;


    public ImageUpload() {

    }

    public ImageUpload(String placeName, String placeInfo, String placeAddress, String placeCell, String placeHours, String placeWebsite, String placeLongitude, String placeLatitude, String urI) {

        this.placeName = placeName;
        this.placeInfo = placeInfo;
        this.placeAddress = placeAddress;
        this.placeCell = placeCell;
        this.placeHours = placeHours;
        this.placeWebsite = placeWebsite;
        this.placeLongitude = placeLongitude;
        this.placeLatitude = placeLatitude;
        this.urI = urI;
    }

    //getters
    public String getPlaceName() {
        return placeName;
    }


    public String getUrI() {
        return urI;
    }




}
