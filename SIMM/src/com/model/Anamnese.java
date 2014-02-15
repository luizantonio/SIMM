package com.model;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Anamnese {

	private int    id;
	private String id_doenca;
	private String id_historia;
	private int    id_paciente;
	
	private Hashtable<Integer,String> anamneseHash = 
			new Hashtable<Integer,String>();  
	
	private Map<String, Hashtable<Integer, String>> mapAnamnese = 
			new HashMap<String, Hashtable<Integer, String>>();
	
	// �rea 13 = Urologia
	private String []Glomerulonefrite = 
	{ 
	"Identifica��o: PGM, 12 anos, M, caucasiano, estudante, natural e procedente de Salvador-Ba."+ 
	"Queixa principal: paciente urinando escuro h� duas semanas."+
	"HDA (hist�rico da doen�a atual): "+
	"Paciente relata que h� duas semanas teve uma infec��o de garganta que dificultava deglutir alimentos "+
	"principalmente no per�odo matinal. Associada � crise teve febre de 38�C e astenia. N�o fez uso de medica��es,"+
	"tendo apenas repousado e houve recupera��o completa do quadro em dois dias."+
	"No terceiro dia de in�cio da faringite, paciente passou a apresentar hemat�ria leve que persistiu por cinco dias"+
	"e depois regrediu. H� tr�s dias houve recidiva da hemat�ria."+
	"IS: paciente relata olig�ria e edema periorbit�rio discretos ao acordar. Nega dis�ria, dor lombar," +
	" febre ou sinais persistentes de faringite. "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientado, hidratado. FC = 70bpm. " +
	"PA = 150x100 mmHg. FR: 19 IRPM. T = 36,5�C.  Mucosas da conjuntiva e fr�nulo lingual hipocoradas ++." +
	" Aus�ncia de adenopatias ou edema. "+
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. Aus�ncia de sopros."+
	"AR: murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios."+
	"Abd�men: sem achados anormais.",



	"Identifica��o: JPD, 15 anos, F, caucasiano, estudante, natural e "+
	"procedente do Rio de Janeiro, capital.  "+
	"Queixa principal: paciente urinando escuro h� um m�s. "+
	"HDA (hist�rico da doen�a atual):  "+
	"Paciente relata que h� um m�s teve uma crise de garganta auto-limitada, "+
	"tendo recupera��o completa em tr�s dias. No per�odo fez uso apenas de "+
	"paracetamol. Ao final do epis�dio come�ou a urinar escuro, mas achou "+
	"que n�o era importante e n�o comentou com ningu�m. A urina voltou ao "+
	"normal depois de uma semana e h� tr�s dias voltou a ficar escura, "+
	"quando ent�o a paciente comentou com sua m�e e essa marcou a consulta. "+
	"H� dois dias paciente tem apresentado tamb�m febre de 38�C, sudorese, "+
	"dor lombar sem irradia��o, astenia e anorexia. Tomou um comprimido de "+
	"paracetamol ontem, com melhora dos sintomas. "+

	"IS: paciente relata cefal�ia frontal. Nega disfagia, tosse, rouquid�o "+
	"e dis�ria. "+

	"Antecedentes: paciente tomou todas as vacinas. J� teve menarca e nega "+
	"primeira rela��o sexual (SIC). "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientado,  "+
	"hidratado. FC = 72bpm. PA = 140x100 mmHg. FR: 19 IRPM. T = 37�C. "+
	"Mucosas da conjuntiva e fr�nulo lingual hipocoradas ++. Edema em MMII +. "+
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. Aus�ncia "+
	"de sopros. "+
	"AR: murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. "+
	"Abd�men: sem achados anormais. ",



	"Identifica��o: PMA, 13 anos, M, negro, estudante, natural e procedente  "+
	"de Aracaju - SE.  "+
	"Queixa principal: paciente inchado h� 15 dias. "+
	"HDA (hist�rico da doen�a atual):  "+
	"M�e relata que h� dois meses paciente apresentou quadro compat�vel com  "+
	"faringoamigdalite (SIC), tendo feito uso de penicilina G benzatina por "+
	"indica��o de vizinhos (sem consulta m�dica pr�via) e a faringite foi "+
	"controlada. Dois dias depois do fim da crise, paciente come�ou a urinar "+
	"escuro, mas n�o relatou nada � m�e. Poucos dias depois a urina escura "+
	"desapareceu (n�o sabe especificar) sem uso de nenhuma medica��o. H� um "+
	"m�s a urina escura reapareceu, tendo o paciente se queixado � m�e. M�e "+
	"procurou o PSF que a encaminhou ao nefrologista sendo hoje a primeira "+
	"consulta. M�e relata ainda que paciente tem apresentado edema "+
	"periorbit�rio e de MMII e dispn�ia a m�dios esfor�os. N�o fez uso "+
	"de medica��es. "+

	"IS: paciente relata cefal�ia periorbit�ria e urina espumante. Nega febre, "+
	"astenia, dor lombar e dis�ria. "+

	"Antecedentes: paciente tomou todas as vacinas. Nega doen�as pr�vias ou "+
	"uso cr�nico de medica��es. "+

	"Ectoscopia: paciente em estado geral regular, consciente e orientado, "+
	"levemente desidratado. FC = 80bpm. PA = 140x110 mmHg. FR: 23 IRPM. "+
	"T = 36,5�C. Pele normocorada. Mucosas da conjuntiva e fr�nulo lingual "+
	"hipocoradas +. Edema em MMII +++ com sinal de Cacifo positivo. "+
	"AC: paciente taquic�rdico, hiperfon�tico, com sopro em foco a�rtico. "+
	"AR: paciente dispn�ico. Ausculta pulmonar apresenta estertores "+
	"crepitantes principalmente em bases. "+
	"Abd�men: sem achados anormais. ",



	"Identifica��o: JPL, 13 anos, M, pardo, estudante, natural e procedente "+
	"de Macei� - AL.  "+
	"Queixa principal: paciente urinando escuro h� tr�s semanas. "+
	"HDA (hist�rico da doen�a atual):  "+
	"M�e relata que h� duas semanas paciente teve uma infec��o de garganta "+
	"associada a disfagia, febre de 39�C, cefal�ia e astenia. Fez ent�o uso "+
	"de dipirona em xarope e paciente teve melhora do quadro em quatro dias. "+
	"N�o procurou acompanhamento m�dico. "+
	"H� uma semana, paciente passou a urinar escuro, quadro que durou cinco "+
	"dias, associado a edema periorbit�rio discreto principalmente matinal. "+
	"A urina escura desapareceu ap�s cinco dias, tendo retornado h� dois "+
	"dias quando a m�e decidiu traz�-lo para consulta m�dica. "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientado, "+
	"hidratado. FC = 70bpm. PA = 130x100 mmHg. FR: 19 IRPM. T = 36,5�C. "+
	"Pele e mucosas normocoradas. Aus�ncia de adenopatias ou edema.  "+
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. "+
	"Aus�ncia de sopros. "+
	"AR: murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. "+
	"Abd�men: sem achados anormais. "	};
	
	// �rea 13 = Urologia
	private String [] Cistite = 
	{
	"Identifica��o: MAS, 23 anos, F, caucasiana, solteira, cabeleireira," +
	" natural e procedente de S�o Lu�s - Ma. "+	
	"Queixa principal: dor durante mic��o h� duas semanas."+
	"HDA (hist�rico da doen�a atual):  "+
	"Paciente refere que h� duas semanas tem apresentado dis�ria, polaci�ria" +
	" e urg�ncia miccional. Refere tamb�m astenia e anorexia durante esse" +
	" per�odo. Houve um epis�dio de febre na primeira semana do quadro e" +
	" para a febre a paciente se automedicou com paracetamol o que" +
	" resultou em resolu��o do sintoma no mesmo dia. N�o fez uso de" +
	" novas medica��es. "+
	"IS: paciente refere ainda anorexia e colora��o avermelhada da" +
	" urina (SIC). Nega perda de peso, nict�ria ou noct�ria. "+
	"Antecedentes: paciente n�o gestante. "+
	"Ectoscopia: paciente em bom estado geral, consciente e orientada," +
	" hidratada. FC = 70bpm. PA = 120x80 mmHg. FR: 19 IRPM. T = 36,5�C." +
	"  Pele e mucosas normocoradas e �midas. Aus�ncia de adenopatias ou edema. "+
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas." +
	" Aus�ncia de sopros."+
	"AR: murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios."+
	"Abd�men: sem achados anormais.", 
			

	
	"Identifica��o: STQ, 20 anos, F, parda, solteira, estudante, natural e "+
	"procedente de Recife - PE. "+
	"Queixa principal: desconforto suprap�bico h� tr�s semanas. "+
	"HDA (hist�rico da doen�a atual): "+
	"Paciente refere que h� tr�s semanas tem sentido desconforto suprap�bico "+
	"persistente. Associado a isso tem tido dis�ria e urg�ncia miccional "+
	"frequentemente. N�o fez uso de medica��es, sendo essa sua primeira "+
	"consulta ap�s in�cio dos sintomas."+

	"IS: Nega perda de peso, astenia e febre."+

	"Antecedentes: paciente n�o gestante."+

	"Ectoscopia: paciente em bom estado geral, consciente e orientada, "+
	"hidratada. FC = 70bpm. PA = 120x80 mmHg. FR: 19 IRPM. T = 36,5�C."+
	"Pele e mucosas normocoradas e �midas. Aus�ncia de adenopatias ou edema."+ 
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. "+
	"Aus�ncia de sopros."+
	"AR: murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios."+
	"Abd�men: sem achados anormais.",
	

	
	"Identifica��o: GSQ, 22 anos, F, caucasiana, solteira, estudante, "+
	"natural e procedente de Caruaru - PE. "+
	"Queixa principal: dis�ria h� um m�s. "+
	"HDA (hist�rico da doen�a atual):  "+
	"Paciente refere que h� um m�s tem apresentado dis�ria e desconforto "+
	"suprap�bico. Refere tamb�m astenia e anorexia durante esse per�odo. "+
	"Teve dois epis�dios de febre. No primeiro, h� tr�s semanas, sua febre "+
	"chegou a 39�C e estava associada a sudorese noturna. Para trat�-la "+
	"fez uso de dipirona. O segundo epis�dio aconteceu h� tr�s dias e fez "+
	"uso de paracetamol como tratamento, tendo resolu��o do sintoma no "+
	"mesmo dia. N�o fez uso de outras medica��es. "+
	"Relata ainda que durante esse per�odo tem percebido sua urina com "+
	"colora��o turva e odor desagrad�vel. "+

	"Antecedentes: paciente n�o gestante. "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientada, "+
	"hidratada. FC = 70bpm. PA = 120x80 mmHg. FR: 19 IRPM. T = 36,5�C. "+
	"Pele e mucosas normocoradas e �midas. Aus�ncia de adenopatias ou edema. "+
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. "+
	"Aus�ncia de sopros. "+
	"AR: murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. "+
	"Abd�men: sem achados anormais. ",
	
	"Identifica��o: ALB, 22 anos, F, caucasiana, solteira, estudante de "+
	"medicina, natural e procedente de Fortaleza - CE. "+
	"Queixa principal: dis�ria h� 10 dias. "+
	"HDA (hist�rico da doen�a atual):  "+
	"Paciente refere que h� tr�s meses apresentou dis�ria, desconforto "+
	"suprap�bico e polaci�ria. N�o teve febre. Suspeitando de cistite, "+
	"se tratou com SMT por tr�s dias tendo resolu��o do quadro. "+
	"H� 10 dias tem novamente apresentado o quadro cl�nico de dis�ria, "+
	"desconforto suprap�bico e polaci�ria, por�m agora associado � febre "+
	"e astenia. Para a febre fez o tratamento com paracetamol e decidiu "+
	"se consultar para investiga��o mais detalhada. "+

	"Antecedentes: paciente com vida sexual ativa. N�o gestante.  "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientada, "+
	"hidratada. FC = 70bpm. PA = 120x80 mmHg. FR: 19 IRPM. T = 36,5�C. "+
	"Pele e mucosas normocoradas e �midas. Aus�ncia de adenopatias ou edema.  "+
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. "+
	"Aus�ncia de sopros. "+
	"AR: murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. "+
	"Abd�men: sem achados anormais. "			
	};
	// �rea 13 = Urologia
	private String [] doencaPorLesaominima = 
	{
	"Identifica��o:PAM, 9 anos, M, branco, estudante, natural e procedente" +
	" de Sorocaba -SP. " +
	"Queixa principal:edema nos olhos h� 4 dias." +
	"HDA (hist�rico da doen�a atual):" +
	"M�e relata que paciente apresentouedema periorbit�rio pela manh� e de MMII" +
	" h� tr�s semanas. Com isso, m�e procurou atendimento no PSF onde o m�dico" +
	" local suspeitou de rea��o al�rgica e receitou dexclorfeniramina. Apesar" +
	" do tratamento, quadro evoluiu com piora gerando anasarca e dispn�ia progressiva." +
	" Foi relatado, ainda, a forma��o de abundante espuma ao urinar. Associado a isso," +
	" foi descrito n�useas , v�mitos e discreta dor abdominal difusa." +

	"IS: paciente nega dor lombar, sintomas miccionais ou outras altera��es urin�rias." +
	" Nega sintomas fora do TGU." +
	"AP (antecedentes patol�gicos): paciente asm�tico." +

	"Ectoscopia: paciente em estado geral regular, consciente e orientado, desidratado." +
	" FC = 76bpm. PA = 120x80mmHg. FR: 23 IRPM. T = 36,5�C. Pele p�lida e ressecada,mucosas" +
	" ressecadas. Cabelo quebradi�o" +
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. Aus�ncia de sopros." +
	"AR:dispn�ico aos m�dios esfor�os. Ausculta pulmonar com estertores crepitantes" +
	" nas bases pulmonares.Oximetria em ar ambiente com Sat O2 de 93 %." +
	"Abd�men: sem achados anormais." ,

	"IDENTIFICA��O: DFT, 5 anos, M, negro, pr�-escolar, natural e procedente " +
	"de Ribeir�o Preto -SP.  " +
	"Queixa principal: edema em todo o corpo h� 8 dias. " +
	"HDA: Acompanhante do paciente relata que o mesmo vem na �ltima semana apresentando " +
	"anasarca, que come�ou com um discreto �incha�o nos olhos�(SIC) depois de um " +
	"episodio gripal  que a partir dai passou para todo o corpo e aumentou. Relata, " +
	"ainda, que a crian�a j� teve edemas, sendo de pequenas propor��ese se resolvia " +
	"com um medicamento (n�o sabe o nome), que foi receitado em consulta anterior, " +
	"sendo que agora n�o fez efeito. � relatadouma astenia progressiva e dispneia " +
	"a pequenos esfor�os.   " +

	"IS: nega outros sintomas " +
	"AP (antecedentes patol�gicos): paciente com dermatite at�pica. " +

	"Ectoscopia: paciente em estado geral regular, consciente e orientado, desidratado. " +
	"FC = 97bpm. PA = 130x75mmHg. FR: 26 IRPM. T = 36,6�C. Pele p�lida com turgor e " +
	"elasticidade diminu�da e seca, mucosas ressecadas e normocoradas. Unhas " +
	"esbranqui�adas, pouco brilho e quebradi�a; pelos esparsos e quebradi�os   " +
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. Aus�ncia " +
	"de sopros. " +
	"AR:dispn�ico aos pequenos esfor�os. Ausculta pulmonar com estertores crepitantes " +
	"em ambos hemot�rax e presentes de forma difusa " +
	"Abd�men: sem achados anormais. " 		
	};
	
	// �rea 13 = Urologia
	private String [] GNDA =
	{
	"Identifica��o:ECB, 13 anos, M, pardo, estudante, natural e procedente de" +
	" Cajazeiras - PB.  " +
	"Queixa principal:paciente relata urina escurecida h� tr�s dias. " +
	"HDA: " +
	"M�e relata que crian�a h�oito dias apresentou faringite com febre," +
	" dificuldade de deglutir alimentos, especialmente os s�lidos e astenia." +
	" N�o se consultou com o m�dico e como tratamento, repousou na cama por" +
	" dois dias tomando apenas paracetamol para al�vio da febre. Depois de" +
	" dois dias os sintomas tiveram resolu��o espont�nea. " +
	"H� tr�s dias paciente tem notado edema bipalpebral ao acordar, mas que" +
	" vai desaparecendo ao longo do dia. No final do dia geralmente apresenta" +
	" edemas em MMII, mas ap�s acordar o incha�o j� desapareceu (SIC). Tamb�m" +
	" relatahemat�ria em que a urina n�o est� avermelhada, mas sim escurecida." +
	" Relata tamb�m dispn�ia ao subir as escadas do seu pr�dio, fen�meno que" +
	" n�o ocorria antes do quadro gripal. Para esses sintomas recentes n�o se" +
	" consultou com outros m�dicos nem fez uso de nenhuma medica��o. " +
	"IS:nega febre nos �ltimos tr�s dias, por�m apresentou epis�dios recentes" +
	" de cefal�ia. " +

	"Ectoscopia:paciente em bom estado geral, consciente e orientado, hidratado" +
	" e normocorado. FC = 70bpm. PA = 150x100 mmHg. FR: 22 IRPM. T = 36,5�C. Poliadenopatia" +
	" cervical com g�nglios de aproximadamente 0,5cm. Faringe hiperemiada +.  . Edema" +
	" periorbit�rio ++, sem aumento de temperatura ou sensibilidade local.Aus�ncia de" +
	" edema em MMII. " +
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR:dispn�ico aos m�dios esfor�os. Ausculta pulmonar com estertores crepitantes" +
	" nas bases pulmonares.Oximetria em ar ambiente com Sat O2 de 93 %. " +
	"Abd�men: sem achados anormais. " ,

	"Identifica��o: JVM, 10 anos, M, caucasiano, estudante, natural e procedente" +
	" de Araruna - PB. " +
	"Queixa principal: paciente relata incha�o nos olhos ao acordarh� cinco dias." +
	"HDA (hist�rico da doen�a atual):" +
	"M�e relata que paciente h� 10 dias apresentou dor de garganta especialmente" +
	" no per�odo matinal, astenia e febre de 40�C. N�o fez uso de medica��es e" +
	" houve resolu��o espont�nea dos sintomas em quatro dias." +
	"H� tr�s dias paciente tem notado edema bipalpebral ao acordar que dificulta" +
	" abrir os olhos, mas que desaparece no decorrer do dia. Tamb�m relatadispn�ia" +
	" a grandes esfor�os e hemat�ria em que a urina se apresenta �cor de coca-cola� (SIC)." +
	"IS: paciente relata dor lombar e olig�ria.Nega cefal�ia." +
	"Antecedentes: paciente fez uso de todas as vacinas (SIC). Paciente asm�tico." +

	"Ectoscopia: paciente em bom estado geral, consciente e orientado, hidratado" +
	" e normocorado. FC = 75bpm. PA = 160x110 mmHg. FR: 22 IRPM. T = 36,5�C." +
	"  Linfonodos palp�veis em cadeia cervical lateral e posterior. Faringe" +
	" hiperemiada ++.  . Edema periorbit�rio +++. Aus�ncia de edema em MMII." +
	"AC: ritmo card�aco regular em 2tempos.hiperfonese de B2 e sopro sist�lico " +
	" em foco a�rtico." +
	"AR: redu��o domurm�rio vesicular e presen�a de estertores crepitantes nas bases."+
	"Abd�men: sem achados anormais." ,

	"Identifica��o:KPT, 12 anos, F, negra, estudante, natural e procedente" +
	" de Fortaleza-CE.  " +
	"Queixa principal: paciente relata incha�o nos olhos e pernas h� tr�s dias. " +
	"HDA (hist�rico da doen�a atual): " +
	"M�e relata que paciente apresentou h� um m�s les�es de pele na bochecha e n�o" +
	" diagnosticadas pelo m�dico como impetigo. Foi tratada com neomicina e lavagem" +
	" das les�es com permanganato de pot�ssio. " +
	"H� quatro dias paciente vem apresentando edema bipalpebral e em membros" +
	" inferiores, sendo esse �ltimoespecialmente no final do dia. M�e relata" +
	" ainda que crian�a tem apresentado hemat�ria, mal estar e n�usea. N�o houve" +
	" consulta m�dica ap�s esses �ltimos sintomas. " +

	"IS: paciente relata olig�ria.Nega dor lombar. " +
	"Antecedentes: pacientenega menarca. Paciente teve quadro de parotidite" +
	" infecciosa ano anterior. " +

	"Ectoscopia: paciente em bom estado geral, consciente e orientado, hidratado" +
	" e normocorado. FC = 75bpm. PA = 150x110 mmHg. FR: 19 IRPM. T = 36,5�C." +
	"  Edema periorbit�rio +++. Edema em MMII ++. Aus�ncia de adenomegalia. " +
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas." +
	" Aus�ncia de sopros. " +
	"AR: murm�rio vesicular presente em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: sem achados anormais.",

	

	
	"Identifica��o:ACS, 9 anos, M, pardo, estudante, natural e procedente de" +
	" Tenente Ananias - RN.  " +
	"Queixa principal:paciente let�rgico h� um dia. " +
	"HDA (hist�rico da doen�a atual): " +
	"M�e relata que paciente apresentou h� um m�s les�es cut�neas especialmente" +
	" faciais, pouco dolorosas e crostosas. Foi tratada com gentamicina e" +
	" eritromicina com resolutividade completa. " +
	"H� oito dias paciente vem apresentando edema bipalpebrale hemat�ria freq�ente," +
	" mas m�e n�o procurou m�dico por conselho de vizinha. H� um dia crian�a" +
	" evoluiu com cefal�ia e estado let�rgico observado pela professora quando" +
	" a crian�a perdeu seu interesse nas atividades escolares e recrea��o (SIC). " +

	"IS: paciente relata olig�ria e dispn�ia a m�dios esfor�os.Nega dor lombar. " +
	"Antecedentes: paciente com todas as vacinas (SIC). " +

	"Ectoscopia:paciente em estado geral regular, desorientado no tempo e" +
	" espa�o, hidratado e normocorado. FC = 75bpm. PA = 200x120 mmHg. FR: 23 IRPM." +
	" T = 36,5�C.  Edema periorbit�rio +++. Edema em MMII ++. Aus�ncia de" +
	" adenomegalia ou les�es cut�neas. " +
	"AC: ritmo card�aco regular em 2 tempos. Bulhas normofon�ticas." +
	" Aus�ncia de sopros. " +
	"AR: murm�rio vesicular presente em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: sem achados anormais. " +
	"Neurol�gico:",
	};
	// �rea 13 = Urologia
	private String [] LitiaseUrinaria =
	{
	"Identifica��o: JFR, masculino, 50 anos, taxista." +
	"QP: Dor em regi�o lombar esquerda h� 2 meses." +
	"HDA: Paciente relata que h� dois meses vem sentindo dores," +
	" de moderada intensidade, em regi�o lombar esquerda, que se" +
	" irradia para o flanco, em aperto, de car�ter intermitente," +
	" sem n�useas, v�mitos ou febre. Relata ter usado paracetamol," +
	" com melhora parcial dos sintomas." +
	"Hist�ria patol�gica: portador de HAS e DM. Em uso de captopril" +
	" e metformina. Nega alergias a qualquer tipo de medicamento." +
	"H�bitos e costumes: Consome bastante prote�na e sal na comida," +
	" tabagista." +
	"Ectoscopia: PA: 160X 100 mmHg; FR: 25 irpm; FC: 110 bpm; IMC= 22 Kg/m2;" +
	" Afebril; Acian�tica; Anict�rica; Regular estado geral; consciente e" +
	" orientada; f�scies de sofrimento; postura ant�lgica; pele de  turgor e" +
	" elasticidade diminu�dos, aus�ncia de les�es prim�rias e secund�rias de pele. " +
	"AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros." +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios." +
	"Abd�men: Abdomen em plano, sim�trico, ru�dos hidroa�reos normais, dor" +
	" � palpa��o superficial e profunda em quadrande superior esquerdo, rins" +
	" n�o palp�veis, Giordano positivo. " ,
	
	
	"ID: RNM, feminino, 34 anos, professora universit�ria." +
	"QP: Dor lombar h� 12 horas." +
	"HDA: Paciente relata que h� 12 horas vem sentindo dores de forte intensidade," +
	" de in�cio s�bito, cont�nua, em aperto, em regi�o lombar que se irradia para" +
	" os flancos e fossa il�aca esquerda, sem fatores de melhora ou piora. Relata" +
	" v�mitos, n�usea e febre. Nega uso de medicamentos." +
	"Hist�ria patol�gica: NDA." +
	"H�bitos e costumes: NDA." +
	"Ectoscopia: PA: 130x85 mmHg; FR: 27 irpm; FC: 120bpm; IMC: 30 kg/m2. Regular" +
	" estado geral, acian�tica, anict�rica, febril, consciente, orientada, posi��o" +
	" ant�lgica, f�scies de sofrimento, pele de elasticidade e turgor conservados." +
	"AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros." +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios." +
	"Abd�men: Abdomen em avental, sim�trico, ru�dos hidroa�reos normais, dor �" +
	" palpa��o superficial e profunda em quadrande superior direito, rins n�o" +
	" palp�veis, Giordano positivo.",

	"ID: FKL, feminina, 62 anos, dona de casa. " +
	"QP: Dor em flanco esquerdo h� 1 m�s. " +
	"HDA: Paciente relata que h� 1 m�s vem sentindo dores, , de car�ter intermitente," +
	" em flanco esquerdo, de leve intensidade, em aperto, que se irradia para fossa" +
	" il�aca esquerda e grandes l�bios. Relata hemat�ria macrosc�pica. Nega n�usea," +
	" v�mito e febre. Fez uso de Dipirona S�dica 500mg de 6/6 horas, com melhora dos" +
	" sintomas. Encontra-se nervosa e apreensiva. " +
	"Hist�ria patol�gica: HAS. Hist�ria materna de c�lon esquerdo (m�e aos 69 anos " +
	"foi diagnosticada com adenocarcinoma de c�lon esquerdo). " + 
	"H�bitos e costumes: NDA. " +
	"Ectoscopia: PA: 140x90 mmHg; FR: 17 irpm; FC: 63 bpm; IMC: 18,9 kg/m2. Bom estado" +
	" geral, acian�tica, anict�rica, afebril, consciente, orientada, f�scies" +
	" incaracter�stica, pele de elasticidade e turgor conservados. " +
	"AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: Abdomen em plano, sim�trico, ru�dos hidroa�reos normais, aus�ncia de" +
	" dor � palpa��o superficial e profunda, rins n�o palp�veis," +
	" Giordano negativo.",

	
	"ID: JLS, masculino, 43 anos, pedreiro."+
	"QP: Dor em dorso h� 1 semana."+
	"HDA: Paciente relata que h� 1 semana vem sentindo dor bilateral, de curso" +
	" cont�nuo, intensidade moderada, em pontada, em dorso que n�o se irradia." +
	" Nega n�usea, v�mito, febre. Fez uso de dipirona s�dica 500 mg, com melhora" +
	" parcial dos sintomas. " +
	"Hist�ria patol�gica: NDA. " +
	"H�bitos e costumes: NDA. " +
	"Ectoscopia: PA: 120x80 mmHg; FR: 15 irpm; FC: 72 bpm; IMC: 23,9 kg/m2. Bom" +
	" estado geral, acian�tico, anict�rico, afebril, consciente, orientado, f�scies" +
	" incaracter�stica, pele de elasticidade e turgor conservados. " +
	"AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: Abdomen em plano, sim�trico, ru�dos hidroa�reos normais, aus�ncia de" +
	" dor � palpa��o superficial e profunda, rins n�o palp�veis," +
	" Giordano negativo.",

	
	"ID: PSM, 52 anos, masculino, advogado. " +
	"QP: Dor nas costas h� 10 horas. " +
	"HDA: Paciente relata que h� 10 horas apareceram de forma s�bita dores no dorso" +
	" de forte intensidade, em c�lica, que se irradiam para flancos, sem fatores de" +
	" piora ou melhora, com n�usea e v�mito, sem febre. Nega uso de medicamentos. " +
	"Hist�ria patol�gica: Paciente com cirurgia para osteofitose programada. HAS," +
	" DM. Apresenta alergia ao iodo. " +
	"H�bitos e costumes: NDA. " +
	"Ectoscopia: PA: 130X80 mmHg; FR: 26 irpm FC: 108 bpm; IMC: 20 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anict�rico, afebril, acian�tico, turgor" +
	" e elasticidade da pele conservados, f�scies de sofrimento, posi��o ant�lgica. " +
	 "AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: Abdomen em plano, sim�trico, ru�dos hidroa�reos normais, dor �" +
	" palpa��o superficial e profunda, rins n�o palp�veis," +
	" Giordano positivo. " ,

	
	"ID: FLV, feminino, 52 anos, engenheira. " +
	"QP: Dor em hipog�strio esquerdo h� 5 dias. " +
	"HDA: Paciente relata que h� 5 dias vem sentindo dores, de modera intensidade," +
	" em hipog�strio, acompanhada de hemat�ria. Sem fatores de melhora ou piora." +
	" Nega ter usado medicamentos para controle da dor. " +
	"IS: Nega perda de peso, astenia, anorexia. " +
	"Hist�ria patol�gica: DM. " +
	"H�bitos e costumes: Tabagista h� 35 anos, 2 ma�os/dia. " +
	"Antecedentes familiares: M�e possuiu c�ncer de rim. " +
	"Ectoscopia: PA: 120X80 mmHg; FR: 16 irpm FC: 62 bpm; IMC: 28 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anict�rico, afebril, acian�tico, turgor" +
	" e elasticidade da pele conservados, f�scies incaracter�stica.  " +
	"AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: Abdomen em plano, sim�trico, ru�dos hidroa�reos normais, aus�ncia" +
	" de dor � palpa��o superficial e profunda, rins n�o palp�veis, Giordano negativo. " ,

	
	
	"ID: MFG, masculino, 34 anos, agente comunit�rio de sa�de. " +
	"QP: Dor em dorso h� 10 dias. " +
	"HDA: Paciente relata que h� 4 anos realizou nefrectomia total de rim direito" +
	" e h� 2 meses realizou cirurgia para corre��o de estenose de JUP secund�ria " +
	"a ITU de repeti��o. Atualmente, encontra-se com dor em regi�o costovertebral" +
	" esquerda h� 10 dias, de forte intensidade, sem irradia��o. Refere n�usea, " +
	"nega v�mitos e febre. Traz laudo de TC de 2 meses atr�s que relata pelve " +
	"intra-renal, estenose de JUP, aus�ncia de c�lculos, hidronefrose grau IV." +
	" Relata ter usado paracetamol, ibuprofeno, sem melhora dos sintomas. " +
	"IS: Nda. " +
	"Hist�ria patol�gica: HAS, DM. " +
	"H�bitos e costumes: NDA. " +
	"Hist�ria familiar: Rins polic�sticos. " +
	"Ectoscopia: PA: 140X90 mmHg; FR: 17 irpm FC: 72 bpm; IMC: 32 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anict�rico, afebril, acian�tico, turgor" +
	" e elasticidade da pele conservados, f�scies incaracter�stica.  " +
	" AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: Abdomen em plano, sim�trico, ru�dos hidroa�reos normais, aus�ncia" +
	" de dor � palpa��o superficial e profunda, rins n�o palp�veis, Giordano" +
	" positivo � esquerda. " ,

	
	
	
	"ID: LEG, masculino, 35 anos, t�cnico de enfermagem. " +
	"QP: Dor em flanco direito h� 4 dias. " +
	"HDA: Paciente relata dor em flanco direito h� 4 dias, sem irradia��o. Nega" +
	" perda de peso, n�usea, v�mito, febre. Nega fatores de melhora e piora. N�o" +
	" utilizou medicamentos para controle da dor. " +
	"Hist�ria patol�gica: Realizou h� 10 anos colecistectomia. Portador de HIV" +
	" h� 15 anos. H� 1 ano foi internado por pneumonia, onde ficou 1 semana em" +
	" UTI. Al�rgico � iodo. " +
	"H�bitos e costumes: Nega tabagismo, alcoolismo.  " +
	"IS: Nega les�es de pele e de cavidade oral. Nega altera��o do h�bito" +
	" intestinal e nega volume e aspecto das fezes anormais. " +
	"Ectoscopia: PA: 110X70 mmHg; FR: 15 irpm FC: 64 bpm; IMC: 19 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anict�rico, afebril, acian�tico," +
	" turgor e elasticidade da pele conservados, aus�ncia de les�es elementares" +
	" de pele, f�scies incaracter�sticas.  " +
	" AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: Abdomen escavado, sim�trico, ru�dos hidroa�reos normais, aus�ncia" +
	" de dor � palpa��o superficial e profunda, Blumberg negativo, Giordano negativo " ,

	
	"ID: KLM, feminino, 23 anos, estudante. " +
	"QP: Dor em epig�strio h� 1 ano. " +
	"HDA: Paciente relata que h� 1 ano apresenta dores em epig�strio, em aperto," +
	" de forte intensidade, com irradia��o lombar inferior. Procurou m�dico que " +
	"receitou Pantoprazol e Ranitidina, sem melhora dos sintomas. Refere 3 epis�dios" +
	" de ITU nos �ltimos 6 meses, em que fez tratamento com antibi�ticos, com melhora.  " +
	"Antecedentes patol�gicos: Nda. " +
	"H�bitos e costumes: Nda. " +
	"IS: Nda. " +
	"Ectoscopia: PA: 110X70 mmHg; FR: 16 irpm FC: 70 bpm; IMC: 30 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anict�rico, afebril, acian�tico, turgor" +
	" e elasticidade da pele conservados, f�scies de dor.  " +
	" AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: Abdomen plano, sim�trico, ru�dos hidroa�reos normais, aus�ncia de" +
	" dor � palpa��o superficial e profunda, aus�ncia visceromegalias, Blumberg" +
	" negativo, Giordano negativo.  " ,

	
	
	"ID: LEL, feminino, 68 anos, aposentada. " +
	"QP: Dor em flaco esquerdo h� 1 m�s. " +
	"HDA: Paciente relata dor em flanco esquerdo h� 1 m�s, em aperto, de forte" +
	" intensidade, que se irradia para grandes l�bios. Relata hemat�ria e n�useas." +
	" Nega v�mitos e febre. N�o utilizou medicamentos. Refere que j� sentiu dores" +
	" com mesmas caracter�sticas durante 8 anos, de car�ter intermitente.  " +
	"Antecedentes patol�gicos: Realizou cirurgia para feocromacitoma h� 15 anos, " +
	"e para exclus�o renal direita h� 5 anos. HAS, DM. " +
	"H�bitos e costumes: Tabagista durente 50 anos, com 3 ma�os/dia. " +
	"IS: Nega perda de peso, astenia, anorexia. " +
	"Ectoscopia: PA: 150X90 mmHg; FR: 19 irpm FC: 75 bpm; IMC: 35 Kg/m2. Regular " +
	"estado feral, consciente e orientado, anict�rico, afebril, acian�tico, turgor " +
	"e elasticidade da pele conservados, f�scies de dor.  " +
	" AC: Ritmo card�aco em dois tempos, bulhas normofon�ticas. Aus�ncia de sopros. " +
	"AR: Murm�rio vesicular em ambos os hemit�rax, sem ru�dos advent�cios. " +
	"Abd�men: Abdomen em avental, sim�trico, ru�dos hidroa�reos normais, aus�ncia " +
	"de dor � palpa��o superficial e profunda, aus�ncia visceromegalias, Giordano negativo." 		
	};
	
	
	public Anamnese() {
		this.anamneseHash = 
				new Hashtable<Integer,String>();
		for(int i = 0; i < this.Glomerulonefrite.length; i++){
			this.anamneseHash.put(i,(this.Glomerulonefrite[i]));
		}
		this.mapAnamnese.put("Glomerulonefrite por IgA (Doen�a de Berger)",this.anamneseHash);
		
		this.anamneseHash = 
				new Hashtable<Integer,String>();
		for(int i = 0; i < this.Cistite.length; i++){
			this.anamneseHash.put(i,(this.Cistite[i]));
		}
		this.mapAnamnese.put("Cistite",this.anamneseHash);
		
		this.anamneseHash =  
				new Hashtable<Integer,String>();
		for(int i = 0; i < this.doencaPorLesaominima.length; i++){
			this.anamneseHash.put(i,(this.doencaPorLesaominima[i]));
		}
		this.mapAnamnese.put("Doenca por lesao m�nima",this.anamneseHash);
		
		this.anamneseHash = 
				new Hashtable<Integer,String>();
		for(int i = 0; i < this.GNDA.length; i++){
			this.anamneseHash.put(i,(this.GNDA[i]));
		}
		this.mapAnamnese.put("GNDA",this.anamneseHash);
		
		this.anamneseHash = 
				new Hashtable<Integer,String>();
		for(int i = 0; i < this.LitiaseUrinaria.length; i++){
			this.anamneseHash.put(i,(this.LitiaseUrinaria[i]));
		}
		this.mapAnamnese.put("Litiase urinaria",this.anamneseHash);
		
		
	}
	
	
	
	
	
	public Hashtable<Integer, String> getAnamneseHash() {
		for(int i = 0; i < this.Glomerulonefrite.length; i++){
			anamneseHash.put(i,(this.Glomerulonefrite[i]));
		}
		return anamneseHash;
	}
	public void setAnamneseHash(Hashtable<Integer, String> anamneseHash) {
		this.anamneseHash = anamneseHash;
	}
	
	public Map<String, Hashtable<Integer, String>> getMapAnamnese() {
		return mapAnamnese;
	}

	public void setMapAnamnese(Map<String, Hashtable<Integer, String>> mapAnamnese) {
		this.mapAnamnese = mapAnamnese;
	}

	public String[] getGlomerulonefrite() {
		return Glomerulonefrite;
	}

	public void setGlomerulonefrite(String[] Glomerulonefrite) {
		this.Glomerulonefrite = Glomerulonefrite;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getId_doenca() {
		return id_doenca;
	}

	public void setId_doenca(String id_doenca) {
		this.id_doenca = id_doenca;
	}

	public String getId_historia() {
		return id_historia;
	}

	public void setId_historia(String id_historia) {
		this.id_historia = id_historia;
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}
	
}
