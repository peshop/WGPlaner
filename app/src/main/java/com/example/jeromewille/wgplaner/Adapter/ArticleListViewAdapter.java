package com.example.jeromewille.wgplaner.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.graphics.ColorUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.jeromewille.wgplaner.Classes.DataStructure.Article;
import com.example.jeromewille.wgplaner.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by jeromewille on 05.12.2017.
 */

public class ArticleListViewAdapter extends ArrayAdapter<Article> {

    private List<Boolean> checkedItems;


    public ArticleListViewAdapter(@NonNull Context context, int resource, @NonNull List<Article> objects) {
        super(context, resource, objects);

        this.checkedItems = new ArrayList<>(Arrays.asList(new Boolean[objects.size()]));
        Collections.fill(this.checkedItems, false);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());

        if (convertView == null)
            convertView = inflater.inflate(R.layout.benotigte_sachen_list_view_item, parent, false);


        final View contentRow;
        contentRow = convertView;



        TextView tvname = (TextView) convertView.findViewById(R.id.textView);
        tvname.setText(getItem(position).getName());

        TextView tvdescription = (TextView) convertView.findViewById(R.id.textView2);
        tvdescription.setText(getItem(position).getDescription());


        final CheckBox cbgekauft = (CheckBox) convertView.findViewById(R.id.checkBox);

        cbgekauft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean ischecked = cbgekauft.isChecked();
                checkedItems.set(position, ischecked);

                if(ischecked)
                    contentRow.setBackgroundResource(R.color.SelectedItem);
                else
                    contentRow.setBackgroundResource(android.R.color.transparent);
            }
        });

        cbgekauft.setChecked(this.checkedItems.get(position));

        if(cbgekauft.isChecked())
            convertView.setBackgroundResource(R.color.SelectedItem);
        else
            contentRow.setBackgroundResource(android.R.color.transparent);

        return convertView;
    }
}
