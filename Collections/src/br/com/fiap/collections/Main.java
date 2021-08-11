package br.com.fiap.collections;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		List<Integer> vetor = new ArrayList<>();
		vetor.add(2);
		vetor.add(1, 30);
		vetor.add(0, 10);
		
		// For convencional
		for (int i = 0; i < vetor.size(); i++) {
			int numero = vetor.get(i);
			System.out.println(numero);
		}
		
		// For each -> � utilizado com vetores/cole��es de objetos
		for(Integer numero : vetor) {
			System.out.println(numero);
		}
		
		System.out.println(vetor.contains(30)); // 30 in vetor -> em Python
		System.out.println(vetor.indexOf(30));
		
		vetor.add(2);
		
		System.out.println(vetor.lastIndexOf(2));
		
		System.out.println(vetor.subList(1, 3)); // final (2) - inicio (1) = 1 -> quantidade de elementos que ser� exibida a partir do inicio  

		
		/**
		 * sublist 
		 * - posicaoInicial
		 * - posicaoFinal
		 * 
		 * posicaoFinal - posicaoInicial = quantidadeElementos que ser� exibido
		 * 
		 * quantidadeElementos == 1 -> s� � exibido o valor na posicaoInicial
		 * quantidadeElementos == 2 -> � exibido o valor da posicaoInicial + o pr�ximo valor, logo na sequ�ncia.
		 */
		
		
		vetor.remove(1);
		vetor.remove(new Integer(30)); // N�o fa�a isso, � s� para fins did�ticos!!!!!!
		
		int posicaoDoNumero = 0;
		int numero = vetor.get(posicaoDoNumero); // vetor[0]
		
		
		System.out.println(vetor);
		System.out.println(numero);
		
		vetor = new LinkedList<>();
		
		Set<Integer> conjunto = new HashSet<>();
		conjunto.add(1);
		conjunto.add(1);
		conjunto.add(2);
		conjunto.add(2);
		conjunto.add(3);
		
		System.out.println(conjunto);
		
		Map<String, Integer> traducaoTextoParaNumero = new TreeMap<>();
		traducaoTextoParaNumero.put("um", 1);
		traducaoTextoParaNumero.put("dois", 2);
		traducaoTextoParaNumero.put("tr�s", 3);
		
		numero = traducaoTextoParaNumero.get("dois");
		
		
	}

}
