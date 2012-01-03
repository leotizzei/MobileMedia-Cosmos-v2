package br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.req;
import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.dt.ImageData;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.UnavailablePhotoAlbumException;



public interface IFilesystemCtr{

	public void addNewPhotoToAlbum ( String imageName, String imagePath, String albumName ) throws InvalidImageDataException, PersistenceMechanismException; 
	public void deleteImage ( String imageName, String albumName ) throws PersistenceMechanismException, ImageNotFoundException; 
	public Image getImageFromRecordStore ( String albumName, String imageName ) throws ImageNotFoundException, PersistenceMechanismException; 
	public String[] getAlbumNames (  ); 
	public void resetImageData (  ) throws PersistenceMechanismException; 
	public void createNewPhotoAlbum ( String albumName ) throws PersistenceMechanismException, InvalidPhotoAlbumNameException; 
	public void deletePhotoAlbum ( String albumName ) throws PersistenceMechanismException; 

	//added
	public ImageData getImageInfo( String imageName ) throws ImageNotFoundException, NullAlbumDataReference;
	public void updateImageInfo( ImageData velhoID , ImageData novoID ) throws InvalidImageDataException, PersistenceMechanismException;
	
	//modified
	//public String[] getImageNames ( String albumName ) throws UnavailablePhotoAlbumException; 
	public ImageData[] getImages( String albumName )throws UnavailablePhotoAlbumException;
	
}