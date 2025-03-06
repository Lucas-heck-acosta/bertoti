package lucas.heck.ventilador.repository;

import lucas.heck.ventilador.entity.Ventilador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VentilatorRepository extends JpaRepository<Ventilador, UUID> {
}
