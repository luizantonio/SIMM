package com.control;


import static com.persistence.Constants.TAG_E;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

import com.control.R;

public class TelaSimular extends Activity implements OnItemClickListener {
	
	private int [] images = {R.drawable.paciente_homem, 
			                 R.drawable.paciente_mulher,
			                 R.drawable.paciente_menino,
			                 R.drawable.paciente_menina,
			                 R.drawable.paciente_nao_identificado};
	private ImageSwitcher imageswitcher;
	/***
	 * 
	     <ImageSwitcher
			   android:id="@+id/imageSwitcher"
			   android:layout_width="wrap_content"
			   android:layout_height="wrap_content"/>  		
	 * */
	private ListView listView;
	private int indexIMG = 0;
	ImageView imagem;
	private ProgressDialog progerss;
	private Handler handler2;
	private TextView anamneseText;
	private TextView anamnese;
	protected int  progresso = 0;
	private ProgressBar barraProgresso;
	private Handler handler;
	private String [] arrayNomes;
	private String [] entries;
	private int idDaAreaSelecionada = 0;
	String nomeDaAreaSelecionada;
	private ArrayList<String> arrayListNomesDoencas ;
	private ArrayList<String> entriesDoenca = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_simular);
		
		//Configura o ImageSwitcher e efeitos
		//this.imageswitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);
		//this.imageswitcher.setInAnimation(AnimationUtils.loadAnimation(this,
		//		                          android.R.anim.fade_in));
		
		
		this.arrayListNomesDoencas = new ArrayList<String>();
		
		// volta para tela anterior		
		Button voltar = (Button) findViewById(R.id.button1);
		voltar.setOnClickListener(new Voltar());
		
		TextView text = (TextView) findViewById(R.id.textViewAssunto);
		/**texto*/
		this.anamneseText = (TextView)findViewById(R.id.textViewAssunto);
		/**texto: Anamnese e exame fisico*/
		this.anamnese = (TextView) findViewById(R.id.text_view_simular1);
		this.anamneseAcao();
		
		//handler2 = new Handler();
		//this.progerss = ProgressDialog.show(this, "SIMM"," Carregando dados, por favor aguarde...", false, true);
		// Identifica o sexo do paciente e busca a imagem
		
		/***this.identificarImg();*************************/
		
		
		//this.barraProgresso = (ProgressBar) findViewById(R.id.progressBar1);
		//handler = new Handler();
		//this.progerss = ProgressDialog.show(this, "SIMM"," Carregando dados, por favor aguarde...", false, true);
		//constroi uma lista 
		this.construirLista();
		
		
	
		//this.verificaSaida();
		
	}
	
	private void verificaSaida() {
		try{
			Intent intent = getIntent();
	        Bundle simmInfo = intent.getExtras();
	        if (simmInfo != null) {	        	
	        	if(simmInfo.containsKey("SAIR")){
	        		sairSelected();
	        	}	        	
	        }
		}catch(Exception e){
			Log.w(TAG_E, "Error: run(), carregar Informações. "+ e);
			return;
		}
	}
	/**
	public void observeProgresso(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				while(progresso < MAXIMO){
					
				}
				
			}
			
			
		}).start();
	}*/
	/**
	 * Método utilizado para construir uma lista exemplo
	 * */
	/**
	 * <ImageView
		     			android:id="@+id/imageView1"
		     			android:layout_width="wrap_content"
		     			android:layout_height="wrap_content"
		     			android:src="@drawable/paciente_menina" />
	 * */
	/**
	public void identificarImg(){
		new Thread(){
			@Override
			public void run(){		
				try{
					StringBuffer contents = new StringBuffer();
				    try {
				      InputStream rawRes = getResources().openRawResource(R.raw.caso1);
				      BufferedReader input = new BufferedReader(new InputStreamReader(rawRes));
				      String line = null;
				      int contadorVirgula = 0;
				      while ((line = input.readLine()) != null) {
				    	if(line.equals("ANAMNESE E EXAME FÍSICO")){
				    		contadorVirgula = 0;   		
				    	}else{
				    		if(contadorVirgula== 1){
				    			contents.append(line);
				    		}
				    	}
				    	contadorVirgula ++;	        
				        if(line == "EXAMES COMPLEMENTARES"){break;}
				      }
				    } catch (IOException ex) {
				      ex.printStackTrace();
				    }
				    String texto = contents.toString();
				    String teste = texto.toLowerCase(); 
					int aux = 0;
					int num = 0;
					int retorno = 0;
  
					aux = teste.indexOf(",",25); 
					num = teste.indexOf(",",aux); 
					String auxStr = teste.substring(aux, aux + 5);
					String minusculo = auxStr.toLowerCase(); 						   
					int n1 = minusculo.indexOf("f");
					
					if(n1 > 0){
						
						indexIMG = 1;
						carregarImg(indexIMG, "F");
					}
					int n2 = minusculo.indexOf("m");
					if(n2 > 0){
						indexIMG = 0;
						carregarImg(indexIMG, "M");
					} 
					if(n1 == n2){
						//iguais = 0 não tem
						indexIMG = 4;
						carregarImg(4, "M");
					}
					  
	
					
				}catch(Exception e){
					Log.w(TAG_E, "Error: Identificar imagem. "+ e);
					e.printStackTrace();
				}
				
			}//fim run
		}.start();	//fim thread
	}

	public void carregarImg(int posicao, String sexoInf){
		final String sexo = sexoInf;
		handler.post(new Runnable(){
			@Override
			public void run() {
				
				progerss.dismiss();	
				if(sexo == "F"){
					//imagem = new ImageView(TelaSimular.this);
					//imagem = (ImageView)findViewById(R.id.imageView1);
					//imagem.setImageResource(R.drawable.paciente_mulher);  // masculino

					// Avisa o ImageSwitcher que a imagem mudou
					imageswitcher.setImageResource(images[1]);
				
				}else if(sexo == "M"){
					//imagem = new ImageView(TelaSimular.this);
					//imagem = (ImageView)findViewById(R.id.imageView1);
					//imagem.setImageResource(R.drawable.paciente_homem);  // masculino
					
					// Avisa o ImageSwitcher que a imagem mudou
					imageswitcher.setImageResource(images[0]);
				}
			}
		});			
	}
	***/
	public void construirLista(){
		this.doencasSelecionadas();
		List<String> nomes = this.entriesDoenca;
				
				
		if (nomes != null){
			// cria lista com nomes das áreas na ListView
			
			listView = (ListView) findViewById(R.id.listview_selecionar_doenca);
			// cria lista com nomes das áreas na ListView
			ArrayAdapter<String> adapter= 
					new	ArrayAdapter<String>(TelaSimular.this, 
							android.R.layout.simple_list_item_1, 
					        nomes );
			listView.setAdapter(adapter);
			listView.setOnItemClickListener(TelaSimular.this);	
		}else{
			Toast.makeText(TelaSimular.this, "null........++++", Toast.LENGTH_SHORT).show();
		}
		
	}
	
	/**
	 * Recuera os dados da intente passada e retorna
	 * */
	public void doencasSelecionadas(){
		Intent intent = getIntent();
        Bundle simmInfo = intent.getExtras();
       List<String> lista = new ArrayList<String>();
        if (simmInfo != null) {
        	
        	if(simmInfo.containsKey("arrayListDoencaSelecionada")){
        		if(simmInfo.getStringArrayList("arrayListDoencaSelecionada") != null)
        			this.entriesDoenca = 
	        			simmInfo.getStringArrayList("arrayListDoencaSelecionada");
        	}
        	if(simmInfo.containsKey("nomeDaAreaSelecionada")){
        		if(simmInfo.getString("nomeDaAreaSelecionada") != null)
        			this.nomeDaAreaSelecionada = simmInfo.getString("nomeDaAreaSelecionada");
        	}
        	if(simmInfo.containsKey("idDaAreaSelecionada")){
        		if(simmInfo.getInt("idDaAreaSelecionada") > 0)
        			this.idDaAreaSelecionada = simmInfo.getInt("idDaAreaSelecionada");
        	}
        	if(simmInfo.containsKey("arrayDoencaSelecionada")){
        		if(simmInfo.getStringArray("arrayDoencaSelecionada") != null)
        			this.arrayNomes = simmInfo.getStringArray("arrayDoencaSelecionada");
        	}
        	if(entriesDoenca.size() > 0){
	        	Iterator it = entriesDoenca.iterator();
	        	while(it.hasNext()){
	        		String string = (String) it.next();
	        		if(string != null){
	        			lista.add(string);
	        		}
	        	}
        	}
        }
       
        if(lista.size() <= 0){
        	lista = Arrays.asList(arrayNomes );
        }
        this.verificaSaida();
		//return (lista);
	}
	public void setArrayNomes(String [] arrayNomes){
		this.arrayNomes = arrayNomes;
	}
	public String [] getArrayNomes(){
		return this.arrayNomes;
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		Toast.makeText(TelaSimular.this, "Metodo", Toast.LENGTH_SHORT).show();
	}
	/** 
	 * classe interna para controlar a volta a tela anterior 
	 * */
	private class Voltar  implements OnClickListener{
		
		public Voltar(){}//construtor
		//método para voltar a tela anterior
		@Override
		public void onClick(View arg0) {
			
			Bundle simmBandle  = new Bundle();
			if( arrayListNomesDoencas != null)
				simmBandle.putStringArrayList("arrayListDoencaSelecionada",  arrayListNomesDoencas );
			if( arrayNomes!= null)
				simmBandle.putStringArray(    "arrayDoencaSelecionada",      arrayNomes );
			if( idDaAreaSelecionada > 0)
				simmBandle.putInt(            "idDaAreaSelecionada",    idDaAreaSelecionada);
			Intent intentAtividade = new Intent(TelaSimular.this, Simular.class);
			intentAtividade.putExtras( simmBandle );
			startActivity( intentAtividade );
		}
	}
	private void anamneseAcao() {
		this.anamnese.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				String texoAnamnese = getTextFromFile();
				anamneseText.setText(texoAnamnese);
			}
		});
		
	}
	public String getTextFromFile(){
		StringBuffer contents = new StringBuffer();
	    try {
	    	
	    	Toast.makeText(TelaSimular.this, "Anamnese", Toast.LENGTH_SHORT).show();
	    	
	        InputStream rawRes = getResources().openRawResource(R.raw.caso2);
	        BufferedReader input = new BufferedReader(new InputStreamReader(rawRes));
	        String line = null;
	        int verific = 0;
	        while ((line = input.readLine()) != null) {
	    	  String aux = line;
	    	  verific = aux.indexOf("EXAMES COMPLEMENTARES",0);
	    	  if(verific < 0){
	    		  contents.append(line + '\n');
	    	  }
	    	  else if(verific > 0){
	    		  break;
	    	  }
	        }
	    } catch (IOException ex) {
	      ex.printStackTrace();
	    }
	    return contents.toString();
	 }		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_simular, menu);
		return true;
	}
	public boolean sairSelected() {
		
		finish();
		return true;
	}
	
}
