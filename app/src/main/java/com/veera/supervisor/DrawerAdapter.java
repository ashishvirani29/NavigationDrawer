package com.veera.supervisor;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DrawerAdapter extends Adapter<DrawerAdapter.ViewHolder> {
    private static final String TAG = "DrawerAdapter";
    private Activity activity;
    private LayoutInflater inflater;
    private int currentPos = -1;
    private callbackListener<Integer, String, String, String> mSingleCallback;

    public DrawerAdapter(Activity c) {
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.activity = c;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.drawer_list_row, parent, false));
    }

    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txtMenuName.setText(Constant.menuName[position] + "");

        if (position == currentPos) {
            holder.txtMenuName.setTextColor(activity.getResources().getColor(R.color.colorAccent));
            Glide.with(activity).load(Constant.menuIconSelected[position]).centerCrop().into(holder.imgMenuIcon);
        } else {
            Glide.with(activity).load(Constant.menuIcon[position]).centerCrop().into(holder.imgMenuIcon);
            holder.txtMenuName.setTextColor(activity.getResources().getColor(R.color.text_color));
        }

        holder.main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentPos = position;
                notifyDataSetChanged();
                mSingleCallback.onClickCallBack(position, "", "", "");
            }
        });

    }

    public int getItemCount() {
        return Constant.menuName.length;
    }

    public void setItemClickCallback(final callbackListener singleCallback) {
        this.mSingleCallback = singleCallback;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenuIcon;
        TextView txtMenuName;
        LinearLayout main;

        ViewHolder(View view) {
            super(view);
            imgMenuIcon=view.findViewById(R.id.imgMenuIcon);
            txtMenuName=view.findViewById(R.id.txtMenuName);
            main=view.findViewById(R.id.main);
        }
    }
}
