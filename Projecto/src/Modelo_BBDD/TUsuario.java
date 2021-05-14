/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo_BBDD;

import java.sql.Connection;

/**
 *
 * @author ketro
 */

public class TUsuario {
    Connection con;

    public TUsuario(Connection con) {
        this.con = con;
    }
   
}
