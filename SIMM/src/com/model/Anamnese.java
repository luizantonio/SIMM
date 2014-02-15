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
	
	// área 13 = Urologia
	private String []Glomerulonefrite = 
	{ 
	"Identificação: PGM, 12 anos, M, caucasiano, estudante, natural e procedente de Salvador-Ba."+ 
	"Queixa principal: paciente urinando escuro há duas semanas."+
	"HDA (histórico da doença atual): "+
	"Paciente relata que há duas semanas teve uma infecção de garganta que dificultava deglutir alimentos "+
	"principalmente no período matinal. Associada à crise teve febre de 38°C e astenia. Não fez uso de medicações,"+
	"tendo apenas repousado e houve recuperação completa do quadro em dois dias."+
	"No terceiro dia de início da faringite, paciente passou a apresentar hematúria leve que persistiu por cinco dias"+
	"e depois regrediu. Há três dias houve recidiva da hematúria."+
	"IS: paciente relata oligúria e edema periorbitário discretos ao acordar. Nega disúria, dor lombar," +
	" febre ou sinais persistentes de faringite. "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientado, hidratado. FC = 70bpm. " +
	"PA = 150x100 mmHg. FR: 19 IRPM. T = 36,5°C.  Mucosas da conjuntiva e frênulo lingual hipocoradas ++." +
	" Ausência de adenopatias ou edema. "+
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. Ausência de sopros."+
	"AR: murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios."+
	"Abdômen: sem achados anormais.",



	"Identificação: JPD, 15 anos, F, caucasiano, estudante, natural e "+
	"procedente do Rio de Janeiro, capital.  "+
	"Queixa principal: paciente urinando escuro há um mês. "+
	"HDA (histórico da doença atual):  "+
	"Paciente relata que há um mês teve uma crise de garganta auto-limitada, "+
	"tendo recuperação completa em três dias. No período fez uso apenas de "+
	"paracetamol. Ao final do episódio começou a urinar escuro, mas achou "+
	"que não era importante e não comentou com ninguém. A urina voltou ao "+
	"normal depois de uma semana e há três dias voltou a ficar escura, "+
	"quando então a paciente comentou com sua mãe e essa marcou a consulta. "+
	"Há dois dias paciente tem apresentado também febre de 38°C, sudorese, "+
	"dor lombar sem irradiação, astenia e anorexia. Tomou um comprimido de "+
	"paracetamol ontem, com melhora dos sintomas. "+

	"IS: paciente relata cefaléia frontal. Nega disfagia, tosse, rouquidão "+
	"e disúria. "+

	"Antecedentes: paciente tomou todas as vacinas. Já teve menarca e nega "+
	"primeira relação sexual (SIC). "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientado,  "+
	"hidratado. FC = 72bpm. PA = 140x100 mmHg. FR: 19 IRPM. T = 37°C. "+
	"Mucosas da conjuntiva e frênulo lingual hipocoradas ++. Edema em MMII +. "+
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. Ausência "+
	"de sopros. "+
	"AR: murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. "+
	"Abdômen: sem achados anormais. ",



	"Identificação: PMA, 13 anos, M, negro, estudante, natural e procedente  "+
	"de Aracaju - SE.  "+
	"Queixa principal: paciente inchado há 15 dias. "+
	"HDA (histórico da doença atual):  "+
	"Mãe relata que há dois meses paciente apresentou quadro compatível com  "+
	"faringoamigdalite (SIC), tendo feito uso de penicilina G benzatina por "+
	"indicação de vizinhos (sem consulta médica prévia) e a faringite foi "+
	"controlada. Dois dias depois do fim da crise, paciente começou a urinar "+
	"escuro, mas não relatou nada à mãe. Poucos dias depois a urina escura "+
	"desapareceu (não sabe especificar) sem uso de nenhuma medicação. Há um "+
	"mês a urina escura reapareceu, tendo o paciente se queixado à mãe. Mãe "+
	"procurou o PSF que a encaminhou ao nefrologista sendo hoje a primeira "+
	"consulta. Mãe relata ainda que paciente tem apresentado edema "+
	"periorbitário e de MMII e dispnéia a médios esforços. Não fez uso "+
	"de medicações. "+

	"IS: paciente relata cefaléia periorbitária e urina espumante. Nega febre, "+
	"astenia, dor lombar e disúria. "+

	"Antecedentes: paciente tomou todas as vacinas. Nega doenças prévias ou "+
	"uso crônico de medicações. "+

	"Ectoscopia: paciente em estado geral regular, consciente e orientado, "+
	"levemente desidratado. FC = 80bpm. PA = 140x110 mmHg. FR: 23 IRPM. "+
	"T = 36,5°C. Pele normocorada. Mucosas da conjuntiva e frênulo lingual "+
	"hipocoradas +. Edema em MMII +++ com sinal de Cacifo positivo. "+
	"AC: paciente taquicárdico, hiperfonético, com sopro em foco aórtico. "+
	"AR: paciente dispnéico. Ausculta pulmonar apresenta estertores "+
	"crepitantes principalmente em bases. "+
	"Abdômen: sem achados anormais. ",



	"Identificação: JPL, 13 anos, M, pardo, estudante, natural e procedente "+
	"de Maceió - AL.  "+
	"Queixa principal: paciente urinando escuro há três semanas. "+
	"HDA (histórico da doença atual):  "+
	"Mãe relata que há duas semanas paciente teve uma infecção de garganta "+
	"associada a disfagia, febre de 39°C, cefaléia e astenia. Fez então uso "+
	"de dipirona em xarope e paciente teve melhora do quadro em quatro dias. "+
	"Não procurou acompanhamento médico. "+
	"Há uma semana, paciente passou a urinar escuro, quadro que durou cinco "+
	"dias, associado a edema periorbitário discreto principalmente matinal. "+
	"A urina escura desapareceu após cinco dias, tendo retornado há dois "+
	"dias quando a mãe decidiu trazê-lo para consulta médica. "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientado, "+
	"hidratado. FC = 70bpm. PA = 130x100 mmHg. FR: 19 IRPM. T = 36,5°C. "+
	"Pele e mucosas normocoradas. Ausência de adenopatias ou edema.  "+
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. "+
	"Ausência de sopros. "+
	"AR: murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. "+
	"Abdômen: sem achados anormais. "	};
	
	// área 13 = Urologia
	private String [] Cistite = 
	{
	"Identificação: MAS, 23 anos, F, caucasiana, solteira, cabeleireira," +
	" natural e procedente de São Luís - Ma. "+	
	"Queixa principal: dor durante micção há duas semanas."+
	"HDA (histórico da doença atual):  "+
	"Paciente refere que há duas semanas tem apresentado disúria, polaciúria" +
	" e urgência miccional. Refere também astenia e anorexia durante esse" +
	" período. Houve um episódio de febre na primeira semana do quadro e" +
	" para a febre a paciente se automedicou com paracetamol o que" +
	" resultou em resolução do sintoma no mesmo dia. Não fez uso de" +
	" novas medicações. "+
	"IS: paciente refere ainda anorexia e coloração avermelhada da" +
	" urina (SIC). Nega perda de peso, nictúria ou noctúria. "+
	"Antecedentes: paciente não gestante. "+
	"Ectoscopia: paciente em bom estado geral, consciente e orientada," +
	" hidratada. FC = 70bpm. PA = 120x80 mmHg. FR: 19 IRPM. T = 36,5°C." +
	"  Pele e mucosas normocoradas e úmidas. Ausência de adenopatias ou edema. "+
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas." +
	" Ausência de sopros."+
	"AR: murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios."+
	"Abdômen: sem achados anormais.", 
			

	
	"Identificação: STQ, 20 anos, F, parda, solteira, estudante, natural e "+
	"procedente de Recife - PE. "+
	"Queixa principal: desconforto suprapúbico há três semanas. "+
	"HDA (histórico da doença atual): "+
	"Paciente refere que há três semanas tem sentido desconforto suprapúbico "+
	"persistente. Associado a isso tem tido disúria e urgência miccional "+
	"frequentemente. Não fez uso de medicações, sendo essa sua primeira "+
	"consulta após início dos sintomas."+

	"IS: Nega perda de peso, astenia e febre."+

	"Antecedentes: paciente não gestante."+

	"Ectoscopia: paciente em bom estado geral, consciente e orientada, "+
	"hidratada. FC = 70bpm. PA = 120x80 mmHg. FR: 19 IRPM. T = 36,5°C."+
	"Pele e mucosas normocoradas e úmidas. Ausência de adenopatias ou edema."+ 
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. "+
	"Ausência de sopros."+
	"AR: murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios."+
	"Abdômen: sem achados anormais.",
	

	
	"Identificação: GSQ, 22 anos, F, caucasiana, solteira, estudante, "+
	"natural e procedente de Caruaru - PE. "+
	"Queixa principal: disúria há um mês. "+
	"HDA (histórico da doença atual):  "+
	"Paciente refere que há um mês tem apresentado disúria e desconforto "+
	"suprapúbico. Refere também astenia e anorexia durante esse período. "+
	"Teve dois episódios de febre. No primeiro, há três semanas, sua febre "+
	"chegou a 39°C e estava associada a sudorese noturna. Para tratá-la "+
	"fez uso de dipirona. O segundo episódio aconteceu há três dias e fez "+
	"uso de paracetamol como tratamento, tendo resolução do sintoma no "+
	"mesmo dia. Não fez uso de outras medicações. "+
	"Relata ainda que durante esse período tem percebido sua urina com "+
	"coloração turva e odor desagradável. "+

	"Antecedentes: paciente não gestante. "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientada, "+
	"hidratada. FC = 70bpm. PA = 120x80 mmHg. FR: 19 IRPM. T = 36,5°C. "+
	"Pele e mucosas normocoradas e úmidas. Ausência de adenopatias ou edema. "+
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. "+
	"Ausência de sopros. "+
	"AR: murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. "+
	"Abdômen: sem achados anormais. ",
	
	"Identificação: ALB, 22 anos, F, caucasiana, solteira, estudante de "+
	"medicina, natural e procedente de Fortaleza - CE. "+
	"Queixa principal: disúria há 10 dias. "+
	"HDA (histórico da doença atual):  "+
	"Paciente refere que há três meses apresentou disúria, desconforto "+
	"suprapúbico e polaciúria. Não teve febre. Suspeitando de cistite, "+
	"se tratou com SMT por três dias tendo resolução do quadro. "+
	"Há 10 dias tem novamente apresentado o quadro clínico de disúria, "+
	"desconforto suprapúbico e polaciúria, porém agora associado à febre "+
	"e astenia. Para a febre fez o tratamento com paracetamol e decidiu "+
	"se consultar para investigação mais detalhada. "+

	"Antecedentes: paciente com vida sexual ativa. Não gestante.  "+

	"Ectoscopia: paciente em bom estado geral, consciente e orientada, "+
	"hidratada. FC = 70bpm. PA = 120x80 mmHg. FR: 19 IRPM. T = 36,5°C. "+
	"Pele e mucosas normocoradas e úmidas. Ausência de adenopatias ou edema.  "+
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. "+
	"Ausência de sopros. "+
	"AR: murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. "+
	"Abdômen: sem achados anormais. "			
	};
	// área 13 = Urologia
	private String [] doencaPorLesaominima = 
	{
	"Identificação:PAM, 9 anos, M, branco, estudante, natural e procedente" +
	" de Sorocaba -SP. " +
	"Queixa principal:edema nos olhos há 4 dias." +
	"HDA (histórico da doença atual):" +
	"Mãe relata que paciente apresentouedema periorbitário pela manhã e de MMII" +
	" há três semanas. Com isso, mãe procurou atendimento no PSF onde o médico" +
	" local suspeitou de reação alérgica e receitou dexclorfeniramina. Apesar" +
	" do tratamento, quadro evoluiu com piora gerando anasarca e dispnéia progressiva." +
	" Foi relatado, ainda, a formação de abundante espuma ao urinar. Associado a isso," +
	" foi descrito náuseas , vômitos e discreta dor abdominal difusa." +

	"IS: paciente nega dor lombar, sintomas miccionais ou outras alterações urinárias." +
	" Nega sintomas fora do TGU." +
	"AP (antecedentes patológicos): paciente asmático." +

	"Ectoscopia: paciente em estado geral regular, consciente e orientado, desidratado." +
	" FC = 76bpm. PA = 120x80mmHg. FR: 23 IRPM. T = 36,5°C. Pele pálida e ressecada,mucosas" +
	" ressecadas. Cabelo quebradiço" +
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. Ausência de sopros." +
	"AR:dispnéico aos médios esforços. Ausculta pulmonar com estertores crepitantes" +
	" nas bases pulmonares.Oximetria em ar ambiente com Sat O2 de 93 %." +
	"Abdômen: sem achados anormais." ,

	"IDENTIFICAÇÃO: DFT, 5 anos, M, negro, pré-escolar, natural e procedente " +
	"de Ribeirão Preto -SP.  " +
	"Queixa principal: edema em todo o corpo há 8 dias. " +
	"HDA: Acompanhante do paciente relata que o mesmo vem na última semana apresentando " +
	"anasarca, que começou com um discreto “inchaço nos olhos”(SIC) depois de um " +
	"episodio gripal  que a partir dai passou para todo o corpo e aumentou. Relata, " +
	"ainda, que a criança já teve edemas, sendo de pequenas proporçõese se resolvia " +
	"com um medicamento (não sabe o nome), que foi receitado em consulta anterior, " +
	"sendo que agora não fez efeito. É relatadouma astenia progressiva e dispneia " +
	"a pequenos esforços.   " +

	"IS: nega outros sintomas " +
	"AP (antecedentes patológicos): paciente com dermatite atópica. " +

	"Ectoscopia: paciente em estado geral regular, consciente e orientado, desidratado. " +
	"FC = 97bpm. PA = 130x75mmHg. FR: 26 IRPM. T = 36,6°C. Pele pálida com turgor e " +
	"elasticidade diminuída e seca, mucosas ressecadas e normocoradas. Unhas " +
	"esbranquiçadas, pouco brilho e quebradiça; pelos esparsos e quebradiços   " +
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. Ausência " +
	"de sopros. " +
	"AR:dispnéico aos pequenos esforços. Ausculta pulmonar com estertores crepitantes " +
	"em ambos hemotórax e presentes de forma difusa " +
	"Abdômen: sem achados anormais. " 		
	};
	
	// área 13 = Urologia
	private String [] GNDA =
	{
	"Identificação:ECB, 13 anos, M, pardo, estudante, natural e procedente de" +
	" Cajazeiras - PB.  " +
	"Queixa principal:paciente relata urina escurecida há três dias. " +
	"HDA: " +
	"Mãe relata que criança háoito dias apresentou faringite com febre," +
	" dificuldade de deglutir alimentos, especialmente os sólidos e astenia." +
	" Não se consultou com o médico e como tratamento, repousou na cama por" +
	" dois dias tomando apenas paracetamol para alívio da febre. Depois de" +
	" dois dias os sintomas tiveram resolução espontânea. " +
	"Há três dias paciente tem notado edema bipalpebral ao acordar, mas que" +
	" vai desaparecendo ao longo do dia. No final do dia geralmente apresenta" +
	" edemas em MMII, mas após acordar o inchaço já desapareceu (SIC). Também" +
	" relatahematúria em que a urina não está avermelhada, mas sim escurecida." +
	" Relata também dispnéia ao subir as escadas do seu prédio, fenômeno que" +
	" não ocorria antes do quadro gripal. Para esses sintomas recentes não se" +
	" consultou com outros médicos nem fez uso de nenhuma medicação. " +
	"IS:nega febre nos últimos três dias, porém apresentou episódios recentes" +
	" de cefaléia. " +

	"Ectoscopia:paciente em bom estado geral, consciente e orientado, hidratado" +
	" e normocorado. FC = 70bpm. PA = 150x100 mmHg. FR: 22 IRPM. T = 36,5°C. Poliadenopatia" +
	" cervical com gânglios de aproximadamente 0,5cm. Faringe hiperemiada +.  . Edema" +
	" periorbitário ++, sem aumento de temperatura ou sensibilidade local.Ausência de" +
	" edema em MMII. " +
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas. Ausência de sopros. " +
	"AR:dispnéico aos médios esforços. Ausculta pulmonar com estertores crepitantes" +
	" nas bases pulmonares.Oximetria em ar ambiente com Sat O2 de 93 %. " +
	"Abdômen: sem achados anormais. " ,

	"Identificação: JVM, 10 anos, M, caucasiano, estudante, natural e procedente" +
	" de Araruna - PB. " +
	"Queixa principal: paciente relata inchaço nos olhos ao acordarhá cinco dias." +
	"HDA (histórico da doença atual):" +
	"Mãe relata que paciente há 10 dias apresentou dor de garganta especialmente" +
	" no período matinal, astenia e febre de 40°C. Não fez uso de medicações e" +
	" houve resolução espontânea dos sintomas em quatro dias." +
	"Há três dias paciente tem notado edema bipalpebral ao acordar que dificulta" +
	" abrir os olhos, mas que desaparece no decorrer do dia. Também relatadispnéia" +
	" a grandes esforços e hematúria em que a urina se apresenta “cor de coca-cola” (SIC)." +
	"IS: paciente relata dor lombar e oligúria.Nega cefaléia." +
	"Antecedentes: paciente fez uso de todas as vacinas (SIC). Paciente asmático." +

	"Ectoscopia: paciente em bom estado geral, consciente e orientado, hidratado" +
	" e normocorado. FC = 75bpm. PA = 160x110 mmHg. FR: 22 IRPM. T = 36,5°C." +
	"  Linfonodos palpáveis em cadeia cervical lateral e posterior. Faringe" +
	" hiperemiada ++.  . Edema periorbitário +++. Ausência de edema em MMII." +
	"AC: ritmo cardíaco regular em 2tempos.hiperfonese de B2 e sopro sistólico " +
	" em foco aórtico." +
	"AR: redução domurmúrio vesicular e presença de estertores crepitantes nas bases."+
	"Abdômen: sem achados anormais." ,

	"Identificação:KPT, 12 anos, F, negra, estudante, natural e procedente" +
	" de Fortaleza-CE.  " +
	"Queixa principal: paciente relata inchaço nos olhos e pernas há três dias. " +
	"HDA (histórico da doença atual): " +
	"Mãe relata que paciente apresentou há um mês lesões de pele na bochecha e não" +
	" diagnosticadas pelo médico como impetigo. Foi tratada com neomicina e lavagem" +
	" das lesões com permanganato de potássio. " +
	"Há quatro dias paciente vem apresentando edema bipalpebral e em membros" +
	" inferiores, sendo esse últimoespecialmente no final do dia. Mãe relata" +
	" ainda que criança tem apresentado hematúria, mal estar e náusea. Não houve" +
	" consulta médica após esses últimos sintomas. " +

	"IS: paciente relata oligúria.Nega dor lombar. " +
	"Antecedentes: pacientenega menarca. Paciente teve quadro de parotidite" +
	" infecciosa ano anterior. " +

	"Ectoscopia: paciente em bom estado geral, consciente e orientado, hidratado" +
	" e normocorado. FC = 75bpm. PA = 150x110 mmHg. FR: 19 IRPM. T = 36,5°C." +
	"  Edema periorbitário +++. Edema em MMII ++. Ausência de adenomegalia. " +
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas." +
	" Ausência de sopros. " +
	"AR: murmúrio vesicular presente em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: sem achados anormais.",

	

	
	"Identificação:ACS, 9 anos, M, pardo, estudante, natural e procedente de" +
	" Tenente Ananias - RN.  " +
	"Queixa principal:paciente letárgico há um dia. " +
	"HDA (histórico da doença atual): " +
	"Mãe relata que paciente apresentou há um mês lesões cutâneas especialmente" +
	" faciais, pouco dolorosas e crostosas. Foi tratada com gentamicina e" +
	" eritromicina com resolutividade completa. " +
	"Há oito dias paciente vem apresentando edema bipalpebrale hematúria freqüente," +
	" mas mãe não procurou médico por conselho de vizinha. Há um dia criança" +
	" evoluiu com cefaléia e estado letárgico observado pela professora quando" +
	" a criança perdeu seu interesse nas atividades escolares e recreação (SIC). " +

	"IS: paciente relata oligúria e dispnéia a médios esforços.Nega dor lombar. " +
	"Antecedentes: paciente com todas as vacinas (SIC). " +

	"Ectoscopia:paciente em estado geral regular, desorientado no tempo e" +
	" espaço, hidratado e normocorado. FC = 75bpm. PA = 200x120 mmHg. FR: 23 IRPM." +
	" T = 36,5°C.  Edema periorbitário +++. Edema em MMII ++. Ausência de" +
	" adenomegalia ou lesões cutâneas. " +
	"AC: ritmo cardíaco regular em 2 tempos. Bulhas normofonéticas." +
	" Ausência de sopros. " +
	"AR: murmúrio vesicular presente em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: sem achados anormais. " +
	"Neurológico:",
	};
	// área 13 = Urologia
	private String [] LitiaseUrinaria =
	{
	"Identificação: JFR, masculino, 50 anos, taxista." +
	"QP: Dor em região lombar esquerda há 2 meses." +
	"HDA: Paciente relata que há dois meses vem sentindo dores," +
	" de moderada intensidade, em região lombar esquerda, que se" +
	" irradia para o flanco, em aperto, de caráter intermitente," +
	" sem náuseas, vômitos ou febre. Relata ter usado paracetamol," +
	" com melhora parcial dos sintomas." +
	"História patológica: portador de HAS e DM. Em uso de captopril" +
	" e metformina. Nega alergias a qualquer tipo de medicamento." +
	"Hábitos e costumes: Consome bastante proteína e sal na comida," +
	" tabagista." +
	"Ectoscopia: PA: 160X 100 mmHg; FR: 25 irpm; FC: 110 bpm; IMC= 22 Kg/m2;" +
	" Afebril; Acianótica; Anictérica; Regular estado geral; consciente e" +
	" orientada; fáscies de sofrimento; postura antálgica; pele de  turgor e" +
	" elasticidade diminuídos, ausência de lesões primárias e secundárias de pele. " +
	"AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros." +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios." +
	"Abdômen: Abdomen em plano, simétrico, ruídos hidroaéreos normais, dor" +
	" à palpação superficial e profunda em quadrande superior esquerdo, rins" +
	" não palpáveis, Giordano positivo. " ,
	
	
	"ID: RNM, feminino, 34 anos, professora universitária." +
	"QP: Dor lombar há 12 horas." +
	"HDA: Paciente relata que há 12 horas vem sentindo dores de forte intensidade," +
	" de início súbito, contínua, em aperto, em região lombar que se irradia para" +
	" os flancos e fossa ilíaca esquerda, sem fatores de melhora ou piora. Relata" +
	" vômitos, náusea e febre. Nega uso de medicamentos." +
	"História patológica: NDA." +
	"Hábitos e costumes: NDA." +
	"Ectoscopia: PA: 130x85 mmHg; FR: 27 irpm; FC: 120bpm; IMC: 30 kg/m2. Regular" +
	" estado geral, acianótica, anictérica, febril, consciente, orientada, posição" +
	" antálgica, fáscies de sofrimento, pele de elasticidade e turgor conservados." +
	"AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros." +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios." +
	"Abdômen: Abdomen em avental, simétrico, ruídos hidroaéreos normais, dor à" +
	" palpação superficial e profunda em quadrande superior direito, rins não" +
	" palpáveis, Giordano positivo.",

	"ID: FKL, feminina, 62 anos, dona de casa. " +
	"QP: Dor em flanco esquerdo há 1 mês. " +
	"HDA: Paciente relata que há 1 mês vem sentindo dores, , de caráter intermitente," +
	" em flanco esquerdo, de leve intensidade, em aperto, que se irradia para fossa" +
	" ilíaca esquerda e grandes lábios. Relata hematúria macroscópica. Nega náusea," +
	" vômito e febre. Fez uso de Dipirona Sódica 500mg de 6/6 horas, com melhora dos" +
	" sintomas. Encontra-se nervosa e apreensiva. " +
	"História patológica: HAS. História materna de cólon esquerdo (mãe aos 69 anos " +
	"foi diagnosticada com adenocarcinoma de cólon esquerdo). " + 
	"Hábitos e costumes: NDA. " +
	"Ectoscopia: PA: 140x90 mmHg; FR: 17 irpm; FC: 63 bpm; IMC: 18,9 kg/m2. Bom estado" +
	" geral, acianótica, anictérica, afebril, consciente, orientada, fáscies" +
	" incaracterística, pele de elasticidade e turgor conservados. " +
	"AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros. " +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: Abdomen em plano, simétrico, ruídos hidroaéreos normais, ausência de" +
	" dor à palpação superficial e profunda, rins não palpáveis," +
	" Giordano negativo.",

	
	"ID: JLS, masculino, 43 anos, pedreiro."+
	"QP: Dor em dorso há 1 semana."+
	"HDA: Paciente relata que há 1 semana vem sentindo dor bilateral, de curso" +
	" contínuo, intensidade moderada, em pontada, em dorso que não se irradia." +
	" Nega náusea, vômito, febre. Fez uso de dipirona sódica 500 mg, com melhora" +
	" parcial dos sintomas. " +
	"História patológica: NDA. " +
	"Hábitos e costumes: NDA. " +
	"Ectoscopia: PA: 120x80 mmHg; FR: 15 irpm; FC: 72 bpm; IMC: 23,9 kg/m2. Bom" +
	" estado geral, acianótico, anictérico, afebril, consciente, orientado, fáscies" +
	" incaracterística, pele de elasticidade e turgor conservados. " +
	"AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros. " +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: Abdomen em plano, simétrico, ruídos hidroaéreos normais, ausência de" +
	" dor à palpação superficial e profunda, rins não palpáveis," +
	" Giordano negativo.",

	
	"ID: PSM, 52 anos, masculino, advogado. " +
	"QP: Dor nas costas há 10 horas. " +
	"HDA: Paciente relata que há 10 horas apareceram de forma súbita dores no dorso" +
	" de forte intensidade, em cólica, que se irradiam para flancos, sem fatores de" +
	" piora ou melhora, com náusea e vômito, sem febre. Nega uso de medicamentos. " +
	"História patológica: Paciente com cirurgia para osteofitose programada. HAS," +
	" DM. Apresenta alergia ao iodo. " +
	"Hábitos e costumes: NDA. " +
	"Ectoscopia: PA: 130X80 mmHg; FR: 26 irpm FC: 108 bpm; IMC: 20 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anictérico, afebril, acianótico, turgor" +
	" e elasticidade da pele conservados, fáscies de sofrimento, posição antálgica. " +
	 "AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros. " +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: Abdomen em plano, simétrico, ruídos hidroaéreos normais, dor à" +
	" palpação superficial e profunda, rins não palpáveis," +
	" Giordano positivo. " ,

	
	"ID: FLV, feminino, 52 anos, engenheira. " +
	"QP: Dor em hipogástrio esquerdo há 5 dias. " +
	"HDA: Paciente relata que há 5 dias vem sentindo dores, de modera intensidade," +
	" em hipogástrio, acompanhada de hematúria. Sem fatores de melhora ou piora." +
	" Nega ter usado medicamentos para controle da dor. " +
	"IS: Nega perda de peso, astenia, anorexia. " +
	"História patológica: DM. " +
	"Hábitos e costumes: Tabagista há 35 anos, 2 maços/dia. " +
	"Antecedentes familiares: Mãe possuiu câncer de rim. " +
	"Ectoscopia: PA: 120X80 mmHg; FR: 16 irpm FC: 62 bpm; IMC: 28 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anictérico, afebril, acianótico, turgor" +
	" e elasticidade da pele conservados, fáscies incaracterística.  " +
	"AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros. " +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: Abdomen em plano, simétrico, ruídos hidroaéreos normais, ausência" +
	" de dor à palpação superficial e profunda, rins não palpáveis, Giordano negativo. " ,

	
	
	"ID: MFG, masculino, 34 anos, agente comunitário de saúde. " +
	"QP: Dor em dorso há 10 dias. " +
	"HDA: Paciente relata que há 4 anos realizou nefrectomia total de rim direito" +
	" e há 2 meses realizou cirurgia para correção de estenose de JUP secundária " +
	"a ITU de repetição. Atualmente, encontra-se com dor em região costovertebral" +
	" esquerda há 10 dias, de forte intensidade, sem irradiação. Refere náusea, " +
	"nega vômitos e febre. Traz laudo de TC de 2 meses atrás que relata pelve " +
	"intra-renal, estenose de JUP, ausência de cálculos, hidronefrose grau IV." +
	" Relata ter usado paracetamol, ibuprofeno, sem melhora dos sintomas. " +
	"IS: Nda. " +
	"História patológica: HAS, DM. " +
	"Hábitos e costumes: NDA. " +
	"História familiar: Rins policísticos. " +
	"Ectoscopia: PA: 140X90 mmHg; FR: 17 irpm FC: 72 bpm; IMC: 32 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anictérico, afebril, acianótico, turgor" +
	" e elasticidade da pele conservados, fáscies incaracterística.  " +
	" AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros. " +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: Abdomen em plano, simétrico, ruídos hidroaéreos normais, ausência" +
	" de dor à palpação superficial e profunda, rins não palpáveis, Giordano" +
	" positivo à esquerda. " ,

	
	
	
	"ID: LEG, masculino, 35 anos, técnico de enfermagem. " +
	"QP: Dor em flanco direito há 4 dias. " +
	"HDA: Paciente relata dor em flanco direito há 4 dias, sem irradiação. Nega" +
	" perda de peso, náusea, vômito, febre. Nega fatores de melhora e piora. Não" +
	" utilizou medicamentos para controle da dor. " +
	"História patológica: Realizou há 10 anos colecistectomia. Portador de HIV" +
	" há 15 anos. Há 1 ano foi internado por pneumonia, onde ficou 1 semana em" +
	" UTI. Alérgico à iodo. " +
	"Hábitos e costumes: Nega tabagismo, alcoolismo.  " +
	"IS: Nega lesões de pele e de cavidade oral. Nega alteração do hábito" +
	" intestinal e nega volume e aspecto das fezes anormais. " +
	"Ectoscopia: PA: 110X70 mmHg; FR: 15 irpm FC: 64 bpm; IMC: 19 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anictérico, afebril, acianótico," +
	" turgor e elasticidade da pele conservados, ausência de lesões elementares" +
	" de pele, fáscies incaracterísticas.  " +
	" AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros. " +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: Abdomen escavado, simétrico, ruídos hidroaéreos normais, ausência" +
	" de dor à palpação superficial e profunda, Blumberg negativo, Giordano negativo " ,

	
	"ID: KLM, feminino, 23 anos, estudante. " +
	"QP: Dor em epigástrio há 1 ano. " +
	"HDA: Paciente relata que há 1 ano apresenta dores em epigástrio, em aperto," +
	" de forte intensidade, com irradiação lombar inferior. Procurou médico que " +
	"receitou Pantoprazol e Ranitidina, sem melhora dos sintomas. Refere 3 episódios" +
	" de ITU nos últimos 6 meses, em que fez tratamento com antibióticos, com melhora.  " +
	"Antecedentes patológicos: Nda. " +
	"Hábitos e costumes: Nda. " +
	"IS: Nda. " +
	"Ectoscopia: PA: 110X70 mmHg; FR: 16 irpm FC: 70 bpm; IMC: 30 Kg/m2. Regular" +
	" estado feral, consciente e orientado, anictérico, afebril, acianótico, turgor" +
	" e elasticidade da pele conservados, fáscies de dor.  " +
	" AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros. " +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: Abdomen plano, simétrico, ruídos hidroaéreos normais, ausência de" +
	" dor à palpação superficial e profunda, ausência visceromegalias, Blumberg" +
	" negativo, Giordano negativo.  " ,

	
	
	"ID: LEL, feminino, 68 anos, aposentada. " +
	"QP: Dor em flaco esquerdo há 1 mês. " +
	"HDA: Paciente relata dor em flanco esquerdo há 1 mês, em aperto, de forte" +
	" intensidade, que se irradia para grandes lábios. Relata hematúria e náuseas." +
	" Nega vômitos e febre. Não utilizou medicamentos. Refere que já sentiu dores" +
	" com mesmas características durante 8 anos, de caráter intermitente.  " +
	"Antecedentes patológicos: Realizou cirurgia para feocromacitoma há 15 anos, " +
	"e para exclusão renal direita há 5 anos. HAS, DM. " +
	"Hábitos e costumes: Tabagista durente 50 anos, com 3 maços/dia. " +
	"IS: Nega perda de peso, astenia, anorexia. " +
	"Ectoscopia: PA: 150X90 mmHg; FR: 19 irpm FC: 75 bpm; IMC: 35 Kg/m2. Regular " +
	"estado feral, consciente e orientado, anictérico, afebril, acianótico, turgor " +
	"e elasticidade da pele conservados, fáscies de dor.  " +
	" AC: Ritmo cardíaco em dois tempos, bulhas normofonéticas. Ausência de sopros. " +
	"AR: Murmúrio vesicular em ambos os hemitórax, sem ruídos adventícios. " +
	"Abdômen: Abdomen em avental, simétrico, ruídos hidroaéreos normais, ausência " +
	"de dor à palpação superficial e profunda, ausência visceromegalias, Giordano negativo." 		
	};
	
	
	public Anamnese() {
		this.anamneseHash = 
				new Hashtable<Integer,String>();
		for(int i = 0; i < this.Glomerulonefrite.length; i++){
			this.anamneseHash.put(i,(this.Glomerulonefrite[i]));
		}
		this.mapAnamnese.put("Glomerulonefrite por IgA (Doença de Berger)",this.anamneseHash);
		
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
		this.mapAnamnese.put("Doenca por lesao mínima",this.anamneseHash);
		
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
