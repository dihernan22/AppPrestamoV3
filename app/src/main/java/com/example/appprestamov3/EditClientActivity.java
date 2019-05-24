package com.example.appprestamov3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class EditClientActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etApellido;
    Spinner spSexo;
    EditText etCedula;
    EditText etTelefono;
    EditText etOcupacion;
    EditText etDireccion;

    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_client);

        p = getIntent().getExtras().getInt("position");

        etNombre = findViewById(R.id.eteNombre);
        etApellido = findViewById(R.id.eteApellido);
        spSexo = findViewById(R.id.speSexo);
        etTelefono = findViewById(R.id.eteTelefono);
        etCedula = findViewById(R.id.eteCedula);
        etOcupacion = findViewById(R.id.eteOcupacion);
        etDireccion = findViewById(R.id.eteDireccion);

        etNombre.setText(Datos.clientes.get(p).getNombre());
        etApellido.setText(Datos.clientes.get(p).getApellido());
        spSexo.setSelection(obtenerPosicionItem(spSexo, Datos.clientes.get(p).getSexo()));
        etTelefono.setText(Datos.clientes.get(p).getTelefono());
        etCedula.setText(Datos.clientes.get(p).getCedula());
        etOcupacion.setText(Datos.clientes.get(p).getOcupacion());
        etDireccion.setText(Datos.clientes.get(p).getDireccion());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_client, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.mnGuardarClient:
                if (etNombre.getText().toString().isEmpty()
                        && etTelefono.getText().toString().isEmpty()
                        && etCedula.getText().toString().isEmpty()
                        && etDireccion.getText().toString().isEmpty()
                )
                {
                    etNombre.setError("");
                    etTelefono.setError("");
                    etCedula.setError("");
                    etDireccion.setError("");
                    Toast.makeText(this, "Revise los Campos", Toast.LENGTH_SHORT).show();
                }
                else if (etNombre.getText().toString().isEmpty())
                {
                    etNombre.setError("Campo Obligatorio");
                }
                else if (etTelefono.getText().toString().isEmpty())
                {
                    etTelefono.setError("Campo Obligatorio");
                }
                else if (etCedula.getText().toString().isEmpty())
                {
                    etCedula.setError("Campo Obligatorio");
                }
                else if (etDireccion.getText().toString().isEmpty())
                {
                    etDireccion.setError("Campo Obligatorio");
                }
                else
                {
                    Datos.clientes.get(p).setNombre(etNombre.getText().toString());
                    Datos.clientes.get(p).setApellido(etApellido.getText().toString());
                    Datos.clientes.get(p).setSexo(spSexo.getSelectedItem().toString());
                    Datos.clientes.get(p).setTelefono(etTelefono.getText().toString());
                    Datos.clientes.get(p).setCedula(etCedula.getText().toString());
                    Datos.clientes.get(p).setOcupacion(etOcupacion.getText().toString());
                    Datos.clientes.get(p).setDireccion(etDireccion.getText().toString());

                    Toast.makeText(this, "Cliente Actualizado", Toast.LENGTH_SHORT).show();

                    finish();
                }
                break;
            case R.id.mnCancelarClient:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public static int obtenerPosicionItem(Spinner spinner, String sexo)
    {
        int posicion = 0;

        for (int i = 0; i < spinner.getCount(); i++)
        {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(sexo)) {
                posicion = i;
            }
        }

        return posicion;
    }
}
