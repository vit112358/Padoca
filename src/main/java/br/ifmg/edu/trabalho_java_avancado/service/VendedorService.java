package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.VendedorDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.Vendedor;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class VendedorService implements Serializable{
    
    VendedorDAO fabDAO = new VendedorDAO();
    
    public void salvar(Vendedor v) throws NegocioException{
        if(v.getNome() == null || v.getLogin() == null){
            throw new NegocioException("Verifique o Usuário! Ele pode não possuir "
                    + "um ID, Nome ou um login válido.");
        }
        
        fabDAO.salvar(v);
    }
    
    public void remover(Vendedor f){
        fabDAO.remover(f);
    }
    
    public Vendedor buscarPorCodigo(Integer codigo) throws NegocioException{
        
        if (codigo == null || codigo <=0 )  
          throw new NegocioException("Informe um código válido.");
        
        return fabDAO.buscarPorCodigo(codigo);
    }
    
    public List<Vendedor> buscarTodos(){
        List<Vendedor> v = fabDAO.buscarTodos();
        return v;
    }
    
    public Boolean loginValido(String login, String senha) throws NegocioException{
        
        if (login == null || senha == null)
          throw new NegocioException("Informe o nome e senha do usuário");
        
        
        if (login.trim().equals("") || senha.trim().equals(""))
          throw new NegocioException("Informe o nome e senha do usuário");
        
        return fabDAO.isLoginValido(login, senha);                
    }
    
}
