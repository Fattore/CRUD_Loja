package objects;

public class Vendas {
    private int codigoVenda;
    private String dataVenda;
    private String horaVenda;
    private float total;
    private int codigoCli;

    /*setters*/
    public void setCodigo(int CODVENDA){
        this.codigoVenda = CODVENDA;
    }

    public void setDataVenda(String DataVenda){
        this.dataVenda = DataVenda;
    }

    public void setHoraVenda(String HoraVenda){
        this.horaVenda = HoraVenda;
    }
    
    public void setTotal(float Total){
        this.total = Total;
    }
    
    public void setCodigoCli(int CODCLI){
        this.codigoCli = CODCLI;
    }
    
    /*getters*/
    public int getCodigo(){
        return codigoVenda;
    }
    
    public String getDataVenda(){
        return dataVenda;
    }
    
    public String getHoraVenda(){
        return horaVenda;
    }
    
    public float getTotal(){
        return total;
    }
    
    public int getCodigoCli(){
        return codigoCli;
    }
}
