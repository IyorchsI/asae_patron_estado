package co.edu.unicauca.asae.proyecto_api_rest_formatos_a.fachadaServices.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class maper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
