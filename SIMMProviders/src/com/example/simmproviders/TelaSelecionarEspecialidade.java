package com.example.simmproviders;

import static android.provider.BaseColumns._ID;
import static com.example.simmproviders.p.Constants.NAME_AREA;
import static com.example.simmproviders.p.Constants.TABLE_NAME_AREA;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.example.simmproviders.p.*;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TelaSelecionarEspecialidade extends Activity implements OnItemClickListener {
	/**
	 *  your content must have a listview whose id attribute is 
	 * */
	private ListView listView;
	private String ACTIVITY_NOME = "TelaSelecionarDoenca" ;
	private ProgressDialog progerss;
	private Handler handler;
	private static final String TAG_E = "Erro:TSD";
	private ArrayList<String> arrayParaListaDeDoencas = 
			new ArrayList<String>(); //por meio de intent par a ListView de Simular.class
	private String nomeDaAreaSelecionada;
	private int idDaAreaSelecionada;
	//private DataBaseHelper dBHelper;

	SimpleCursorAdapter mAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_selecionar_especialidade);
		
		// botão responsável por voltar para a tela anterior	
		Button voltar = (Button) findViewById(R.id.button1);
		voltar.setOnClickListener(new Voltar());

		try {
			handler = new Handler();                        //alert progresso
			this.progerss = ProgressDialog.show(this, "SIMM area"," Carregando dados, por favor aguarde...", false, true);
		    this.addArea();		                        //adiciona on nomes da Areas no BD
		}catch(Exception error){
			Log.w(TAG_E, "Error: In addArea(), onCreat() " + error);
		}
		try{
			//handler = new Handler();                        //alert progresso
			//this.progerss = ProgressDialog.show(this, "SIMM"," Carregando dados, por favor aguarde...", false, true);
			this.selecionarArea();		                //adiciona os nomes das Areas num lisview
		}catch(Exception error){
			Log.w(TAG_E, "Error: In selecionarArea() " + error);
		}

	}
	
	/**
	 * Método para adicionar os nomes das Áreas Médicas no BD 
	 * */
	public void addArea() {
		new Thread(){
			@Override
			public void run(){
				try{
					persisteNoBDNomesAreasDeArquivo();
				}catch(Exception e){
					return;
				}				
			}//fim run
		}.start();	//fim thread
	}
	public void persisteNoBDNomesAreasDeArquivo(){
		handler.post(new Runnable(){
			@Override
			public void run() {
				Cursor mCursor = managedQuery(SIMMProvider.CONTENT_URI, null, null, null, null);
			    if (mCursor.getCount() < 1){
			    	InputStream rawRes = getResources().openRawResource(R.raw.nomearea);
				    String nome = new String();
				    String nomeAux = new String();
					ContentValues values = new ContentValues();	
					Scanner scanner = new Scanner(rawRes);
					try {
						int contador = 1;
						while (scanner.hasNext()) {
							int numero = 0;
							nome = scanner.nextLine();// recolhe númrero do AREA_ID
							if(nome.equals("^z") || nome.equals("^Z")){break;}
							numero = Integer.parseInt( nome );
							nomeAux = scanner.nextLine();
							values.put( Constants.ESPECIALIDADE_NAME, nomeAux );	
							values.put("identificador", numero );
							getContentResolver().insert(SIMMProvider.CONTENT_URI, values);
							contador++;
						}//while
					} catch (SQLException e) {
						Log.w(TAG_E, "Error: --->" +  e);
					} catch (Exception e) {
						Log.w(TAG_E, "Error: --->" +  e);
					}			 
			     }
			    progerss.dismiss();
		      }	  
			}
	  );	
	}
	/**
	 * Busca no BD as áreas para exibir
	 * */
	private Cursor getArea() {
		Cursor mCursor = managedQuery(SIMMProvider.CONTENT_URI, null, null, null, null);
	    return mCursor;
	}
	/**
	 * Método para adicionar os nomes das Áreas no ArrayAdapter <String> 
	 * para colocar no ListView da activity_tela_selecionar_doenca.xml 
	 * */
	
	public void selecionarArea(){
		new Thread(){
			@Override
			public void run(){
				try{
					Cursor mCursor = managedQuery(SIMMProvider.CONTENT_URI, null, null, null, null);
					mCursor.moveToFirst();
					int tamanho = 0;
					int index = 0;
					tamanho = mCursor.getCount();
					String[] entries = new String[mCursor.getCount()];
					if(mCursor.getCount() > 0){
						entries = new String[mCursor.getCount()];
						while (mCursor.moveToNext()) {
							if(mCursor != null){
								int id        = Integer.parseInt(mCursor.getString(0));
								System.out.println(" selecionar------->"+ id);
								String nome_area = mCursor.getString(2).toString();
								System.out.println(" selecionar------->"+  nome_area);
								entries[index] = nome_area;
								index ++;
								if (index == 31){break;}
							}
						}
					}
					mCursor.close();
					List<String> namesList = Arrays.asList(entries);
					construirLista(namesList);
				}catch(Exception e){
					Log.w(TAG_E, "Error: " +  e);
					return;
				}
			}//fim run
		}.start();	//fim thread 
	}
	
	/**
	 * Método que preenche o ListView em activity_tela_selecionar_doenca.xml 
	 * */
	public void construirLista( final List<String> lista){
		try{
			handler.post(new Runnable(){
				@Override
				public void run() {
					try{
						if(lista == null){
							Log.w(TAG_E, "Error: In construirLista() =  null");
						}else if(lista.size() == 0){
							Log.w(TAG_E, "Error: In construirLista().size() = 0");
						}else {				
							// Fecha a janela do dialogo
							progerss.dismiss();
							listView = (ListView) findViewById(R.id.listview_selecionar_doenca);
							// cria lista com nomes das áreas na ListView
							ArrayAdapter<String> adapter= 
									new	ArrayAdapter<String>(TelaSelecionarEspecialidade.this, 
											android.R.layout.simple_list_item_1, 
									        lista );
							listView.setAdapter(adapter);
							listView.setOnItemClickListener(TelaSelecionarEspecialidade.this);
						}
					}catch(Exception e){return;}	
				}
			});
			
		}catch(Exception e){return;}
	}

	/**
	 * Método responsável por encontrar uma Área Médica e chama o método
	 * selecionarDoencaPorAreaID(int id)  para recuperar as doenças desta área
	 * e setar o ArrayList<String> para enviá-lo para o método simular (
	 * ArrayList<String> doencasDaArea), este passa a lista de doenças para a tela
	 * a classe TelaSimular que a usa em uma ListView
	 * */
	public ArrayList<String> selecionarDoencasPorArea(String nomeArea){
		//SQLiteDatabase db = this.dBHelper.getReadableDatabase();
		try{
		    Cursor mCursor = this.getArea(); 
		    
			if (mCursor != null) {
				 mCursor.moveToFirst();
				 if(mCursor.getCount() > 0){
					 Cursor cursorSimular = null;
					 while (mCursor.moveToNext()) {
						 int indice  = Integer.parseInt(mCursor.getString(0));
						 this.idDaAreaSelecionada = indice;
						 String nome_area =            mCursor .getString(1);
						 this.nomeDaAreaSelecionada = nome_area;
						 if(nomeArea.equals(nome_area)){
							 cursorSimular = this.selecionarDoencaAreaID(indice);// Recupera os nomes das doenças
							 if(cursorSimular.getCount() > 0){
								 while (cursorSimular.moveToNext()) {
									 int idsm          = Integer.parseInt(cursorSimular.getString(0));
									 String nome_doenca = cursorSimular .getString(1);
									 String area_id     =  cursorSimular .getString(2);
									 this.arrayParaListaDeDoencas.add(nome_doenca);
								 }
							 }
							 break;
						 } 
					 }
					 cursorSimular.close();
				 }
			 }
			mCursor.close();
		}catch(Exception e){
			Log.w(TAG_E, "Error: In selecionarDoencasPorArea(String nomeArea) " + e);
		}finally{
			//db.close();
		}
		 return arrayParaListaDeDoencas;
	}
	
	public ArrayList<String> getArrayParaListaDeDoencas() {
		return this.arrayParaListaDeDoencas;
	}
	
	public void setArrayParaListaDeDoencas(ArrayList<String> 
	                                           arrayParaListaDeDoencas) {
		this.arrayParaListaDeDoencas = arrayParaListaDeDoencas;
	}
	/**
	 * Método que recupera a coleção de nomes de doenças atravé do ID da área
	 * na tabela doenca.
	 * */
	public Cursor selecionarDoencaAreaID(int rowId) throws SQLException {
		Cursor mCursor = managedQuery(SIMMProvider.CONTENT_URI, null, null, null, null);
	    if (mCursor != null) {
	      mCursor.moveToFirst();
	    }
	    Toast.makeText(TelaSelecionarEspecialidade.this, "Doenças não estão retornando!", 
	    		Toast.LENGTH_SHORT).show();
	    
	    return mCursor;
	}
	
	/** 
	 * classe interna para controlar a volta a tela anterior 
	 * */
	private class Voltar  implements OnClickListener{
		
		public Voltar(){}//construtor
		//método para voltar a tela anterior
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(TelaSelecionarEspecialidade.this,TelaSIMM.class));
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_selecionar_especialidade, menu);
		return true;
	}
	/**
	 * Envia um Array com nomes de doenças para a classe Simular
	 * */
	public void simular(ArrayList<String> nomesDoenca){
		ArrayList<String> nomes =  nomesDoenca;

		if(nomes.size() > 0){
			Bundle infoBandle = new Bundle();
			infoBandle.putStringArrayList("arrayListDoencaSelecionada", nomes );
			infoBandle.putString(         "nomeDaAreaSelecionada", this.nomeDaAreaSelecionada);
			infoBandle.putInt(            "idDaAreaSelecionada",   this.idDaAreaSelecionada);
			
			Intent intentAtividade = 
					new Intent(TelaSelecionarEspecialidade.this,TelaSelecionarDoenca.class);
			intentAtividade.putExtras( infoBandle );
			startActivity( intentAtividade );
		}else{
			Toast.makeText(TelaSelecionarEspecialidade.this,
					"Não há nenhuma doença disponível para essa área!" +
					 " Volte e Tente novamente com uma que possua!",
					  Toast.LENGTH_LONG).show();
		}
	}
	public boolean sairSelected() {
		finish();
		return true;
	}
	

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int posicao, long id) {
		final int posicaoNome = posicao;
		final long ID = id;
		Object s = arg0.getItemAtPosition(posicao);
        final String selectedItem=s.toString();
        // exibe um novo Alert Dialog com o item selecionado
        AlertDialog.Builder abd = new AlertDialog.Builder(TelaSelecionarEspecialidade.this);
        abd.setTitle("SIMM");
        abd.setMessage("Area: " + selectedItem);
        abd.setPositiveButton("Ok", 
        		new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// Pega o item naquela posição
						Object o = listView.getItemAtPosition(posicaoNome);
						String area = o.toString();
						Toast.makeText(TelaSelecionarEspecialidade.this, area,
							       Toast.LENGTH_SHORT).show();
						// caso a área seja selecionada , então busca as doenças daquela área			
						ArrayList<String> listaNomesDoencas = 
									selecionarDoencasPorArea(area);
						if(listaNomesDoencas != null){
							simular(listaNomesDoencas);// Método que passa dados para a classe Simular	
						}
					}
                }
        );
        abd.setNegativeButton("Cancel", 
        		new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						startActivity(new Intent(TelaSelecionarEspecialidade.this,
								TelaSelecionarEspecialidade.class));
					}
                }
        );
        abd.show();
	}
}