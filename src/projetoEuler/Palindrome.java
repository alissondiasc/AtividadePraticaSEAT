package projetoEuler;

import java.util.Scanner;

public class Palindrome {
	private static Scanner scanner;

	public String palindrome(int digitos) {
		int maiorPalindrome = 0;
		int maiorI = 0;
		int maiorJ = 0;
		int max = getMax(digitos);
		int min = getMin(digitos);

		// Para 3, max equivale a 999, nove possibilidades para as 3 posições e
		// o i equivale a 100, pois a baixo disso
		// não existe mais 3 digitos.
		for (int i = max; i >= min; i--) {
			for (int j = max; j >= min; j--) {
				String resultado = Integer.toString(i * j);
				String inverso = new StringBuffer(resultado).reverse().toString();

				if (resultado.equals(inverso)) { // compara o valor.
					int valor = Integer.parseInt(resultado);
					if (valor > maiorPalindrome) {
						maiorPalindrome = valor;
						maiorI = i;
						maiorJ = j;
					}
				}
			}
		}

		return maiorI + " * " + maiorJ + " = " + maiorPalindrome;
	}

	public int getMax(int digitos) {
		int base = 0;
		for (int i = digitos - 1; i >= 0; i--) {
			base += 9 * Math.pow(10, i);
		}
		return base;
	}

	public int getMin(int digitos) {
		return (int) Math.pow(10, digitos - 1);
	}

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		System.out.print("Digite a quantidade de digitos: ");
		int num = scanner.nextInt();
		System.out.println(new Palindrome().palindrome(num));
	}
}
