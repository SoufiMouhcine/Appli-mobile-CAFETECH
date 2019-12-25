package com.example.caftech;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class setting extends Activity {
    TextView retour;
    TextView suggville;
    TextView suggcafe;

    //retour
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        retour=(TextView)findViewById(R.id.retour);
        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ret=new Intent(setting.this,CafeMedia.class);
                startActivity(ret);
            }
        });

        //suggestion ville
        suggville=(TextView)findViewById(R.id.suggville);
        suggville.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendemail=new Intent(Intent.ACTION_SEND);
                sendemail.setData(Uri.parse("mailto: "));
                sendemail.setType("message/rfc822");
                sendemail.putExtra(Intent.EXTRA_EMAIL, new String[]{" cafetech2019app@gmail.com"});
                sendemail.putExtra(Intent.EXTRA_SUBJECT,"Suggérez une Ville");
                sendemail.putExtra(Intent.EXTRA_TEXT,"Nom de la Ville:\n\nBonjour,\n\nJe voudrais suggérer cette ville pour faire partie du réseau CaféTech\n\nEnvoyé de mon Android");
                startActivity(sendemail);

            }
        });

        //suggestion cafe
        suggcafe=(TextView)findViewById(R.id.suggcafe);
        suggcafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendemail=new Intent(Intent.ACTION_SEND);
                sendemail.setData(Uri.parse("mailto: "));
                sendemail.setType("message/rfc822");
                sendemail.putExtra(Intent.EXTRA_EMAIL, new String[]{" cafetech2019app@gmail.com"});
                sendemail.putExtra(Intent.EXTRA_SUBJECT,"Suggérez un Café");
                sendemail.putExtra(Intent.EXTRA_TEXT,"Nom du Café:\n\nBonjour,\n\nJe voudrais suggérer ce café pour faire partie du réseau CaféTech\n\nEnvoyé de mon Android");
                startActivity(sendemail);
            }
        });

        }

}
