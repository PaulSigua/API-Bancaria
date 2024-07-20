package ec.edu.ups.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarjeta {
	
	@Id
    @GeneratedValue
    private Long id;

    private String numeroTarjeta;
    private String tipo; // Debito o Credito

    @ManyToOne
    @JoinColumn(name = "cuenta_id")
    private Cuenta cuenta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@Override
	public String toString() {
		return "Tarjeta [id=" + id + ", numeroTarjeta=" + numeroTarjeta + ", tipo=" + tipo + ", cuenta=" + cuenta + "]";
	}
	
}
