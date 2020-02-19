package functions;


import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import core.Op;




	
public final class OperatorConfig {
	
	protected static List<Class<? extends Op>> Operators = new ArrayList<Class<? extends Op>>();
	
	private static final String SERIALIZED_FILE_NAME="settings.xml";
	
	
	private static File opConfigs;
	private static FileReader configFR;
	private static FileWriter configFW;
	

	
	/*
	 * Metodo usato per salvare le funzioni su file di configurazione
	 */
	public static void saveConfigs() throws IOException, InterruptedException {
		
		
		opConfigs = new File(SERIALIZED_FILE_NAME);
		configFR = new FileReader(opConfigs);
		configFW = new FileWriter(opConfigs);
		
		
	}
	
	
	protected static boolean cleanSettings() {
		if(opConfigs!= null) {
			if(opConfigs.exists()) {
				return opConfigs.delete();
			}
		}
		return false;
	}
	
	protected static OperatorConfig loadConfigs() throws ParserConfigurationException, SAXException, IOException, ClassNotFoundException {
		
		if(opConfigs.exists()) {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			StringBuilder xmlStringBuilder = new StringBuilder();
			xmlStringBuilder.append("<?xml version=\"1.0\"?> <class> </class>");
			ByteArrayInputStream input = new ByteArrayInputStream(
			   xmlStringBuilder.toString().getBytes("UTF-8"));
			Document doc = db.parse(input);
			
			Element root = doc.getDocumentElement();
			
			Map<String,Class<? extends Op>> dataMap = new HashMap<String,Class<? extends Op>>();//FORMAT Name|Path
			NodeList dataList = root.getElementsByTagName("operator");
			
			//Acquisizione nome operatore e path della classe
			for(int i = 0; i< dataList.getLength(); i++	) {
				
				String name = dataList.item(i).getAttributes().getNamedItem("OperatorName").getNodeValue();
				
				Class<? extends Op> op = (Class<? extends Op>) Op.class.forName(name, true, Op.class.getClassLoader());
				
				dataMap.putIfAbsent(name, op);
				
				Op.class.getClass();
			}

			Operators = (List<Class<? extends Op>>) dataMap.values();
		}else {
			//FILE DOESN'T EXISTS CASE
		}
		
		return null;
		
	}
}

