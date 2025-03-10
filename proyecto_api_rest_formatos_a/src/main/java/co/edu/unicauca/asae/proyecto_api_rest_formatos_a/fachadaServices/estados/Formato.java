package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.estados;

import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.enumEstados;
import lombok.NoArgsConstructor;
@NoArgsConstructor
public class Formato {
    private EstadoInt estado;
    
    public Formato(enumEstados estado) {
        switch (estado) {
            case EN_FORMULACION->this.estado=new EstadoFormulacion();
            case EN_EVALUACION->this.estado=new EstadoEvaluacion();
            case POR_CORREGIR->this.estado=new EstadoCorregir();
            case APROBADO->this.estado=new EstadoAprobado();
            case RECHAZADO->this.estado=new EstadoRechazado();
        }
   }
    
   public EstadoInt getEstado()  {
       return this.estado;
   }
}
