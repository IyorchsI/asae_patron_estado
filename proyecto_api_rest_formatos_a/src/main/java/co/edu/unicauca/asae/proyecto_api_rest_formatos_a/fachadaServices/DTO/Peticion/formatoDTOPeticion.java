package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Peticion;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME,include =  JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = formatoPPDTOPeticion.class, name = "PP"),
    @JsonSubTypes.Type(value = formatoTIDTOPeticion.class, name = "TI")   
})
public abstract class  formatoDTOPeticion {
    private String titulo;
    private String estudiante;
    private Integer codigo;
    private String director;

}
