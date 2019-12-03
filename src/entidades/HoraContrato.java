package entidades;

import java.util.Date;

public class HoraContrato {

	private Date data;
	private Double valorPorHora;
	private int horas;
	
	public HoraContrato() {
	}

	public HoraContrato(Date data, Double valorPorHora, int horas) {
		this.data = data;
		this.valorPorHora = valorPorHora;
		this.horas = horas;
	}
	
	public Double valorTotal(){
		return valorPorHora * horas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getValorPorHora() {
		return valorPorHora;
	}

	public void setValorPorHora(Double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}


	
	
	

}
