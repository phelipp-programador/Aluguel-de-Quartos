package com.phddigital.quarto.configuration;

import com.phddigital.quarto.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationQuarto {
    @Autowired
    ResidenciaRepository residenciaRepository;

    /**
     * Caso o ja possua um quarto no banco de dados ele retornar true
     *
     * @return
     */
    @Bean(name = "contemResidencia")
    public boolean contemResidencia() {
        return (residenciaRepository.findAll().size() > 0) ? true : false;
    }
}
