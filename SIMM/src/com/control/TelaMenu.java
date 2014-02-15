package com.control;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import static com.persistence.Constants.TAG_E;

public class TelaMenu extends Activity {

	public static final int NOVO = 0;
	public static final int SALVAR = 1;
	public static final int SAIR = 2;
	ImageView novo ;
	ImageView salvar ;
	ImageView sair ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_menu);
		TextView view = new TextView (this);
		view.setText("MENU");
		setContentView(view);
		
		novo = (ImageView) findViewById(R.id.imageView1_novo);
		novo.setOnClickListener(new Novo());
		salvar = (ImageView) findViewById(R.id.imageView2_salvar);
		salvar.setOnClickListener(new Salvar());
		sair = (ImageView) findViewById(R.id.imageView3_sair);
		sair.setOnClickListener(new Sair());
		
	}
	private class Salvar  implements OnClickListener{
		
		public Salvar(){}//construtor
		//método para voltar a tela anterior
		@Override
		public void onClick(View arg0) {
			Toast.makeText(TelaMenu.this, "SALVAR", Toast.LENGTH_SHORT);
			startActivity(new Intent(TelaMenu.this,TelaSIMM.class));
		}
	}
	
	private class Novo  implements OnClickListener{
		
		public Novo(){}//construtor
		//método para voltar a tela anterior
		@Override
		public void onClick(View arg0) {
			Toast.makeText(TelaMenu.this, "NOVO", Toast.LENGTH_SHORT);
			startActivity(new Intent(TelaMenu.this,TelaSIMM.class));
		}
	}
	private class Sair  implements OnClickListener{
		
		public Sair(){}//construtor
		//método para voltar a tela anterior
		@Override
		public void onClick(View arg0) {
			Toast.makeText(TelaMenu.this, "SAIR", Toast.LENGTH_SHORT);
			Bundle infoBandle = new Bundle();
			infoBandle.putBoolean("SAIR", true);
			
			Intent intentAtividade4 = 
					new Intent(TelaMenu.this,TelaSimular.class);
			intentAtividade4.putExtras( infoBandle );
			startActivity( intentAtividade4 );
			
			Intent intentAtividade3 = 
					new Intent(TelaMenu.this,Simular.class);
			intentAtividade3.putExtras( infoBandle );
			startActivity( intentAtividade3 );
						
			Intent intentAtividade2 = 
					new Intent(TelaMenu.this,TelaSelecionarDoenca.class);
			intentAtividade2.putExtras( infoBandle );
			startActivity( intentAtividade2 );
			
			Intent intentAtividade1 = 
					new Intent(TelaMenu.this,TelaSIMM.class);
			intentAtividade1.putExtras( infoBandle );
			startActivity( intentAtividade1 );
			
			Intent intentAtividade0 = 
					new Intent(TelaMenu.this,TelaMenu.class);
			intentAtividade0.putExtras( infoBandle );
			startActivity( intentAtividade0 );
			
			
			
			
			
		}
	}
	private class Voltar  implements OnClickListener{
		
		public Voltar(){}//construtor
		//método para voltar a tela anterior
		@Override
		public void onClick(View arg0) {
			Toast.makeText(TelaMenu.this, "Voltar", Toast.LENGTH_SHORT);
			startActivity(new Intent(TelaMenu.this,TelaSIMM.class));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_menu, menu);
		return true;
	}
	public boolean sairSelected() {
		
		finish();
		return true;
	}
	/***
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item){
		switch(item.getItemId()){
		case NOVO:
			Toast.makeText(TelaMenu.this, "NOVO", Toast.LENGTH_SHORT);
			return true;
		case SALVAR:
			Toast.makeText(TelaMenu.this, "SALVAR", Toast.LENGTH_SHORT);
			return true;
		case SAIR:
			Toast.makeText(TelaMenu.this, "SAIR", Toast.LENGTH_SHORT);
			return true;
		}
		return false;
	}
	*****/
}
