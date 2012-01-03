package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.warningexceptionhandler.impl;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.warningexceptionhandler.spec.prov.IExceptionsHandlerCtr;



public class WarningExceptionHandler implements IExceptionsHandlerCtr{

	public void handle(Exception exception) {
		IManager manager = ComponentFactory.createInstance();
		MIDlet midlet = (MIDlet)manager.getRequiredInterface( "IMobileResources" );
		
		exception.printStackTrace();
		Alert alert = new Alert( "Error" , exception.getMessage() , null, AlertType.ERROR );
		alert.setTimeout( 5000 );
		
		Displayable currentDisplay = Display.getDisplay( midlet ).getCurrent();
		Display.getDisplay( midlet ).setCurrent(alert, currentDisplay );
	}
}
