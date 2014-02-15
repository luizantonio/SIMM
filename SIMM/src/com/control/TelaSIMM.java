package com.control;

import com.control.R;
import static com.persistence.Constants.TAG_E;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class TelaSIMM extends Activity {

	private TextView text_historia;
	private TextView text_livre;
	private TextView text_sair;
	private TextView text_menu;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_simm);

		this.text_menu = (TextView) findViewById(R.id.text_menu);
		this.menu();
		//sai da activity (apicacao)
		this.text_sair= (TextView) findViewById(R.id.text_sair);
		//this.text_sair.setOnClickListener(new Sair());
		// sair
		this.sair();
		// seta a variável de instância
		this.text_livre= (TextView) findViewById(R.id.text_livre);
		// seta a variável de instância
		this.text_historia= (TextView) findViewById(R.id.text_historia);
		// seleciona o modo de simulação
		this.selecionarModo(); 
		this.verificaSaida();
		
	}
	private void verificaSaida() {
		try{
			Intent intent = getIntent();
	        Bundle simmInfo = intent.getExtras();
	        if (simmInfo != null) {	        	
	        	
	        	if(simmInfo.containsKey("arrayListDoencaSelecionada")){
	        		
	        	}
	        	if(simmInfo.containsKey("nomeDaAreaSelecionada")){
	        		
	        	}
	        	if(simmInfo.containsKey("idDaAreaSelecionada")){
	        		
	        	}
	        	if(simmInfo.containsKey("arrayDoencaSelecionada")){
	        		
	        	}
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
	 *Selecionar o modo
	 **/
	public void selecionarModo(){
		this.text_historia.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(TelaSIMM.this,TelaSelecionarDoenca.class));
			}
		});
		this.text_livre.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(TelaSIMM.this, "Serviço não disponíel.", Toast.LENGTH_SHORT).show();
				
			}
		});
	}
	public void sair(){
		this.text_sair.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				sairSelected();		
			}
		});
	}
	public void menu(){
		this.text_menu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(TelaSIMM.this, "Menu", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(TelaSIMM.this,TelaMenu.class));		
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_simm, menu);
		return true;
	}
	public boolean sairSelected() {
		Toast.makeText(TelaSIMM.this, "Sair.", Toast.LENGTH_SHORT).show();
		Bundle infoBandle = new Bundle();
		infoBandle.putBoolean("SAIR",true);
		
		Intent intentAtividade3 = 
				new Intent(TelaSIMM.this,TelaSimular.class);
		intentAtividade3.putExtras( infoBandle );
		startActivity( intentAtividade3 );
		
		Intent intentAtividade2 = 
				new Intent(TelaSIMM.this,Simular.class);
		intentAtividade2.putExtras( infoBandle );
		startActivity( intentAtividade2 );
		
		Intent intentAtividade1 = 
				new Intent(TelaSIMM.this,TelaSelecionarDoenca.class);
		intentAtividade1.putExtras( infoBandle );
		startActivity( intentAtividade1 );
		
		
		finish();
		return true;
	}

}
