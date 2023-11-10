package Cohorte14Equipo21.back.repositorios;

import Cohorte14Equipo21.back.modelos.registrodecompra.RegistroDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistroDeCompraRepository extends JpaRepository<RegistroDeCompra, Long> {

    @Query("SELECT r FROM RegistroDeCompra r WHERE r.user.id = :id")
    RegistroDeCompra buscarPorClienteId(@Param("id") Long id);
}
