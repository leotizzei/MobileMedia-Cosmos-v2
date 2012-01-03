package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.impl;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.AManager;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;

class Manager extends AManager implements IManager{

	Hashtable providedInterfaces;
	Hashtable requiredInterfaces;

	static int counter = 0;
	
	Manager(){
		
		
		providedInterfaces = new Hashtable();
		requiredInterfaces = new Hashtable();
		this.setProvidedInterface("IMobilePhoneCtr", new br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.impl.IMobilePhoneMgrFacade());
		
	}
	
	
	public String[] getProvidedInterfaces(){
	   Vector provInterfaceList = new Vector();
	   provInterfaceList.addElement("IMobilePhoneCtr");
	     
	   return convertListToArray(provInterfaceList.elements());
	}

	
	private String[] convertListToArray(Enumeration stringEnum){
		Vector stringVector = new Vector();
		for (Enumeration iter = stringEnum; iter.hasMoreElements();) {
			String element = (String) iter.nextElement();
			stringVector.addElement(element);
		}
		
		String[] stringArray = new String[stringVector.size()];
		for (int i=0; i < stringVector.size(); i++){
			stringArray[i] = (String) stringVector.elementAt(i);
		}
		return stringArray;
	}

	public Object getProvidedInterface(String name){
		return this.providedInterfaces.get(name);
	}
	
	public Object getRequiredInterface(String name){
		return this.requiredInterfaces.get(name);
	}

	public void setProvidedInterface(String name, Object facade){
		this.providedInterfaces.put(name, facade);
	}

	public void setRequiredInterface(String name,Object facade){
		if(name == null)
			System.err.println("name is null");
		if(facade == null)
			System.err.println("br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.impl.Manager facade is null");
		if(requiredInterfaces == null)
			System.err.println("requiredinterfaces is null");
		this.requiredInterfaces.put(name, facade);
	}
	
}



