package com.edu.pe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pe.clases.Departamento;
import com.edu.pe.dao.Negocio;


public class consultarFragment extends Fragment implements Button.OnClickListener{

    EditText txtConsultar;
    TextView txtResultado;
    Button botonConsultar , botonEliminar;
    Negocio obj;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_consultar, container, false);

        txtConsultar = v.findViewById(R.id.txtNroBuscar);
        txtResultado = v.findViewById(R.id.txtResConsulta);
        botonConsultar = v.findViewById(R.id.btnConsultar);
        botonEliminar = v.findViewById(R.id.btnEliminar);

        botonConsultar.setOnClickListener(this);
        botonEliminar.setOnClickListener(this);

        obj = new Negocio(getContext());
        obj.AbrirConexion();

        return v;
    }


    @Override
    public void onClick(View view) {
        if(botonConsultar == view){
            Consultar();
        }else if(botonEliminar == view){
            Eliminar();
        }
    }

    public void Consultar(){
        String nro = txtConsultar.getText().toString();

        Departamento d = obj.Consulta(nro);

        if(d != null){
            txtResultado.setText(d.toString());
            Toast.makeText(getContext() ,"Dato encontrado", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getContext() ,"Nro "+nro+" no encontrado", Toast.LENGTH_SHORT).show();
            txtResultado.setText("");
        }
    }

    public void Eliminar(){
        String nro = txtConsultar.getText().toString();

        int res = obj.Eliminar(nro);

        if(res > 0){
            Toast.makeText(getContext() ,"Nro "+nro+" departamento eliminado correctamente", Toast.LENGTH_SHORT).show();
            txtResultado.setText("");
        }else{
            Toast.makeText(getContext() ,"No se ha podido eliminar departamento", Toast.LENGTH_SHORT).show();
        }
    }
}