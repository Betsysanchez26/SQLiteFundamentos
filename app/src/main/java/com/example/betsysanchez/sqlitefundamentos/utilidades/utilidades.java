package com.example.betsysanchez.sqlitefundamentos.utilidades;

/**
 * Created by BetsySanchez on 26/02/2018.
 */

public class utilidades {
    public static final String TablaContacto="contacto";
    public static final String campo_id="id";
    public static final String campo_nombre="nombre";
    public static final String campo_telefono="telefono";

    public static final String crearTablaContacto="CREATE TABLE "+TablaContacto+"("+campo_id+" INT"+", "+campo_nombre+" TEXT,"+campo_telefono+" TEXT)";
}
