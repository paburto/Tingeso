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
@Table(name="registro")
public class Registro implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Long id_registro;

    @Column(nullable = false, name = "representante")
    private String representante;

    @Column(nullable = false, name = "fecha_inicio")
    private Date fecha_inicio;

    @Column(nullable = false, name = "fecha_termino")
    private Date fecha_termino;

    @ManyToOne(cascade = CascadeType.ALL,
					fetch = FetchType.LAZY)
		@JoinColumn(name = "id_habitacion")
		@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
		private Habitacion habitacion;

    @ManyToMany(mappedBy="registros")
    private Set<Cliente> clientes;

    @ManyToMany(mappedBy="registros")
    private Set<Servicio> servicios;

    public Registro() {

    }

    public Registro(String representante, Date fecha_inicio,  Date fecha_termino) {
        this.representante = representante;
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }

	public Long getIdRegistro() {
		return id_registro;
	}

	public void setIdRegistro(Long id_registro) {
		this.id_registro = id_registro;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante= representante;
	}

	public Date getFechaInicio(){
		return fecha_inicio;
	}

	public void setFechaInicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}


	public Date getFechaTermino(){
		return fecha_termino;
	}

	public void setFechaTermino(Date fecha_termino) {
		this.fecha_termino = fecha_termino;
	}

}
