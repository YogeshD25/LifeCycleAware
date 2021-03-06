package com.architecturecomponent.lifecycleaware;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class NoteViewModel extends AndroidViewModel {

    private String TAG = this.getClass().getSimpleName();
    private NoteDao noteDao;
    private NoteRoomDatabase noteDB;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteDB = NoteRoomDatabase.getDatabase(application);
        noteDao = noteDB.noteDao();
    }
    public void insert(Note note){
        new InsertAsyncTask(noteDao).execute(note);
    }

    @Override
    protected void onCleared(){
        super.onCleared();
        Log.i(TAG,"Android ViewModel destroyed");
    }

    private class InsertAsyncTask extends AsyncTask<Note,Void,Void>{

        NoteDao mNoteDao;
        public InsertAsyncTask(NoteDao mNoteDao){
            this.mNoteDao = mNoteDao;
        }
        @Override
        protected Void doInBackground(Note... notes) {
            mNoteDao.insert(notes[0]);
            return null;
        }
    }
}
