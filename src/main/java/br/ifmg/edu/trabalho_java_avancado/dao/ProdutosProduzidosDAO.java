package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.ProdutosProduzidos;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class ProdutosProduzidosDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(ProdutosProduzidos p){
        em.getTransaction().begin();
        em.merge(p);
        em.getTransaction().commit();
    }
    
    public void remover(ProdutosProduzidos p){
        ProdutosProduzidos aux = em.find(ProdutosProduzidos.class,p.getID());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public ProdutosProduzidos buscarPorCodigo(Integer codigo){
        return em.find(ProdutosProduzidos.class, codigo);
    }
    
    public List<ProdutosProduzidos> buscarTodos(){
        return em.createQuery("from ProdutosProduzidos p").getResultList();
    } 
}
