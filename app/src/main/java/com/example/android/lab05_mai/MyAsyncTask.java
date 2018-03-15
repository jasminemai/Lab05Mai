package com.example.android.lab05_mai;

import android.arch.persistence.room.Database;
import android.os.AsyncTask;

/**
 * Created by Jasmine on 3/15/18.
 */

public class MyAsyncTask extends AsyncTask<String, Void, Void> {
    LabDatabase database;

    public MyAsyncTask(LabDatabase database)
    {
        this.database = database;
    }

    @Override
    protected Void doInBackground(String... strings) {
        Person person = new Person();
        person.setName(strings[0]);
        database.personDao().insertPerson(person);
        return null;
    }
}
