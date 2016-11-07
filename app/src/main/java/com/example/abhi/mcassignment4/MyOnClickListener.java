package com.example.abhi.mcassignment4;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/**
 * Created by Abhi on 02-11-2016.
 */

public class MyOnClickListener implements View.OnClickListener {
    int position;
    Context context;
    @Override
    public void onClick(View view) {
        Log.d("f","Clicked at position : " + position);
        MainActivity.position = position;
        ((MainActivity)context).startViewActivity();
    }

    public MyOnClickListener(int position, Context context){
        this.position = position;
        this.context = context;
    }
}
