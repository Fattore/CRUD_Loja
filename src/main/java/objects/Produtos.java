package objects;

import java.util.Date;

public class Produtos {
    private int codigoProd;
    private float precoVenda;
    private String descricao;
    private Date validade;
    private float precoCusto;
    private int estoque;
    private int codigoDist;

    /*setters*/
    public void setCodigoProd(int CODPROD){
        this.codigoProd = CODPROD;
    }

    public void setPrecoVenda(float PrecoVenda){
        this.precoVenda = PrecoVenda;
    }

    public void setDescricao(String Descricao){
        this.descricao = Descricao;
    }
    
    public void setValidade(Date Validade){
        this.validade = Validade;
    }
    
    public void setPrecoCusto(float PrecoCusto){
        this.precoCusto = PrecoCusto;
    }
    
    public void setEstoque(int Estoque){
        this.estoque = Estoque;
    }
    
    public void setCodigoDist(int CODDIST){
        this.codigoDist = CODDIST;
    }
    
    /*getters*/
    public int getCodigoProd(){
        return codigoProd;
    }

    public float getPrecoVenda(){
        return precoVenda;
    }

    public String getDescricao(){
        return descricao;
    }
    
    public Date getValidade(){
        return validade;
    }
    
    public float getPrecoCusto(){
        return precoCusto;
    }
    
    public int getEstoque(){
        return estoque;
    }
    
    public int getCodigoDist(){
        return codigoDist;
    }

    public java.sql.Date getDataValidade() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
