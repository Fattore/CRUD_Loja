package objects;

import java.util.Date;

public class Distribuidores {
    private int codigoDist;
    private String nomeFantasia;
    private String razaoSocial;
    private String telefone;
    private String email;

    /*setters*/
    public void setCodigo(int CODDIST){
        this.codigoDist = CODDIST;
    }

    public void setNomeFantasia(String NomeFantasia){
        this.nomeFantasia = NomeFantasia;
    }

    public void setRazaoSocial(String RazaoSocial){
        this.razaoSocial = RazaoSocial;
    }
    
    public void setTelefone(String Telefone){
        this.telefone = Telefone;
    }
    
    public void setEmail(String Email){
        this.email = Email;
    }
    
    /*getters*/
    public int getCodigo(){
        return codigoDist;
    }
    
    public String getNomeFantasia(){
        return nomeFantasia;
    }
    
    public String getRazaoSocial(){
        return razaoSocial;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public String getEmail(){
        return email;
    }
}
