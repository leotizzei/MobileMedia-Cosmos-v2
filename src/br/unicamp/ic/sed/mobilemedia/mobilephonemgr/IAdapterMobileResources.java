package br.unicamp.ic.sed.mobilemedia.mobilephonemgr;

import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.req.IMobileResourcesCtr;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;

class IAdapterMobileResources implements IMobileResourcesCtr {
	
	
	
		
	public MIDlet getMainMIDlet() {
		IManager mgr = ComponentFactory.createInstance();
		br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req.IMobileResources mobResources = (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req.IMobileResources) mgr.getRequiredInterface("IMobileResources");
		return mobResources.getMainMIDlet();
	}

}
