package br.ifmg.edu.trabalho_java_avancado.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Vitor
 */
public class FabricaEntity {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("PADARIAPU");
    
    public static EntityManager getEntityManager(){
           return emf.createEntityManager();
    }
}
