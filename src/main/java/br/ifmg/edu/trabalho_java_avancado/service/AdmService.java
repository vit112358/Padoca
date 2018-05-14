/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.service;

import br.ifmg.edu.trabalho_java_avancado.dao.AdmDAO;
import br.ifmg.edu.trabalho_java_avancado.modelo.Adm;
import br.ifmg.edu.trabalho_java_avancado.util.NegocioException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Vitor
 */
public class AdmService implements Serializable {

    AdmDAO fabDAO = new AdmDAO();

    public void salvar(Adm v) throws NegocioException {
        if (v.getNome() == null || v.getLogin() == null || v.getSenha() == null) {
            throw new NegocioException("Verifique o Usuário! Ele pode não possuir "
                    + "Nome, Senha ou um login válido.");
        }

        fabDAO.salvar(v);
    }

    public void remover(Adm f) {
        fabDAO.remover(f);
    }

    public Adm buscarPorCodigo(Integer codigo) {
        return fabDAO.buscarPorCodigo(codigo);
    }

    public List<Adm> buscarTodos() {
        return fabDAO.buscarTodos();
    }

    public Adm loginValido(String login, String senha) throws NegocioException {

        if (login == null || senha == null) {
            throw new NegocioException("Informe o nome e senha do usuário");
        }

        if (login.trim().equals("") || senha.trim().equals("")) {
            throw new NegocioException("Informe o nome e senha do usuário");
        }

        return fabDAO.isLoginValido(login, senha);
    }
}
