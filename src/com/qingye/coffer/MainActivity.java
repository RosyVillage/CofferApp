package com.qingye.coffer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.facebook.Session;
import com.facebook.Session.StatusCallback;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

public class MainActivity extends Activity {
	

	private boolean isResumed = false;
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
	
	//track the sessiona and trigger a session state change listener
	private UiLifecycleHelper uiHelper;
	private Session.StatusCallback callback = 
			new StatusCallback() {
				
				@Override
				public void call(Session session, SessionState state, Exception exception) {
			
					onSessionStateChange(session, state, exception);					
				}
			};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		uiHelper = new UiLifecycleHelper(this, callback);
		uiHelper.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

		
	}

	
	private void onSessionStateChange(Session session, SessionState state, Exception exception)
	{
		//This is where we use the flag variable isResumed
		if(isResumed){
			
			if(state.isOpened()){
				//If the session state is open
				//Show the authenticated fragment
				//showFragment(SELECTION, false);
				Intent intent = new Intent(this, SelectionActivity.class);
				intent.putExtra(EXTRA_MESSAGE, "Hello");
				startActivity(intent);
			} else if(state.isClosed()){
				//If the session staet is close;
				//Show the login fragemtn
				//showFragment(LOGIN, false);
			}
		}
	}
	
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		uiHelper.onResume();
		
		//set the isResumed to track the state of the app
		isResumed = true;
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		
		uiHelper.onPause();
		
		//set the isResumed to track the state of the app
		isResumed = false;
	}
	


	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		uiHelper.onActivityResult(requestCode, resultCode, data);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		uiHelper.onDestroy();
	}
	
	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		uiHelper.onSaveInstanceState(outState);
	}
}
