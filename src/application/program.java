package application;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import entities.TaxPayer;

public class program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Quantos contribuintes você vai digitar?");
		int n = sc.nextInt();
		System.out.println();

		List<TaxPayer> taxPayerList = new ArrayList<>();

		for (int i = 1; i <= n; i++) {

			System.out.printf("Digite os dados do %dº contribuinte:", i);
			System.out.println();
			System.out.print("Renda anual com salário: ");
			double salaryIncome = sc.nextDouble();
			System.out.print("Renda anual com prestação de serviço: ");
			double servicesIncome = sc.nextDouble();
			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();
			System.out.print("Gastos Médicos: ");
			double healthSpending = sc.nextDouble();
			System.out.print("Gastos Educacionais: ");
			double educationSpending = sc.nextDouble();

			TaxPayer taxPayer = new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending,
					educationSpending);

			taxPayerList.add(taxPayer);
			System.out.println();

		}

		sc.close();

		for (TaxPayer taxPayer : taxPayerList) {
			int i = 1 + taxPayerList.indexOf(taxPayer);

			System.out.println("Resumo do " + i + "º contribuinte:");
			System.out.printf("Imposto Bruto Total: %.2f ", taxPayer.grossTax());
			System.out.println();
			System.out.printf("Abatimento: %.2f ", taxPayer.taxRebate());
			System.out.println();
			System.out.printf("Imposto Devido: %.2f ", taxPayer.netTax());
			System.out.println();
			System.out.println();

		}
	}

}
