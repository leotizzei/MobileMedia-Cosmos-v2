package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.warningexceptionshandler_mobilephonemgr.impl;


import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;


public class ComponentFactory {

	private static IManager manager = null;

	public static IManager createInstance(){
	
		if (manager==null)
			manager = (IManager) new Manager();
		
		return manager;
	}
}



