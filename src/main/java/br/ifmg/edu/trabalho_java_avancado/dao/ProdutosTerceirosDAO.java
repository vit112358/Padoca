package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutoTerceiros;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class ProdutosTerceirosDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(ProdutoTerceiros p){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void remover(ProdutoTerceiros p){
        ProdutoTerceiros aux = em.find(ProdutoTerceiros.class,p.getID());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public ProdutoTerceiros buscarPorCodigo(Integer codigo){
        return em.find(ProdutoTerceiros.class, codigo);
    }
    
    public List<ProdutoTerceiros> buscarTodos(){
        return em.createQuery("from ProdutosTerceiros p").getResultList();
    }
    
}
