package com.example.appprestamov3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AddClientActivity extends AppCompatActivity {

    EditText etNombre;
    EditText etApellido;
    Spinner spSexo;
    EditText etTelefono;
    EditText etCedula;
    EditText etOcupacion;
    EditText etDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_client);

        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        spSexo = findViewById(R.id.spSexo);
        etTelefono = findViewById(R.id.etTelefono);
        etCedula = findViewById(R.id.etCedula);
        etOcupacion = findViewById(R.id.etOcupacion);
        etDireccion = findViewById(R.id.etDireccion);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_client, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
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
                    Cliente c = new Cliente();

                    c.setNombre(etNombre.getText().toString());
                    c.setApellido(etApellido.getText().toString());
                    c.setSexo(spSexo.getSelectedItem().toString());
                    c.setTelefono(etTelefono.getText().toString());
                    c.setCedula(etCedula.getText().toString());
                    c.setOcupacion(etOcupacion.getText().toString());
                    c.setDireccion(etDireccion.getText().toString());

                    Datos.clientes.add(c);

                    Toast.makeText(this, "Cliente Agregado", Toast.LENGTH_SHORT).show();

                    String resultado = etNombre.getText().toString();
                    Intent i = getIntent();
                    i.putExtra("ResGuardado", "Ingreso de nuevo cliente " + resultado);
                    setResult(RESULT_OK, i);

                    finish();
                }
                break;
            case R.id.mnCancelarClient:
                Intent i = getIntent();
                i.putExtra("ResCancelado", "Cancelo ingreso nuevo cliente");
                setResult(RESULT_CANCELED, i);

                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
