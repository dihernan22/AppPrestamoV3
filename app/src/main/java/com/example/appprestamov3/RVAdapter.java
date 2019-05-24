package com.example.appprestamov3;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ClientHolder> {
    private List<Cliente> clienteList;
    private Context context1;

    public RVAdapter(List<Cliente> personaList) {

        this.clienteList = personaList;
    }

    @NonNull
    @Override
    public ClientHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_client, viewGroup, false);
        ClientHolder clientHolder = new ClientHolder(view);
        return clientHolder;
    }

    public class ClientHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvNombre;
        private TextView tvApellido;
        private ImageButton ibEditar;
        private ImageButton ibEliminar;
        private Context context;

        public ClientHolder(@NonNull View view)
        {
            super(view);
            context = view.getContext();
            context1 = context;

            tvNombre = view.findViewById(R.id.tviNombre);
            tvApellido = view.findViewById(R.id.tviApellido);

            ibEditar = view.findViewById(R.id.ibEditar);
            ibEliminar = view.findViewById(R.id.ibDelete);
        }

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    public int getItemCount() {
        return clienteList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull final ClientHolder clientHolder, final int i) {
        clientHolder.tvNombre.setText(clienteList.get(i).getNombre());
        clientHolder.tvApellido.setText(clienteList.get(i).getApellido());

        clientHolder.tvNombre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerCliente(i);
            }
        });

        clientHolder.tvApellido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VerCliente(i);
            }
        });

        clientHolder.ibEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(context1, EditClientActivity.class);
                intent3.putExtra("Position", i);
                Toast.makeText(context1, "Cargando datos del Cliente", Toast.LENGTH_SHORT).show();
                context1.startActivity(intent3);
            }
        });

        clientHolder.ibEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context1);
                builder.setTitle("Eliminando cliente");
                builder.setMessage("Esta seguro que desea eliminar al cliente " + clientHolder.tvNombre.getText());
                builder.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        clienteList.remove(i);
                        notifyItemRemoved(i);
                        notifyItemRangeChanged(i, clienteList.size());
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context1, "Accion Cancelada", Toast.LENGTH_SHORT).show();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
    }

    void VerCliente(int p)
    {
        Intent intent = new Intent(context1, VerUnClientActivity.class);
        intent.putExtra("position", p);
        context1.startActivity(intent);
    }
}
