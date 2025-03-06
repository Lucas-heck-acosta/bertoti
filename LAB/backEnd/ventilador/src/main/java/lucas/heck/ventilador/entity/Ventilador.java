package lucas.heck.ventilador.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "ventiladores")
public class Ventilador {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID vent_id;
    @Column(name = "vent_nome")
    private String nome;
    @Column(name = "vent_potencia")
    private int potencia;

    @CreationTimestamp
    private Instant creationTimeStamp;
    @UpdateTimestamp
    private Instant updateTimeStamp;

    @Version
    private int version;

    public Ventilador() {
    }

    public Ventilador(UUID vent_id, String nome, int potencia, Instant creationTimeStamp, Instant updateTimeStamp) {
        this.vent_id = vent_id;
        this.nome = nome;
        this.potencia = potencia;
        this.creationTimeStamp = creationTimeStamp;
        this.updateTimeStamp = updateTimeStamp;
    }

    public UUID getVent_id() {
        return vent_id;
    }

    public void setVent_id(UUID vent_id) {
        this.vent_id = vent_id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Instant getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Instant creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Instant getUpdateTimeStamp() {
        return updateTimeStamp;
    }

    public void setUpdateTimeStamp(Instant updateTimeStamp) {
        this.updateTimeStamp = updateTimeStamp;
    }
}
