package pl.edu.ug.inf.am.gps;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;
import pl.edu.ug.inf.am.game.dagger.PerGame;

import javax.inject.Inject;

@PerGame
public class GPS {

    private final LocationManager locationManager;
    private final LocationListener locationListener;
    private final Context context;
    private boolean running;
    private GPSListener listener;

    @Inject
    public GPS(final Context context) {
        this.context = context;
        locationManager = (LocationManager) this.context.getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {

            @Override
            public void onLocationChanged(Location location) {
                if (listener != null) {
                    listener.onLocationChanged(location);
                }
                Toast.makeText(context, "Gps onLocationChanged " + location.toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Toast.makeText(context, "Gps onStatusChanged ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderEnabled(String provider) {
                Toast.makeText(context, "Gps onProviderEnabled ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderDisabled(String provider) {
                Toast.makeText(context, "Gps onProviderDisabled ", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public void stop() throws CantUseGPSException{
        checkIfGpsEnabled();
        try {
            locationManager.removeUpdates(locationListener);
            running = false;
        }catch (SecurityException e){
            throw new CantUseGPSException();
        }
    }

    public void start() throws CantUseGPSException {
        checkIfGpsEnabled();
        try {
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
            running = true;
        }catch (SecurityException e){
            throw new CantUseGPSException();
        }
    }

    public void setListener(GPSListener listener) {
        this.listener = listener;
    }

    public boolean isRunning() {
        return running;
    }

    private void checkIfGpsEnabled() throws CantUseGPSException {
        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            throw new CantUseGPSException();
        }
    }

    public interface GPSListener {
        void onLocationChanged(Location location);
    }
}
