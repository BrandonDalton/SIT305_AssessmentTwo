package com.example.sit305_assessmenttwo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class item_listAdapter extends ArrayAdapter<item> {

    private LayoutInflater customLayout;
    private ArrayList<item> items;
    private int viewID;

    public item_listAdapter(Context context, int id, ArrayList<item> items) {
        super(context, id, items);
        this.items = items;
        customLayout = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        viewID = id;
    }

    public View getView(int position, View convertView, ViewGroup parents) {
        convertView = customLayout.inflate(viewID, null);

        item item = items.get(position);

        if (item != null) {
            TextView itemName = convertView.findViewById(R.id.textItemName);
            TextView brandName = convertView.findViewById(R.id.textBrand);
            TextView stockName = convertView.findViewById(R.id.textStock);

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
        return convertView;
    }
}
