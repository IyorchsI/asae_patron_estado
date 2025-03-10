package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Peticion;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class formatoPPDTOPeticion extends formatoDTOPeticion {
    private String asesor;
    public formatoPPDTOPeticion(String asesor,String titulo, String estudiante, Integer codigo, String director) {
        super( titulo, estudiante, codigo, director);
        this.asesor=asesor;
    }
    public formatoPPDTOPeticion() {
    }
    
}
