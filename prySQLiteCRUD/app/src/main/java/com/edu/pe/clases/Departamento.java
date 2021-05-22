package com.edu.pe.clases;

import java.io.Serializable;

public class Departamento implements Serializable {
    int nro;
    int tipo;
    String cliente;
    int anios;

    public String NombreTipo(){
       String nomTipo[] = {"" , "70 mtrs" ,  "90 mtrs", "120 mtrs" , "150 mtrs"};
       return nomTipo[tipo];
    }

    public double Costo(){
        double costo[] = {0, 120000 , 160000 , 200000 , 250000};

        return costo[tipo];
    }

    public double Interes(){
        double interes = 0.0;
        interes = 0.05 * anios * Costo();
        return interes;
    }

    public double CuotaInicial(){
        return 0.1 * Costo();
    }

    public double Saldo() {
        return Costo() - CuotaInicial() + Interes();
    }

    public double CuotaMensual() {
        return Saldo() / (getAnios() * 12);
    }

    @Override
    public String toString(){
        String cadena = "";
        cadena+="Nro : "+nro+"\n";
        cadena+="Cliente : "+cliente+"\n";
        cadena+="Departamento : "+NombreTipo()+"\n";
        cadena+="Costo : "+Costo()+"\n";
        cadena+="Numero de años : "+anios+"\n";
        cadena+="Interes a pagar : "+Redondear(Interes())+"\n";
        cadena+="Cuota Inicial : "+Redondear(CuotaInicial())+"\n";
        cadena+="Saldo : "+Redondear(Saldo())+"\n";
        cadena+="Cuota Mensual : "+Redondear(CuotaMensual());

        return cadena;
    }

    public double Redondear(double valor){
        return Math.round(valor * 100)/100.0;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getAnios() {
        return anios;
    }

    public void setAnios(int anios) {
        this.anios = anios;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }
}
