package com.xealot.cordova.plugin.android.referrer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

// import android.util.Log;

public class Receiver extends BroadcastReceiver {

    private static final String REFERRER = "referrer";

    @Override
    public void onReceive (Context context, Intent intent) {

        Bundle extras = intent.getExtras();
        if ( extras != null ) {
            String referrerString = extras.getString( REFERRER );
            if ( referrerString != null ) {
                SharedPreferences sharedPreferences = context.getSharedPreferences( REFERRER, Context.MODE_PRIVATE );

    	        Editor edit = sharedPreferences.edit();
    	        edit.putString( REFERRER, referrerString );
    	        edit.commit();

                // Log.i( REFERRER, "RECEIVER DEBUG: " + referrerString );
            }
        }
    }
} //: Receiver
