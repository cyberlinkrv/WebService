package br.com.cyberlinkrv.objetos;

/**
 *
 * @author Cyber_Link_Recepcao
 */
public class CadLogin {
    
    int id; //NN
    String login;
    String senha;
    
    
    public CadLogin(){
       
    }

    public CadLogin(int id, String login, String senha) {
        this.id = id;
        this.login = login;
        this.senha = senha;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
    
}
