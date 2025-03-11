package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.enumEstados;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.formatoEntity;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.formatoPPE;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.formatoTIE;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.repositories.formatoRepository;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Peticion.formatoDTOPeticion;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Peticion.formatoPPDTOPeticion;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Peticion.formatoTIDTOPeticion;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Respuesta.formatoDTORespuesta;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Respuesta.formatoPPDTORespuesta;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Respuesta.formatoTIDTORespuesta;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.estados.Formato;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.estados.Resultado;

@Service("IDFachadaFormatoServices")
public class FormatoServiceImpl implements IFormatoService{

    @Qualifier("IDFormatoRepository")
    private formatoRepository servicioAccesoBaseDatos;

    private ModelMapper modelMapper;
    
    public FormatoServiceImpl(formatoRepository servicioAccesoBaseDatos, ModelMapper modelMapper){
        this.servicioAccesoBaseDatos=servicioAccesoBaseDatos;
        this.modelMapper=modelMapper;
    }

    @Override
    public List<formatoDTORespuesta> findAll() {
        List<formatoDTORespuesta> listaRetornar=null;
		Optional<Collection<formatoEntity>> formatosEntityOpt = this.servicioAccesoBaseDatos.findAll();
		
		// Si el Optional está vacío, devolvemos una lista vacía
		if (formatosEntityOpt.isEmpty()) {
			listaRetornar=List.of(); // Retorna una lista inmutable vacía
			
		}
		
		// Convertimos la colección a una lista y la mapeamos a formatoDTO
		Collection<formatoEntity> formatosEntity = formatosEntityOpt.get();
		listaRetornar = formatosEntity.stream().map(formato ->{
			if(formato instanceof formatoPPE){
				return this.modelMapper.map(formato, formatoPPDTORespuesta.class);
			}else{
				return this.modelMapper.map(formato, formatoTIDTORespuesta.class);
			}
		}).toList();
		
		
		return listaRetornar;
    }

	@Override
    public List<formatoDTORespuesta> findAllByDate(Date fechaInicio, Date fechaFin) {
        List<formatoDTORespuesta> listaRetornar=null;
		Optional<Collection<formatoEntity>> formatosEntityOpt = this.servicioAccesoBaseDatos.findAll();
		fechaInicio.toString();
		fechaFin.toString();
		
		
		// Si el Optional está vacío, devolvemos una lista vacía
		if (formatosEntityOpt.isEmpty()) {
			listaRetornar=List.of(); // Retorna una lista inmutable vacía
			
		}
		
		// Convertimos la colección a una lista y la mapeamos a formatoDTO
		Collection<formatoEntity> formatosEntity = formatosEntityOpt.get().stream()
				.filter(formato -> formato.getFechaRegistro().after(fechaInicio) &&
						formato.getFechaRegistro().before(fechaFin))
				.toList();
				
		listaRetornar = formatosEntity.stream().map(formato ->{
				if(formato instanceof formatoPPE){
					return this.modelMapper.map(formato, formatoPPDTORespuesta.class);
				}else{
					return this.modelMapper.map(formato, formatoTIDTORespuesta.class);
				}
		}).toList();
		
		
		return listaRetornar;
    }

    @Override
    public formatoDTORespuesta findById(Integer id) {
        formatoDTORespuesta formatoRetornar=null;
		Optional<formatoEntity> optionalFormato = this.servicioAccesoBaseDatos.findById(id);
		if(optionalFormato.isPresent())
		{
			formatoEntity formatoEntity=optionalFormato.get();
			if(formatoEntity instanceof formatoPPE){
				formatoRetornar= this.modelMapper.map(formatoEntity, formatoPPDTORespuesta.class);
			}else{
				formatoRetornar= this.modelMapper.map(formatoEntity, formatoTIDTORespuesta.class);
			}
			
		}

		return formatoRetornar;
    }

    @Override
    public formatoDTORespuesta save(formatoDTOPeticion formato) {
		formatoDTORespuesta formatoDTO=null;
		if(formato instanceof formatoPPDTOPeticion){
			formatoPPE formatoPPEntity = this.modelMapper.map(formato, formatoPPE.class);
			formatoPPEntity.setEstados(enumEstados.EN_FORMULACION);
			formatoPPEntity.setFechaRegistro(new Date());
			formatoEntity objFormatoEntity = this.servicioAccesoBaseDatos.save(formatoPPEntity);
			System.out.println(objFormatoEntity);
			formatoDTO= this.modelMapper.map(objFormatoEntity, formatoPPDTORespuesta.class);
		}else{
			formatoTIE formatoTIEntity = this.modelMapper.map(formato, formatoTIE.class);
			formatoTIEntity.setEstados(enumEstados.EN_FORMULACION);
			formatoTIEntity.setFechaRegistro(new Date());
			formatoEntity objFormatoEntity = this.servicioAccesoBaseDatos.save(formatoTIEntity);
			System.out.println(objFormatoEntity);
			formatoDTO= this.modelMapper.map(objFormatoEntity, formatoTIDTORespuesta.class);
		}
		return formatoDTO;
    }

    @Override
    public formatoDTORespuesta update(Integer id, formatoDTOPeticion formato) {
        formatoEntity formatoActualizado=null;
		Optional<formatoEntity> formatoEntityOp = this.servicioAccesoBaseDatos.findById(id);
		formatoDTORespuesta respuesta = null;
		if(formatoEntityOp.isPresent())
		{
			formatoEntity objFormatoDatosNuevos=formatoEntityOp.get();
			Optional<formatoEntity> optionalFormato = null;
			if(objFormatoDatosNuevos instanceof formatoPPE){
				formatoPPE objFormatoPP = (formatoPPE) objFormatoDatosNuevos;
				formatoPPDTOPeticion formatoPP = (formatoPPDTOPeticion) formato;
				objFormatoPP.setTitulo(formatoPP.getTitulo());
				objFormatoPP.setAsesor(formatoPP.getAsesor());
				objFormatoPP.setCodigo(formatoPP.getCodigo());
				objFormatoPP.setEstudiante(formatoPP.getEstudiante());
				objFormatoPP.setDirector(formatoPP.getDirector());
				optionalFormato = this.servicioAccesoBaseDatos.update(id, objFormatoPP);
				formatoActualizado=optionalFormato.get();
				respuesta = this.modelMapper.map(formatoActualizado, formatoPPDTORespuesta.class);
			}else{
				formatoTIE objFormatoTI = (formatoTIE) objFormatoDatosNuevos;
				formatoTIDTOPeticion formatoTI = (formatoTIDTOPeticion) formato;
				objFormatoTI.setTitulo(formatoTI.getTitulo());
				objFormatoTI.setCodigo(formatoTI.getCodigo());
				objFormatoTI.setEstudiante(formatoTI.getEstudiante());
				objFormatoTI.setCodigo2(formatoTI.getCodigo2());
				objFormatoTI.setEstudiante2(formatoTI.getEstudiante2());
				objFormatoTI.setDirector(formatoTI.getDirector());
				optionalFormato = this.servicioAccesoBaseDatos.update(id, objFormatoTI);
				formatoActualizado=optionalFormato.get();
				respuesta = this.modelMapper.map(formatoActualizado, formatoTIDTORespuesta.class);
			}
		}

		return respuesta;
    }
	@Override
    public Resultado cambiarEstado(Integer id, enumEstados estado) {
		formatoDTORespuesta formatoActual = findById(id);
        Formato objFormato = new Formato(formatoActual.getEstados());
        Resultado objResultado = null;
        switch (estado) {
            case EN_FORMULACION->objResultado=objFormato.getEstado().enFormulacion(objFormato);
            case EN_EVALUACION->objResultado=objFormato.getEstado().enEvaluacion(objFormato);
            case POR_CORREGIR->objResultado=objFormato.getEstado().porCorregir(objFormato);
            case APROBADO->objResultado=objFormato.getEstado().aprobado(objFormato);
            case RECHAZADO->objResultado=objFormato.getEstado().rechazado(objFormato);
        }
        if(objResultado.cambioPermitido()){
			this.servicioAccesoBaseDatos.cambiarEstado(id, estado);
		}
        return objResultado;
    }
    
}
