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
@Table(name="historial")
public class Historial implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_historial")
    private Long id_historial;

    @Column(nullable = false, name = "descripcion")
    private String descripcion;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Usuario usuario;

    public Historial() {

    }

    public Historial(String descripcion){
      this.descripcion = descripcion;
    }

	public Long getIdHistorial() {
		return id_historial;
	}

	public void setIdHistorial(Long id) {
		this.id_historial = id_historial;
	}

	public String getDescripcionHistorial() {
		return descripcion;
	}

	public void setDescripcionHistorial(String descripcion) {
		this.descripcion= descripcion;
	}

}
