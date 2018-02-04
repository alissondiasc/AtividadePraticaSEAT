package projetoEuler;

import java.util.Scanner;

public class NumeroPrimo {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		System.out.print("Digite um número: ");
		int num = scanner.nextInt();

		System.out.println(new NumeroPrimo().getPrimoNaPosicao(num));
	}

	public int getPrimoNaPosicao(int posicao) {
		int count = 0;
		int num = 1;
		while (count != posicao) {
			num++;

			if (isPrimo(num)) {
				count++;
			}
		}

		return num;
	}

	public boolean isPrimo(int num) {
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
