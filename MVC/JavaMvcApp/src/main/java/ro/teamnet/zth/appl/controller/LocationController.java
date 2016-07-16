package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.domain.Location;
import ro.teamnet.zth.appl.service.LocationService;
import ro.teamnet.zth.appl.service.LocationServiceImpl;

import java.util.List;

/**
 * Created by user on 7/14/2016.
 */
@MyController(urlPath = "/locations")
public class LocationController {
    LocationService locationService=new LocationServiceImpl();

    @MyRequestMethod(urlPath = "/all")
    public List<Location> getAllLocations(){
        return locationService.findAllLocations();
    }

    @MyRequestMethod(urlPath = "/one")
    public String getOneLocation(){
        return "oneRandomLocation";
    }
}
