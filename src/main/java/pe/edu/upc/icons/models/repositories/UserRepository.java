package pe.edu.upc.icons.models.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.upc.icons.models.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername( String username ) throws Exception;
}