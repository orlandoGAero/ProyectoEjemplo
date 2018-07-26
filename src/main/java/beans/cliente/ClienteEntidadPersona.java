package beans.cliente;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import beans.dominio.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author devorlando
 */
public class ClienteEntidadPersona {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Persona persona1 = new Persona("Barry", "Allen", "Allen", "barry@gmail.com", "7223456783");
        log.debug("Objeto a persistir: " + persona1);
        
        em.persist(persona1);
        
        tx.commit();
        log.debug("Objeto persistido: " + persona1);
        em.close();
    }
}
