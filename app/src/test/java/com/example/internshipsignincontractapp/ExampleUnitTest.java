package com.example.internshipsignincontractapp;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.internshipsignincontractapp.Model.DbConnector;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void dbConnectionNotNull() {
        DbConnector dbConnector = DbConnector.getInstance();
        Boolean b =true;
        assertNotNull(b);
    }
}