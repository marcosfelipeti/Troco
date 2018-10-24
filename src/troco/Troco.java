package troco;

import java.util.Scanner;

public class Troco {
	
	public static void main(String[] args) {
		lerValor();
	}
	
	private static double lerValor() {
		Scanner ler = new Scanner(System.in);
		double x;
		System.out.printf("Informe um valor: ");
		x = ler.nextDouble();
		System.out.println(x);
		return x;
	}
	
}
