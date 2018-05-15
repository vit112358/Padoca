package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.ProdutosTerceirosDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutoTerceiros;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class ProdutosTerceirosService implements Serializable{
    
    ProdutosTerceirosDAO fabDAO = new ProdutosTerceirosDAO();
    
    public void salvar(ProdutoTerceiros v) throws NegocioException{
        if(v.getNome() == null || v.getPrecoVenda() == null || v.getEstoque() == null){
            throw new NegocioException("Verifique o Produto! Ele pode não possuir "
                    + "Nome, Estoque ou um Preço.");
        }
        
        fabDAO.salvar(v);
    }
    
    public void remover(ProdutoTerceiros f){
        fabDAO.remover(f);
    }
    
    public ProdutoTerceiros buscarPorCodigo(Integer codigo){
        return fabDAO.buscarPorCodigo(codigo);
    }
    
    public List<ProdutoTerceiros> buscarTodos(){
        return fabDAO.buscarTodos();
    }
    
}
