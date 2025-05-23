package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.estados;


public class EstadoCorregir implements EstadoInt{
  
    @Override
    public Resultado enFormulacion(Formato formato) {
        return new Resultado(false, "El formato no se puede enviar a formulación");

    }

    @Override
    public Resultado porCorregir(Formato formato) {
        return new Resultado(false, "El formato no se puede enviar a corregir");
    }

    @Override
    public Resultado enEvaluacion(Formato formato) {
        return new Resultado(true, "El formato se envió a evaluar");
    }

    @Override
    public Resultado aprobado(Formato formato) {
        return new Resultado(false, "El formato no se puede aprobar");
    }

    @Override
    public Resultado rechazado(Formato formato) {
        return new Resultado(false, "El formato no se puede rechazar");
    }
    
    @Override
    public String toString(){
        return "Corrección";
    }  
}
