package com.cibertec.servidor.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.cibertec.servidor.entity.Medicamento;
import com.cibertec.servidor.repository.MedicamentoDAO;

@Service
public class MedicamentoServiceImpl extends ICRUDImpl<Medicamento, Integer>{

	@Autowired
	private MedicamentoDAO medicamentoDAO;

	@Override
	public JpaRepository<Medicamento, Integer> getRepository() {
		// TODO Auto-generated method stub
		return medicamentoDAO;
	}
	
}
