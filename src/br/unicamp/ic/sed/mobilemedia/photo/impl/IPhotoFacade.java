
package br.unicamp.ic.sed.mobilemedia.photo.impl;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.photo.spec.prov.IPhoto;

class IPhotoFacade implements IPhoto{

	private PhotoController photoController;
	
	public IPhotoFacade( ){
		photoController = new PhotoController( );
	}
	
	
	public void initPhotoListScreen ( String[] imageNames ){
		photoController.initPhotoListScreen(imageNames);

	}

	public void initPhotoViewScreen ( Image image ){
		photoController.initPhotoViewScreen(image);

	} 

	public String getSelectedPhoto (  ){
		return photoController.getSelectedPhoto();

	}
	
	public String getAddedPhotoName() {
			
		return photoController.getAddedPhotoName();
	}
	
	public String getAddedPhotoPath() {
	
		return photoController.getAddedPhotoPath();
	}
	
	
	public void initAddPhotoToAlbum(String albumName) {
		photoController.initAddPhotoToAlbum(albumName);

	}

	
	 
	public String getNewLabel() {
		return photoController.getNewLabel();
	}


	 
	public void initEditLabelScreen( ) {
		photoController.initEditLabelScreen(  );
		
	} 


}