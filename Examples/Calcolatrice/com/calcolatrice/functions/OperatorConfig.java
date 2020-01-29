package com.calcolatrice.functions;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.calcolatrice.core.Op;




	
public final class OperatorConfig {
	
	private static class ConfigMap implements Map{
		
		private HashMap<String,Op> map;
		@Override
		public int size(){
			return map.values().size();

		}

		@Override
		public boolean isEmpty() {
			if(size() == 0)
				return false;
			
			return true;
		}

		@Override
		public boolean containsKey(Object key) {
			if(map.containsKey((String)key)) {
				return true;
			}
			return false;
		}

		@Override
		public boolean containsValue(Object value) {
			if(map.containsValue((Op)value)) {
				return true;
			}
			return false;
		}

		@Override
		public Object get(Object key) {
			map.get((String)key);
			return null;
		}

		@Override
		public Object put(Object key, Object value) {
			
			map.put((String)key, (Op) value);
			
			return null;
		}

		@Override
		public Object remove(Object key) {
			
			return map.remove((String)key);
		}
		
		@Override
		public void putAll(Map m) {
			m.putAll(m);
		}

		@Override
		public void clear() {
			map.clear();
		}

		@Override
		public Set<String> keySet() {
			return map.keySet();

		}

		@Override
		public Collection<Op> values() {
			return map.values();
		}

		@Override
		public Set entrySet() {
			return map.entrySet();
		}
		
	}
	
	private static ConfigMap cfMap;
	private static File opConfigs;
	private static FileReader configFR;
	private static FileWriter configFW;


	
	/*
	 * Metodo usato per caricare le funzioni da file di configurazione
	 */
	public static boolean loadConfigs() throws IOException, InterruptedException {
		
		
		opConfigs = new File("settings.xml");
		configFR = new FileReader(opConfigs);
		configFW = new FileWriter(opConfigs);
		
		if(opConfigs.createNewFile()) {
			//codice di inizializzazione del file di setting
			
		}else {
			char[] raw = null;
			int pointer = configFR.read(raw);
			configFR.wait();
			String rawS = new String(raw);
			
			for(String row : rawS.split(",")) {
				String[] str = row.split(".");
				cfMap.put(str[0],);
			}
			
		}
		return false;
	}
}

