package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutoProduzido;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class ProdutosProduzidosDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(ProdutoProduzido p){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void remover(ProdutoProduzido p){
        ProdutoProduzido aux = em.find(ProdutoProduzido.class,p.getID());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public ProdutoProduzido buscarPorCodigo(Integer codigo){
        return em.find(ProdutoProduzido.class, codigo);
    }
    
    public List<ProdutoProduzido> buscarTodos(){
        return em.createQuery("from ProdutoProduzido p").getResultList();
    } 
}
