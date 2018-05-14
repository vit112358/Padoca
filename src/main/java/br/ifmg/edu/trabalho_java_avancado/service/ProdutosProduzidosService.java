package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.ProdutosProduzidosDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutosProduzidos;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class ProdutosProduzidosService implements Serializable{
    
    ProdutosProduzidosDAO fabDAO = new ProdutosProduzidosDAO();
    
    public void salvar(ProdutosProduzidos v) throws NegocioException{
        if(v.getNome() == null || v.getPrecoVenda() == null || v.getMateriaisUsados() == null){
            throw new NegocioException("Verifique o Produto! Ele pode não possuir "
                    + "um Nome, Materiais Usados ou um Preço.");
        }
        
        fabDAO.salvar(v);
    }
    
    public void remover(ProdutosProduzidos f){
        fabDAO.remover(f);
    }
    
    public ProdutosProduzidos buscarPorCodigo(Integer codigo){
        return fabDAO.buscarPorCodigo(codigo);
    }
    
    public List<ProdutosProduzidos> buscarTodos(){
        return fabDAO.buscarTodos();
    }
}
