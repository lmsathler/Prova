package services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import entity.User;
import exception.NotFoundException;
import repository.MicroEmpresaRepository;

@Service
public class MicroEmpresaService {
	
	private final MicroEmpresaRepository microEmpresaRepository;

	public MicroEmpresaService(MicroEmpresaRepository microEmpresaRepository) {
		this.microEmpresaRepository = microEmpresaRepository;
	}
	
	public User create(User u) {
		u.setDataDeCadastro(LocalDateTime.now());

		microEmpresaRepository.save(u);
		
		return u;
	}
	
	
	public User update(String id, User u) {

		var existing = get(id);

		existing.setName(u.getName());
		existing.setCnpj(u.getCnpj());
		existing.setEmail(u.getEmail());
		
		existing.setDataDeCadastro(LocalDateTime.now());

		microEmpresaRepository.save(existing);
		
		return existing;
	}
	

	public User get(String id) {
		
		var user = microEmpresaRepository.findById(id);
		
		if (user.isEmpty()) {
			throw new NotFoundException("User with ID " + id + " not found");
		} 
		
		return user.get();
	}
	
	public List<User> getAll() {
		return microEmpresaRepository.findAll();
	}

	public void delete(String id) {
		get(id);
		
		microEmpresaRepository.deleteById(id);
	}

}
