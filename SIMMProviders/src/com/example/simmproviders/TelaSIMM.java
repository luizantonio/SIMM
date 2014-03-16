package com.example.simmproviders;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TelaSIMM extends Activity {

	private TextView historia;
	private TextView livre;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_simm);
		this.historia = (TextView) findViewById(R.id.text_historia);
		this.livre = (TextView) findViewById(R.id.text_livre);
		this.acaoButons();
		
	}
	
	private void acaoButons() {
		this.historia.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Toast.makeText(TelaSIMM.this, "Modo história", Toast.LENGTH_SHORT).show();
				startActivity(new Intent(TelaSIMM.this,TelaSelecionarEspecialidade.class));
			}
		});
		this.livre.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View v) {
				Toast.makeText(TelaSIMM.this, "Modo livre", Toast.LENGTH_SHORT).show();
				//startActivity(new Intent(TelaSIMM.this,TelaSelecionarDoenca.class));
			}
		});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_simm, menu);
		return true;
	}

}
