package com.hackealo.main;

import java.util.HashMap;

public class Contador {

	// Tendra asociada la letra junto a su total de repeticiones
	private static HashMap<String, Integer> mapa = null;

	/*
	 * 
	 * Ordenar de mayor a menor según cantidad de apariciones las siguientes
	 * letras del alfabeto. Si empatan, ordenar alfabéticamente. Dar la
	 * respuesta en minúscula.
	 * kvUSJiexUMdwUSZTXnanTQIHpzYLMZAfTQmkCMGJfWvbaRPmTgzutBuILwahTgzvYVaOmoFQctTcrKUzrvUnlcWoaFCHyEutBJmeYUmgCRxQKhpeiXQrshQnjDgdCOtUdCqLuhBvlwbQWoQNNOtzknOdoCOVqdMqNHUlrUGNetqhtKtqkiUWZNcwtJddEQamoIVrRM
	 */

	public static void main(String[] args) {

		final String cadena = "OkvUSJiexUMdwUSZTXnanTQIHpzYLMZAfTQmkCMGJfWvbaRPmTgzutBuILwahTgzvYVaOmoFQctTcrKUzrvUnlcWoaFCHyEutBJmeYUmgCRxQKhpeiXQrshQnjDgdCOtUdCqLuhBvlwbQWoQNNOtzknOdoCOVqdMqNHUlrUGNetqhtKtqkiUWZNcwtJddEQamoIVrRM";
		// final String cadena = "ABCA";
		char[] charCadena = cadena.toCharArray();
		coincidencias(charCadena);
		for (char c : charCadena) {
			System.out.println(c + " =>" + mapa.get(String.valueOf(c)));
		}
		System.out.println("PROBANDO =>" + mapa.get("C")); // Devuelve el numero
															// de veces que se
															// repite la letra C

	}
	/**
	 * Este metodo guarda en un objeto map cada uno de los caracteres con el total de veces que aparece
	 * @param charCadena caracteres a contar
	 */
	private static void coincidencias(char charCadena[]) {
		int contador = 0;
		mapa = new HashMap<String, Integer>();
		for (int i = 0; i < charCadena.length; i++) {
			System.out.println("Elemento (" + i + ") => " + charCadena[i]);
			for (int j = 0; j < charCadena.length; j++) {
				System.out.println("Comparando elemento " + charCadena[i] + " con " + charCadena[j]);
				if (charCadena[i] == charCadena[j]) { 
					System.out.println("Encontramos una inicidencia => " + charCadena[j]);
					contador++; //Vamos iterando el numero de veces que encontramos coincidencias
				}
				if (isUltimoElemento(j, charCadena)) { //Si es el ultimo elemento
					System.out.println("Llego al utlimo elemento papurry");
					mapa.put(String.valueOf(charCadena[i]), contador); //Guardo la letra con el total
					contador = 0; //Reseteo el contador

				}
			}
		}
	}

	/**
	 * @param index el numero a comparar
	 * @param array el array de caracteres
	 * @return Si la posicion del elemento que le pasamos es igual al limite del array devolvemos verdadero
	 */
	private static boolean isUltimoElemento(int index, char[] array) {
		return ((array.length - 1) == index) ? true : false;
	}
}
