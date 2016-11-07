package com.example.abhi.mcassignment4;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddItemActivity extends AppCompatActivity {

    final View.OnClickListener addItemButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String itemTitle = ((EditText)findViewById(R.id.ItemEditText)).getText().toString();
            String itemDesc = ((EditText)findViewById(R.id.ItemDescEditText)).getText().toString();
            if(!itemDesc.isEmpty() && !itemTitle.isEmpty()){
                Item item = new Item(itemDesc, itemTitle);
                MainActivity.itemList.add(item);
                Toast.makeText(getApplicationContext(),"Item added", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"Enter both title and description", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        Toolbar addItemToolbar = (Toolbar) findViewById(R.id.addItem_toolbar);
        setSupportActionBar(addItemToolbar);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        Button addButton = (Button)findViewById(R.id.AddItemButton);
        addButton.setOnClickListener(addItemButtonListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_item_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

}
