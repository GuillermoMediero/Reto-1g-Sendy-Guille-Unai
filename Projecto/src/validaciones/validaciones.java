/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validaciones;

import Excepciones.DatoNoValido;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author unai diez
 */
public class validaciones {
    
    public static void validarnombre(String nombre,String tabla) throws DatoNoValido {
      // Comprobar si no esta vacio el dato recibido
        if (nombre.isEmpty())
           throw new DatoNoValido("Es obligatorio indicar el nombre");
       
      // Expresión regular solo letras y 1 como mínimo
      Pattern p = Pattern.compile("^[a-zA-Z ]{1,}$");
      Matcher m = p.matcher(nombre);
      if (!m.matches())
          throw new DatoNoValido("El nombre del "+ tabla+" debe estar formado solo por letras");
    } 
    // Comprobar rol
    public static void validarrol(String rol ) throws DatoNoValido {
      // Comprobar si no esta vacio el dato recibido
        if (rol.isEmpty())
           throw new DatoNoValido("Es obligatorio indicar el rol");
       
      // Expresión regular solo letras y 1 como mínimo
      Pattern p = Pattern.compile("^[a-zA-Z ]{1,}$");
      Matcher m = p.matcher(rol);
      if (!m.matches())
          throw new DatoNoValido("El rol del jugar está formado sólo por letras");
    }
     // Comprobar nickname
    public static void validarnickname(String nickname) throws DatoNoValido {
      // Comprobar si no esta vacio el nickname recibido
        if (nickname.isEmpty())
           throw new DatoNoValido("Es obligatorio indicar el nickname");
       
      // Expresión regular solo letras y 1 como mínimo
      Pattern p = Pattern.compile("^[a-z0-9]{1,}$");
      Matcher m = p.matcher(nickname);
      if (!m.matches())
          throw new DatoNoValido("El nickname del jugadr está formado sólamente por letras y numeros");
    }
          // Comprobar sueldo
    public static void validarsueldo(String sueldo,String tabla) throws DatoNoValido {
      // Comprobar si no esta vacio el dato recibido
        if (sueldo.isEmpty())
           throw new DatoNoValido("Es obligatorio indicar el nombre");
       
      // Expresión regular solo numerico y 1 como mínimo con posibilidad de un coma con obligacion de dos deccimales
      Pattern p = Pattern.compile("^[0-9 ]{1,}(\\,[\\\\w-]{2})?$");
      Matcher m = p.matcher(sueldo);
      if (!m.matches())
          throw new DatoNoValido("El sueldo del "+ tabla+" debe ser numerico");
    }
    public static void validarcorreo(String correo) throws DatoNoValido {
      
       
      // Expresión regular solo letras y 1 como mínimo
      Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
      Matcher m = p.matcher(correo);
      if (!m.matches())
          throw new DatoNoValido("El nombre del producto está formado sólo por letras");
    }
    // comprobar si existe el usuario
    public static void validarcontrasena(String contrasena) throws DatoNoValido {
      // Expresión regular solo letras y 1 como mínimo
      Pattern p = Pattern.compile("^[a-zA-Z ]{1,}$");
      Matcher m = p.matcher(contrasena);
      if (!m.matches())
          throw new DatoNoValido("El nombre del producto está formado sólo por letras");
    }
    // comprobar si existe el usuario
    public static String validarusuario(String correo,String contrasena) {
      String tipo="";
       if(tipo.isEmpty())
       {
           tipo="usuario";
       }
       else{ 
           if(tipo.isEmpty())
         tipo="admin";
        else {
       }
       }
       return tipo;
      // comprobar existencias
     
    }
    
}
