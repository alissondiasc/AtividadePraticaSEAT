package projetoEuler;

import java.util.Scanner;

public class NumeroAdjacent {

	private Scanner scanner = null;
	private String milDigitos = null;
	private int adjacentes = 0;

	public static void main(String[] args) {
		NumeroAdjacent numeroAdjacent = new NumeroAdjacent();

		numeroAdjacent.scanner = new Scanner(System.in);

		try {
			numeroAdjacent.lerNumeroMilDigitos();
			numeroAdjacent.lerNumerosAdjacentes();
			numeroAdjacent.maiorProduto();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			numeroAdjacent.scanner.close();
		}
	}

	public void lerNumeroMilDigitos() throws Exception {
		System.out.print("Insira um número de 1000 dígitos: ");
		this.milDigitos = this.scanner.next();

		if (this.milDigitos.length() != 1000) {
			throw new Exception("O número informado não possui mil digítos!");
		}
	}

	public void lerNumerosAdjacentes() throws Exception {
		System.out.print("Digite um número: ");
		this.adjacentes = this.scanner.nextInt();

		if (this.adjacentes > 1000 || this.adjacentes < 1) {
			throw new Exception("O número informado não pode ser menor que 1 ou maior que 1000!");
		}
	}

	public void maiorProduto() throws Exception {
		long maxProd = -1;
		for (int i = 0; i + this.adjacentes <= 1000; i++) {
			long prod = 1;
			for (int j = 0; j < this.adjacentes; j++) {
				if (Character.isDigit(this.milDigitos.charAt(i + j))) {
					prod *= Character.getNumericValue(this.milDigitos.charAt(i + j));
				} else {
					throw new Exception("Character inválido: " + this.milDigitos.charAt(i + j));
				}
			}
			maxProd = Math.max(prod, maxProd);
		}
		System.out.println(Long.toString(maxProd));
	}

}
