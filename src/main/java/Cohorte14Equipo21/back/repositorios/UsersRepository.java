package Cohorte14Equipo21.back.repositorios;

import Cohorte14Equipo21.back.modelos.usuarios.usuario.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    @Query("SELECT u FROM User u WHERE userName = :valor")
    Optional<User> findByUsername(@Param("valor") String userName);
}
