package com.control;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.control.R;
import com.model.Area;
import com.model.Doenca;
import com.persistence.DataBaseHelper;
import static android.provider.BaseColumns._ID;
import static com.persistence.Constants.TABLE_NAME_AREA;
import static com.persistence.Constants.NAME_AREA;
import static com.persistence.Constants.TABLE_NAME_DOENCA;
import static com.persistence.Constants.NAME_DOENCA;
import static com.persistence.Constants.AREA_ID;
import static com.persistence.Constants.TAG_E;

/**
 * Classe responsável por criar  a tela de Selecão de doenças  
 * e enviar a coleção de doenças para a classe Simular, por meio
 * de intent 
 * */
public class TelaSelecionarDoenca extends Activity implements OnItemClickListener {
	/**
	 *  your content must have a listview whose id attribute is 
	 * */
	private ListView listView;
	private String ACTIVITY_NOME = "TelaSelecionarDoenca" ;
	private ProgressDialog progerss;
	private Handler handler;
	private static final String TAG_E = "Erro:TSD";
	private ArrayList<String> arrayParaListaDeDoencas = new ArrayList<String>(); //por meio de intent par a ListView de Simular.class
	private Area area ;
	private Doenca doenca ;
	private String nomeDaAreaSelecionada;
	private int idDaAreaSelecionada;
	private DataBaseHelper dBHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tela_selecionar_doenca);
		
		// botão responsável por voltar para a tela anterior	
		Button voltar = (Button) findViewById(R.id.button1);
		voltar.setOnClickListener(new Voltar());
		this.area = new Area();
		this.doenca = new Doenca();
		try{
			this.dBHelper = new DataBaseHelper(this);	//inicializa o BD
		}catch(Exception error){
			Log.w(TAG_E, "Error: In selecionarDoencasPorArea(String nomeArea) " + error);
		}
		try {
			handler = new Handler();                        //alert progresso
			this.progerss = ProgressDialog.show(this, "SIMM area"," Carregando dados, por favor aguarde...", false, true);
		    this.addArea();		                        //adiciona on nomes da Areas no BD
		}catch(Exception error){
			Log.w(TAG_E, "Error: In addArea(), onCreat() " + error);
		}
		try {
			//handler = new Handler();                        //alert progresso
			//this.progerss = ProgressDialog.show(this, "SIMM doenca"," Carregando dados, por favor aguarde...", false, true);
		    this.addDoenca();		                    //adiciona on nomes das Doencas
		}catch(Exception error){
			Log.w(TAG_E, "Error: In addDoenca(), onCreat() " + error);
		}
		try{
			//handler = new Handler();                        //alert progresso
			//this.progerss = ProgressDialog.show(this, "SIMM"," Carregando dados, por favor aguarde...", false, true);
			this.selecionarArea();		                //adiciona os nomes das Areas num lisview
		}catch(Exception error){
			Log.w(TAG_E, "Error: In selecionarDoencasPorArea(String nomeArea) " + error);
		}
		this.verificaSaida();
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
			Log.w(TAG_E, "Error:  verifica saida. "+ e);
			return;
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
				progerss.dismiss();	
				SQLiteDatabase db = dBHelper.getWritableDatabase();
			    Cursor cursor = getArea();
			    
			    if (cursor.getCount() < 1){
			    	InputStream rawRes = getResources().openRawResource(R.raw.nomearea);
				    String nome = new String();
					ContentValues values = new ContentValues();	
					Scanner scanner = new Scanner(rawRes);
					try {
						
						while (scanner.hasNext()) {
							nome = scanner.nextLine();
							if(nome.equals("^z") || nome.equals("^Z")){break;}
							System.out.println("nome---> "+nome);	
							values.put(NAME_AREA, nome);	
							db.insertOrThrow(TABLE_NAME_AREA,null, values);				
						}//while
					} catch (SQLException e) {
						Log.w(TAG_E, "Error: --->" +  e);
					} catch (Exception e) {
						Log.w(TAG_E, "Error: --->" +  e);
					}			 
			     }
				 cursor.close();
				 db.close();// fecha o BD	 
			}
		});	
	}
	/**
	 * Busca no BD as áreas para exibir
	 * */
	private static String[] FROM_AREA = { _ID, NAME_AREA};
	private static String ORDER_BY = NAME_AREA + " ASC";
	private Cursor getArea() {
	    // Perform a managed query. The Activity will handle closing
	    // and re-querying the cursor when needed.
	    SQLiteDatabase db = this.dBHelper.getReadableDatabase();
	    Cursor cursor = db
	        .query(TABLE_NAME_AREA, FROM_AREA, null, null, null, null, ORDER_BY);
	    startManagingCursor(cursor);
	    return cursor;
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
					Cursor cursor = getArea();
					cursor.moveToFirst();
					int tamanho = 0;
					int index = 0;
					tamanho = cursor.getCount();
					String[] entries = new String[cursor.getCount()];
					if(cursor.getCount() > 0){
						entries = new String[cursor.getCount()];
						while (cursor.moveToNext()) {
							if(cursor != null){
								int id        = Integer.parseInt(cursor.getString(0));
								System.out.println(" selecionar------->"+ id);
								String nome_area = cursor.getString(1).toString();
								System.out.println(" selecionar------->"+  nome_area);
								entries[index] = nome_area;
								index ++;
								if (index == 31){break;}
							}
						}
					}
					cursor.close();
					List<String> namesList = Arrays.asList(entries);
					construirLista(namesList);
				}catch(Exception e){
					Log.w(TAG_E, "Error: " +  e);
					return;
				}
				
			}//fim run
		}.start();	//fim thread
		//return (namesList); 
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
									new	ArrayAdapter<String>(TelaSelecionarDoenca.this, 
											android.R.layout.simple_list_item_1, 
									        lista );
							listView.setAdapter(adapter);
							listView.setOnItemClickListener(TelaSelecionarDoenca.this);
						}
					}catch(Exception e){return;}	
				}
			});
			
		}catch(Exception e){return;}
	}
	/**
	 * Método para adicionar os nomes das doenças no BD 
	 * */
	public void addDoenca() {
		new Thread(){
			@Override
			public void run(){
				try{
					persisteNomesDoencasDeArquivoNoBD();
				}catch(Exception e){
					return;
				}				
			}//fim run
		}.start();	//fim thread
	}
	
	public void persisteNomesDoencasDeArquivoNoBD(){
		handler.post(new Runnable(){
			@Override
			public void run() {
				progerss.dismiss();	
				SQLiteDatabase db = dBHelper.getWritableDatabase();
			    Cursor cursor = getDoenca();
			    
			    if (cursor.getCount() < 1){
			    	InputStream rawRes = getResources().openRawResource(R.raw.nomedoenca);
				    String nome = new String();
					ContentValues values = new ContentValues();	
					Scanner scanner = new Scanner(rawRes);
					try {
						
						int count = 1;
						while (scanner.hasNext()) {
							count++;
							int numero = 0;
							nome = scanner.nextLine();// recolhe númrero do AREA_ID
							System.out.println("nome  antes---> "+ nome );
							if(nome.equals("^z") || nome.equals("^Z")){break;}
							System.out.println("Count--> "+ count );
							if((count % 2) == 0){
								numero = validaInteger( nome );
								System.out.println("if numero---> "+ numero );
							}
							nome = scanner.nextLine();// recolhe nome para NAME_DOENCA
							System.out.println("nome  antes 2 ---> "+ nome );
							if(numero > 0){
								
								System.out.println("if numero DDoença---> "+ numero );
								System.out.println("if nome   DDoenca---> "+ nome );
								values.put(NAME_DOENCA, nome );	
								values.put(AREA_ID, numero );
								db.insertOrThrow(TABLE_NAME_DOENCA,null, values );	
							}
										
						}//while
					} catch (SQLException e) {
						Log.w(TAG_E, "Error: --->" +  e);
					} catch (Exception e) {
						Log.w(TAG_E, "Error: --->" +  e);
					}			 
			     }
				 cursor.close();
				 db.close();// fecha o BD	 
			}
		});		
	}
	public int validaInteger(String text){
		System.out.println("====validaInt=texto====> "+text);
		int retorno = 0;
		String texto = text;
		String textoAux = text;
        byte qtdeLetras = 0;
        int indiceEspaco = 0;
        int indiceInicio = texto.indexOf(" ");
        int indicefim = texto.lastIndexOf(texto, 0);
        for(char c: texto.toCharArray()) {
            if(!Character.isLetter(c) && !Character.isWhitespace(c)){
            	retorno = Integer.parseInt(textoAux);
            	System.out.println("=====int==1====> "+retorno);
            	return retorno;
            }
            if(Character.isLetter(c)){
                qtdeLetras++;
            }
            if(Character.isWhitespace(c)){
            	indiceEspaco = texto.indexOf(" ",0);
            }
        }
		if(qtdeLetras > 0 || indiceInicio > 0){
			return 0;
		}
		System.out.println("====int===2====> "+retorno);
		return retorno;
	}
	
	private static String[] FROM_DOENCA = { _ID, NAME_DOENCA,AREA_ID};
	private static String ORDER_BY_DOENCA = NAME_DOENCA  + " ASC"; ;
	/**
	 * Método para recuperar os nomes das doenças do BD
	 * */
	private Cursor getDoenca() {
	    // Perform a managed query. The Activity will handle closing
	    // and re-querying the cursor when needed.
	    SQLiteDatabase db = this.dBHelper.getReadableDatabase();
	    Cursor cursor = db
	        .query(TABLE_NAME_DOENCA, FROM_DOENCA, null,
	        		null, null, null, ORDER_BY_DOENCA);
	    startManagingCursor(cursor);
	    return cursor;
	}
	
	/**
	 * Método responsável por encontrar uma Área Médica e chama o método
	 * selecionarDoencaPorAreaID(int id)  para recuperar as doenças desta área
	 * e setar o ArrayList<String> para enviá-lo para o método simular (
	 * ArrayList<String> doencasDaArea), este passa a lista de doenças para a tela
	 * a classe TelaSimular que a usa em uma ListView
	 * */
	public ArrayList<String> selecionarDoencasPorArea(String nomeArea){
		SQLiteDatabase db = this.dBHelper.getReadableDatabase();
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
			db.close();
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
		//Toast.makeText(TelaSelecionarDoenca.this, "Interno "+ rowId, Toast.LENGTH_LONG).show();
		SQLiteDatabase db = this.dBHelper.getReadableDatabase();
	    Cursor mCursor = db.query(true, TABLE_NAME_DOENCA, FROM_DOENCA,
	    		                  AREA_ID + "=" + rowId, null, null,
	    		                   null, null, null);
	    if (mCursor != null) {
	      mCursor.moveToFirst();
	    }
	    db.close();
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
			startActivity(new Intent(TelaSelecionarDoenca.this,TelaSIMM.class));
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tela_selecionar_doenca, menu);
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
					new Intent(TelaSelecionarDoenca.this,Simular.class);
			intentAtividade.putExtras( infoBandle );
			startActivity( intentAtividade );
		}else{
			Toast.makeText(TelaSelecionarDoenca.this,
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
        AlertDialog.Builder abd = new AlertDialog.Builder(TelaSelecionarDoenca.this);
        abd.setTitle("SIMM");
        abd.setMessage("Area: " + selectedItem);
        abd.setPositiveButton("Ok", 
        		new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface arg0, int arg1) {
						// Pega o item naquela posição
						Object o = listView.getItemAtPosition(posicaoNome);
						String area = o.toString();
						Toast.makeText(TelaSelecionarDoenca.this, area,
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
						startActivity(new Intent(TelaSelecionarDoenca.this,
								TelaSelecionarDoenca.class));
					}
                }
        );
        abd.show();
	}
}