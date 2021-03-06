package uk.ac.shef.oak.com4510.model.sensors;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.text.DateFormat;
import java.util.Date;

import uk.ac.shef.oak.com4510.view.activities.Main2Activity;

public class LocationService extends IntentService {
    private Location mCurrentLocation;
    private String mLastUpdateTime;

    public LocationService(String name) {
        super(name);
    }

    public LocationService() {
        super("Location Intent");
    }

    /**
     * called when a location is recognised
     *
     * @param intent
     */
    @Override
    protected void onHandleIntent(Intent intent) {
        if (LocationResult.hasResult(intent)) {
            LocationResult locResults = LocationResult.extractResult(intent);
            if (locResults != null) {
                for (Location location : locResults.getLocations()) {
                    if (location == null) continue;
                    //do something with the location
                    Log.i("New Location", "Current location: " + location);
                    mCurrentLocation = location;
                    mLastUpdateTime = DateFormat.getTimeInstance().format(new Date());
                    Log.i("MAP", "new location " + mCurrentLocation.toString());
                    // check if the activity has not been closed in the meantime
                    if (Main2Activity.getActivity()!=null)
                        // any modification of the user interface must be done on the UI Thread. The Intent Service is running
                        // in its own thread, so it cannot communicate with the UI.
                        Main2Activity.getActivity().runOnUiThread(new Runnable() {
                            public void run() {
                                try {

                                    if (Main2Activity.getMap() != null)
                                        Main2Activity.getMap().addMarker(new MarkerOptions().
                                                position(new LatLng(mCurrentLocation.getLatitude(),
                                                        mCurrentLocation.getLongitude()))
                                                .title(mLastUpdateTime));
                                    CameraUpdate zoom = CameraUpdateFactory.zoomTo(15);
                                    // it centres the camera around the new location
                                    Main2Activity.getMap().moveCamera(CameraUpdateFactory.newLatLng(new LatLng(mCurrentLocation.getLatitude(), mCurrentLocation.getLongitude())));
                                    // it moves the camera to the selected zoom
                                    Main2Activity.getMap().animateCamera(zoom);
                                } catch (Exception e ){
                                    Log.e("LocationService", "Error cannot write on map "+e.getMessage());
                                }
                            }
                        });
                }
            }

        }
    }
}

