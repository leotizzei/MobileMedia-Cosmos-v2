package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.warningexceptionhandler.impl;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.AManager;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;

class Manager extends AManager implements IManager{

	Hashtable providedInterfaces;
	Hashtable requiredInterfaces;
	
	public Manager() {
		providedInterfaces = new Hashtable();
		requiredInterfaces = new Hashtable();
		this.setProvidedInterface("IExceptionsHandlerCtr", new IExceptionHandlerFacade());
	}
	
		
	public String[] getProvidedInterfaces(){
		Vector provInterfaceList = new Vector();
		provInterfaceList.addElement("IExceptionsHandlerCtr");
		
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


	public IManager getInternalComponent(String id){

		return null;
	}


	public Hashtable getProvidedInterfaceTypes() {

		return null;
	}


	public Hashtable getRequiredInterfaceTypes() {

		return null;
	}


	public boolean isComposite() {

		return false;
	}


	public String[] listProvidedInterfaces() {

		return null;
	}


	public String[] listRequiredInterfaces() {

		return null;
	}


	public void setInternalComponent(String id, IManager component){
		System.err.println("Error!That is not a composite component");
		
	}
	
	public Object getProvidedInterface(String name){
		Object aux = this.providedInterfaces.get(name);
		if(aux == null)
			System.err.println("Interface "+name+" is not provided by warningexceptionhandler");
		return aux;
	}
	
	public Object getRequiredInterface(String name){
		return this.requiredInterfaces.get(name);
	}

	public void setProvidedInterface(String name, Object facade){
		this.providedInterfaces.put(name, facade);
	}

	public void setRequiredInterface(String name,Object facade){
		this.requiredInterfaces.put(name, facade);
	}

	
}



