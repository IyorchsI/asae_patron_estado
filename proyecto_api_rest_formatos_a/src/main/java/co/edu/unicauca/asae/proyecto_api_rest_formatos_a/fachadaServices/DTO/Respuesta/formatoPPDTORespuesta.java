package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Respuesta;

import java.util.Date;

import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.enumEstados;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class formatoPPDTORespuesta extends formatoDTORespuesta {
    private String asesor;
    public formatoPPDTORespuesta(String asesor, Integer id,String titulo, String estudiante, Integer codigo, String director, Date fechaRegistro, enumEstados estado) {
        super(id,titulo, estudiante, codigo, director, fechaRegistro, estado);
        this.asesor=asesor;
    }
    public formatoPPDTORespuesta() {
    }
}
