package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Dto.MicroEmpresaDto;
import entity.User;
import services.MicroEmpresaService;

@RestController
public class MicroEmpresaController {
	
private final MicroEmpresaService microEmpresaService;
	
	public MicroEmpresaController(MicroEmpresaService microEmpresaService) {
		this.microEmpresaService = microEmpresaService;
	}
	
	@GetMapping("/users/{id}")
	public MicroEmpresaDto getById(@PathVariable String id) {
		var user = microEmpresaService.get(id);
		
		return new MicroEmpresaDto(user);
	}
	
	@GetMapping("/users")
	public List<MicroEmpresaDto> getAll() {
		var users = microEmpresaService.getAll();
		
		var userDtos = new ArrayList<MicroEmpresaDto>();
		
		for (var user: users) {
			userDtos.add(new MicroEmpresaDto(user));
		}
		
		return userDtos;
	}
	
	@PostMapping("/users")
	public MicroEmpresaDto create(@RequestBody MicroEmpresaDto u) {
		var user = new User(u);
		
		user = microEmpresaService.create(user);
		
		return new MicroEmpresaDto(user); 
	}
	
	@PutMapping("/users/{id}")
	public MicroEmpresaDto update(@PathVariable String id, @RequestBody MicroEmpresaDto u) {
		var user = new User(u);

		user = microEmpresaService.update(id, user);
		
		return new MicroEmpresaDto(user);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		microEmpresaService.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
