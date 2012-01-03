   
package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.impl;

import javax.microedition.lcdui.Command;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.prov.IMobilePhoneCtr;

class IMobilePhoneMgrFacade implements IMobilePhoneCtr{

	private BaseController controller;
	
	public IMobilePhoneMgrFacade() {
		controller = new BaseController();
		
	}
	
	public void postCommand ( Command command ){
		controller.postCommand( command );
	}



	public void startUp() {
		BaseController controller = new BaseController();
		//controller.setManager(manager);
		controller.init();
		
	}



	

}