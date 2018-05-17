package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Itens;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class ItensDAO {
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(Itens a){
        em.getTransaction().begin();
        em.merge(a);
        em.getTransaction().commit();
    }
    
    public boolean remover(Itens a){
        Itens aux = em.find(Itens.class,a.getID());
        if (aux != null){
            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();
            return true;            
        }
        else
            return false;       
    }
    
    public Itens buscarPorCodigo(Integer codigo){
        return em.find(Itens.class, codigo);
    }
    
    public List<Itens> buscarTodos(){
        String sql = "from " + "Vendedor" + " v";
        List<Itens> v = em.createQuery(sql).getResultList();
        return v;
    }

}
