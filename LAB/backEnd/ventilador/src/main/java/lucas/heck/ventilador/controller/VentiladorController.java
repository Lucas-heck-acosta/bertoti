package lucas.heck.ventilador.controller;

import lucas.heck.ventilador.controller.DTO.CreateVentiladorDTO;
import lucas.heck.ventilador.controller.DTO.UpdateVentiladorDTO;
import lucas.heck.ventilador.entity.Ventilador;
import lucas.heck.ventilador.service.VentiladorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ventiladores")
public class VentiladorController {

    private final VentiladorService ventiladorService;

    public VentiladorController(VentiladorService ventiladorService) {
        this.ventiladorService = ventiladorService;
    }

    @PostMapping
    public ResponseEntity<Ventilador> postVentilador(@RequestBody CreateVentiladorDTO ventiladorDTO) {
        try {
            UUID vent_id = ventiladorService.createVentilador(ventiladorDTO);
            return ResponseEntity.created(URI.create("/ventiladores/" + vent_id)).build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error creating Ventilador", e);
        }
    }

    @GetMapping("/{vent_id}")
    public ResponseEntity<Ventilador> getVentilador(@PathVariable UUID vent_id) {
        try {
            var ventilador = ventiladorService.getVentiladorById(vent_id);
            if (ventilador.isPresent()) {
                return ResponseEntity.ok().body(ventilador.get());
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving Ventilador", e);
        }
    }

    @GetMapping
    public ResponseEntity<List<Ventilador>> getVentiladors() {
        try {
            var ventiladores = ventiladorService.getAllVentiladors();
            return ResponseEntity.ok().body(ventiladores);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving Ventiladores", e);
        }
    }

    @PutMapping("/{vent_id}")
    public ResponseEntity<Void> updateVentiladorById(@PathVariable("vent_id") UUID vent_id,
                                                     @RequestBody UpdateVentiladorDTO updateVentiladorDTO) {
        try {
            ventiladorService.updateVentiladorById(vent_id, updateVentiladorDTO);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error updating Ventilador", e);
        }
    }

    @DeleteMapping("/{vent_id}")
    public ResponseEntity<Void> deleteVentilador(@PathVariable UUID vent_id) {
        try {
            ventiladorService.deleteVentiladorById(vent_id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error deleting Ventilador", e);
        }
    }
}