/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import Modelo_BBDD.*;
import Views.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ketro
 */
public class Projecto {
    private static BaseDatos bd;
    
    
    private static Principal p;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          try{
            bd = new BaseDatos();
            bd.conectar();
            
            /*tp = new TablaPersonas(bd.getCon());*/
            
            p = new Principal();
            p.setVisible(true);
        }
        catch(Exception e){
            bd.desconectar();
            JOptionPane.showMessageDialog(null,"Error " +  e.getMessage());
        }
    }
    
}
