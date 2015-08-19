package com.hackealo.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Contador {

	// Tendra asociada la letra junto a su total de repeticiones
	private static HashMap<String, Integer> mapa = null;
	private static ArrayList<Integer> numeros = new ArrayList<Integer>();
	private static String[] letrasOrdenadas = null;
	private static ArrayList<String> posicionesOcupadas = new ArrayList<String>();

	/*
	 * 
	 * Ordenar de mayor a menor según cantidad de apariciones las siguientes
	 * letras del alfabeto. Si empatan, ordenar alfabéticamente. Dar la
	 * respuesta en minúscula.
	 * kvUSJiexUMdwUSZTXnanTQIHpzYLMZAfTQmkCMGJfWvbaRPmTgzutBuILwahTgzvYVaOmoFQctTcrKUzrvUnlcWoaFCHyEutBJmeYUmgCRxQKhpeiXQrshQnjDgdCOtUdCqLuhBvlwbQWoQNNOtzknOdoCOVqdMqNHUlrUGNetqhtKtqkiUWZNcwtJddEQamoIVrRM
	 */

	public static void main(String[] args) {

		final String cadena = "oenLVHgXzQZOpmEdxwVqymJVbrIMvSPZUVetjHduuFfaHOTCpWsFYYwxcvBImWGtVPsRVXxEELMqTmCpEcSnzqSyWvLtvMwBqAHMBtOdLiTeHhtLcnPiqoHhXrftLHOQCxAyVqqeNyyEduJOldAREGsowEiFCdTZrDLWSBhrYqLQGFLoroJvQgRjgutVPyRfRRPLVgU";
		// final String cadena = "DDAAABBB";
		// final String cadena = "EEEZZZZABB"; Z E B A
		char[] charCadena = cadena.toCharArray();
		coincidencias(charCadena);
		ordenarTotales(numeros);
		mostrarValores(mapa);
		for (int i = 0; i < numeros.size(); i++) {
			System.out.println(i + ")" + numeros.get(i));
		}

		letrasOrdenadas = new String[numeros.size()];
		for (int i = 0; i < numeros.size(); i++) {
			for (Entry<String, Integer> entry : mapa.entrySet()) {
				String key = entry.getKey();
				int value = entry.getValue();
				if (value == numeros.get(i)) { 
					if (!isLetraAsociada(letrasOrdenadas, i, key)) {
						//Si el elemento no se repite en el array
						if (letrasOrdenadas[i] == null) {
							//Si esa posicion esta vacia
							letrasOrdenadas[i] = key;
							//Agrego el elemento
//							System.out.println("Agregue el elemento " + key + " En la posicion " + i);
						} else {
							posicionesOcupadas.add(String.valueOf(i));
							//Si la posicion esta ocupada  lo agrego a la posicion siguiente
							if ((i + 1) < letrasOrdenadas.length) { //Si el array no llego al limite
								letrasOrdenadas[i + 1] = key;
								//Lo agrego
//								System.out.println("Agregue el elemento " + key + " En la posicion " + i);
							}
						}

					}

				}

			}

		}
		for (int i = 0; i < letrasOrdenadas.length; i++) {
			System.out.print("   "+i + ") " + letrasOrdenadas[i]+" ");
		}
		System.out.println("\n\n");
		for (String c : posicionesOcupadas) {
			System.out.println("POSICIONES OCUPADADAS "+c);
		}

	}

	private static boolean isLetraAsociada(String[] letras, int i, String key) {
		boolean existe = false;

		for (int j = 0; j < letras.length; j++) {
			if (letras[j] == key) {
				existe = true;
			}
		}

		return existe;

	}

	/*
	 * LLAVE (t) VALOR (9)
	 */

	/**
	 * Este metodo guarda en un objeto map cada uno de los caracteres con el
	 * total de veces que aparece
	 * 
	 * @param charCadena
	 *            caracteres a contar
	 */
	private static void coincidencias(char charCadena[]) {
		int contador = 0;
		mapa = new HashMap<String, Integer>();
		for (int i = 0; i < charCadena.length; i++) {
			// System.out.println("Elemento (" + i + ") => " + charCadena[i]);
			for (int j = 0; j < charCadena.length; j++) {
				// System.out.println("Comparando elemento " + charCadena[i] +
				// " con " + charCadena[j]);
				if (charCadena[i] == charCadena[j]) {
					// System.out.println("Encontramos una inicidencia => " +
					// charCadena[j]);
					contador++; // Vamos iterando el numero de veces que
								// encontramos coincidencias
				}
				if (isUltimoElemento(j, charCadena)) { // Si es el ultimo
					if (!isKeyAsociada(charCadena[i])) { // Si no tiene un
															// elemento asociado
//						System.out.println("Agrego al mapa (" + charCadena[i] + "-" + contador + ")");
						mapa.put(String.valueOf(charCadena[i]), contador);
						agregarNumeroLista(contador);
					}
					contador = 0; // Reseteo el contador

				}
			}
		}
	}

	private static void agregarNumeroLista(int contador) {
		numeros.add(contador);

	}

	private static void ordenarTotales(ArrayList<Integer> numeros) {
		for (int i = 0; i < numeros.size(); i++) {
			for (int j = 0; j < numeros.size() - 1; j++) {
				if (numeros.get(j + 1) > numeros.get(j)) {
					int mayor = numeros.get(j + 1);
					int menor = numeros.get(j);
					numeros.set(j, mayor);
					numeros.set(j + 1, menor);
				}

			}
		}

	}

	private static void mostrarValores(HashMap<String, Integer> mapa2) {
		int contador = 0;
		System.out.println("----------------VALORES DEL MAPA----------------");
		for (Entry<String, Integer> entry : mapa2.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println("LLAVE (" + key + ") VALOR (" + value + ")");
			contador += value;

		}
		System.out.println("Total ==>" + contador);

	}

	/**
	 * @param index
	 *            el numero a comparar
	 * @param array
	 *            el array de caracteres
	 * @return Si la posicion del elemento que le pasamos es igual al limite del
	 *         array devolvemos verdadero
	 */
	private static boolean isUltimoElemento(int index, char[] array) {
		return ((array.length - 1) == index) ? true : false;
	}

	private static boolean isKeyAsociada(char c) {
//		System.out.println("El valor " + c + " mapa =>" + mapa.get(String.valueOf(c)));
		return (mapa.get(String.valueOf(c)) != null) ? true : false;
	}

}
