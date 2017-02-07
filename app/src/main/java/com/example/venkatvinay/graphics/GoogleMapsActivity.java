package com.example.venkatvinay.graphics;

import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by Venkat Vinay on 7/3/2016.
 */
public class GoogleMapsActivity extends AppCompatActivity implements LocationListener {
    private GoogleMap googleMap;
    double latitude = 17.4242;
    double longitude = 78.4346;
    double lat = 17;
    double lng = 80;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_demo);
        if (googleMap == null) {
            googleMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
        }
        LocationManager locationManager = (LocationManager)
                getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Location location = locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
        double latitude1 = location.getLatitude();
        double longitude2 = location.getLongitude();
        googleMap.setMyLocationEnabled(true);
        LatLng ll=new LatLng(latitude, longitude);
        LatLng l2=new LatLng(lat, lng);
        LatLng latLng=new LatLng(latitude1,longitude2);
        MarkerOptions marker = new MarkerOptions().position(ll).title("Sec,");
        MarkerOptions marker1 = new MarkerOptions().position(l2).title("my,");
        MarkerOptions marker2 = new MarkerOptions().position(latLng).title("my22,");

        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
        marker1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
        //marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.ball_left_pink));
        googleMap.addMarker(marker);
        googleMap.addMarker(marker1);
        googleMap.addMarker(marker2);

        CameraPosition cameraPosition = new CameraPosition.Builder().target(ll).zoom(3).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
       // googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
    }


    @Override
    public void onLocationChanged(Location location) {
        lat = location.getLatitude();
        lng = location.getLongitude();
    }
}
