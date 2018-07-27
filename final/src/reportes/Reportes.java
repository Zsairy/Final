/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reportes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author USER
 */
public class Reportes {
    public void ReporteFacultad () throws SQLException, JRException{
        Connection con = null;
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto","tutorias","123");
        JasperReport reporte = null;
        reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\franc\\Desktop\\project\\Final\\final\\src\\reportes\\Facultad.jasper");
        JasperPrint print = JasperFillManager.fillReport(reporte , null, con);
        JasperViewer ver = new JasperViewer(print,false);
        ver.setTitle("Facultad");
        ver.setVisible(true);
    }
     public void ReporteEscuela () throws SQLException, JRException{
        Connection con = null;
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto","tutorias","123");
        JasperReport reporte = null;
        reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\franc\\Desktop\\project\\Final\\final\\src\\reportes\\Escuela.jasper");
        JasperPrint print = JasperFillManager.fillReport(reporte , null, con);
        JasperViewer ver = new JasperViewer(print,false);
        ver.setTitle("Escuela");
        ver.setVisible(true);
    }
      public void ReporteNiveles () throws SQLException, JRException{
        Connection con = null;
        con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/proyecto","tutorias","123");
        JasperReport reporte = null;
        reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\franc\\Desktop\\project\\Final\\final\\src\\reportes\\Nivel.jasper");
        JasperPrint print = JasperFillManager.fillReport(reporte , null, con);
        JasperViewer ver = new JasperViewer(print,false);
        ver.setTitle("Nivel");
        ver.setVisible(true);
    }
}
