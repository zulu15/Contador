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
//		final String cadena = "ABCA";
		char[] charCadena = cadena.toCharArray();
		coincidencias(charCadena);
		for (char c : charCadena) {
			System.out.println(c+" =>" +mapa.get(String.valueOf(c)));
		}
		System.out.println("PROBANDO =>"+mapa.get("C"));

	}

	private static void coincidencias(char charCadena[]) {
		int contador=0;
		mapa = new HashMap<String, Integer>();
		for (int i = 0; i < charCadena.length; i++) {
			System.out.println("Elemento (" + i + ") => " + charCadena[i]);
			for (int j = 0; j < charCadena.length; j++) {
				System.out.println("Comparando elemento " + charCadena[i] + " con " + charCadena[j]);
				if (charCadena[i] == charCadena[j]) {
					System.out.println("Encontramos una inicidencia => " + charCadena[j]);
					contador++;
				}
				if(isUltimoElemento(j,charCadena)){
					System.out.println("Llego al utlimo elemento papurry");
					mapa.put(String.valueOf(charCadena[i]), contador);
					contador=0;
				
			}
		}
	}
	}

	private static boolean isUltimoElemento(int index, char[] array) {
		return ((array.length-1)==index) ? true : false;
	}
}
