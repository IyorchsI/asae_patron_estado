package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.repositories;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.enumEstados;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.formatoEntity;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.formatoPPE;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.formatoTIE;

@Repository("IDFormatoRepository")
public class formatoRepository {
    
    private Map<Integer, formatoEntity> mapaFormatos;

    public formatoRepository(){
        this.mapaFormatos= new HashMap<>();
        this.cargarFormatos();
    }

    // Listar todos los formatos (opcional si está vacío)
    public Optional<Collection<formatoEntity>> findAll() {
        System.out.println("Invocando a listar formatos");
        return mapaFormatos.isEmpty() ? Optional.empty() : Optional.of(mapaFormatos.values());
    }

    // Buscar un formato por ID
    public Optional<formatoEntity> findById(Integer id) {
        System.out.println("Invocando a consultar un formato");
        return Optional.ofNullable(mapaFormatos.get(id));
    }

    // Guardar un nuevo formato
    public formatoEntity save(formatoEntity formato) {
        Integer aux=this.mapaFormatos.size()+1;
        formato.setId(aux);
        this.mapaFormatos.put(aux, formato); // Guarda el cliente
        return formato;
    }

    // Actualizar un formato existente
    public Optional<formatoEntity> update(Integer id, formatoEntity formato) {
        Optional<formatoEntity> respuesta;
		System.out.println("Invocando a actualizar un formato");
        if (this.mapaFormatos.containsKey(id)) {
            this.mapaFormatos.put(id, formato);
            respuesta= Optional.of(formato);
        }
        else{
            respuesta= Optional.empty();
        }
       
		return respuesta;
    }
    
    public Boolean cambiarEstado(Integer id,enumEstados estados){
        Boolean respuesta;
        formatoEntity formato;
		System.out.println("Invocando cambiar estado");
        if (this.mapaFormatos.containsKey(id)) {
            formato=this.mapaFormatos.get(id);
            formato.setEstados(estados);
            this.mapaFormatos.put(id, formato);
            respuesta= true;
        }
        else{
            respuesta= false;
        }
        return respuesta;
    }

    private void cargarFormatos(){
        mapaFormatos.put(1, new formatoPPE("asesor",1,"titulo","estudiante",123,"director",new Date(),enumEstados.EN_FORMULACION));
        mapaFormatos.put(2, new formatoTIE(3312, "aasd",2,"titulo","estudiante",123,"director",new Date(),enumEstados.EN_FORMULACION));
    }

}
