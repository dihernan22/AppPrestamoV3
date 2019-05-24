package com.example.appprestamov3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class VerPrestamosActivity extends AppCompatActivity {

    private AdapterPrestamo adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_prestamos);

        /*Prestamo p = new Prestamo();

        p.setNombres("Marlon Davila");
        p.setMontoPagar(13000.0);
        p.setPlazo(5);

        Datos.prestamos.add(p);*/

        ListView lvPrestamo = findViewById(R.id.lvVerPrestamo);
        adapter = new AdapterPrestamo(this, Datos.prestamos);
        lvPrestamo.setAdapter(adapter);
    }
}
