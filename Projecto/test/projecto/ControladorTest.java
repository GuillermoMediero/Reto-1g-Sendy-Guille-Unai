/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projecto;

import Modelo_UML.Asistente;
import Modelo_UML.Clasificacion;
import Modelo_UML.Dueno;
import Modelo_UML.Entrenador;
import Modelo_UML.Equipo;
import Modelo_UML.Jornada;
import Modelo_UML.Jugador;
import Modelo_UML.Partido;
import Modelo_UML.Usuario;
import java.util.ArrayList;
import javax.swing.JFrame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1GDAW11
 */
public class ControladorTest {
    
    public ControladorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class Controlador.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Controlador.main(args);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of inicioSesion method, of class Controlador.
     * comprobacion si el inicio de session de usuario va correcto
     */
    @Test
    public void testInicioSesionusu() {
        System.out.println("inicioSesion");
        String correo = "pepi";
        String clave = "123";
        Controlador.inicioSesion(correo, clave);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of llamarPrincipal method, of class Controlador.
     * testea si envia a la ventana de usuario despes del inicio de session
     */
    @Test
    public void testLlamarPrincipalusu() {
        System.out.println("llamarPrincipal");
        Controlador.Rol rol = Controlador.Rol.USUARIO;
        String nombre = "pepi";
        Controlador.llamarPrincipal(rol, nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    @Test
    public void testInicioSesionadmin() {
        System.out.println("inicioSesion");
        String correo = "sendy";
        String clave = "123";
        Controlador.inicioSesion(correo, clave);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of llamarPrincipal method, of class Controlador.
     * testea si envia a la ventana de administrador
     */
    @Test
    public void testLlamarPrincipaladmin() {
        System.out.println("llamarPrincipal");
        Controlador.Rol rol = Controlador.Rol.ADMINISTRADOR;
        String nombre = "sendy";
        Controlador.llamarPrincipal(rol, nombre);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
  /**
     * Test of cerrarSesion method, of class Controlador.
     * testea si cierra session
     */
    @Test
    public void testCerrarSesionusu() {
        System.out.println("cerrarSesion");
        Controlador.cerrarSesion();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }      
    
}
