   
package br.unicamp.ic.sed.mobilemedia.filesystemmgr_mobilephonemgr.impl;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.dt.ImageData;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req.IFilesystem;

class IFileSystemAdapter implements IFilesystem{
	
	
	public IFileSystemAdapter() {}
	
	public ImageData[] getImages ( String albumName ) throws UnavailablePhotoAlbumException{
	
	
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			return this.converteImageDatas( filesystem.getImages(albumName) );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.UnavailablePhotoAlbumException e) {
				throw new UnavailablePhotoAlbumException( e );
		}
	} 
	
	public void addNewPhotoToAlbum ( String imageName, String imagePath, String albumName ) throws InvalidImageDataException, PersistenceMechanismException{
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.addNewPhotoToAlbum(imageName, imagePath, albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException e) {
			throw new InvalidImageDataException( e );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e );
		}
	}
	
	public void deleteImage ( String imageName, String albumName ) throws PersistenceMechanismException, ImageNotFoundException{
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.deleteImage(imageName, albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException e) {
			throw new ImageNotFoundException( e ); 
		}
	}
	
	public Image getImageFromRecordStore ( String albumName, String imageName ) throws ImageNotFoundException, PersistenceMechanismException{
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			return filesystem.getImageFromRecordStore(albumName, imageName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException e) {
			throw new ImageNotFoundException( e );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e );
		}
	}
	
	public String[] getAlbumNames (  ){
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");		return filesystem.getAlbumNames();
	}
	
	public void resetImageData (  ) throws PersistenceMechanismException{
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.resetImageData();
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e );
		}
	}
	
	public void createNewPhotoAlbum ( String albumName ) throws PersistenceMechanismException, InvalidPhotoAlbumNameException{
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.createNewPhotoAlbum(albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidPhotoAlbumNameException e) {
			throw new InvalidPhotoAlbumNameException( e.getMessage() );
		}
	}
	
	public void deletePhotoAlbum ( String albumName ) throws PersistenceMechanismException{
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		try {
			filesystem.deletePhotoAlbum(albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e );
		}
	}

	
	public ImageData getImageInfo(String imageName)
			throws ImageNotFoundException, NullAlbumDataReference {
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		
		try {
			return this.converteImageData( filesystem.getImageInfo(imageName) );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.ImageNotFoundException e) {
			throw new ImageNotFoundException( e.getMessage() );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.NullAlbumDataReference e) {
			throw new NullAlbumDataReference( e.getMessage() );
		}
	}

	
	public void updateImageInfo(ImageData velhoID, ImageData novoID)
			throws InvalidImageDataException, PersistenceMechanismException {
		
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem filesystem;
		IManager manager = ComponentFactory.createInstance();
		filesystem = (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.prov.IFilesystem)manager.getRequiredInterface("IFilesystem");
		
		try {
			filesystem.updateImageInfo( this.converteImageData2( velhoID ),this.converteImageData2( novoID) );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.InvalidImageDataException e) {
			throw new InvalidImageDataException( e.getMessage() );
		} catch (br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e.getMessage() );
		}
	}
	
	private ImageData converteImageData( br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.dt.ImageData imageDT ){
		ImageData imageData = new ImageData( imageDT.getForeignRecordId() , imageDT.getParentAlbumName() , imageDT.getImageLabel() );
		
		imageData.setRecordId( imageDT.getRecordId() );
		
		// #ifdef includeSorting
		imageData.setNumberOfViews( imageDT.getNumberOfViews() );
		// #endif
		
		return imageData;
	}
	
	private br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.dt.ImageData converteImageData2( ImageData imageDT ){
		br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.dt. ImageData imageData = new br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.dt.ImageData( imageDT.getForeignRecordId() , imageDT.getParentAlbumName() , imageDT.getImageLabel() );
		
		imageData.setRecordId( imageDT.getRecordId() );
		
		// #ifdef includeSorting
		imageData.setNumberOfViews( imageDT.getNumberOfViews() );
		// #endif
		
		return imageData;
	}
	
	private ImageData[] converteImageDatas( br.unicamp.ic.sed.mobilemedia.filesystemmgr.spec.dt.ImageData[] imageDTs ){
		ImageData[] imageDatas = new ImageData[ imageDTs.length ];
		
		for( int i = 0 ; i < imageDTs.length ; i++ )
			imageDatas[ i ] = this.converteImageData( imageDTs[ i ] );
		
		return imageDatas;
	}

}