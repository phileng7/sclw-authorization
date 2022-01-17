package com.sclw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sclw.model.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer>{

}
