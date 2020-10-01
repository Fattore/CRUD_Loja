package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Validador {
    
    public static boolean ValorENumeroInteiro(String valor)
    {
        try
        {
          Integer.parseInt(valor);
          return true;
        }         
        catch(Exception e)   
        {
            return false;
        }
    }
    
    public static boolean ValorEDataValida(String valor)
    {
        try
        {
          SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy");
          new java.sql.Date(format.parse(valor).getTime());
          return true;
        }         
        catch(Exception e)   
        {
            return false;
        }
    }
    
    
}
