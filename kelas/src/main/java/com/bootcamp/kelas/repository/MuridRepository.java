package com.bootcamp.kelas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.kelas.model.Murid;

@Repository
public interface MuridRepository extends JpaRepository<Murid, Long>{

}
