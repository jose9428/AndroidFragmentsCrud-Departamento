package com.edu.pe.adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.edu.pe.R;
import com.edu.pe.clases.Departamento;

import java.util.List;

public class Adapta extends RecyclerView.Adapter<Adapta.MyHolder>  {
    List<Departamento> lista;
    Context contexto;

    public Adapta(List<Departamento> lista, Context contexto) {
        this.lista = lista;
        this.contexto = contexto;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //va a llamar a la vista que contiene los controles
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.vista1, viewGroup,false);

        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int pos) {
        Departamento d=lista.get(pos);
        myHolder.txtResultado.setText(d.toString());

        if(d.getTipo() == 1){
            myHolder.imagen.setImageResource(R.drawable.depa1);
        }else  if(d.getTipo() == 2){
            myHolder.imagen.setImageResource(R.drawable.depa2);
        }else  if(d.getTipo() == 3){
            myHolder.imagen.setImageResource(R.drawable.depa3);
        }else{
            myHolder.imagen.setImageResource(R.drawable.depa4);
        }
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        TextView txtResultado;
        ImageView imagen;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            txtResultado=itemView.findViewById(R.id.txtRes);
            imagen = itemView.findViewById(R.id.imageView);
        }
    }
}
