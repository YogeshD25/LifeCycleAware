package com.architecturecomponent.lifecycleaware;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {



    @PrimaryKey
    @NonNull
    private String id;
    @NonNull
    @ColumnInfo(name = "note")
    private String mNote;

    public Note(String id,String note){
        this.id = id;
        this.mNote = note;
    }

    @NonNull
    public String getId() {
        return id;
    }

    @NonNull
    public String getmNote() {
        return mNote;
    }

}
