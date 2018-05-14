package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.VendaDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.Venda;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class VendaService implements Serializable{
    
    VendaDAO fabDAO = new VendaDAO();
    
    public void salvar(Venda v) throws NegocioException{
        if(v.getID() == null || v.getVendedor() == null || v.getDataVenda() == null){
            throw new NegocioException("Verifique a Venda! Ela pode não possuir "
                    + "um Vendedor responsável, ID ou uma data definida.");
        }
        
        fabDAO.salvar(v);
    }
    
    public void remover(Venda f){
        fabDAO.remover(f);
    }
    
    public Venda buscarPorCodigo(Integer codigo){
        return fabDAO.buscarPorCodigo(codigo);
    }
    
    public List<Venda> buscarTodos(){
        return fabDAO.buscarTodos();
    }
    
}
