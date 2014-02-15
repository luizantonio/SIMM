package com.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

public class Historia {
	
	private Hashtable<Integer,String> historiasHash = new Hashtable<Integer,String>();  
	
	private String [] historias = { "Por favor, doutor, me ajude." +
            			" Estou urinando escuro e com os olhos" +
            			" inchados há uma semana..."};

	private int id;
	private String id_doenca;
	private String historia;
	private int id_paciente;

	public Historia() { }
	
	public Hashtable<Integer,String> getHistorias(){		
		for(int i = 0; i < historias.length; i++){
			historiasHash.put(i,(this.historias[i]));
		}
		return historiasHash;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getId_doenca() {
		return id_doenca;
	}
	public void setId_doenca(String id_doenca) {
		this.id_doenca = id_doenca;
	}
	public String getHistoria() {
		return historia;
	}
	public void setHistoria(String historia) {
		this.historia = historia;
	}
	public int getId_paciente() {
		return id_paciente;
	}
	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
}
