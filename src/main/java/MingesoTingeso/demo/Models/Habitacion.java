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
@Table(name="habitacion")
public class Habitacion implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Long id_habitacion;

    @Column(nullable = false, name = "tipo")
    private String tipo;

    @Column(nullable = false, name = "capacidad_ninos")
    private int capacidad_ninos;

    @Column(nullable = false, name = "capacidad_adultos")
    private int capacidad_adultos;

    @Column(nullable = false, name = "precio_noche")
    private int precio_noche;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_habitacion")
    @JsonIgnore
    private List<Registro> registros;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_habitacion")
    @JsonIgnore
    private List<ReservaHabitacion> reservahabitaciones;


    public Habitacion() {

    }

    public Habitacion(String tipo, int capacidad_ninos,int capacidad_adultos, int precio_noche) {
        this.tipo = tipo;
        this.capacidad_ninos = capacidad_ninos;
        this.capacidad_adultos = capacidad_adultos;
        this.precio_noche = precio_noche;
    }

	public Long getIdHabitacion() {
		return id_habitacion;
	}

	public void setIdHabitacion(Long id_habitacion) {
		this.id_habitacion= id_habitacion;
	}

	public String getTipoHabitacion() {
		return tipo;
	}

	public void setTipoHabitacion(String tipo) {
		this.tipo= tipo;
	}

	public int getCapacidadNinos() {
		return capacidad_ninos;
	}

	public void setCapacidadNinos(int capacidad_ninos) {
		this.capacidad_ninos = capacidad_ninos;
	}

	public int getCapacidadAdultos() {
		return capacidad_adultos;
	}

	public void setCapacidadAdultos(int capacidad_adultos) {
		this.capacidad_adultos = capacidad_adultos;
	}
  public int getPrecioNoche() {
    return precio_noche;
  }

  public void setPrecioNoche(int precio_noche) {
    this.precio_noche = precio_noche;
  }
}
