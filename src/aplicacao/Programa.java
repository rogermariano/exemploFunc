package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidades.Departamento;
import entidades.Funcionario;
import entidades.HoraContrato;
import entidades.enums.NivelFuncionario;

public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("=========================================================");
		System.out.println("      Programa exemplo de composi��o de classes");
		System.out.println("=========================================================");
		System.out.print("Informe o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Informe os dados do funcion�rio");
		System.out.println("=========================================================");
		
		System.out.print("Nome           : ");
		String nomeFunc = sc.nextLine();
		
		System.out.print("N�vel Funcional: ");
		String nivelFunc = sc.nextLine();
		
		System.out.print("Sal�rio Base   : ");
		Double salarioFunc = sc.nextDouble();
		
		Funcionario funcionario = new Funcionario(nomeFunc, NivelFuncionario.valueOf(nivelFunc), salarioFunc, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos para este funcion�rio");
		int qtd = sc.nextInt();
		
		for (int i = 1; i<= qtd; i++){
			System.out.println("Entre com os dados do contrato n� " + i);
			System.out.print("Data (dd/MM/yyy)");
			Date dataContrato = sdf.parse(sc.next());
			System.out.print("Valor por Hora: ");
			Double valorHora = sc.nextDouble();
			System.out.print("Total de Horas do projeto: ");
			int qtdHoras = sc.nextInt();
			HoraContrato novoContrato = new HoraContrato(dataContrato, valorHora, qtdHoras);
			funcionario.adicionaContratos(novoContrato);
		}
		
		System.out.println();
		System.out.print("Informe o M�s e Ano para Calcular a renda: ");
		String mesAno = sc.next();
		
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome do Funcion�rio : " + funcionario.getNome());
		System.out.println("Departamento        : " + funcionario.getDepartamento().getNome());
		System.out.println("Renda para " + mesAno + ": " + String.format("%.2f",funcionario.calculaRenda(ano, mes)));
		
		
		sc.close();
		
	}

}
