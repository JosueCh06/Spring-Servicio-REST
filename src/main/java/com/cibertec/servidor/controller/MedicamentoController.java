package com.cibertec.servidor.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.servidor.entity.Medicamento;
import com.cibertec.servidor.serviceImpl.MedicamentoServiceImpl;
import com.cibertec.servidor.utils.NotFoundException;

@CrossOrigin(origins = "http://localhost:8099/")
@RestController
@RequestMapping("/medicamento")
public class MedicamentoController {

	@Autowired
	private MedicamentoServiceImpl medicamentoService;
	
	// Select * from table
	// Convierte a JSON
	@GetMapping("/listar")
	public ResponseEntity<List<Medicamento>> listarMedicamentos() throws Exception{
		List<Medicamento> lista = medicamentoService.listarTodos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("buscar/{codigo}")
	public ResponseEntity<Medicamento> buscar(@PathVariable("codigo") int cod) throws Exception {
		Medicamento med = medicamentoService.buscarPorId(cod);
		// validar
		if(med==null)
			throw new NotFoundException();
		return new ResponseEntity<>(med, HttpStatus.OK);
	}
	
	@PostMapping("/registrar")
	public ResponseEntity<Medicamento> registrar(@RequestBody Medicamento med) throws Exception {
		Medicamento m = medicamentoService.registrar(med);
		return new ResponseEntity<>(m, HttpStatus.CREATED);
	}
	
	@PutMapping("/actualizar")
	public ResponseEntity<Medicamento> actualizar(@RequestBody Medicamento med) throws Exception {
		Medicamento m = medicamentoService.buscarPorId(med.getCodigo());
		// validar
		if(m==null)
			throw new NotFoundException();
		else
			m = medicamentoService.actualizar(med);
		return new ResponseEntity<>(m, HttpStatus.OK);
	}
	
	@DeleteMapping("eliminar/{codigo}")
	public ResponseEntity<Void> eliminar(@PathVariable("codigo") int cod) throws Exception {
		Medicamento m = medicamentoService.buscarPorId(cod);
		// validar
		if(m==null)
			throw new NotFoundException();
		else
			medicamentoService.eliminar(cod);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
