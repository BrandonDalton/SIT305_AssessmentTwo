package com.example.sit305_assessmenttwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class itemListViewAdapter extends ArrayAdapter<item> {
    //Custom Layout Variable
    private LayoutInflater customLayout;
    private ArrayList<item> items;
    private int viewID;

    public itemListViewAdapter(Context context, int id, ArrayList<item> items) {
        super(context, id, items);
        this.items = items;
        customLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewID = id;
    }

    public View getView(int position, View convertView, ViewGroup parents) {
        //Gets View And Inflates Our Custom View To It
        convertView = customLayout.inflate(viewID, null);
        //Get The Position of the Item
        item item = items.get(position);
        //If There Is An Item
        if (item != null) {
            //Place Values Into UI
            TextView itemName = convertView.findViewById(R.id.textItemName);
            TextView brandName = convertView.findViewById(R.id.textBrand);
            TextView stockName = convertView.findViewById(R.id.textStock);
            //Gets The Values and Sets The Text
            if (itemName != null) {
                itemName.setText((item.getName()));
            }
            if (itemName != null) {
                brandName.setText((item.getBrand()));
            }
            if (itemName != null) {
                stockName.setText((item.getStock()));
            }
        }
        //Returns The Custom View
        return convertView;
    }
}
