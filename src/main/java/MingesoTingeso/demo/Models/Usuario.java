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
@Table(name="usuario")
public class Usuario implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id_usuario;

    @Column(nullable = false, name = "nombre_usuario")
    private String nombre_usuario;

    @Column(nullable = false, name = "rol_usuario")
    private String rol_usuario;

    @Column(nullable = false, name = "correo_usuario")
    private String correo_usuario;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private List<Historial> historiales;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private List<Reserva> reservas;


    public Usuario() {

    }

    public Usuario(String nombre_usuario, String rol_usuario, String correo_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.rol_usuario = rol_usuario;
        this.correo_usuario = correo_usuario;
    }

	public Long getIdUsuario() {
		return id_usuario;
	}

	public void setIdUsuario(Long id) {
		this.id_usuario = id_usuario;
	}

	public String getNombreUsuario() {
		return nombre_usuario;
	}

	public void setNombreUsuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getRolUsuario() {
		return rol_usuario;
	}

	public void setRolUsuario(String rol_usuario) {
		this.rol_usuario = rol_usuario;
	}

  public String getCorreoUsuario(){
    return correo_usuario;
  }

  public void setCorreoUsuario(String correo_usuario){
    this.correo_usuario = correo_usuario;
  }
}
