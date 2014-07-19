package com.qingye.drawerfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qingye.coffer.R;
import com.qingye.tabFragment.cofferListFragment;
import com.qingye.tabFragment.mapFragment;


public class PhotosFragment extends Fragment {

	public PhotosFragment(){}
	private FragmentTabHost mTabHost;
	private View view;
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
		if(view!=null){
			ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);

            
			
		}
		
			
			view = inflater.inflate(R.layout.fragment_photos, container, false);
		
			mTabHost = (FragmentTabHost) view.findViewById(R.id.tabhost);
			mTabHost.setup(getActivity(), getChildFragmentManager(), R.id.tabcontent);
			mTabHost.addTab(mTabHost.newTabSpec("Coffer List").setIndicator("Coffer List"),
	                cofferListFragment.class, null);
			mTabHost.addTab(mTabHost.newTabSpec("Map View").setIndicator("Map View"),
	                mapFragment.class, null);
			
		

		
         
	       return view;
    }
		
	
	
}
