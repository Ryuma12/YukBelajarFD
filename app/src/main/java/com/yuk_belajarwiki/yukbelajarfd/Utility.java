package com.yuk_belajarwiki.yukbelajarfd;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Utility {

    public static final String EXTRAS_NOTE_FILENAME = "EXTRAS_NOTE_FILENAME";
    public static final String FILE_EXTENSION = ".bin";


    public static boolean saveNote (Context context,Note note){
        String filesave = String.valueOf(note.getDatetime())+ FILE_EXTENSION;

        FileOutputStream fos;
        ObjectOutputStream oos;

        try {
            fos = context.openFileOutput(filesave, Context.MODE_PRIVATE);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(note);
            oos.close();
            fos.close();

        }catch (IOException e){
            e.printStackTrace();
            return false; //pemberitahuan error
        }
       return true;
    }
    static ArrayList<Note> getAllSavedNote(Context context){
        ArrayList<Note> note =new ArrayList<>();

        File filesDir= context.getFilesDir();
        ArrayList<String> noteFile=new ArrayList<>();
       for(String file : filesDir.list()){
           if(file.endsWith(FILE_EXTENSION)){
               noteFile.add(file);
           }
       }
        FileInputStream fis;
        ObjectInputStream ois;

        for(int i=0; i<noteFile.size();i++){
            try{
                fis = context.openFileInput(noteFile.get(i));
                ois = new ObjectInputStream(fis);
                note.add((Note)ois.readObject());
                fis.close();
                ois.close();

            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                return null;
            }
        }
        return note;
    }
    static  Note getNoteByName(Context context, String filename){
        File file=new File(context.getFilesDir(), filename);
        Note note;
        if(file.exists()){
            FileInputStream fis;
            ObjectInputStream ois;
            try{
                fis = context.openFileInput(filename);
                ois = new ObjectInputStream(fis);
                note=(Note)ois.readObject();
                fis.close();
                ois.close();

            }catch (IOException | ClassNotFoundException e){
                e.printStackTrace();
                return null;
            }
            return note;
        }
        return null;
    }

    static void deleteNote(Context context, String filename) {
        File dir= context.getFilesDir();
        File file= new File(dir, filename);
        if(file.exists()){
            file.delete();
        }
    }
}
