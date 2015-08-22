package com.hackealo.main;

import java.io.Serializable;

public class Letra implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private String letra;
	private int repeticiones;
	private int indexAbecedario;

	public String getLetra() {
		return letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public int getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(int repeticiones) {
		this.repeticiones = repeticiones;
	}

	public int getIndexAbecedario() {
		return indexAbecedario;
	}

	public void setIndexAbecedario(int indexAbecedario) {

		this.indexAbecedario = indexAbecedario;
	}

	
	
	@Override
	public String toString() {
		return "Letra [letra=" + letra + ", repeticiones=" + repeticiones + ", indexAbecedario=" + indexAbecedario + "]";
	}
}
