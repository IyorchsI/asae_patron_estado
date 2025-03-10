package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.estados;


public class  EstadoFormulacion implements EstadoInt{
    
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
        return new Resultado(false, "El formato ya fue aprobado");
    }

    @Override
    public Resultado rechazado(Formato formato) {
        return new Resultado(false, "El formato no se puede rechazar");
    }
    
    @Override
    public String toString(){
        return "En formulación";
    }
}