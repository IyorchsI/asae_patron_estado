package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.estados;
public interface EstadoInt {
    Resultado enFormulacion(Formato formato);
    Resultado porCorregir(Formato formato);
    Resultado enEvaluacion(Formato formato);
    Resultado aprobado(Formato formato);
    Resultado rechazado(Formato formato);
    
}
