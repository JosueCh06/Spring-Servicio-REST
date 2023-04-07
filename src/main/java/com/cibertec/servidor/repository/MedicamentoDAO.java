package com.cibertec.servidor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cibertec.servidor.entity.Medicamento;

public interface MedicamentoDAO extends JpaRepository<Medicamento, Integer>{

}
