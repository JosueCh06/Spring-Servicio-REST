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

import com.cibertec.servidor.entity.Laboratorio;
import com.cibertec.servidor.serviceImpl.LaboratorioServiceImpl;

@CrossOrigin(origins = "http://localhost:8099/")
@RestController
@RequestMapping("/laboratorio")
public class LaboratorioController {

	@Autowired
	private LaboratorioServiceImpl laboratorioService;
	
	// Select * from table
	// Convierte a JSON
	@GetMapping("/listar")
	public ResponseEntity<List<Laboratorio>> listarLaboratorios() throws Exception{
		List<Laboratorio> lista = laboratorioService.listarTodos();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	// Select * from table where campo1 = ?
	// Convierte a JSON
	@GetMapping("/buscar/{codigo}")
	public Laboratorio buscarLaboratorio(@PathVariable("codigo") Integer cod) throws Exception{
		return laboratorioService.buscarPorId(cod);
	}
	
	// Insert into table values (?, ?)
	@PostMapping("/registrar")
	public void registrar(@RequestBody Laboratorio lab) throws Exception{
		laboratorioService.registrar(lab);
	}
	
	// Update table set campo1=?, campo2=? where campoN=?
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Laboratorio lab) throws Exception{
		laboratorioService.actualizar(lab);
	}
	
	// Delete from table where campoN=?
	@DeleteMapping("/eliminar/{codigo}")
	public void eliminar(@PathVariable("codigo") Integer cod) throws Exception{
		laboratorioService.eliminar(cod);
	}	
	
}
