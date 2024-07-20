package ec.edu.ups.api.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private int id;
	private String nombres;
	private String Apellidos;
	private String cedula;
	private String telefono;
	private String fechaNacimiento;
	private String correo;
	
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
    private List<Cuenta> cuentas;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return Apellidos;
	}
	public void setApellidos(String apellidos) {
		Apellidos = apellidos;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public List<Cuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}
	
	public void addCuenta(Cuenta cuenta) {
        if (cuentas == null) {
            cuentas = new ArrayList<>();
        }
        cuentas.add(cuenta);
        cuenta.setUsuario(this); // Asegura la relación bidireccional
    }
	
	public void eliminarCuenta(Cuenta cuenta) {
		cuentas.remove(cuenta);
	}
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombres=" + nombres + ", Apellidos=" + Apellidos + ", cedula=" + cedula
				+ ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + ", correo=" + correo
				+ ", cuentas=" + cuentas + "]";
	}
	
}
