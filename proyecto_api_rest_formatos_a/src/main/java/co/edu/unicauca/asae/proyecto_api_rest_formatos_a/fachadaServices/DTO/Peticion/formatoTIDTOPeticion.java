package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Peticion;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class formatoTIDTOPeticion extends formatoDTOPeticion {
    private String estudiante2;
    private Integer codigo2;
    public formatoTIDTOPeticion(String estudiante2,Integer codigo2,String titulo, String estudiante, Integer codigo, String director) {
        super(titulo, estudiante, codigo, director);
        this.codigo2=codigo2;
        this.estudiante2=estudiante2;
    }
    public formatoTIDTOPeticion() {

    }
    
}
