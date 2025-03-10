package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class formatoEntity {
    private Integer id;
    private String titulo;
    private String estudiante;
    private Integer codigo;
    private String director;
    private Date fechaRegistro; //Manejar en fachada
    private enumEstados estados;
    
    
}
