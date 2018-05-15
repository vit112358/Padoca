package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Producao;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class ProducaoDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(Producao a){
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }
    
    public void remover(Producao a){
        Producao aux = em.find(Producao.class,a.getId());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public Producao buscarPorCodigo(Integer codigo){
        return em.find(Producao.class, codigo);
    }
    
    public List<Producao> buscarTodos(){
        return em.createQuery("from Producao a").getResultList();
    }
}
