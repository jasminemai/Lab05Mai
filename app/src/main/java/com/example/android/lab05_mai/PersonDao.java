package com.example.android.lab05_mai;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Jasmine on 3/15/18.
 */
@Dao
public interface PersonDao {
    @Insert
    void insertPerson (Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons ();
}
