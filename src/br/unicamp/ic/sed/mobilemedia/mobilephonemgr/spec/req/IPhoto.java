package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req;

import javax.microedition.lcdui.Image;


public interface IPhoto{

	public void initPhotoListScreen ( String[] imageNames ); 
	public void initPhotoViewScreen ( Image image );  
	public String getSelectedPhoto (  );  

	public void initAddPhotoToAlbum ( String albumName );
	public String getAddedPhotoPath (  ); 
	public String getAddedPhotoName (  );
	
	//added
	public void initEditLabelScreen();
	public String getNewLabel();

}