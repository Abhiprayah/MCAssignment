package com.example.abhi.mcassignment4;

import android.support.v7.widget.RecyclerView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Abhi on 01-11-2016.
 */

public class ItemList extends  ArrayList<Item> implements Serializable{
    transient RecyclerView.Adapter recyclerAdapter;
    transient MainActivity context;
    public void setRecycler(RecyclerView.Adapter recyclerAdapter){
        this.recyclerAdapter = recyclerAdapter;
    }

    public void setActivity(MainActivity activity){
        context = activity;
    }

    @Override
    public boolean add(Item item) {
        boolean result = super.add(item);
        recyclerAdapter.notifyDataSetChanged();
        context.save();
        return result;
    }
}
