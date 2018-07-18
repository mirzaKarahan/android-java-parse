package com.mirzakarahan.parseplatform;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText edtUsername;
    EditText edtPassword;

    Button btnSignin;
    Button btnSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);

        btnSignin = (Button) findViewById(R.id.btnSignin);
        btnSignup = (Button) findViewById(R.id.btnSignUp);



        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Users");
                query.whereEqualTo("username",edtUsername.getText().toString().trim());
                query.whereEqualTo("password",edtPassword.getText().toString().trim());

                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e != null){
                            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.loginError),Toast.LENGTH_SHORT).show();
                        }else{
                            if (objects.size()>0){
                                Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.loginSuccesful)+objects.get(0).getString("username"),Toast.LENGTH_SHORT).show();
                            }else {
                                Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.usernameOrPasswordWrong),Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<ParseObject> query = ParseQuery.getQuery("Users");
                query.whereEqualTo("username",edtUsername.getText().toString().trim());
                query.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if (e != null){
                            Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.loginError),Toast.LENGTH_SHORT).show();
                        }else{
                            if (objects.size()>0){
                                Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.usernameAlreadyExists)+objects.get(0).getString("username"),Toast.LENGTH_SHORT).show();
                            }else {
                                //Add user
                                ParseObject user = new ParseObject("Users");
                                user.put("username",edtUsername.getText().toString().trim());
                                user.put("password", edtPassword.getText().toString().trim());
                                user.saveInBackground();
                                Toast.makeText(getApplicationContext(),getApplicationContext().getString(R.string.userRegisterSuccessful),Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });
            }
        });
    }
}
