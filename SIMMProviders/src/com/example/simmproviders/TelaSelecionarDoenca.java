package com.example.simmproviders;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class TelaSelecionarDoenca extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_selecionar_doenca);
		
		// botão responsável por voltar para a tela anterior	
		Button voltar = (Button) findViewById(R.id.button1);
		voltar.setOnClickListener(new Voltar());
				
		Toast.makeText(TelaSelecionarDoenca.this, "VOLTE", Toast.LENGTH_LONG).show();
		
	}
	/** 
	 * classe interna para controlar a volta a tela anterior 
	 * */
	private class Voltar  implements OnClickListener{
		
		public Voltar(){}//construtor
		//método para voltar a tela anterior
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(TelaSelecionarDoenca.this,TelaSIMM.class));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_selecionar_doenca, menu);
		return true;
	}

}
