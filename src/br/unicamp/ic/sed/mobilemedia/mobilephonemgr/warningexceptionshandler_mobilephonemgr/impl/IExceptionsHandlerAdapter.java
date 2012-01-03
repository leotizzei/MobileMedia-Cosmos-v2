package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.warningexceptionshandler_mobilephonemgr.impl;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.req.IExceptionsHandlerCtr;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;

class IExceptionsHandlerAdapter implements IExceptionsHandlerCtr{

	
	
	
	public void handle(Exception exception) {
		br.unicamp.ic.sed.mobilemedia.mobilephonemgr.warningexceptionhandler.spec.prov.IExceptionsHandlerCtr handler;	
		IManager mgr = ComponentFactory.createInstance();
		handler = (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.warningexceptionhandler.spec.prov.IExceptionsHandlerCtr)mgr.getRequiredInterface("IExceptionsHandler");
		handler.handle(exception);
	}
}