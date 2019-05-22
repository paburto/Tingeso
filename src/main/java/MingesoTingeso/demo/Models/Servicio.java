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
@Table(name="servicio")
public class Servicio implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_servicio")
    private Long id_servicio;

    @Column(nullable = false, name = "descripcion")
    private String descripcion;

    @Column(nullable = false, name = "nombre_servicio")
    private String nombre_servicio;

    @Column(nullable = false, name = "precio_servicio")
    private int precio_servicio;

    @ManyToMany
    private Set<Registro> registrosServicio;

    public Servicio() {

    }

    public Servicio(String descripcion, String nombre_servicio, int precio_servicio) {
        this.descripcion = descripcion;
        this.nombre_servicio = nombre_servicio;
        this.precio_servicio= precio_servicio;
    }

	public Long getIdServicio() {
		return id_servicio;
	}

	public void setIdServicio(Long id) {
		this.id_servicio= id_servicio;
	}

	public String getDescripcionServicio() {
		return descripcion;
	}

	public void setDescripcionServicio(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombreServicio() {
		return nombre_servicio;
	}

	public void setNombreServicio(String nombre_servicio) {
		this.nombre_servicio = nombre_servicio;
	}

	public int getPrecio() {
		return precio_servicio;
	}

	public void setPrecio(int precio_servicio) {
		this.precio_servicio = precio_servicio;
	}

}
