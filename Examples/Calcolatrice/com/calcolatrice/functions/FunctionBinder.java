package com.calcolatrice.functions;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.calcolatrice.core.Op;

import jdk.jfr.Description;

public class FunctionBinder {
	
	public String[] operatorList;
	
	public FunctionBinder(String[] operatorList) {
		this.operatorList = operatorList;
	}
	
	/*
	 * Metodo usato per caricare le funzioni da file di configurazione
	 */
	public FunctionBinder() {
		
	}
	
	
	//GESTIONE FILE PROPERTY 
	
	public boolean AddOp(Op op) throws FileNotFoundException, IOException {
		
		// Save Settings
	    Properties saveProps = new Properties();
	    saveProps.setProperty("operator", "/somethingpath1");
	    
	    saveProps.setProperty("path2", "/somethingpath2");
	    saveProps.storeToXML(new FileOutputStream("settings.xml"), "");
		
		return false;
	}
}
