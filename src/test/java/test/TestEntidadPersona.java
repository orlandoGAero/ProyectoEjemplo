package test;

import static org.junit.Assert.assertTrue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import beans.dominio.Persona;

/**
 *
 * @author devorlando
 */
public class TestEntidadPersona {
    
    static EntityManager em = null;
    static EntityTransaction tx = null;
    static EntityManagerFactory emf = null;
    
    Logger log = LogManager.getRootLogger();
    
    @BeforeClass
    public static void init() throws Exception {
        emf = Persistence.createEntityManagerFactory("PersonaPU");
    }
    
    @Before
    public void setup() {
        try {
            em = emf.createEntityManager();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Test
    public void testPersonaEntity() {
        log.debug("Iniciando test Persona Entity con JPA");
        
        assertTrue(em != null);
        
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Persona persona1 = new Persona("Irving", "Gonzalez", "Reyes", "igonz@gmail", "5543234567");
        
        log.debug("Objeto a persistir: " + persona1);
        
        em.persist(persona1);
        tx.commit();
        
        assertTrue(persona1.getIdPersona() != null);
        
        log.debug("Objeto persistido: " + persona1);
        log.debug("Fin test Persona Entity con JPA");
    }
    
    @After
    public void tearDown() throws Exception {
        if (em != null) {
            em.close();
        }
    }
}
