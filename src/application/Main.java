package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) throws ParseException {

		// String teste = "asd;123";
		// System.out.println("primeira posicao: " + teste.split(";")[0]);
		// String javaVersion = System.getProperty("java.version");
		// String javaHome = System.getProperty("java.home");
		// String java_home = System.getenv("JAVA_HOME");
		// String path = System.getenv("PATH");

		testeSplit2();
		//testeArrayList();
		// testeMap();
		// testeSplit();
		// testeJavaLinkedIn();
		// testeDesconto();
		// testeList();
		// testeStringToLong();
		// testeData();
		// testeTimestamp();
		// testeItensVtex();
		// removeEspecCaract("00-000-00_0/0");
		// testeInstant();
		// testeDataLocal();
		// formataDataOracle("2021-07-27T23:59:59.000-03:00");
		// testeSubstring();
		// testeJSON();
		// comparaJSON();
		// localeDatas();
		// conversaoDatas();
		// testeCalendar();
		// formatandoDatas();
		// formatandoSaidaDatas();

		// exemploArray();
		// String teste = String.format("teste %s", "ok");
		// trataRetorno();
		// String preco = formatDoubleFedex("5.568");
		// formataDataFedex("2021-06-25 14:34:51.000");
		// formataDataIntelipost("2021-06-25 14:34:51.000");
		// formataStringToDecimal("4622408");
		// formataStringToDecimal("879");
		// geraArrayAPartirCSV();
		// tabelasArray();
		// respostaPutPedidoVenda();
		// retornoDivisao();
		// formatTelefone();
		// dividirString();
	}
	
	public static void testeSplit2() {
		System.out.println(splitString("1010-5645464"));		
		
	}
	
	public static String splitString(String str) {
		return str.split("-")[0];		
	}
	
	public static void testeArrayList() {
        List<JSONObject> listOrcamento = new ArrayList<JSONObject>();
        JSONObject orcamento = new JSONObject();
        orcamento.put("transacao", "transacao");
        orcamento.put("cnpj_empresa", "cnpj_empresa");
        orcamento.put("doc_cliente", "doc_cliente");
        orcamento.put("data_documento", "data_documento");
        orcamento.put("documento", "documento");
        orcamento.put("codigo_produto", "codigo_produto");
        orcamento.put("qtdeproduto", "qtdeproduto");
        orcamento.put("preco_unitario", "preco_unitario");
        orcamento.put("posicao_item", "posicao_item");
        
        orcamento.put("obs", "obs");
        orcamento.put("plano", "plano");
        orcamento.put("valor_frete", "valor_frete");
        orcamento.put("origem_codigo_produto", "origem_codigo_produto");
        orcamento.put("codigo_vendedor", "codigo_vendedor");
        orcamento.put("pedido", "pedido");
        orcamento.put("reserva_estoque", "reserva_estoque");
        
        listOrcamento.add(orcamento);
        
        for (JSONObject objOrc : listOrcamento) {
        	System.out.println(objOrc.toString(2));
        }
        
	}

	public static void testeDesconto() {

		JSONObject objProduto = new JSONObject();

		objProduto.put("value", 62.94);
		objProduto.put("discount", 6.71);

		Double value = objProduto.optDouble("value");
		Double discount = objProduto.optDouble("discount");

		Double discountPercent = (discount * 100) / value;

		Double discntPrc = (objProduto.optDouble("discount") * 100) / objProduto.optDouble("value");

		System.out.println("percentual de desconto: " + discountPercent);
		System.out.println("percentual de desconto: " + String.format("%.2f", discntPrc));
	}

	public static void testeToLowerCase() {
		String result = "\"msgRet\":\"Ok";

		if (result.toLowerCase().toString().contains(String.format("\"msgret\":\"ok").toLowerCase())) {
			System.out.println("Retorno com sucesso");
		} else {
			System.out.println("Erro");
		}
	}

	public static void testeMap() {
		Map<String, String> bodyAuth = new HashMap<String, String>();
		bodyAuth.put("grant_type", "password");
		bodyAuth.put("username", "AAQJ");
		bodyAuth.put("password", "AAQJAAUAAAUFAAUAAAUCAAUGAAUFAAUHAAQIAAQIAAQIAAQJAAQIAAQJ");
		bodyAuth.put("client_id", "userIntegration");

		/*
		 * JSONObject bodyAuth = new HashMap<>(); bodyAuth.put("grant_type",
		 * "password"); bodyAuth.put("username", "AAQJ"); bodyAuth.put("password",
		 * "AAQJAAUAAAUFAAUAAAUCAAUGAAUFAAUHAAQIAAQIAAQIAAQJAAQIAAQJ");
		 * bodyAuth.put("client_id", "userIntegration");
		 */

		System.out.println(bodyAuth.toString());

	}

	public static void testeSplit() {
		String skuCode = "04.200.00003--001";
		String[] prodDer = null;
		String codProd = "";
		String codDer = "";

		prodDer = skuCode.split("--");
		if (prodDer.length > 1) {
			codProd = prodDer[0];
			codDer = prodDer[1];
		} else {
			codProd = prodDer[0];
		}

		System.out.println("codProd: " + codProd);
		System.out.println("codDer: " + codDer);

	}

	public static void testeJavaLinkedIn() {
		String[] array = new String[] { "A", "B", "C" };
		List<String> list1 = Arrays.asList(array);
		List<String> list2 = new ArrayList<>(Arrays.asList(array));
		List<String> list3 = new ArrayList<>(Arrays.asList("A", new String("B"), "C"));
		System.out.print(list1.equals(list2));
		System.out.print(list1.equals(list3));
	}

	public static void testeStringToLong() {
		String str = "45";

		Date dt = new Date();

		System.out.println(dt);
		System.out.println(dt.getTime());

		System.out.println(Long.valueOf(str));
	}

	public static void testeList() {
		JSONArray listaArray = new JSONArray();
		List<JSONObject> list = new ArrayList<JSONObject>();

		JSONObject obj1 = new JSONObject();
		obj1.put("id", 1);
		obj1.put("name", "objeto 1");
		list.add(obj1);

		JSONObject obj2 = new JSONObject();
		obj2.put("id", 1);
		obj2.put("name", "objeto 2");
		list.add(obj2);

		JSONObject obj3 = new JSONObject();
		obj3.put("id", 1);
		obj3.put("name", "objeto 3");
		list.add(obj3);

		JSONObject especObj = new JSONObject();

		list.addAll(Arrays.asList(obj1, obj2, obj3));

		System.out.println(list.toString());

		especObj = (JSONObject) list.get(0);

		System.out.println(especObj);

	}

	public static void testeData() {
		Locale.setDefault(Locale.US);

		Date novaData = new Date();

		System.out.println(novaData.toInstant());
	}

	public static void testeTimestamp() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Date dt = new Date();
		long lg = dt.getTime();

		System.out.println("lg: " + lg);

		try {
			dt = sdf.parse("10/11/2021");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Long milliSeconds = 9999999998L;

		Timestamp ts = new Timestamp(milliSeconds);

		// Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		// String date = new SimpleDateFormat("dd/MM/yyyy").format(timestamp.getTime());
		String date = new SimpleDateFormat("dd/MM/yyyy").format(ts.getTime());
		System.out.println(date + ", " + String.valueOf(ts));
	}

	public static void testeItensVtex() {
		JSONArray planilha = new JSONArray();
		JSONObject linha = new JSONObject();

		linha.put("id", "1");
		linha.put("ean", "7899990393734");
		linha.put("ref", "70031-Cinza Mescla Escuro-P");
		planilha.put(linha);

		linha.put("id", "2");
		linha.put("ean", "7899990393741");
		linha.put("ref", "70031-Cinza Mescla Escuro-M");
		planilha.put(linha);
	}

	public static void removeEspecCaract(String arg) {
		arg = arg.replace("-", "");
		arg = arg.replace("_", "");
		arg = arg.replace("/", "");

		System.out.println(arg);
	}

	private static void testeInstant() {

		Date d = Date.from(Instant.parse("2021-07-19T14:56:37.227Z"));

		// Date orderDateAux = Date.from(Instant.parse("2021-07-19T14:56:37.227"));
		// Date orderDateAux = Date.from(Instant.parse("2021-07-19T14:56:37Z"));

		System.out.println("d: " + d);

		// Date orderDateAux = Date.from(Instant.parse("2021-07-19T14:56:37.227"));

		// System.out.println("orderFateAux: " + orderDateAux);

		Date data = new Date();
		String strData = "";
		strData = String.valueOf(data.toInstant());

		System.out.println(data.toInstant());
		System.out.println(strData);
	}

	private static void testeDataLocal() {
		LocalDate dt = LocalDate.now();

		System.out.println(dt);
	}

	private static void testeSubstring() {
		String retornoApi = "Objeto entregue ao destinatário";
		String situacao = retornoApi.substring(0, 15);

		if (situacao.equals("Objeto entregue")) {
			System.out.println("Entrega finalizada");
		}

		System.out.println(situacao);
	}

	public static void comparaJSON() {

		JSONArray retornoListaCorreio = retornaJSONCorreio();
		JSONArray retornoListaPedido = retornaJSONPedido();

		for (Object retornoPedido : retornoListaPedido) {
			JSONObject pedido = (JSONObject) retornoPedido;

			for (int i = 0; i < retornoListaCorreio.length(); i++) {
				JSONObject correio = (JSONObject) retornoListaCorreio.get(i);

				if (pedido.optString("numero").equals(correio.optString("numero"))) {
					System.out.println(correio.optString("numero"));
					// retornoListaCorreio.remove(i);
				}

			}
		}
	}

	public static JSONArray retornaJSONCorreio() {
		JSONArray listaCorreio = new JSONArray();
		for (int i = 1; i <= 9; i++) {
			listaCorreio.put(criaObjeto("entrega" + i, "220" + i, "c"));
		}
		return listaCorreio;
	}

	public static JSONArray retornaJSONPedido() {
		JSONArray listaPedido = new JSONArray();
		for (int i = 1; i <= 5; i++) {
			listaPedido.put(criaObjeto("entrega" + i, "220" + i, "p"));
		}
		return listaPedido;
	}

	public static JSONObject criaObjeto(String nome, String numero, String identificador) {
		JSONObject obj = new JSONObject();

		obj.put("nome", nome);
		obj.put("numero", numero);
		obj.put("identificador", identificador);

		if (identificador == "c") {
			obj.put("outros", "valor aleatório");
		}

		return obj;
	}

	public static void localeDatas() throws ParseException {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();

		// System.out.println(data.);

		Locale brasil = new Locale("pt", "BR"); // Retorna do país e a língua
		Locale eua = Locale.US;
		Locale italia = Locale.ITALIAN;

		DateFormat f2 = DateFormat.getDateInstance(DateFormat.FULL, brasil);
		System.out.println("Data e hora brasileira: " + f2.format(data));

		DateFormat f3 = DateFormat.getDateInstance(DateFormat.FULL, eua);
		System.out.println("Data e hora americana: " + f3.format(data));

		DateFormat f4 = DateFormat.getDateInstance(DateFormat.FULL, italia);
		System.out.println("Data e hora italiana: " + f4.format(data));
	}

	public static void conversaoDatas() throws ParseException {
		Calendar c = Calendar.getInstance();
		Date data = c.getTime();
		DateFormat f = DateFormat.getDateInstance();

		Date data2 = f.parse("12/01/1995");
		System.out.println(data2);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Data formatada: " + sdf.format(data));

		// Converte Objetos
		System.out.println("Data convertida:" + sdf.parse("02/08/1970"));
	}

	public static void formatandoSaidaDatas() {
		// https://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401

		Calendar c = Calendar.getInstance();
		Date data = c.getTime();

		DateFormat f = DateFormat.getDateInstance(DateFormat.FULL); // Data COmpleta
		System.out.println("Data brasileira: " + f.format(data));

		f = DateFormat.getDateInstance(DateFormat.LONG);
		System.out.println("Data sem o dia descrito: " + f.format(data));

		f = DateFormat.getDateInstance(DateFormat.MEDIUM);
		System.out.println("Data resumida 1: " + f.format(data));

		DateFormat fs = DateFormat.getDateInstance(DateFormat.SHORT);
		System.out.println("Data resumida 2: " + fs.format(data));
	}

	public static void formatandoDatas() {
		// https://www.devmedia.com.br/trabalhando-com-as-classes-date-calendar-e-simpledateformat-em-java/27401

		Calendar c = Calendar.getInstance();
		c.set(2013, Calendar.FEBRUARY, 28);
		Date data = c.getTime();
		System.out.println("Data atual sem formatação: " + data);

		// Formata a data
		DateFormat formataData = DateFormat.getDateInstance();
		System.out.println("Data atual com formatação: " + formataData.format(data));

		// Formata Hora
		DateFormat hora = DateFormat.getTimeInstance();
		System.out.println("Hora formatada: " + hora.format(data));

		// Formata Data e Hora
		DateFormat dtHora = DateFormat.getDateTimeInstance();
		System.out.println(dtHora.format(data));
	}

	public static void testeCalendar() {
		Calendar c = Calendar.getInstance();

		System.out.println("Data e Hora atual: " + c.getTime());
	}

	public static void exemploArray() {
		String stringwebsites = "1, 2, 3, 4";
		String[] website_ids = stringwebsites.split(",");

		System.out.println(website_ids.toString());

	}

	private StringBuilder geraSbProdutos(JSONArray produtos) {

		String delimiterProd = ";";
		String rnProd = "\r\n";
		StringBuilder sb = new StringBuilder();
		for (Object produtoObj : produtos) {
			JSONObject produto = (JSONObject) produtoObj;

			sb.append(produto.optString("JDATRNT").trim()).append(delimiterProd);
			sb.append(produto.optString("JDACUST").trim()).append(delimiterProd);
			sb.append(produto.optString("JDACUSD").trim()).append(delimiterProd);
			sb.append(produto.optString("JDADOCN").trim()).append(delimiterProd);
			sb.append(produto.optString("JDADATD").trim()).append(delimiterProd);
			sb.append(produto.optString("JDALOCT").trim()).append(delimiterProd);
			sb.append(produto.optString("JDASTRF").trim()).append(delimiterProd);
			sb.append(produto.optString("JDAUPCN").trim()).append(delimiterProd);
			sb.append(produto.optString("JDASKUN").trim()).append(delimiterProd);
			sb.append(produto.optString("JDAUNTM").trim()).append(delimiterProd);
			sb.append(produto.optString("JDADESC").trim()).append(delimiterProd);
			sb.append(produto.optString("JDAQNTY").trim()).append(delimiterProd);
			sb.append(produto.optString("JDARETP").trim()).append(delimiterProd);
			sb.append(produto.optString("JDASTRT").trim());
			sb.append(rnProd);
		}
		return sb;
	}

	public static Date formataDataOracle(String stData) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date data = null;

		stData = stData.replace("T", " ");
		stData = stData.split("-", 4)[0] + "-" + stData.split("-", 4)[1] + "-" + stData.split("-", 4)[2];

		try {
			data = sdf.parse(stData);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		JSONObject cliente = new JSONObject();
		cliente.put("original_iso", data);
		// cliente.get

		return (data);
	}

	public static void trataRetorno() {
		JSONObject origem = new JSONObject();
		// Montando o JSON de origem
		origem.put("code", 400);
		origem.put("sucsses", false);
		origem.put("resposta",
				"[{\"message\":\"Foreign key external ID: 1580 not found for field Codigo_representante_ERP__c in entity User\",\"errorCode\":\"INVALID_FIELD\",\"fields\":[]}]");

		String resposta = origem.optString("resposta");
		resposta = resposta.replace("\"", "");
		resposta = resposta.replace("{", "");
		resposta = resposta.replace("}", "");
		resposta = resposta.replace("[", "");
		resposta = resposta.replace("]", "");

		String message = resposta.split(",")[0];
		String errorCode = resposta.split(",")[1];

		System.out.println("Resultado Esperado: " + errorCode.split(":")[1] + " - " + message.split(":", 2)[1]);
	}

	public static String formatDoubleFedex(String valor) {
		if (!valor.equals(null) && !valor.equals("")) {
			String valorStr = String.format("%.2f", Double.parseDouble(valor));
			return valorStr;
		} else
			return "0,00";
	}

	public static void formataDataFedex(String data) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("ddMMyyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		String dt2 = null;
		try {
			dt2 = sdf1.format(sdf2.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(dt2);
	}

	public static void formataDataIntelipost(String data) {
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		String dt2 = null;
		try {
			dt2 = sdf1.format(sdf2.parse(data));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		System.out.println(dt2);
	}

	public static void formataStringToDecimal(String preco) {
		String precoFormatado = "";

		Integer precoInt = Integer.parseInt(preco);
		Double precoF = (double) precoInt / 10000;
		precoFormatado = String.valueOf(precoF);

		System.out.println(precoFormatado);

		/*
		 * if
		 * 
		 * if (preco.length() < 5) { preco = "0." + preco; }
		 * 
		 * precoFormatado = preco.substring(0, preco.length() - 4) + "." +
		 * preco.substring(preco.length() - 4, preco.length());
		 */

		// System.out.println(precoFormatado);
	}

	public static void geraArrayAPartirCSV() {
		// D:\Dev\arquivos_importar\tabelaPrecoTotal.csv
		String arquivoCSV = "D:\\Dev\\arquivos_importar\\tabelaPrecoTotal.csv";
		BufferedReader br = null;
		String linha = "";
		String csvDivisor = ",";
		try {

			br = new BufferedReader(new FileReader(arquivoCSV));
			while ((linha = br.readLine()) != null) {

				String[] campo = linha.split(csvDivisor);

				System.out.println(
						"Tabela [code= " + campo[campo.length - 2] + " , name=" + campo[campo.length - 1] + "]");

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void tabelasArray() {
		String[] tabelas = { "1", "4", "5", "6", "7", "10", "11", "12", "14", "15", "16", "17", "18", "19", "20", "21",
				"23", "24", "25", "26", "28", "29", "30", "33", "37", "38", "40", "41", "42", "44", "45", "46", "48",
				"49", "50", "51", "52", "54", "56", "60", "62", "64", "65", "70", "72", "73", "74", "76", "78", "80",
				"85", "90", "91", "92", "94", "95", "96", "97", "98", "99", "100", "103", "104", "105", "106", "107",
				"108", "109", "110", "113", "114", "115", "117", "118", "119", "123", "127", "131", "132", "133", "134",
				"138", "139", "145", "147", "150", "166", "169", "171", "173", "174", "176", "177", "178", "182", "183",
				"184", "185", "186", "189", "190", "191", "193", "199", "200", "207", "210", "212", "225", "234", "235",
				"236", "301", "304", "307", "312", "317", "318", "330", "507", "512", "518", "519", "522", "800", "810",
				"830", "850", "999", "5071", "5072", "5121", "5122", "5181", "5182", "5188", "5192", "5221", "5222" };
		for (int i = 0; i < tabelas.length; i++) {
			System.out.println(tabelas[i]);
		}
	}

	public static void testeJSON() {
		JSONArray carros = new JSONArray();
		JSONArray carrosImportados = new JSONArray();

		JSONObject monza = new JSONObject();
		monza.put("modelo", "monza");
		monza.put("codigo", 74);
		monza.put("tipo", "popular");

		JSONObject celta = new JSONObject();
		celta.put("modelo", "celta");
		celta.put("codigo", 15);
		celta.put("tipo", "popular");

		JSONObject viper = new JSONObject();
		viper.put("modelo", "viper");
		viper.put("codigo", 123);
		viper.put("tipo", "importado");

		JSONObject bmw = new JSONObject();
		bmw.put("modelo", "bmw");
		bmw.put("codigo", 62);
		bmw.put("tipo", "importado");

		carros.put(monza);
		carros.put(celta);
		carrosImportados.put(viper);
		carrosImportados.put(bmw);

		JSONArray todosCarros = new JSONArray();
		todosCarros = concatArray(carros, carrosImportados);

		carros = concatArray(carros, carrosImportados);

		// System.out.println(todosCarros.toString());
		// System.out.println(carros.toString());
		// JSONObject grupoCarro = new JSONObject();
		// grupoCarro.put("modelo", carros.optJSONObject(0).optString("modelo"));
		// System.out.println(carros.get(1).toString());
		// System.out.println(grupoCarro.toString());
	}

	// Concatena arrays lists
	private static JSONArray concatArray(JSONArray jsArr1, JSONArray jsArr2) {
		List<Object> list = jsArr1.toList();
		list.addAll(jsArr2.toList());
		return new JSONArray(list);
	}

	public static void respostaPutPedidoVenda() {
		String respostaString = new String("{\r\n" + "    \"itensPedido\": [\r\n" + "        {\r\n"
				+ "            \"precoUnit\": \"3141002\",\r\n" + "            \"qtdPedida\": \"20\",\r\n"
				+ "            \"itemPedido\": \"D10000CR001122244020\",\r\n"
				+ "            \"codProduto\": \"D10000CR001122244020\"\r\n" + "        }\r\n" + "    ],\r\n"
				+ "    \"codPedidoCliente\": \"\",\r\n" + "    \"pedidoAutomacao\": \"\",\r\n"
				+ "    \"codTabelaPreco\": \"5182\",\r\n" + "    \"consumidorFinal\": false,\r\n"
				+ "    \"codTipoCobranca\": \"0\",\r\n" + "    \"empresa\": \"1\",\r\n"
				+ "    \"codCliente\": \"15123\",\r\n" + "    \"codTipoNF\": \"1001\"\r\n" + "}");

		JSONObject resposta = new JSONObject(respostaString);

		System.out.println(resposta.toString());

	}

	public static void retornoDivisao() {
		// Scanner sc = new Scanner();

		double a;

		a = 13.0;

		if (a % 2 == 0) {
			System.out.println("Numero par");
		} else
			System.out.println("Número impar");
	}

	public static void dividirString() {
		String codigo = "1001-Pedido Venda";
		String[] codigoSplit = codigo.split("-");

		int a = codigo.length();

		System.out.println(codigoSplit[0]);
	}

	public static void formatTelefone() {
		String telefone = "(047) 3222-4959";

		System.out.println(telefone);

		telefone = telefone.replace("(", "");
		telefone = telefone.replace(")", "");
		telefone = telefone.replace(" ", "");
		telefone = telefone.replace("-", "");

		if (telefone.length() > 10) {
			telefone = telefone.substring(1, 11);
		}

		System.out.println(telefone);
	}

	private static String concatenaCampos() {
		String camposConcatenados = "";
		String[] campos = { "TIPO_REG", "TIPO_OPER", "TIPO_PROC_SO", "FISCAL", "WHSEID", "STORERKEY", "ORDERKEY",
				"EXTERNORDERKEY", "ORDERDATE", "DELIVERYDATE", "PRIORITY", "CONSIGNEEKEY", "C_CONTACT1", "C_CONTACT2",
				"C_COMPANY", "C_ADDRESS1", "C_ADDRESS2", "C_ADDRESS3", "C_ADDRESS4", "C_CITY", "C_STATE", "C_ZIP",
				"C_COUNTRY", "C_ISOCNTRYCODE", "C_PHONE1", "C_PHONE2", "C_FAX1", "C_FAX2", "C_VAT", "BILLTOKEY",
				"B_CONTACT1", "B_CONTACT2", "B_COMPANY", "B_ADDRESS1", "B_ADDRESS2", "B_ADDRESS3", "B_ADDRESS4",
				"B_CITY", "B_STATE", "B_ZIP", "B_COUNTRY", "B_ISOCNTRYCODE", "B_PHONE1", "B_PHONE2", "B_FAX1", "B_FAX2",
				"B_VAT", "BATCHFLAG", "DISCHARGEPLACE", "DELIVERYPLACE", "INTERMODALVEHICLE", "COUNTRYOFORIGIN",
				"COUNTRYDESTINATION", "TYPE", "ORDERGROUP", "TRANSPORTATIONMODE", "EXTERNALORDERKEY2", "C_EMAIL1",
				"C_EMAIL2", "SUSR1", "SUSR2", "SUSR3", "SUSR4", "SUSR5", "NOTES1", "SHIPTOGETHER", "DELIVERYDATE2",
				"REQUESTEDSHIPDATE", "ACTUALSHIPDATE", "DELIVER_DATE", "OHTYPE", "CARRIERCODE", "CARRIERNAME",
				"CARRIERADDRESS1", "CARRIERADDRESS2", "CARRIERCITY", "CARRIERSTATE", "CARRIERZIP", "CARRIERCOUNTRY",
				"CARRIERPHONE", "DRIVERNAME", "TRAILERNUMBER", "TRAILEROWNER", "DEPDATETIME", "NOTES2",
				"NVI_NUM_NOTA_FISCAL", "NVI_SERIE", "NVI_CFOP", "NVI_CNPJ_TRANPORTADORA", "NVI_BASE_ICMS",
				"NVI_VALOR_ICMS", "NVI_VALOR_IPI", "NVI_VALOR_PRODUTOS", "NVI_VALOR_TOTAL_NF", "NVI_CNPJ_DESTINATARIO",
				"NVI_TIPO_NOTA_FISCAL", "TIPO_REG_DET", "TIPO_OPER_DET", "TIPO_PROC_SO_DET", "FISCAL_DET_DET",
				"WHSEID_DET", "STORERKEY_DET", "ORDERKEY_DET", "EXTERNORDERKEY_DET", "EXTERNLINENO", "SKU",
				"ORIGINALQTY", "UOM", "PACKKEY", "PICKCODE", "CARTONGROUP", "UNITPRICE", "LOTTABLE1", "LOTTABLE2",
				"LOTTABLE3", "LOTTABLE4", "LOTTABLE5", "LOTTABLE6", "LOTTABLE7", "LOTTABLE8", "LOTTABLE9", "LOTTABLE10",
				"EFFECTIVEDATE", "SUSR1_DET", "SUSR2_DET", "SUSR3_DET", "SUSR4_DET", "SUSR5_DET", "NOTES3",
				"ALLOCATESTRATEGYKEY", "PREALLOCATESTRATEGYKEY", "ALLOCATESTRATEGYTYPE", "SKUROTATION", "SHELFLIFE",
				"OKTOSUBSTITUTE", "SHIPGROUP01", "SHIPGROUP02", "SHIPGROUP03", "PICKINGINSTRUCTIONS", "OPPREQUEST",
				"EXTERNALLOT", "NVI_NUM_NOTA_FISCAL_DET", "NVI_SERIE_DET", "NIV_ITEM_SEQUENCIA", "NIV_VALOR_UNITARIO",
				"NIV_ALIQUOTA_IPI", "NIV_LOCAL", "NIV_LOTE", "NIV_PALLET" };

		for (String campo : campos) {
			if (camposConcatenados == "")
				camposConcatenados = campo;
			else
				camposConcatenados += "," + campo;
		}

		return camposConcatenados;
	}

}
