package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.Materia_PrimaDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.Materia_Prima;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class Materia_PrimaService implements Serializable{
    
    Materia_PrimaDAO fabDAO = new Materia_PrimaDAO();
    
    public void salvar(Materia_Prima m) throws NegocioException{
        if(m.getNome() == null || m.getFornecedor() == null){
            throw new NegocioException("Verifique a Materia Prima! Ela pode não possuir "
                    + "Nome ou um Fornecedor.");
        }
        
        fabDAO.salvar(m);
    }
    
    public void remover(Materia_Prima f){
        fabDAO.remover(f);
    }
    
    public Materia_Prima buscarPorCodigo(Integer codigo){
        return fabDAO.buscarPorCodigo(codigo);
    }
    
    public List<Materia_Prima> buscarTodos(){
        return fabDAO.buscarTodos();
    }
    
    public List<Materia_Prima> getMateriaPeloNome(String nome){
        return fabDAO.getMateriaPeloNome(nome);
    }
    
}
