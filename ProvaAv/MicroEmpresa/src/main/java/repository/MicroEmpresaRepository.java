package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import entity.User;

public interface MicroEmpresaRepository extends MongoRepository<User, String>{

}
