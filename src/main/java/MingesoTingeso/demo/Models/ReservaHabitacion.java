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
@Table(name="reservahabitacion")
public class ReservaHabitacion implements Serializable {

  @Id
    @Column(nullable = false, name = "id")
    private Long id;

    @Column(nullable = false, name = "fecha_inicio")
    private Date fecha_inicio;

    @Column(nullable = false, name = "fecha_termino")
    private Date fecha_termino;

    @ManyToOne(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Reserva reserva;

    @ManyToOne(cascade = CascadeType.ALL,
          fetch = FetchType.LAZY)
    @JoinColumn(name = "id_habitacion")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Habitacion habitacion;

    public ReservaHabitacion() {

    }

    public ReservaHabitacion(Date fecha_inicio, Date fecha_termino) {
        this.fecha_inicio = fecha_inicio;
        this.fecha_termino = fecha_termino;
    }

    public Date getFechaInicioRH() {
      return fecha_inicio;
    }

    public void setFechaInicioRH(Date fecha_inicio) {
      this.fecha_inicio = fecha_inicio;
    }

    public Date getFechaTerminoRH() {
      return fecha_termino;
    }

    public void setFechaTerminoRH(Date fecha_termino) {
      this.fecha_termino = fecha_termino;
    }


}
