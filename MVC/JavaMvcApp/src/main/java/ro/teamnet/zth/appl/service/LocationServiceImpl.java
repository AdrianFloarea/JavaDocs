package ro.teamnet.zth.appl.service;

import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.util.List;

/**
 * Created by FFA on 16.07.2016.
 */
public class LocationServiceImpl implements LocationService {
    LocationDao locationDao=new LocationDao();

    @Override
    public List<Location> findAllLocations() {
        return locationDao.getAllLocations();
    }
}
