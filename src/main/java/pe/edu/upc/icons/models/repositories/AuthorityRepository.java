package pe.edu.upc.icons.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.icons.models.entities.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long>{
	
}