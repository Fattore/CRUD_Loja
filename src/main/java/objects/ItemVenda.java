package objects;

public class ItemVenda {
    private int codigoItemVenda;
    private int quantidade;
    private float subTotal;
    private int codigoVenda;
    private int codigoProd;

    /*setters*/
    public void setCodigoItemVenda(int CODIV){
        this.codigoItemVenda = CODIV;
    }

    public void setQuantidade(int Quantidade){
        this.quantidade = Quantidade;
    }

    public void setSubTotal(float SubTotal){
        this.subTotal = SubTotal;
    }
    
    public void setCodigoVenda(int CODVenda){
        this.codigoVenda = CODVenda;
    }
    
    public void setCodigoProd(int CODProd){
        this.codigoProd = CODProd;
    }
    
    /*getters*/
    public int getCodigoItemVenda(){
        return codigoItemVenda;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    
    public float getSubTotal(){
        return subTotal;
    }
    
    public int getCodigoVenda(){
        return codigoVenda;
    }
    
    public int getCodigoProd(){
        return codigoProd;
    }    
}
