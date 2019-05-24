package com.example.appprestamov3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class VerUnClientActivity extends AppCompatActivity {

    TextView tvNombre, tvApellido, tvSexo, tvTelefono;
    TextView tvCedula, tvOcupacion, tvDireccion;

    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_un_client);

        p = getIntent().getExtras().getInt("position");

        tvNombre = findViewById(R.id.etvNombre);
        tvApellido = findViewById(R.id.etvApellido);
        tvSexo = findViewById(R.id.spvSexo);
        tvTelefono = findViewById(R.id.etvTelefono);
        tvCedula = findViewById(R.id.etvCedula);
        tvOcupacion = findViewById(R.id.etvOcupacion);
        tvDireccion = findViewById(R.id.etvDireccion);

        tvNombre.setText(Datos.clientes.get(p).getNombre());
        tvApellido.setText(Datos.clientes.get(p).getApellido());
        tvSexo.setText(Datos.clientes.get(p).getSexo());
        tvTelefono.setText(Datos.clientes.get(p).getTelefono());
        tvCedula.setText(Datos.clientes.get(p).getCedula());
        tvOcupacion.setText(Datos.clientes.get(p).getOcupacion());
        tvDireccion.setText(Datos.clientes.get(p).getDireccion());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.mnAdd)
        {
            Intent intent = new Intent(this, AddPrestamoActivity.class);
            intent.putExtra("Nombres", tvNombre.getText() + " " + tvApellido.getText());
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
