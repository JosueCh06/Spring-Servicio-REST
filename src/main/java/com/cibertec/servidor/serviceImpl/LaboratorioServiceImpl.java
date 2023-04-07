package com.cibertec.servidor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.servidor.entity.Laboratorio;
import com.cibertec.servidor.repository.LaboratorioDAO;

@Service
public class LaboratorioServiceImpl extends ICRUDImpl<Laboratorio, Integer>{

	@Autowired
	private LaboratorioDAO laboratorioDAO;

	@Override
	public JpaRepository<Laboratorio, Integer> getRepository() {
		// TODO Auto-generated method stub
		return laboratorioDAO;
	}

}
