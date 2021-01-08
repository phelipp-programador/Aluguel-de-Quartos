package com.phddigital.quarto.repository;

import com.phddigital.quarto.model.Cliente;
import com.phddigital.quarto.model.Residencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ResidenciaRepository extends JpaRepository<Residencia,Integer> {

}
