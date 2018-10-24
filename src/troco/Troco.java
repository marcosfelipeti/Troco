package troco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Troco {
	
	public static void main(String[] args) {
		double valorDigitado = lerValor();
		Map<String, Integer> quantidade = darTrocoContabilizado(valorDigitado);
		imprimirTroco(quantidade);
	}
	
	private static Map<String, Integer> darTrocoContabilizado(double valorDigitado)
	{
		double[] cedulasMoedas = {100.0, 50.0, 10.0, 5.0, 1.0, 0.50, 0.10, 0.05, 0.01};
		Map<String, Integer> quantidade = new HashMap<>();
		
		for (int i = 0; i < cedulasMoedas.length; i++)
		{
			valorDigitado -= cedulasMoedas[i];			
			while (valorDigitado >= 0)
			{				
				if (quantidade.containsKey(String.valueOf(cedulasMoedas[i])))
				{
					quantidade.replace(String.valueOf(cedulasMoedas[i]), quantidade.get(String.valueOf(cedulasMoedas[i])) + 1);
				}
				else
				{
					quantidade.put(String.valueOf(cedulasMoedas[i]), 1);
				}
				valorDigitado -= cedulasMoedas[i];
			}
			valorDigitado += cedulasMoedas[i];
		}		
		
		return quantidade;
	}
	
	private static void imprimirTroco(Map<String, Integer> quantidade)
	{
		System.out.println("Distribuição do troco");
		quantidade.entrySet().forEach(entry -> 
			System.out.println(entry.getKey() + ": " + entry.getValue()));
	}

	private static double lerValor()
	{
		Scanner ler = new Scanner(System.in);
		double x;
		System.out.printf("Informe um valor: ");
		x = ler.nextDouble();	
		ler.close();
		return x;
	}
	
}
