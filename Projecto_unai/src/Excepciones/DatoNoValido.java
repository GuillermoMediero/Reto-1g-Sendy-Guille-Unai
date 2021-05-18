package Excepciones;

public class DatoNoValido extends Exception{
    private String message;
    public DatoNoValido(){
        
    }
    public DatoNoValido(String mensaje){
        message = mensaje;
    }
    @Override
    public String getMessage(){
        return message;
    }
}
