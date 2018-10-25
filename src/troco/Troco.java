package troco;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Troco {
	
	public static void main(String[] args) {

		double valorDigitado = 0;
		try {
			valorDigitado = lerValor(args[0] == "" ? null : Double.valueOf(args[0]));
			Map<String, Integer> quantidade = darTrocoContabilizado(valorDigitado);
			imprimirTroco(quantidade);	
		} 
		catch (Exception e) {
			System.out.println("Valor invalido!");
		}
	}
	
	public static Map<String, Integer> darTrocoContabilizado(double valorDigitado)
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
	
	public static void imprimirTroco(Map<String, Integer> quantidade)
	{
		System.out.println("Distribuição do troco");
		quantidade.entrySet().forEach(entry -> 
			System.out.println((Double.parseDouble(entry.getKey()) >= 1 ? "Cédula de " : "Moeda de ") 
					+ entry.getKey() + ": " + entry.getValue()));
	}

	public static double lerValor(Double value) throws Exception
	{
		Scanner ler = new Scanner(System.in);
		double valorLido;
		System.out.printf("Informe um valor: ");
		valorLido = value == null ? ler.nextDouble() : value;
		ler.close();
		
		if(valorLido < 0)
		{
			
			throw new RuntimeException();
		}
			return valorLido;			

	}
	
}
