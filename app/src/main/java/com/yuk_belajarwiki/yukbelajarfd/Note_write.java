package com.yuk_belajarwiki.yukbelajarfd;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Note_write extends AppCompatActivity {

    private EditText mEditTitle;
    private EditText mEditContent;
    private String mNoteFile;
    private Note mLoadedNote;
    private boolean mIsViewingOrUpdating;
    private long mNoteCreationTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_write);

        mEditTitle = findViewById(R.id.note_title);
        mEditContent = findViewById(R.id.note_conten);

        mNoteFile = getIntent().getStringExtra("Note_File");

        if (mNoteFile != null && !mNoteFile.isEmpty() && mNoteFile.endsWith(Utility.FILE_EXTENSION)) {
            mLoadedNote = Utility.getNoteByName(getApplicationContext(), mNoteFile);
            if (mLoadedNote != null) {
                mEditTitle.setText(mLoadedNote.getTitle());
                mEditContent.setText(mLoadedNote.getContent());
                mNoteCreationTime = mLoadedNote.getDatetime();
                mIsViewingOrUpdating = true;
            } else { //user wants to create a new note
                mNoteCreationTime = System.currentTimeMillis();
                mIsViewingOrUpdating = false;
            }

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //load menu based on the state we are in (new, view/update/delete)
        if (mIsViewingOrUpdating) { //user is viewing or updating a note
            getMenuInflater().inflate(R.menu.menu_write, menu);
        } else { //user wants to create a new note
            getMenuInflater().inflate(R.menu.menu_write, menu);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_main_note_save:
                saveNote();
                break;
            case R.id.action_main_note_delete:
                deleteNote();
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    private void saveNote() {
        Note note;
        if (mLoadedNote == null) {
            note = new Note(System.currentTimeMillis(), mEditTitle.getText().toString(),
                    mEditContent.getText().toString());
        } else {
            note = new Note(mLoadedNote.getDatetime(), mEditTitle.getText().toString(),
                    mEditContent.getText().toString());
        }
        if (Utility.saveNote(this, note)) {
            Toast.makeText(this, "catatan tersimpan", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "tidak dapat tersimpan pastikan memmori anda cukup",
                    Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    private void deleteNote() {
        if (mLoadedNote == null) {
            finish();
        } else {

            AlertDialog.Builder dialog = new AlertDialog.Builder(this)
                    .setTitle("Hapus").setMessage("Anda akan menghapus" + mEditTitle.getText() + "Anda yakin?")
                    .setPositiveButton("ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Utility.deleteNote(getApplicationContext(),
                                    mLoadedNote.getDatetime() + Utility.FILE_EXTENSION);
                            Toast.makeText(getApplicationContext(),
                                    mEditTitle.getText() + "telah dihapus",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    })
                    .setNegativeButton("Tidak", null)
                    .setCancelable(false);
            dialog.show();

        }
    }
}





