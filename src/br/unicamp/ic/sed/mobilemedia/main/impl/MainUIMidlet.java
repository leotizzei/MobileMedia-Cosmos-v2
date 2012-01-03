package br.unicamp.ic.sed.mobilemedia.main.impl;

import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import br.unicamp.ic.sed.mobilemedia.main.spec.prov.IMobileResources;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IMobilePhone;


//Following are pre-processor statements to include the required
//classes for device specific features. They must be commented out
//if they aren't used, otherwise it will throw exceptions trying to
//load classes that aren't available for a given platform.


/* 
 * @author trevor
 *
 * This is the main Midlet class for the core J2ME application
 * It contains all the basic functionality that should be executable
 * in any standard J2ME device that supports MIDP 1.0 or higher. 
 * Any additional J2ME features for this application that are dependent
 * upon a particular device (ie. optional or proprietary library) are
 * de-coupled from the core application so they can be conditionally included
 * depending on the target platform 
 * 
 * This Application provides a basic Photo Album interface that allows a user to view
 * images on their mobile device. 
 * */
public class MainUIMidlet extends MIDlet implements IMobileResources {

	br.unicamp.ic.sed.mobilemedia.album.spec.prov.IManager album;
	
	br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IManager filesystem;
	br.unicamp.ic.sed.mobilemedia.album_mobilephonemgr.impl.IManager album_mobilePhone;
	br.unicamp.ic.sed.mobilemedia.filesystemmgr_mobilephonemgr.impl.IManager filesystem_mobilePhone;
	br.unicamp.ic.sed.mobilemedia.photo.spec.prov.IManager photo;
	br.unicamp.ic.sed.mobilemedia.photo_mobilephonemgr.impl.IManager photo_mobilePhone;
	
	br.unicamp.ic.sed.mobilemedia.mainuimidlet_album.impl.IManager mainMidlet_album;
	br.unicamp.ic.sed.mobilemedia.mainuimidlet_photo.impl.IManager mainMidlet_photo;
	br.unicamp.ic.sed.mobilemedia.mainuimidlet_mobilephonemgr.impl.IManager mainmidlet_mobilephone; 
	
	//subcomponents
	br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager mobilePhone;
	br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager mobilePhone2;
	
	public MainUIMidlet() {
	    //do nothing
	}

	/**
	 * Start the MIDlet by creating new model and controller classes, and
	 * initialize them as necessary
	 */
	public void startApp() throws MIDletStateChangeException {
		
		System.out.println("Starting MobileMediaXPI - v2");
		
		// create all imanagers
		filesystem = br.unicamp.ic.sed.mobilemedia.filesystemmgr.impl.ComponentFactory.createInstance();
		album_mobilePhone = br.unicamp.ic.sed.mobilemedia.album_mobilephonemgr.impl.ComponentFactory.createInstance();
		mobilePhone = br.unicamp.ic.sed.mobilemedia.mobilephonemgr.ComponentFactory.createInstance();
		
		filesystem_mobilePhone = br.unicamp.ic.sed.mobilemedia.filesystemmgr_mobilephonemgr.impl.ComponentFactory.createInstance();
		album = br.unicamp.ic.sed.mobilemedia.album.impl.ComponentFactory.createInstance();
		
		mainMidlet_album = br.unicamp.ic.sed.mobilemedia.mainuimidlet_album.impl.ComponentFactory.createInstance();
		photo = br.unicamp.ic.sed.mobilemedia.photo.impl.ComponentFactory.createInstance();
	
		photo_mobilePhone = br.unicamp.ic.sed.mobilemedia.photo_mobilephonemgr.impl.ComponentFactory.createInstance();
		mainMidlet_photo = br.unicamp.ic.sed.mobilemedia.mainuimidlet_photo.impl.ComponentFactory.createInstance();
		mainmidlet_mobilephone = br.unicamp.ic.sed.mobilemedia.mainuimidlet_mobilephonemgr.impl.ComponentFactory.createInstance();
		
		/*Setting required interfaces for all components and connectors*/

		/*MobilePhone*/
		mobilePhone.setRequiredInterface("IFilesystem", filesystem_mobilePhone.getProvidedInterface("IFilesystem"));
			
		mobilePhone.setRequiredInterface("IMobileResources", mainmidlet_mobilephone.getProvidedInterface("IMobileResources") );
		
		mobilePhone.setRequiredInterface("IPhoto", photo_mobilePhone.getProvidedInterface("IPhoto"));
		
		mobilePhone.setRequiredInterface("IAlbum", album_mobilePhone.getProvidedInterface("IAlbum"));
		
		/*Album*/
		album.setRequiredInterface("IMobileResources", mainMidlet_album.getProvidedInterface("IMobileResources") );
		
		album.setRequiredInterface("IMobilePhone", album_mobilePhone.getProvidedInterface("IMobilePhone"));
		
		/*Photo*/
		photo.setRequiredInterface("IMobilePhone", photo_mobilePhone.getProvidedInterface("IMobilePhone"));
		
		photo.setRequiredInterface("IMobileResources", mainMidlet_photo.getProvidedInterface("IMobileResources") );
		
		
		/*connectors*/
		mainMidlet_photo.setRequiredInterface("IMobileResources", this );
			
		photo_mobilePhone.setRequiredInterface("IPhoto", photo.getProvidedInterface("IPhoto"));
		
		photo_mobilePhone.setRequiredInterface("IMobilePhone", mobilePhone.getProvidedInterface("IMobilePhone"));

		mainmidlet_mobilephone.setRequiredInterface("IMobileResources", this );
				
		album_mobilePhone.setRequiredInterface("IAlbum", album.getProvidedInterface("IAlbum"));
	
		album_mobilePhone.setRequiredInterface("IMobilePhone", mobilePhone.getProvidedInterface("IMobilePhone"));
		
		mainMidlet_album.setRequiredInterface("IMobileResources", this );
		
		filesystem_mobilePhone.setRequiredInterface("IFilesystem", filesystem.getProvidedInterface("IFilesystem"));
		
		
		
		IMobilePhone mobPhone = (IMobilePhone) mobilePhone.getProvidedInterface("IMobilePhone");
		
		System.out.println("mobPhone.startUp()");
		
		mobPhone.startUp();
	}

	/**
	 * Pause the MIDlet
	 * This method does nothing at the moment.
	 */
	public void pauseApp() {
		//do nothing
	}

	/**
	 * Destroy the MIDlet
	 */
	public void destroyApp(boolean unconditional) {
		notifyDestroyed();
	}

	public MIDlet getMainMIDlet() {
		return this;
	}
}