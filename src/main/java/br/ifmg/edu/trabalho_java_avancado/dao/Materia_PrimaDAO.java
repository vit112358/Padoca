package br.ifmg.edu.trabalho_java_avancado.dao;

import br.ifmg.edu.trabalho_java_avancado.modelo.Materia_Prima;
import br.ifmg.edu.trabalho_java_avancado.util.FabricaEntity;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Vitor
 */
public class Materia_PrimaDAO {
    EntityManager em = FabricaEntity.getEntityManager();
    
    public void salvar(Materia_Prima m){
        em.getTransaction().begin();
        em.merge(m);
        em.getTransaction().commit();
    }
    
    public void remover(Materia_Prima m){
        Materia_Prima aux = em.find(Materia_Prima.class,m.getID());
        em.getTransaction().begin();
        em.remove(aux);
        em.getTransaction().commit();        
    }
    
    public Materia_Prima buscarPorCodigo(Integer codigo){
        return em.find(Materia_Prima.class, codigo);
    }
    
    public List<Materia_Prima> buscarTodos(){
        String sql = "from " + "Materia_Prima" + " m";
        List<Materia_Prima> m = em.createQuery(sql).getResultList();
        return m;
    }
    
    public List<Materia_Prima> getMateriaPeloNome(String nome){
        
        String sql = "Select c from Materia_Prima c "
                   + "where c.nome like ?1";
        
        
        return em.createQuery(sql, Materia_Prima.class)
                .setParameter("1", nome)
                .getResultList();  
    }
}
