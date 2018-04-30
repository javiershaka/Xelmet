
package mx.itson.xemlet.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author mppme
 */
@Entity
public class tipollamada {
    
    private int idtipollamada;
    
    @Id
    @GeneratedValue
    public int getId() {
        return idtipollamada;
    }

    public int getIdtipollamada() {
        return idtipollamada;
    }

    public void setIdtipollamada(int idtipollamada) {
        this.idtipollamada = idtipollamada;
    }
    
}
