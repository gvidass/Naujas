package com.example.moksleivis.naujas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class Naujas extends AppCompatActivity implements View.OnClickListener {


    private EditText editTextName, editTextEmail, editTextMobile,
            editTextPassword;

    private Button buttonSubmit;


    private AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_naujas);


        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);


        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);


        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);



        awesomeValidation.addValidation(this, R.id.editTextName, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.editTextEmail, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.editTextPassword, "^[A-Za-z\\s]{1,}[\\.]{0,1}[A-Za-z\\s]{0,}$", R.string.passworderror);



        buttonSubmit.setOnClickListener(this);
    }

    private void submitForm() {

        if (awesomeValidation.validate()) {
            Toast.makeText(this, "Registration Successfull", Toast.LENGTH_LONG).show();


        }
    }

    @Override
    public void onClick(View view) {
        if (view == buttonSubmit) {
            submitForm();
        }
    }
}