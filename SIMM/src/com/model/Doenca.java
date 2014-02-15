package com.model;

import java.util.ArrayList;
import java.util.List;

public class Doenca {

	private String [] nomesDoenca =
		             {
			          "Asma",
					  "Bronquiectasia" ,
					  "DPOC",
                      "Micoses Pulmonares", 
                      "Pneumonia",
                      "Tuberculose",
                      "Cistite",
                      "Glomerulonefrite por IgA (Doença de Berger)",
                      "GNDA",
                      "Litíase urinária" 
		             };
	private int id;
	private String nome_doenca;
	private String area_id;

	public Doenca() {
		// TODO Auto-generated constructor stub
	}

	public List<String> getNomesDoenca() {
		List<String> lista = new ArrayList<String>();
		for(int i = 0; i < nomesDoenca.length; i++){
			lista.add(this.nomesDoenca[i]);
		}
		return lista;
	}

	public void setNomesDoenca(String[] nomesDoenca) {
		this.nomesDoenca = nomesDoenca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome_doenca() {
		return nome_doenca;
	}

	public void setNome_doenca(String nome_doenca) {
		this.nome_doenca = nome_doenca;
	}

	public String getArea_id() {
		return area_id;
	}

	public void setArea_id(String area_id) {
		this.area_id = area_id;
	}
	

}
