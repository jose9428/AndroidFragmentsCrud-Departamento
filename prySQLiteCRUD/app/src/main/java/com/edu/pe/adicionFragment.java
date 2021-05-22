package com.edu.pe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.pe.clases.Departamento;
import com.edu.pe.dao.Negocio;

public class adicionFragment extends Fragment implements Button.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner spDepart;
    TextView txtAnios , txtCliente;
    Button botonAceptar;
    Button botonNuevo;
    ImageView imagen;

    String items[] = {"70 Mtrs" , "90 Mtrs" , "120 Mtrs" , "150 Mtrs"};

    Negocio obj;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_adicion, container, false);
        botonAceptar = v.findViewById(R.id.btnAceptar);
        botonNuevo = v.findViewById(R.id.btnNuevo);
        txtAnios = v.findViewById(R.id.txtAnios);
        txtCliente = v.findViewById(R.id.txtCliente);
        spDepart = v.findViewById(R.id.spTipo);
        imagen = v.findViewById(R.id.lbImagenDep);

        ArrayAdapter<String> adapta = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items);
        //ArrayAdapter adapta = ArrayAdapter.createFromResource(this ,R.array.departamentos,android.R.layout.simple_list_item_1);
        spDepart.setAdapter(adapta);
        spDepart.setOnItemSelectedListener(this);
        botonAceptar.setOnClickListener(this);

        obj = new Negocio(getContext());
        obj.AbrirConexion();

        return v;
    }
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String nom[] = {"depa1" , "depa2"  , "depa3" , "depa4"};

       // int direccion = getResources().getIdentifier("drawable/"+nom[i] ,null , getPackageName());
        int id = getResources().getIdentifier(nom[i], "drawable", getActivity().getPackageName());
        imagen.setImageResource(id);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    @Override
    public void onClick(View view) {
        if(botonAceptar == view){
            Calcular();
        }else if(botonNuevo == view){
            Limpiar();
        }
    }

    public void Calcular(){
        Departamento d = new Departamento();
        d.setAnios(Integer.parseInt(txtAnios.getText().toString().trim()));
        d.setCliente(txtCliente.getText().toString().trim());
        d.setTipo(spDepart.getSelectedItemPosition()+1);

        long res = obj.Adicion(d);

        if(res >0){
            Toast.makeText(getContext(),"Departamento registrado correctamente ",Toast.LENGTH_SHORT).show();
            Limpiar();
        }else{
            Toast.makeText(getContext(),"No se ha registrado departamento ",Toast.LENGTH_SHORT).show();
        }
    }

    public void Limpiar(){
        txtCliente.setText("");
        txtAnios.setText("");
    }
}