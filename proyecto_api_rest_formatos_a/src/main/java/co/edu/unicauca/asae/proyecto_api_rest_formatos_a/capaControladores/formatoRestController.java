package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaControladores;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.capaAccesoADatos.models.enumEstados;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Peticion.formatoDTOPeticion;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.DTO.Respuesta.formatoDTORespuesta;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.estados.Resultado;
import co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.services.IFormatoService;

@RestController
@RequestMapping("/api/formatos")
public class formatoRestController {
   	@Autowired
	@Qualifier("IDFachadaFormatoServices")
	private IFormatoService formatoService;

	@GetMapping("/listar")
	public List<formatoDTORespuesta> listarFormatos() {		
		return formatoService.findAll();
	}

	@GetMapping("/listarfecha")
	public List<formatoDTORespuesta> listarFormatosFecha(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaInicio,@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaFin ) {		
		return formatoService.findAllByDate(fechaInicio,fechaFin);
	}

	@GetMapping("/consultar/{id}")
	public formatoDTORespuesta consultarFormato(@PathVariable Integer id) {
		formatoDTORespuesta objFormato = null;
		objFormato = formatoService.findById(id);
		return objFormato;
	}
	@PostMapping("/crear")
	public formatoDTORespuesta crearFormato(@RequestBody formatoDTOPeticion formato) {
		formatoDTORespuesta objFormato = null;
		objFormato = formatoService.save(formato);
		return objFormato;
	}

	@PutMapping("/actualizar/{id}")
	public formatoDTORespuesta actualizarFormato(@RequestBody formatoDTOPeticion formato, @PathVariable Integer id) {
		formatoDTORespuesta objFormato = null;
		objFormato = formatoService.update(id, formato);
		return objFormato;
	}
	@PatchMapping("/cambiarestado/{id}/{estado}")
	public Resultado actualizarFormato(@PathVariable Integer id, @PathVariable enumEstados estado) {
		Resultado resFormato = formatoService.cambiarEstado(id, estado);
		return resFormato;
	}
}
