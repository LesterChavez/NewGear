package com.example.tysonlove.newgear;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;


public class ListViewAdapter extends ArrayAdapter {
    private Context context;
    private ArrayList<ProductsActivity> use;

    public ListViewAdapter(Context context, int textViewResourceId, ArrayList objects) {
        super(context, textViewResourceId, objects);

        this.context = context;
        use = objects;

    }

    private class ViewHolder {
        TextView Rod ;
        TextView Reel;
        TextView Lures;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.listviewlayout, null);

            holder = new ViewHolder();
            holder.Rod = (TextView) convertView.findViewById(R.id.textView);
            holder.Reel = (TextView) convertView.findViewById(R.id.textView2);
            holder.Lures = (TextView) convertView.findViewById(R.id.textView3);

            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ProductsActivity individualUser = use.get(position);
        holder.Rod.setText(individualUser.getRodeONe() + "");
        holder.Reel.setText(individualUser.getReelOne());
        holder.Lures.setText(individualUser.getLureOne());

        return convertView;


    }
}