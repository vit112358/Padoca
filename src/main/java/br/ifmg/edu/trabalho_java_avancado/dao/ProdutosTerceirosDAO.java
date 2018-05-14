package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutosTerceiros;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class ProdutosTerceirosDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(ProdutosTerceiros p){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void remover(ProdutosTerceiros p){
        ProdutosTerceiros aux = em.find(ProdutosTerceiros.class,p.getID());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public ProdutosTerceiros buscarPorCodigo(Integer codigo){
        return em.find(ProdutosTerceiros.class, codigo);
    }
    
    public List<ProdutosTerceiros> buscarTodos(){
        return em.createQuery("from ProdutosTerceiros p").getResultList();
    }
    
}
