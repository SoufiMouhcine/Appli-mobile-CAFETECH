package com.example.caftech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Starbucks extends AppCompatActivity {
    CheckBox esspresso,checkBox2,machiato,checkBox3,checkBox4,checkBox5,checkBox6,checkBox7,checkBox8,checkBox9;
    EditText adresse,numTel;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starbucks);

        adresse = (EditText) findViewById(R.id.adresse);
        numTel = (EditText) findViewById(R.id.editText4);

        esspresso = (CheckBox) findViewById(R.id.esspresso);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        machiato = (CheckBox) findViewById(R.id.machiato);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendemail=new Intent(Intent.ACTION_SEND);
                sendemail.setData(Uri.parse("mailto: "));
                sendemail.setType("message/rfc822");
                sendemail.putExtra(Intent.EXTRA_EMAIL, new String[]{"starbuckscoffee2019app@gmail.com"});
                sendemail.putExtra(Intent.EXTRA_SUBJECT,"Commande du Café");
                sendemail.putExtra(Intent.EXTRA_TEXT,"ADRESSE: "+adresse.getText().toString()+"\n\nNUMERO DE TELEPHONE: "+numTel.getText().toString()+"\n\nCOMMANDE: "+commande()+"\n\nPRIX TOTAL: "+price()+" DH");
                startActivity(sendemail);
            }
        });
    }
    public int price()
    {
        int prix = 0;
        if (esspresso.isChecked())
            prix += 10;
        if (checkBox2.isChecked())
            prix += 8;
        if (machiato.isChecked())
            prix += 20;
        if (checkBox3.isChecked())
            prix += 30;
        if (checkBox4.isChecked())
            prix += 33;
        if (checkBox5.isChecked())
            prix += 35;
        if (checkBox6.isChecked())
            prix += 35;
        if (checkBox7.isChecked())
            prix += 40;
        if (checkBox8.isChecked())
            prix += 33;
        if (checkBox9.isChecked())
            prix += 30;
        return prix;

    }
    public  String commande(){
        String commande = "";
        if (esspresso.isChecked())
            commande += esspresso.getText().toString() + ", ";
        if (checkBox2.isChecked())
            commande += checkBox2.getText().toString() + ", ";
        if (machiato.isChecked())
            commande += machiato.getText().toString() + ", ";
        if (checkBox3.isChecked())
            commande += checkBox3.getText().toString() + ", ";
        if (checkBox4.isChecked())
            commande += checkBox4.getText().toString() + ", ";
        if (checkBox5.isChecked())
            commande += checkBox5.getText().toString() + ", ";
        if (checkBox6.isChecked())
            commande += checkBox6.getText().toString() + ", ";
        if (checkBox7.isChecked())
            commande += checkBox7.getText().toString() + ", ";
        if (checkBox8.isChecked())
            commande += checkBox8.getText().toString() + ", ";
        if (checkBox9.isChecked())
            commande += checkBox9.getText().toString() + ". ";
        return commande;
    }







}
