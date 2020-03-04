package com.yuk_belajarwiki.yukbelajarfd;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class tawal_note extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tawal_note);
        listView = findViewById(R.id.ListView);
        @SuppressLint("ResourceType") Toolbar toolbar = findViewById(R.menu.menu_note);
        setSupportActionBar(toolbar);


        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_note, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_main_new_note:
                startActivity(new Intent(this, Note_write.class));
                break;
        }

        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();
        listView.setAdapter(null);

        ArrayList<Note> notes = Utility.getAllSavedNote(this);
        if (notes == null || notes.size() == 0) {
            Toast.makeText(this, "Tidak ada catatan yang tesimpan", Toast.LENGTH_SHORT).show();
        } else {
            Note_adapter na = new Note_adapter(this, R.layout.item_note, notes);
            listView.setAdapter(na);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //run the NoteActivity in view/edit mode
                    String fileName = ((Note) listView.getItemAtPosition(position)).getDatetime()
                            + Utility.FILE_EXTENSION;
                    Intent viewNoteIntent = new Intent(getApplicationContext(), Note_write.class);
                    viewNoteIntent.putExtra(Utility.EXTRAS_NOTE_FILENAME, fileName);
                    startActivity(viewNoteIntent);
                }
            });
        }

    }
}
