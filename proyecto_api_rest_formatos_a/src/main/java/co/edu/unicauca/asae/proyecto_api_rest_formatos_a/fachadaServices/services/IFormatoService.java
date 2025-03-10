package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.services;

import java.util.Date;
import java.util.List;

import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.enumEstados;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Peticion.formatoDTOPeticion;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Respuesta.formatoDTORespuesta;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.estados.Resultado;

public interface IFormatoService {

    public List<formatoDTORespuesta> findAll();
    public List<formatoDTORespuesta> findAllByDate(Date fechaInicio, Date fechaFin);
    public formatoDTORespuesta findById(Integer id);
    public formatoDTORespuesta save (formatoDTOPeticion formato);
    public formatoDTORespuesta update (Integer id, formatoDTOPeticion formato);
    public Resultado cambiarEstado (Integer id ,enumEstados estado);
    
} 
