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
	private float detalleDeVentaPrecio;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "venta_total_id")
	private VentaTotal ventaTotal;
	
	@OneToOne(mappedBy = "detalleDeVenta", fetch = FetchType.LAZY)
	private Plato plato;

	public float getDetalleDeVentaPrecio() {
		return detalleDeVentaPrecio;
	}

	public void setDetalleDeVentaPrecio(float detalleDeVentaPrecio) {
		this.detalleDeVentaPrecio = detalleDeVentaPrecio;
	}

	public Integer getDetalleDeVentaId() {
		return detalleDeVentaId;
	}

	public void setDetalleDeVentaId(Integer detalleDeVentaId) {
		this.detalleDeVentaId = detalleDeVentaId;
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
