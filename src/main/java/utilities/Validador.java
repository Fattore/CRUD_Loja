package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;
import javax.swing.JOptionPane;

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
    
    public static void DataValidade(String valor) {
       
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
        LocalDateTime now = LocalDateTime.now();
        
        String dataAtual = dtf.format(now);

        int dataPc = Integer.parseInt(dataAtual.replace("/",""));
        int dataProd = Integer.parseInt(valor.replace("/",""));
        
        if( dataProd >= dataPc){
            int vencido = (dataProd-dataPc);
            
            JOptionPane.showMessageDialog(null,"O produto está vencida há: "+Integer.toString(vencido)+" dias");
        }
        
    }
    
}
