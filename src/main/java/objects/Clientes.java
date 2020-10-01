package objects;

import java.util.Date;

public class Clientes {
    private int codigo;
    private String nome;
    private Date nascimento;
    private String endereco;
    private String telefone;
    private String email;

    /*setters*/
    public void setCodigo(int COD){
        this.codigo = COD;
    }

    public void setNome(String Nome){
        this.nome = Nome;
    }

    public void setNascimento(Date Nascimento){
        this.nascimento = Nascimento;
    }
    
    public void setEndereco(String Endereco){
        this.endereco = Endereco;
    }
    
    public void setTelefone(String Telefone){
        this.telefone = Telefone;
    }
    
    public void setEmail(String Email){
        this.email = Email;
    }
    
    /*getters*/
    public int getCodigo(){
        return codigo;
    }
    
    public String getNome(){
        return nome;
    }
    
    public Date getNascimento(){
        return nascimento;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public String getTelefone(){
        return telefone;
    }
    
    public String getEmail(){
        return email;
    }
}
