package com.phddigital.quarto.repository;

import com.phddigital.quarto.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Integer> {
    @Query(nativeQuery = true,value = "Select * from cliente where upper(nome) like concat(upper(:nome),'%')")
    public Optional<List<Cliente>> findLikeName(@Param("nome") String nome);
}
