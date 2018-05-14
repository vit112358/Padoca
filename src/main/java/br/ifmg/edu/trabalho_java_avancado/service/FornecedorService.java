package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.FornecedorDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.Fornecedor;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class FornecedorService implements Serializable {
    
    FornecedorDAO fabDAO = new FornecedorDAO();
    
    public void salvar(Fornecedor f) throws NegocioException{
        if(f.getCNPJ() == null || f.getRazaoSocial() == null){
            throw new NegocioException("Verifique o Fornecedor! Ele pode não possuir "
                    + "um CNPJ ou uma Razão Social.");
        }
        
        fabDAO.salvar(f);
    }
    
    public void remover(Fornecedor f){
        fabDAO.remover(f);
    }
    
    public Fornecedor buscarPorCodigo(Integer codigo){
        return fabDAO.buscarPorCodigo(codigo);
    }
    
    public List<Fornecedor> buscarTodos(){
        return fabDAO.buscarTodos();
    }
    
    public List<Fornecedor> getMateriaPeloNome(String nome){
        return fabDAO.getFornecedorPeloNome(nome);
    }
}
