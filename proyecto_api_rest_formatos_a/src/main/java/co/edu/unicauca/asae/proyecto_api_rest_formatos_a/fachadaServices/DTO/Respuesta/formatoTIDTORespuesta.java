package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Respuesta;

import java.util.Date;

import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.enumEstados;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class formatoTIDTORespuesta extends formatoDTORespuesta {
    private String estudiante2;
    private Integer codigo2;
    public formatoTIDTORespuesta(String estudiante2,Integer codigo2,Integer id, String titulo, String estudiante, Integer codigo, String director, Date fechaRegistro, enumEstados estado) {
        super(id,titulo, estudiante, codigo, director, fechaRegistro, estado);
        this.codigo2=codigo2;
        this.estudiante2=estudiante2;
    }
    public formatoTIDTORespuesta() {
    }
}
