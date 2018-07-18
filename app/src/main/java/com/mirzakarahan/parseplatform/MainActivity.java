package com.mirzakarahan.parseplatform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Users");
        query.whereEqualTo("username","mirzaakarahan");
        query.whereEqualTo("password","12345");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                if (e != null){
                    System.out.println("Error = "+e.getLocalizedMessage());
                }else{
                    System.out.println("Kullanıcı = "+objects.size());
                }
            }
        });

    }
}
