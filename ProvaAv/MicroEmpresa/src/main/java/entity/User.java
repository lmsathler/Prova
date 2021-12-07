package entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import Dto.MicroEmpresaDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {	

	@Id 
	private String id;
	
	private String name;	
	
	private String email;
	
	private String cnpj;
	
	private LocalDateTime dataDeCadastro;
	
	public User(MicroEmpresaDto microEmpresaDto) {
		this.id = microEmpresaDto.getId();
		this.name = microEmpresaDto.getName();
		this.email = microEmpresaDto.getEmail();
		this.cnpj = microEmpresaDto.getCnpj();
		this.dataDeCadastro = microEmpresaDto.getDataDeCadastro();
	}
}
