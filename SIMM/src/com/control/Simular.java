package com.control;

import static android.provider.BaseColumns._ID;
import static com.persistence.Constants.TABLE_NAME_DOENCA;
import static com.persistence.Constants.NAME_DOENCA;
import static com.persistence.Constants.AREA_ID;
import static com.persistence.Constants.TAG_E;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.ContentValues;
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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.control.R;
import com.model.Area;
import com.model.Doenca;
import com.persistence.DataBaseHelper;
/**
 * Classe responsável por criar  a tela de Simular 
 * e enviar a coleção de doenças para a classe TelaSimular, por meio
 * de intent 
 * */
public class Simular extends Activity implements OnItemClickListener {

	private ListView listView;
	private ProgressDialog progerss;
	private Handler handler;
	private TextView texto_doenca;
	private TextView simular;
	private String [] arrayNomes ;
	private ArrayList<String> arrayList = new ArrayList<String>();
	private ArrayList<String> nomesDoencas = new ArrayList<String>();
	private String nomeDaAreaSelecionada;
	private int idDaAreaSelecionada = 0;
	private static final String TAG_E = "Erro:TSD";
	private ArrayList<String> arrayParaListaDeDoencas; //por meio de intent par a ListView de Simular.class
	private ArrayList<String> entriesDoenca = new ArrayList<String>();
	private DataBaseHelper dBHelper;
	private Area area ;
	private Doenca doenca ;
	private static String[] FROM_DOENCA = { _ID, NAME_DOENCA,AREA_ID};
	private static String ORDER_BY_DOENCA = NAME_DOENCA  + " ASC"; ;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simular);
		
		this.arrayParaListaDeDoencas = new ArrayList<String>();
		try{
			this.dBHelper = new DataBaseHelper(this);
		}catch(Exception error){
			Log.w(TAG_E, "Error: In DataBaseHelper(this), onCreate " + error);
		}		
		// volta para tela anterior		
		Button voltar = (Button) findViewById(R.id.button1);
		voltar.setOnClickListener(new Voltar());

		/***
		handler = new Handler();
		this.progerss = ProgressDialog.show(this, "SIMM",
				"Carregando, por favor aguarde...",
				false, true);
		*****/
		
		this.carregarInformacoes();
		
		//setNomeDoenca();// exibe o nome da doenca na tela
		this.simular = (TextView) findViewById(R.id.text_view_simular);
		
		// método que direciona para a tela de simulação
		this.simularAtendimento();	
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
	public void carregarInformacoes(){
		/***new Thread(){
			@Override
			public void run(){***/
				try{
					Intent intent = getIntent();
			        Bundle simmInfo = intent.getExtras();
			        if (simmInfo != null) {			        	
			        	
			        	if(simmInfo.containsKey("arrayListDoencaSelecionada")){
			        		if(simmInfo.getStringArrayList("arrayListDoencaSelecionada") != null)
			        			entriesDoenca = 
				        			simmInfo.getStringArrayList("arrayListDoencaSelecionada");
			        			setArrayNomesDoencas(entriesDoenca );
			        	}
			        	if(simmInfo.containsKey("nomeDaAreaSelecionada")){
			        		if(simmInfo.getString("nomeDaAreaSelecionada") != null)
				        		nomeDaAreaSelecionada = simmInfo.getString("nomeDaAreaSelecionada");
				        		setNomeDaAreaSelecionada(nomeDaAreaSelecionada);
			        	}
			        	if(simmInfo.containsKey("idDaAreaSelecionada")){
			        		if(simmInfo.getInt("idDaAreaSelecionada")> 0)
			        			idDaAreaSelecionada = simmInfo.getInt(     "idDaAreaSelecionada");
			        			/**Toast.makeText(Simular.this, "ID: "+ idDaAreaSelecionada,
			    					Toast.LENGTH_SHORT).show();*/
			        		
			        			setIdDaAreaSelecionada(idDaAreaSelecionada );
			        	}
			        	if(simmInfo.containsKey("arrayDoencaSelecionada")){
			        		if(simmInfo.getStringArray("arrayDoencaSelecionada") != null)
			        			arrayNomes = simmInfo.getStringArray("arrayDoencaSelecionada");
			        	}
			        	if(simmInfo.containsKey("SAIR")){
			        		
			        		//sairSelected();
			        	}
			        	/**
			        	if(entriesDoenca.size() > 0) {//|| (entriesDoenca.size() == arrayNomes.length)){
			        		List<String> lista = new ArrayList<String>();
				        	Iterator it = entriesDoenca.iterator();
				            while(it.hasNext()){
				        		String string = (String) it.next();
				        		if(string != null){
				        			lista.add(string);
				        		}
				        	}
			        		
				        	//Toast.makeText(Simular.this, entriesDoenca.size(), 
				        			//Toast.LENGTH_SHORT).show();
				        	
				        	//Log.w(TAG_E, "ALERTA: FOI ArrayList-------------------");
				        	construirLista(lista);
				        	
			        	}else {//if(entriesDoenca.size() == 0){
			        		int idnovo = simmInfo.getInt("idDaAreaSelecionada");
			        		Cursor cursor = selecionarDoencaAreaID(idnovo );
			        		List<String> lista2 = preencheArrayNomes(cursor);
			        		
			        		Log.w(TAG_E, "ALERTA: FOI Array-----------------------");
			        		List<String> lista2 = Arrays.asList(arrayNomes);
			        		construirLista(lista2);
			        	}*/
			        	
			        	
			        }
			        construirLista();
				}catch(Exception e){
					Log.w(TAG_E, "Error: run(), carregar Informações. "+ e);
					return;
				}
			/***}
		}.start();***/
	}
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
	 * Método que recupera a coleção de nomes de doenças através do ID da área
	 * na tabela doenca.
	 * */
	public Cursor selecionarDoencaAreaID(int rowId) throws SQLException {	
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
	
	public void construirLista(){
		
		int index = this.idDaAreaSelecionada;
		
		if(index != 0){ 
			Cursor cursorAux = this.selecionarDoencaAreaID(index);
			if (cursorAux.getCount() > 0){
				final List<String> listaAuxD = this.preencheArrayNomes(cursorAux);
				/**handler.post(new Runnable(){
						@Override
						public void run() {**/
							try{
								// Fecha a janela do dialogo
								/**progerss.dismiss();**********/
								// cria lista com nomes das áreas na ListView
								ArrayAdapter<String> adapter= 
										new	ArrayAdapter<String>(Simular.this, 
												android.R.layout.simple_list_item_1,  
												listaAuxD );
								//setListAdapter(adapter);
								
								listView = (ListView) findViewById(R.id.listview_simular);
								listView.setAdapter(adapter);
								listView.setOnItemClickListener(Simular.this);
							
							}catch(Exception e){
								Log.w(TAG_E, "Error: In construirLista() Simular. " + e);
								Toast.makeText(Simular.this, "Ocorreu um problema, tente novamente!",
										Toast.LENGTH_SHORT).show();
								return;
							}	
						}
				/***	});	
			}***/
		}
		
	}

	public void setArrayNomesDoencas(ArrayList<String> doencas) {	this.nomesDoencas = doencas;	}
	
	public String getNomeDaAreaSelecionada() {	return nomeDaAreaSelecionada;	}
	
	public void setNomeDaAreaSelecionada(String nomeDaAreaSelecionada) {  this.nomeDaAreaSelecionada = nomeDaAreaSelecionada;	}
	
	public int getIdDaAreaSelecionada() {	return idDaAreaSelecionada;	}
	
	public void setIdDaAreaSelecionada(int idDaAreaSelecionada) {	this.idDaAreaSelecionada = idDaAreaSelecionada;	}
	
	/** 
	 * Recupera a intent e devolve uma lista de nomes
	 *  */
	public void setIdArea(){
		Intent intent = getIntent();
        Bundle simmInfo = intent.getExtras();
        if (simmInfo != null) {
        	this.idDaAreaSelecionada = simmInfo.getInt("idDaAreaSelecionada");
        }
	}
	
	/** recupera o vetor de nomes de doenças; usado na classe simular*/
	public String [] getArrayNomes(){		return this.arrayNomes;	}
	/**
	 * adiciona os elemmentos  selecionados no array de string 
	 * para compor alista de nomes de doenças que o usuário irá trabalhar
	 * 
	 * */
	public void addNomesDasDoencas(){
		if(this.arrayList.size() != 0){
			Iterator it = this.arrayList.iterator();
			this.arrayNomes = new String [this.arrayList.size()];
			int contador = 0;
			String test = "";
			while(it.hasNext()){
				String nomeAdd = (String) it.next();
				if(nomeAdd != null){
					System.out.println(">>>>>>>>>>>> "+ nomeAdd);
					this.arrayNomes[contador] = nomeAdd;
					contador++;
					test += ", " + nomeAdd;
				}
			}
			Toast.makeText(this, "Você Selecionou: " + test , Toast.LENGTH_SHORT).show();
		}
	}

	/** 
	 * Constroi uma lista de nomes para serem selecionados
	 * @param entriesDoenca 
	 *  */
	
	public List<String> verificaQuantidade(List<String> lista){
		if(lista == null){
			Toast.makeText(Simular.this, "Volte e selecione uma outra área médica.",
					Toast.LENGTH_SHORT).show();
			Log.w(TAG_E, "Error: In construirLista() =  null");
		}else if(lista.size() == 0){
			int id = this.getIdDaAreaSelecionada();
			if (id == 0){
				this.setIdArea();
			}else{
				Cursor cursor = this.selecionarDoencaAreaID(id);
				if(cursor == null){
					Log.w(TAG_E, "Erro: em verificaQuantidade(). cursor =  null");
				}else if(cursor.getCount() > 0){
					lista = this.preencheArrayNomes(cursor);
				}
			}
		}
		return lista;
	}
	
	private List<String> preencheArrayNomes(Cursor cursor1) {
		List<String> nomesAux= new ArrayList<String>();
		Cursor cursor = cursor1;
		if(cursor.getCount() > 0){
			 cursor.moveToFirst();
			 while (cursor.moveToNext()) {
				 int id        = Integer.parseInt(cursor.getString(0));
				 String nome_doenca = cursor .getString(1);
				 String area_id = cursor .getString(2);
				 nomesAux.add(nome_doenca);
			 }
		}	
		return (nomesAux); 
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.simular, menu);
		return true;
	}
	/**
	 * Método responsável pela seleção das doenças para trabalhar
	 *   */
	/**
	protected void onListItemClick(ListView l, View v, int position, long id){
		super.onListItemClick(l, v, position, id);
		// Pega o item naquela posição
		Object o = this.getListAdapter().getItem(position);
		String nome = o.toString();
		// add no ArrayList
		if(this.arrayList.size() == 0){
				this.arrayList.add(nome);
		}else if(this.arrayList.size() > 0){
			if(!this.arrayList.contains(nome)){
				this.arrayList.add(nome);
			}
		}
		//add no Array 'arrayNomes'
		this.addNomesDasDoencas();
	}
	*/
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int posicao, long id) {	
	    // Pega o item naquela posição
		Object o = listView.getItemAtPosition(posicao);
		String nome = o.toString();
		// add no ArrayList
		if(this.arrayList.size() == 0){
				this.arrayList.add(nome);
		}else if(this.arrayList.size() > 0){
			if(!this.arrayList.contains(nome)){
				this.arrayList.add(nome);
			}
		}
		//add no Array 'arrayNomes'
		this.addNomesDasDoencas();
	}
	/**
	 * Classe interna responsável por retornar a tela anterior
	 * */
	private class Voltar  implements OnClickListener{
		
		public Voltar(){}//construtor
		//método para voltar a tela anterior
		@Override
		public void onClick(View arg0) {
			startActivity(new Intent(Simular.this, TelaSelecionarDoenca.class));
		}
	}
	/**
	 * Método responsável por direcionar para a classe Telasimular e
	 * envia alguma informação para ela
	 * */
	public void simularAtendimento(){
		Toast.makeText(Simular.this, "Método SimularAtendimento..." , Toast.LENGTH_SHORT).show();
		this.simular.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if(arrayNomes == null){
					Toast.makeText(Simular.this, "Selecione alguma doença na lista!" ,
							Toast.LENGTH_SHORT).show();
				}else if(arrayNomes.length > 0){
					Toast.makeText(Simular.this, "Simular!" , Toast.LENGTH_SHORT).show();
					
					Bundle infoBandle = new Bundle();
					if( arrayList != null)
						infoBandle.putStringArrayList("arrayListDoencaSelecionada", arrayList);
					if( arrayNomes!= null)
						infoBandle.putStringArray(    "arrayDoencaSelecionada",      arrayNomes );
					if( idDaAreaSelecionada > 0)
						infoBandle.putInt(            "idDaAreaSelecionada",    idDaAreaSelecionada);
					Intent intentAtividade = new Intent(Simular.this, TelaSimular.class);
					intentAtividade.putExtras( infoBandle );
					startActivity( intentAtividade );
					
				}else{
					Toast.makeText(Simular.this, "Selecione alguma doença na lista!" ,
							Toast.LENGTH_SHORT).show();
					startActivity(new Intent(Simular.this, Simular.class));
				}
			}
		});
	}
	public boolean sairSelected() {
		
		finish();
		return true;
	}
}
