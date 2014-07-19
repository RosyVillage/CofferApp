package com.qingye.adapter;

import java.util.ArrayList;
import java.util.HashMap;

import com.qingye.coffer.R;
import com.qingye.utility.ImageLoader;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CofferListAdapter extends BaseAdapter {

	private Activity activity;
	private ArrayList< HashMap<String, String> > data;
	private static LayoutInflater inflater = null;
	public ImageLoader imageLoader;
	

	
	public CofferListAdapter(Activity a, ArrayList<HashMap<String, String>> d){
		activity = a;
		data = d;
		inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		imageLoader = new ImageLoader(activity.getApplicationContext());
		
	}
	@Override
	public int getCount() {
		
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		
		return position;
	}

	@Override
	public long getItemId(int position) {
		
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		View vi = convertView;
		if(convertView == null)
		{
			
			vi = inflater.inflate(R.layout.coffer_list_row, null);
		}
		
		TextView title = (TextView) vi.findViewById(R.id.coffer_title);
		TextView people = (TextView) vi.findViewById(R.id.coffer_people);
		TextView time = (TextView) vi.findViewById(R.id.coffer_time);
		ImageView thumb_image = (ImageView) vi.findViewById(R.id.coffer_list_image);
		
		HashMap<String, String> coffer = new HashMap<String, String>();
		coffer = data.get(position);//get the current coffer
		
		title.setText(coffer.get("title"));
		people.setText(coffer.get("artist"));
		time.setText(coffer.get("duration"));
		imageLoader.DisplayImage(coffer.get("thumb_url"), thumb_image);
		
        return vi;
		
	}

}
