package Dto;

import java.time.LocalDateTime;

import entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MicroEmpresaDto {
	
	private String id;
	
	private String name;
	
	private String cnpj; 
	
	private String email;
	
	private LocalDateTime dataDeCadastro;	

	public MicroEmpresaDto(User u) {
		this.id = u.getId();
		this.name = u.getName();
		this.cnpj = u.getCnpj();
		this.email = u.getEmail();
		this.dataDeCadastro = u.getDataDeCadastro();
	}

}
