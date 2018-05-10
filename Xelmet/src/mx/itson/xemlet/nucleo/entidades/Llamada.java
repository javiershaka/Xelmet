package mx.itson.xemlet.nucleo.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author javiershaka en esta clase tenemos id que es su identificador receptor
 * a quien llamara tipoLlamada si es llamada FIJA o MOVIL duracion donde se
 * redondea si es menor o mayor dependiendo los segundos que le pongas y por eso
 * es un int fecha donde guarda la fecha idReferencial que guarda el id de
 * cliente para hacer la referencia a ese cliente en la relacion oneToMany
 *
 */
@Entity
public class Llamada {

    private int id;
    private String receptor;
    private String tipoLlamada;
    private int duracionMinutos;

    private String fecha;
    private int idReferencial;

    /**
     * @return the id
     */
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the receptor
     */
    public String getReceptor() {
        return receptor;
    }

    /**
     * @param receptor the receptor to set
     */
    public void setReceptor(String receptor) {
        this.receptor = receptor;
    }

    /**
     * @return the duracionMinutos
     */
    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    /**
     * @param duracionMinutos the duracionMinutos to set
     */
    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the tipoLlamada
     */
    public String getTipoLlamada() {
        return tipoLlamada;
    }

    /**
     * @param tipoLlamada the tipoLlamada to set
     */
    public void setTipoLlamada(String tipoLlamada) {
        this.tipoLlamada = tipoLlamada;
    }

    /**
     * @return the idReferencial el id hace referencia al id del cliente 
     */
    public int getIdReferencial() {
        return idReferencial;
    }

    /**
     * @param idReferencial the idReferencial to set
     */
    public void setIdReferencial(int idReferencial) {
        this.idReferencial = idReferencial;
    }

}
