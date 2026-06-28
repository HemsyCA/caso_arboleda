package com.banco.banco_arboleda.repository;

import com.banco.banco_arboleda.model.Recarga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecargaRepository extends JpaRepository<Recarga, Long> {}