package com.example.android.lab05_mai;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Jasmine on 3/15/18.
 */

public class MyAsyncTask2 extends AsyncTask<Void, Void, ArrayList<Person>> {
    LabDatabase personDB;
    Context context;
    public MyAsyncTask2(LabDatabase personDB, Context context)
    {
        this.personDB = personDB;
        this.context = context;
    }

    protected void onPostExecute(ArrayList<Person> persons) {
        super.onPostExecute(persons);
        ArrayList<String> personNames = new ArrayList<>();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
    }

    protected ArrayList<Person> doInBackground(Void... voids) {
        ArrayList<Person> persons = (ArrayList) personDB.personDao().getAllPersons();
        return persons;

    }
}
