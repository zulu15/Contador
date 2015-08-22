package com.hackealo.main;
import java.util.LinkedList;

public class Hackealo {

	private static LinkedList<Letra> linkLetras = new LinkedList<Letra>();
	private static Letra[] arrayLetras = null;

	public static void main(String[] args) {
		 String cadena = 
"YrVfxARgEKBxlYJjYWEznZFzZFBCFoObQjZllyKOSfngZdgdEnZgMWVxTqiHWWXYxmeqKqrAIMIjJaUKxvYZAsRKOlkhwNMaNbFkmzILvXTsuMEVRyyxZQWJpLARRxgzLDrLVWMjjatcYTOzMRzdYUNbupwhTUQvGePLlpwwYCuVIRLZcXcwUMRjnZpyWoAoQEfDJnf";
		cadena = cadena.toLowerCase();
		 char cadenaArray[] = cadena.toCharArray();
		contarArray(cadenaArray);
		ordenarAlfabeticamente();
		
		int contador=0;
		for (Letra l : arrayLetras) {
			System.out.print(l.getLetra());
			contador+=l.getRepeticiones();
		}
		System.out.println("\nTotal repeticiones ("+contador+") size ("+cadena.length()+")");
	}

	public static void contarArray(char array[]) {
		Letra letra = null;
		int contador = 0;
		for (int i = 0; i < array.length; i++) {
			letra = new Letra();
			for (int j = 0; j < array.length; j++) {
				if (array[i] == array[j]) {
					
					contador++;
				}
			}
			letra.setLetra(String.valueOf(array[i]));
			letra.setRepeticiones(contador);
			letra.setIndexAbecedario((int) String.valueOf(array[i]).toUpperCase().charAt(0));
			if(!isLetraAgregada(letra)){
				linkLetras.add(letra);
			}
			contador = 0;
		}
		arrayLetras= new Letra[linkLetras.size()];
		for (int i = 0; i < linkLetras.size(); i++) {
			arrayLetras[i]=linkLetras.get(i);
		}
	}

	private static boolean isLetraAgregada(Letra letra) {
		boolean agregada=false;
		for (int i = 0; i < linkLetras.size(); i++) {
			if(letra.getLetra().equals(linkLetras.get(i).getLetra())){
				agregada=true;
			}
		}
		return agregada;
	}


	private static void ordenarAlfabeticamente() {

		ordenarPorRepeticiones();
		for (int i = 0; i < arrayLetras.length; i++) {
			for (int j = 0; j < arrayLetras.length - 1; j++) {
				if (!arrayLetras[j].getLetra().equals(arrayLetras[j + 1].getLetra())) {
					if (arrayLetras[j].getRepeticiones() == arrayLetras[j + 1].getRepeticiones()) {
						if (arrayLetras[j + 1].getIndexAbecedario() < arrayLetras[j].getIndexAbecedario()) {
							Letra mayor = arrayLetras[j + 1];
							Letra menor = arrayLetras[j];
							arrayLetras[j] = mayor;
							arrayLetras[j + 1] = menor;
						}
					}
				}
			}

		}
	
	}

	private static void ordenarPorRepeticiones() {
		for (int i = 0; i < arrayLetras.length; i++) {
			for (int j = 0; j < arrayLetras.length - 1; j++) {

				if (arrayLetras[j + 1].getRepeticiones() > arrayLetras[j].getRepeticiones()) {
					Letra mayor = arrayLetras[j + 1];
					Letra menor = arrayLetras[j];
					arrayLetras[j] = mayor;
					arrayLetras[j + 1] = menor;
				}
			}

		}

	}

	
	
	
	
	
	
	
	
	
	

}
