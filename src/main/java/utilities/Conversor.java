package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversor {
    
    public static Date StringParaData(String valor)
    {
        try
        {
            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            return new java.sql.Date(format.parse(valor).getTime());
        }
        catch(Exception e)
        {
            return null;
        }
    }
}