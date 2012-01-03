package br.unicamp.ic.sed.mobilemedia.mobilephonemgr;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.req.IPhotoCtr;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req.IPhoto;

public class IAdapterPhoto implements IPhotoCtr {

	
	
	
	public String getAddedPhotoName() {
		IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		return photo.getAddedPhotoName();
	}

	
	public String getAddedPhotoPath() {
		IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		return photo.getAddedPhotoPath();
	}

	
	public String getSelectedPhoto() {
		IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		return photo.getSelectedPhoto();
	}

	
	public void initAddPhotoToAlbum(String albumName) {
		IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		photo.initAddPhotoToAlbum(albumName);

	}

	
	public void initPhotoListScreen(String[] imageNames) {
		IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		photo.initPhotoListScreen(imageNames);
	}

	
	public void initPhotoViewScreen(Image image) {
		IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		photo.initPhotoViewScreen(image);

	}


	 
	public String getNewLabel() {
		IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		return photo.getNewLabel();
	}


	 
	public void initEditLabelScreen() {
		IManager mgr = ComponentFactory.createInstance();
		IPhoto photo = (IPhoto) mgr.getRequiredInterface("IPhoto");
		photo.initEditLabelScreen();	
	}

}
