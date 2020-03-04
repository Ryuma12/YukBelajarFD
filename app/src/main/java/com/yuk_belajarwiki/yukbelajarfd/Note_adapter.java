package com.yuk_belajarwiki.yukbelajarfd;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Note_adapter extends ArrayAdapter<Note> {

    Note_adapter(Context context, int resource, ArrayList<Note> notes) {
        super(context, resource, notes);
    }


    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        //return super.getView(position, convertView, parent);
        if(convertView==null){
            convertView=LayoutInflater.from(getContext()).inflate(R.layout.item_note,null );
            }
         Note note=getItem(position);

        if(note != null){
            TextView title= convertView.findViewById(R.id.list_note_title);
            TextView date=  convertView.findViewById(R.id.list_note_date);
            TextView content=  convertView.findViewById(R.id.list_note_content);

            title.setText(note.getTitle());
            date.setText(note.getDatetimeFormat(getContext()));

            if(note.getContent().length() > 50){
                content.setText(note.getContent().substring(0,50));
            }else{
                content.setText(note.getContent());
            }
            }
        return convertView;
    }
}
