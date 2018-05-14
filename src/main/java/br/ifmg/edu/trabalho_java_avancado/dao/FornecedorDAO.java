package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Fornecedor;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class FornecedorDAO {
    
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(Fornecedor f){
        em.getTransaction().begin();
        em.merge(f);
        em.getTransaction().commit();
    }
    
    public boolean remover(Fornecedor f){
        Fornecedor aux = em.find(Fornecedor.class,f.getID());
        if (aux != null){
            em.getTransaction().begin();
            em.remove(aux);
            em.getTransaction().commit();
            return true;            
        }
        else
            return false;          
    }
    
    public Fornecedor buscarPorCodigo(Integer codigo){
        return em.find(Fornecedor.class, codigo);
    }
    
    public List<Fornecedor> buscarTodos(){
        String sql = "from " + "Fornecedor" + " v";
        List<Fornecedor> v = em.createQuery(sql).getResultList();
        return v;
    }
    
    public List<Fornecedor> getFornecedorPeloNome(String nome){
        
        String sql = "Select c from Fornecedor c "
                   + "where c.razaoSocial like ?1";
        
        
        return em.createQuery(sql, Fornecedor.class)
                .setParameter("1", nome)
                .getResultList();  
    }
}
