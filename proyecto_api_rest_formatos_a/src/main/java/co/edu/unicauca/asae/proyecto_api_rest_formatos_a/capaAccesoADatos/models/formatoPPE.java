package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class formatoPPE extends formatoEntity {

    private String asesor;
    private String carta;
    public formatoPPE(String carta, String asesor,Integer id,String titulo,String estudiante,Integer codigo,String director,Date fechaRegistro,enumEstados estados){
        super(id,titulo,estudiante,codigo,director,fechaRegistro,estados);
        this.asesor=asesor;
        this.carta=carta;
    }
    
}
