package services;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.annotation.security.RunAs;

import static org.mockito.ArgumentMatchers.any;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import Dto.MicroEmpresaDto;
import entity.User;
import repository.MicroEmpresaRepository;

@ExtendWith(MockitoExtension.class)
public class MicroEmpresaServiceTest {
	
	@InjectMocks
	private MicroEmpresaService microEmpresaService;
	
	@Test
	void create() {
		User user = new User(new MicroEmpresaDto());
		MicroEmpresaRepository microEmpresaRepository = mock(MicroEmpresaRepository.class);
	    when(microEmpresaRepository.save(any())).thenReturn(user);
	    microEmpresaService.create(user);
	    verify(microEmpresaRepository , times(1)).save(any());
		
	}
	
	@Test
	void get() {
	}

}
