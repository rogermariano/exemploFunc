package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelFuncionario;

public class Funcionario {

	private String nome;
	private NivelFuncionario nivelFuncionario;
	private Double salarioBase;
	
	private Departamento departamento;
	
	private List<HoraContrato> contratos = new ArrayList<>();
	
	public Funcionario(){
		
	}

// não inserir listas no construtor, inicialize a lista na declaração do atributo
	
	public Funcionario(String nome, NivelFuncionario nivelFuncionario,
			Double salarioBase, Departamento departamento) {
		this.nome = nome;
		this.nivelFuncionario = nivelFuncionario;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	
	public void adicionaContratos(HoraContrato contrato){
		contratos.add(contrato);
	}
	
	public void removeContrato(HoraContrato contrato){
		contratos.remove(contrato);
	}
	
	
	public Double calculaRenda(int ano, int mes){
		Double sum = salarioBase;
		Calendar cal = Calendar.getInstance();
		
		for(HoraContrato c : contratos){
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1+ cal.get(Calendar.MONTH);
			
			if(ano == c_ano && mes == c_mes){
				sum += c.valorTotal();
			}
		}
		
		return sum;
		
		
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelFuncionario getNivelFuncionario() {
		return nivelFuncionario;
	}

	public void setNivelFuncionario(NivelFuncionario nivelFuncionario) {
		this.nivelFuncionario = nivelFuncionario;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<HoraContrato> getContratos() {
		return contratos;
	}

	
	
		
	
}
