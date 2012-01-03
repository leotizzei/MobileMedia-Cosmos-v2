   
package br.unicamp.ic.sed.mobilemedia.filesystemmgr.impl;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.dt.ImageData;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem;

class IFilesystemFacade implements IFilesystem{

	private AlbumData albumData;
	
	public IFilesystemFacade(){
		albumData = new AlbumData();
	}
	
	public ImageData[] getImages ( String albumName ) throws UnavailablePhotoAlbumException{
		return albumData.getImages(albumName);
	} 
	
	public void addNewPhotoToAlbum ( String imageName, String imagePath, String albumName ) throws InvalidImageDataException, PersistenceMechanismException{
		albumData.addNewPhotoToAlbum(imageName, imagePath, albumName);
	} 
	
	public void deleteImage ( String imageName, String albumName ) throws PersistenceMechanismException, ImageNotFoundException{
		albumData.deleteImage(imageName, albumName);
	} 
	
	public Image getImageFromRecordStore ( String albumName, String imageName ) throws ImageNotFoundException, PersistenceMechanismException{
		return albumData.getImageFromRecordStore(albumName, imageName);
	} 
	
	public String[] getAlbumNames (  ){
		return albumData.getAlbumNames();
	} 
	
	public void resetImageData (  ) throws PersistenceMechanismException{
		albumData.resetImageData();	
	} 
	
	public void createNewPhotoAlbum ( String albumName ) throws PersistenceMechanismException, InvalidPhotoAlbumNameException{
		albumData.createNewPhotoAlbum(albumName);		
	} 
	
	public void deletePhotoAlbum ( String albumName ) throws PersistenceMechanismException{
		albumData.deletePhotoAlbum(albumName);	
	}

	
	public ImageData getImageInfo(String imageName) throws ImageNotFoundException, NullAlbumDataReference {
		return albumData.getImageInfo(imageName);
	}

	
	public void updateImageInfo(ImageData velhoID, ImageData novoID) throws InvalidImageDataException, PersistenceMechanismException {
		albumData.updateImageInfo(velhoID, novoID);
		
	} 

}