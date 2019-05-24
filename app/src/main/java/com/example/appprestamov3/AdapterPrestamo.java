package com.example.appprestamov3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;

public class AdapterPrestamo extends BaseAdapter {
    private Activity activity;
    private List<Prestamo> prestamoList;

    public AdapterPrestamo(Activity activity, List object)
    {
        this.activity = activity;
        this.prestamoList = object;
    }

    public void clear() {
        prestamoList.clear();
    }

    public void addAll(List<Prestamo> prestamos) {
        for (int i = 0; i < prestamos.size(); i++) {
            prestamoList.add(prestamos.get(i));
        }
    }

    @Override
    public int getCount() {
        return prestamoList.size();
    }

    @Override
    public Object getItem(int position) {
        return prestamoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_prestamo, null);
        }

        Prestamo p = prestamoList.get(position);

        TextView tvNombre = v.findViewById(R.id.tvNombre);
        TextView tvTotal = v.findViewById(R.id.tvTotal);
        TextView tvPlazo = v.findViewById(R.id.tviPlazo);

        tvNombre.setText(p.getNombres());
        tvTotal.setText(String.valueOf(p.getMontoPagar()));
        tvPlazo.setText(String.valueOf(p.getPlazo()));

        return v;
    }
}
