/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Adm;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class AdmDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(Adm a){
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }
    
    public void remover(Adm a){
        Adm aux = em.find(Adm.class,a.getID());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public Adm buscarPorCodigo(Integer codigo){
        return em.find(Adm.class, codigo);
    }
    
    public List<Adm> buscarTodos(){
        return em.createQuery("from Adm a").getResultList();
    }
    
    public Adm isLoginValido(String login, String senha){
        
        String sql = "Select u from Adm u "
                   + "where u.login = ?1 and u.senha = ?2";
        
        Adm user = em.createQuery(sql, Adm.class)
                         .setParameter("1", login)
                         .setParameter("2", senha)
                         .getSingleResult();
        
        if (user != null)
           return user;       
        
        return null;
        
    }
    
}
