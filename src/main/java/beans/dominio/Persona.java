package beans.dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author devorlando
 */
@Entity
public class Persona implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id_persona")
    private Integer idPersona;
    
    @Column(nullable = false, length = 45)
    private String nombre;
    
    @Column(name = "apellido_paterno", nullable = false, length = 45)
    private String apPaterno;
    
    @Column(name = "apellido_materno", nullable = false, length = 45)
    private String apMaterno;
    
    @Column(nullable = false, length = 45)
    private String email;
    
    @Column(length = 45)
    private String telefono;
    
    public Persona() {
    }
    
    public Persona(int idPersona) {
        this.idPersona = idPersona;
    }

    public Persona(String nombre, String apPaterno, String apMaterno, String email, String telefono) {
        this.nombre = nombre;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.email = email;
        this.telefono = telefono;
    }

    public Integer getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(Integer idPersona) {
        this.idPersona = idPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Persona{" + "idPersona=" + idPersona + ", nombre=" + nombre
                + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno
                + ", email=" + email + ", telefono=" + telefono + '}';
    }
}