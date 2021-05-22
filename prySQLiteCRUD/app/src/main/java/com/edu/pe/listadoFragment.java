package com.edu.pe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.pe.adaptador.Adapta;
import com.edu.pe.dao.Negocio;


public class listadoFragment extends Fragment {
    Negocio obj;
    RecyclerView recy;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v= inflater.inflate(R.layout.fragment_listado, container, false);
        recy=v.findViewById(R.id.recy1);
        obj=new Negocio(getContext());
        obj.AbrirConexion();
        Adapta dp=new Adapta(obj.listado(),getContext());
        recy.setLayoutManager( new LinearLayoutManager(getContext()));
        recy.setAdapter(dp);
        return v;

    }
}