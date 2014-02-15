package com.model;

import java.util.ArrayList;
import java.util.List;

public class Area {

	
	private String [] nomesAreas =
		{"Cardiologia", "Nefrologia", "Pneumologia",
		 "Gastroenterologia","Hepatologia","Endocrinologia",
		 "Hematologia","Reumatologia","Imunologia",
		 "Mastologia", "Ginecologia","Obstetr�cia",
		 "Urologia","Oftalmologia","Neurologia",	
		 "Infectologia","Dermatologia","Cabe�a e pesco�o",
		 "Neurocirurgia", "Pediatria","Neonatologia",
		 "Psiquiatria","Psican�lise","Otorrinolaringologia",
		 "Ortopedia","Medicina gen�tica","Medicina molecular",
		 "Geriatria","Cirurgia pl�stica","Homeopatia"};
		
	private String nome;
	private int id;
	public Area() {
		// TODO Auto-generated constructor stub
	}
	public List<String> getNomesAreas() {
		List<String> lista = new ArrayList<String>();
		for(int i = 0; i < nomesAreas.length; i++){
			lista.add(this.nomesAreas[i]);
		}
		return lista;
	}
	public void setNomesAreas(String[] nomesAreas) {
		this.nomesAreas = nomesAreas;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

}
