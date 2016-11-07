package com.example.abhi.mcassignment4;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Abhi on 01-11-2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    Context context;
    public MyAdapter(Context context){
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row,parent,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Item item = MainActivity.itemList.get(position);
        holder.itemTitle.setText(item.getTitle());
        holder.itemView.setOnClickListener(new MyOnClickListener(position, context));
        //holder.itemDesc.setText(item.getDetails());
    }

    @Override
    public int getItemCount() {
        return MainActivity.itemList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView itemTitle;/* itemDesc;*/
        public MyViewHolder(View itemView) {
            super(itemView);
            itemTitle = (TextView)itemView.findViewById(R.id.ItemTitleTextView);
            //itemDesc = (TextView)itemView.findViewById(R.id.ItemDescTextView);
        }
    }

}
