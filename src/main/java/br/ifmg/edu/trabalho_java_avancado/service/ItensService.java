package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.ItensDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.Itens;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class ItensService {
    
    ItensDAO fabDAO = new ItensDAO();

    public void salvar(Itens v) throws NegocioException {
        if (v.getProduto() == null || v.getMp()== null) {
            throw new NegocioException("Verifique o Usuário! Ele pode não possuir "
                    + "matéria prima ou produtos.");
        }

        fabDAO.salvar(v);
    }

    public void remover(Itens f) {
        fabDAO.remover(f);
    }

    public Itens buscarPorCodigo(Integer codigo) {
        return fabDAO.buscarPorCodigo(codigo);
    }

    public List<Itens> buscarTodos() {
        return fabDAO.buscarTodos();
    }
    
}
