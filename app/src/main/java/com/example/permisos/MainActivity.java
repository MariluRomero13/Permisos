package com.example.permisos;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch camaraSwitch, audioSwitch, ubicacionSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        camaraSwitch = findViewById(R.id.camaraSwitch);
        audioSwitch = findViewById(R.id.audioSwitch);
        ubicacionSwitch = findViewById(R.id.ubicacionSwitch);

        permisoCamara();
        permisoUbicacion();
        permisoAudio();

        View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId())
                {
                    case R.id.camaraSwitch:
                        permisoCamara();
                        break;
                    case R.id.audioSwitch:
                       permisoAudio();
                        break;
                    case R.id.ubicacionSwitch:
                        permisoUbicacion();
                        break;
                }
            }
        };

        camaraSwitch.setOnClickListener(click);
        audioSwitch.setOnClickListener(click);
        ubicacionSwitch.setOnClickListener(click);
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults)
    {
        switch (requestCode)
        {
            case 1:
                if (grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permiso de cámara aceptado :D", Toast.LENGTH_SHORT).show();
                    camaraSwitch.setChecked(true);
                }
                else
                    {
                    Toast.makeText(this, "Permiso de cámara rechazado D:", Toast.LENGTH_SHORT).show();
                    camaraSwitch.setChecked(false);
                }
                break;
            case 2:
                if (grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permiso de internet aceptado :D", Toast.LENGTH_SHORT).show();
                    audioSwitch.setChecked(true);
                }
                else
                {
                    Toast.makeText(this, "Permiso de internet rechazado :c", Toast.LENGTH_SHORT).show();
                    audioSwitch.setChecked(false);
                }
                break;
            case 3:
                if (grantResults.length > 0  && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permiso de ubicación aceptado :D", Toast.LENGTH_SHORT).show();
                    ubicacionSwitch.setChecked(true);
                }
                else
                {
                    Toast.makeText(this, "Permiso de ubicación rechazado :c", Toast.LENGTH_SHORT).show();
                    ubicacionSwitch.setChecked(false);
                }
                break;
        }
    }

    public void permisoCamara()
    {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
            {

                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.CAMERA)) {
                    String[] lp = new String[]{Manifest.permission.CAMERA};
                    ActivityCompat.requestPermissions(MainActivity.this, lp, 1);
                    camaraSwitch.setChecked(false);
                }
                else
                {

                    String[] lp = new String[] {Manifest.permission.CAMERA};
                    ActivityCompat.requestPermissions(MainActivity.this,lp,1);
                    camaraSwitch.setChecked(false);
                }
            }
            else
            {
                camaraSwitch.setChecked(true);
            }
        }

    }

    public void permisoAudio()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED)
            {

                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.RECORD_AUDIO)) {
                    String[] lp = new String[]{Manifest.permission.RECORD_AUDIO};
                    ActivityCompat.requestPermissions(MainActivity.this, lp, 2);
                    audioSwitch.setChecked(false);
                }
                else
                {

                    String[] lp = new String[] {Manifest.permission.RECORD_AUDIO};
                    ActivityCompat.requestPermissions(MainActivity.this,lp,2);
                   audioSwitch.setChecked(false);
                }
            }
           else
            {
                audioSwitch.setChecked(true);
            }
        }

    }

    public void permisoUbicacion()
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
        {
            if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)
            {

                if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,Manifest.permission.ACCESS_FINE_LOCATION)) { Toast.makeText(MainActivity.this, "Aceptalo", Toast.LENGTH_SHORT).show();
                    String[] lp = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                    ActivityCompat.requestPermissions(MainActivity.this, lp, 3);
                    ubicacionSwitch.setChecked(false);
                }
                else
                {

                    String[] lp = new String[] {Manifest.permission.ACCESS_FINE_LOCATION};
                    ActivityCompat.requestPermissions(MainActivity.this,lp,3);
                    ubicacionSwitch.setChecked(false);
                }
            }
            else
            {
                ubicacionSwitch.setChecked(true);
            }
        }

    }

}
