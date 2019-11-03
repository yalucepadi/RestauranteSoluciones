package pe.edu.upn.model.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_de_venta")
public class DetalleDeVenta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "detalle_de_venta_id")
	private Integer detalleDeVentaId;

	@Column(name = "detalle_de_venta_precio")
	private float detalleDeVenta_precio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venta_total_id")
	private VentaTotal ventaTotal;
	
	@OneToOne(mappedBy = "detalleDeVenta", fetch = FetchType.LAZY)
	private Plato plato;

	public Integer getDetalleDeVentaId() {
		return detalleDeVentaId;
	}

	public void setDetalleDeVentaId(Integer detalleDeVentaId) {
		this.detalleDeVentaId = detalleDeVentaId;
	}

	public float getDetalleDeVenta_precio() {
		return detalleDeVenta_precio;
	}

	public void setDetalleDeVenta_precio(float detalleDeVenta_precio) {
		this.detalleDeVenta_precio = detalleDeVenta_precio;
	}

	public VentaTotal getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(VentaTotal ventaTotal) {
		this.ventaTotal = ventaTotal;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

}
