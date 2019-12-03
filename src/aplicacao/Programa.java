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
		System.out.println("      Programa exemplo de composição de classes");
		System.out.println("=========================================================");
		System.out.print("Informe o nome do departamento: ");
		String nomeDepartamento = sc.nextLine();
		System.out.println("Informe os dados do funcionário");
		System.out.println("=========================================================");
		
		System.out.print("Nome           : ");
		String nomeFunc = sc.nextLine();
		
		System.out.print("Nível Funcional: ");
		String nivelFunc = sc.nextLine();
		
		System.out.print("Salário Base   : ");
		Double salarioFunc = sc.nextDouble();
		
		Funcionario funcionario = new Funcionario(nomeFunc, NivelFuncionario.valueOf(nivelFunc), salarioFunc, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos para este funcionário");
		int qtd = sc.nextInt();
		
		for (int i = 1; i<= qtd; i++){
			System.out.println("Entre com os dados do contrato nº " + i);
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
		System.out.print("Informe o Mês e Ano para Calcular a renda: ");
		String mesAno = sc.next();
		
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));
		
		System.out.println("Nome do Funcionário : " + funcionario.getNome());
		System.out.println("Departamento        : " + funcionario.getDepartamento().getNome());
		System.out.println("Renda para " + mesAno + ": " + String.format("%.2f",funcionario.calculaRenda(ano, mes)));
		
		
		sc.close();
		
	}

}
