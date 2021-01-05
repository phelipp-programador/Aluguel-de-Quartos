package com.phddigital.quarto.service;

import com.phddigital.quarto.model.ModelDao;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ServiceDao {
    default Optional save(JpaRepository repository, ModelDao entity){
        ModelDao save =(ModelDao) repository.save(entity);
        return (save!=null)?Optional.of(save):Optional.empty();

    }
    default Optional<List> select(JpaRepository repository){
        List all = repository.findAll();
        return (all.size()>0)?Optional.of(all):Optional.empty();
    }
}
