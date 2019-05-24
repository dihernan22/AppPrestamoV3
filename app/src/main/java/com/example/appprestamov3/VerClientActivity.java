package com.example.appprestamov3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class VerClientActivity extends AppCompatActivity {

    private List<Cliente> clienteList = new ArrayList<>();
    private RVAdapter adapter;
    int n = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_client);

        if(n == 0) {
            Cliente c1 = new Cliente();
            c1.setNombre("Marlon");
            c1.setApellido("Davila");
            Datos.clientes.add(c1);

            Cliente c2 = new Cliente();
            c2.setNombre("Jose");
            c2.setApellido("Urroz");
            Datos.clientes.add(c2);

            n = 1;
        }

        RecyclerView rvClient = findViewById(R.id.rvClient);
        adapter= new RVAdapter(Datos.clientes);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        rvClient.setHasFixedSize(true);
        rvClient.setLayoutManager(layoutManager);
        rvClient.setAdapter(adapter);
    }
}
