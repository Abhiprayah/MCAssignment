package com.example.abhi.mcassignment4;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Created by Abhi on 01-11-2016.
 */

public class ItemList extends  ArrayList<Item>{
    RecyclerView.Adapter recyclerAdapter;
    public void setRecycler(RecyclerView.Adapter recyclerAdapter){
        this.recyclerAdapter = recyclerAdapter;
    }

    @Override
    public boolean add(Item item) {
        boolean result = super.add(item);
        recyclerAdapter.notifyDataSetChanged();
        return result;
    }
}
