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
@Table(name="cliente")
public class Cliente implements Serializable {

	@Id
    @Column(nullable = false, name = "rut")
    private Long rut;

    @Column(nullable = false, name = "nombreCliente")
    private String nombreCliente;


    @Column(nullable = false, name = "telefono")
    private int telefono;


    @Column(nullable = false, name = "fechaNacimiento")
    private Date fechaNacimiento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "rut")
    @JsonIgnore
    private List<Reserva> reservas;

    @ManyToMany
    private Set<Registro> registros;

    public Cliente() {

    }

    public Cliente( String nombreCliente, int telefono ,Date fechaNacimiento) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

	public Long getRut() {
		return rut;
	}

	public void setRut(Long rut) {
		this.rut = rut;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public int getTelefonoCliente() {
		return telefono;
	}

	public void setTelefonoCliente(int telefono) {
		this.telefono = telefono;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaVencimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
