package MingesoTingeso.demo.Models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="reserva")
public class Reserva implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Long id_reserva;

    @Column(nullable = false, name = "estado")
    private String estado;

		@ManyToOne(cascade = CascadeType.ALL,
					fetch = FetchType.LAZY)
		@JoinColumn(name = "rut")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Cliente cliente;

		@ManyToOne(cascade = CascadeType.ALL,
					fetch = FetchType.LAZY)
		@JoinColumn(name = "id_usuario")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Usuario usuario;


		@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
		@JoinColumn(name = "id_reserva")
		@JsonIgnore
		private List<ReservaHabitacion> reservahabitaciones;



    public Reserva() {

    }

    public Reserva(String estado) {
        this.estado = estado;
    }

	public Long getIdReserva() {
		return id_reserva;
	}

	public void setIdReserva(Long id_reserva) {
		this.id_reserva = id_reserva;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
