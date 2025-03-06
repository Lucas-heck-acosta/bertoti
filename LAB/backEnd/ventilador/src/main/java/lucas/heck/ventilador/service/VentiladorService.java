package lucas.heck.ventilador.service;

import lucas.heck.ventilador.controller.DTO.CreateVentiladorDTO;
import lucas.heck.ventilador.controller.DTO.UpdateVentiladorDTO;
import lucas.heck.ventilador.entity.Ventilador;
import lucas.heck.ventilador.repository.VentilatorRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VentiladorService {

    private final VentilatorRepository ventilatorRepository;

    public VentiladorService(VentilatorRepository ventilatorRepositry) {
        this.ventilatorRepository = ventilatorRepositry;
    }

    public UUID createVentilador(CreateVentiladorDTO ventiladorDTO) {
        Ventilador entity = new Ventilador(
                null,
                ventiladorDTO.nome(),
                ventiladorDTO.potencia(),
                Instant.now(),
                null);

        Ventilador ventiladorSalvo = ventilatorRepository.save(entity);
        return ventiladorSalvo.getVent_id();
    }

    public Optional<Ventilador> getVentiladorById(UUID vent_id) {
        return ventilatorRepository.findById(vent_id);
    }

    public List<Ventilador> getAllVentiladors() {
        return ventilatorRepository.findAll();
    }

    public void updateVentiladorById(UUID ventId, UpdateVentiladorDTO updateVentiladorDTO) {
        Optional<Ventilador> ventiladorEntity = ventilatorRepository.findById(ventId);

        if (ventiladorEntity.isPresent()) {
            Ventilador ventilador = ventiladorEntity.get();

            if(updateVentiladorDTO.nome() != null) {
                ventilador.setNome(updateVentiladorDTO.nome());
            }

            if(updateVentiladorDTO.potencia() != 0) {
                ventilador.setPotencia(updateVentiladorDTO.potencia());
            }
            ventilatorRepository.save(ventilador);
        }

    }

    public void deleteVentiladorById(UUID ventId) {
        boolean exists = ventilatorRepository.existsById(ventId);
        if (exists) {
            ventilatorRepository.deleteById(ventId);
        }
    }
}
