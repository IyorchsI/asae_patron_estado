package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Respuesta;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.enumEstados;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, include =  JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = formatoPPDTORespuesta.class, name = "PP"),
    @JsonSubTypes.Type(value = formatoTIDTORespuesta.class, name = "TI")   
})
public abstract class formatoDTORespuesta {
    private Integer id;
    private String titulo;
    private String estudiante;
    private Integer codigo;
    private String director;
    private Date fechaRegistro; //Manejar en fachada
    private enumEstados estados;

}
