/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Vendedor;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class VendedorDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(Vendedor a){
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }
    
    public boolean remover(Vendedor a){
        Vendedor aux = em.find(Vendedor.class,a.getID());
        if (aux != null){
            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();
            return true;            
        }
        else
            return false;       
    }
    
    public Vendedor buscarPorCodigo(Integer codigo){
        return em.find(Vendedor.class, codigo);
    }
    
    public List<Vendedor> buscarTodos(){
        String sql = "from " + "Vendedor" + " v";
        List<Vendedor> v = em.createQuery(sql).getResultList();
        return v;
    }
    
    public boolean isLoginValido(String login, String senha){
        
        String sql = "Select u from Funcionario u "
                   + "where u.login = ?1 and u.senha = ?2";
        
        Vendedor user = em.createQuery(sql, Vendedor.class)
                         .setParameter("1", login)
                         .setParameter("2", senha)
                         .getSingleResult();
        
        if (user != null)
           return true;       
        
        return false;
        
    }
    
}
