package com.qingye.tabFragment;


import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.qingye.coffer.R;

/*I met this problem when importing the Google Map API based on the
  official instruction. It seemed to conflict with the Facebook API and in the
  library of the build path, I could not see the Google Play jar.
  I manually imported it in the sdk folder. However, It still did not work.
  The thing is I cannot adopt class like GoogleMap.
  
  However, next morning when I opened the Eclipse, I found everything works again...
  do not know how. I also follow the instruction to change the path of the support v4 jar...
  http://stackoverflow.com/questions/19419112/cant-import-facebook-sdk-conflicting-with-google-play-services
*/

public class mapFragment extends Fragment {
	private GoogleMap map;
	
	private LocationManager mLocationManager;
	private boolean isNetworkEnabled;
	private final int Location_Refresh_Time = 10;
	private final int Location_Refresh_Distance = 10;
	

	
	//private GoogleMap map;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.maptabfragment,container, false);
		

		//map = getActivity().getS  ((SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		map =   ((SupportMapFragment) getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).getMap();//((SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map)).getMap();
	
		
		
		/*set up the Location Manager so that we can track the change of the location
		notice this bunch of method and funcitons aboout location are totally different from 
	    google gms*/
		
		mLocationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
		Location currentLocation = mLocationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		double latitude = currentLocation.getLatitude();
		double longitude = currentLocation.getLongitude();
		map.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).alpha(0.7f).snippet("Current Location").flat(true).title("Irvine"));
				
		
		//isNetworkEnabled = mLocationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
		
		//set up the listener for the Map
		mLocationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, Location_Refresh_Time, Location_Refresh_Distance,mLocationListener);
		
		return rootView;
	}
	
	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
		if (map != null) {
		        getActivity().getSupportFragmentManager().beginTransaction()
		            .remove(getActivity().getSupportFragmentManager().findFragmentById(R.id.map)).commit();
		        map = null;
		    }
	}
	
	private final LocationListener mLocationListener = new LocationListener() {
	    @Override
	    public void onLocationChanged(final Location location) {
	        //your code here
	    }
	    public void onStatusChanged(String provider, int status, Bundle extras) {};
	    public void onProviderDisabled(String provider) {};
	    public void onProviderEnabled(String provider) {};
	};

}
