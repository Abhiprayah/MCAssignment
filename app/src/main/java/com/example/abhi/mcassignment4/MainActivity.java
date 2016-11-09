package com.example.abhi.mcassignment4;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StringReader;

public class MainActivity extends AppCompatActivity {

    private final static String FILE_NAME = "itemList";
    public static ItemList itemList = new ItemList();
    public static int position=0;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;



    public void save(){
        FileOutputStream outputStream;
        try{
            outputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(itemList);
            objectOutputStream.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void startViewActivity(){
        final Intent intent = new Intent(getApplicationContext(), ViewItemDetailsActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        try {
            FileInputStream inputStream = openFileInput(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            itemList = (ItemList) objectInputStream.readObject();
            objectInputStream.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }

        recyclerView = (RecyclerView) findViewById(R.id.ItemListRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyAdapter(this);
        recyclerView.setAdapter(adapter);
        itemList.setRecycler(adapter);
        itemList.setActivity(this);
        recyclerView.smoothScrollToPosition(position);
        Log.d("f","Inside OnCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addItem:
                final Intent intent = new Intent(getApplicationContext(), AddItemActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /*
    final RecyclerView.OnItemTouchListener itemTouchListener = new RecyclerView.OnItemTouchListener() {
        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
            View child = rv.findChildViewUnder(e.getX(),e.getY());
            if(child != null){
                //Toast.makeText(getApplicationContext(),"Touched : " + rv.getChildAdapterPosition(child),Toast.LENGTH_SHORT).show();
                //position = rv.getChildAdapterPosition(child);
                //final Intent intent = new Intent(getApplicationContext(), ViewItemDetailsActivity.class);
                //startActivity(intent);
                //Log.d("f","ViewActivity Startet");
            }
            Log.d("f","Inside onInterceptTouchEvent");
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {
            Log.d("f","Inside onTouchEvent");
        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
            Log.d("f","Inside onRequestDisallowInterceptTouchEvent");
        }
    };
    */
}
