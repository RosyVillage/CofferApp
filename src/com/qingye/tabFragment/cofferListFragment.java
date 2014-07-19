package com.qingye.tabFragment;



import java.util.ArrayList;
import java.util.HashMap;

import com.qingye.adapter.CofferListAdapter;
import com.qingye.coffer.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class cofferListFragment extends Fragment {
	ListView list;
	CofferListAdapter adapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.coffer_list_fragment, container,false);
		
		ArrayList<HashMap<String, String>> cofferList = new ArrayList<HashMap<String,String>>();
		
		
		for(int i = 0;i<100;i++){
			HashMap<String, String> map = new HashMap<String, String>();
			if(i%2==0){
			
			map.put("id", "1");
			map.put("title", "Someone Like You");
			map.put("artist", "Adele");
			map.put("duration","4:47");
			map.put("thumb_url", "http://api.androidhive.info/music/images/adele.png");
			
		
			}
			else{
				map.put("id", "2");
				map.put("title", "Space Bound");
				map.put("artist", "Eminem");
				map.put("duration","4:38");
				map.put("thumb_url", "http://api.androidhive.info/music/images/eminem.png");
				
			}
			cofferList.add(map);
		}
		
		list = (ListView)  rootView.findViewById(R.id.coffer_list);
		adapter = new CofferListAdapter(getActivity(), cofferList);
		list.setAdapter(adapter);
		
		list.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
			                long id) {
			        }
		});
		
		return rootView;
	}

}
