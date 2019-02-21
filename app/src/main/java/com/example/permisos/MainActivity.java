package com.example.permisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button btncamera, btngps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btncamera = findViewById(R.id.btncamera);
        btngps = findViewById(R.id.btngps);


        View.OnClickListener click = new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.btncamera:
                        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                        {
                            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CAMERA))
                            {
                                Toast.makeText(MainActivity.this,"Aceptalo", Toast.LENGTH_SHORT).show();
                                String[] lp = new String[] {Manifest.permission.CAMERA};
                                ActivityCompat.requestPermissions(MainActivity.this,lp,1);
                            }
                            else
                            {
                                String[] lp = new String[] {Manifest.permission.CAMERA};
                                ActivityCompat.requestPermissions(MainActivity.this,lp,1);
                            }
                        }
                        break;

                    case R.id.btngps:
                        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
                        {
                            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION))
                            {
                                Toast.makeText(MainActivity.this,"Aceptalo", Toast.LENGTH_SHORT).show();
                                String[] lp = new String[] {Manifest.permission.ACCESS_FINE_LOCATION};
                                ActivityCompat.requestPermissions(MainActivity.this,lp,2);
                            }
                            else
                            {
                                String[] lp = new String[] {Manifest.permission.ACCESS_FINE_LOCATION};
                                ActivityCompat.requestPermissions(MainActivity.this,lp,2);
                            }
                        }
                        break;
                }
            }
        };

        btncamera.setOnClickListener(click);
        btngps.setOnClickListener(click);


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {

                }
                break;

            case 2:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                {

                }
                break;
        }
    }



}
