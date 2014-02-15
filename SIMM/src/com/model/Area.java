package com.model;

import java.util.ArrayList;
import java.util.List;

public class Area {

	
	private String [] nomesAreas =
		{"Cardiologia", "Nefrologia", "Pneumologia",
		 "Gastroenterologia","Hepatologia","Endocrinologia",
		 "Hematologia","Reumatologia","Imunologia",
		 "Mastologia", "Ginecologia","Obstetrícia",
		 "Urologia","Oftalmologia","Neurologia",	
		 "Infectologia","Dermatologia","Cabeça e pescoço",
		 "Neurocirurgia", "Pediatria","Neonatologia",
		 "Psiquiatria","Psicanálise","Otorrinolaringologia",
		 "Ortopedia","Medicina genética","Medicina molecular",
		 "Geriatria","Cirurgia plástica","Homeopatia"};
		
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
