package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class formatoTIE extends formatoEntity {

    private String estudiante2;
    private Integer codigo2;
    public formatoTIE(Integer codigo2,String estudiante2,Integer id,String titulo,String estudiante,Integer codigo,String director,Date fechaRegistro,enumEstados estados){
        super(id,titulo,estudiante,codigo,director,fechaRegistro,estados);
        this.codigo2=codigo2;
        this.estudiante2=estudiante2;
    }
    
    
    
}