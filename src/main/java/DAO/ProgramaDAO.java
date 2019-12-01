/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Conexion.Conexion;
import Modelo.ProgramaBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author liliana.gironusam
 */
public class ProgramaDAO {
     Conexion conn;
    ResultSet rs;
    PreparedStatement ps;


    public ProgramaDAO(Conexion conn) {
        this.conn = conn;
    }
        
    
    
}