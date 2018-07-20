/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

import accesodatos.AccesoDatos;
import accesodatos.ConjuntoResultado;
import java.io.Serializable;
import java.util.ArrayList;
import accesodatos.Parametro;
import java.sql.SQLException;
import entidades.Facultad;

/**
 *
 * @author franc
 */
public class FFacultad implements Serializable {

    public static boolean Insertar(Facultad facultad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.finsertar_facultad(?,?,?,?)";
            lstP.add(new Parametro(1, facultad.getCodigo()));
            lstP.add(new Parametro(2, facultad.getNombre()));
            lstP.add(new Parametro(3, facultad.getDescripcion()));
            lstP.add(new Parametro(4, facultad.getCodigo_sicoa()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static ArrayList<Facultad> llenarFacultades(ConjuntoResultado rs) throws Exception {
        ArrayList<Facultad> lst = new ArrayList<Facultad>();
        Facultad facultad = null;
        try {
            while (rs.next()) {
                facultad = new Facultad(rs.getInt("pcodigo"), rs.getString("pnombre"), rs.getString("pdescripcion"), rs.getInt("pcodigo_sicoa"));
                lst.add(facultad);
            }
        } catch (Exception e) {
            lst.clear();
            throw e;
        }
        return lst;
    }

    public static ArrayList<Facultad> ObtenerFacultades() throws Exception {
        ArrayList<Facultad> lst = new ArrayList<Facultad>();
        try {
            String sql = "select * from actividades.fc_obtener_facultad()";
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql);
            lst = llenarFacultades(rs);
            rs = null;

        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static Facultad ObtenerFacultadDadoCodigo(int codigo) throws Exception {
        Facultad lst;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.fc_obtener_facultad_dado_codigo(?)";
            lstP.add(new Parametro(1, codigo));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            lst = new Facultad();
            lst = llenarFacultades(rs).get(0);
            rs = null;
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return lst;
    }

    public static boolean actualizar(Facultad facultad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.factualiza_facultad(?,?,?,?)";
            lstP.add(new Parametro(1, facultad.getNombre()));
            lstP.add(new Parametro(2, facultad.getDescripcion()));
            lstP.add(new Parametro(3, facultad.getCodigo_sicoa()));
            lstP.add(new Parametro(4, facultad.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }

    public static boolean eliminar(Facultad facultad) throws Exception {
        boolean eje = false;
        try {
            ArrayList<Parametro> lstP = new ArrayList<Parametro>();
            String sql = "select * from actividades.felimina_facultad(?)";
            lstP.add(new Parametro(1, facultad.getCodigo()));
            ConjuntoResultado rs = AccesoDatos.ejecutaQuery(sql, lstP);
            while (rs.next()) {
                if (rs.getString(0).equals("true"));
                eje = true;
            }
        } catch (SQLException exConec) {
            throw new Exception(exConec.getMessage());
        }
        return eje;
    }
}