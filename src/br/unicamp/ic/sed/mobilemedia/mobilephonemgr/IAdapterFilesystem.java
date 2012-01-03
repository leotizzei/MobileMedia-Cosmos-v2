package br.unicamp.ic.sed.mobilemedia.mobilephonemgr;

import javax.microedition.lcdui.Image;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.dt.ImageData;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.ImageNotFoundException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.InvalidImageDataException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.InvalidPhotoAlbumNameException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.NullAlbumDataReference;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.PersistenceMechanismException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.UnavailablePhotoAlbumException;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.req.IFilesystemCtr;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req.IFilesystem;



public class IAdapterFilesystem implements IFilesystemCtr {

	public void addNewPhotoToAlbum(String imageName, String imagePath,
			String albumName) throws InvalidImageDataException,
			PersistenceMechanismException {
		
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		try {
			filesystem.addNewPhotoToAlbum(imageName, imagePath, albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.InvalidImageDataException e) {
			throw new InvalidImageDataException( e.getMessage() );
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e.getMessage() );
		}
		
		
	}


	public void createNewPhotoAlbum(String albumName)
			throws PersistenceMechanismException,
			InvalidPhotoAlbumNameException {
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		try {
			filesystem.createNewPhotoAlbum(albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e.getMessage() );
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.InvalidPhotoAlbumNameException e) {
			throw new InvalidPhotoAlbumNameException( e.getMessage() );
		}

	}


	public void deleteImage(String imageName, String albumName)
			throws PersistenceMechanismException, ImageNotFoundException {
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		try {
			filesystem.deleteImage(imageName, albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e.getMessage() );
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.ImageNotFoundException e) {
			throw new ImageNotFoundException( e.getMessage() );
		}
	}


	public void deletePhotoAlbum(String albumName)
			throws PersistenceMechanismException {
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		try {
			filesystem.deletePhotoAlbum(albumName);
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e.getMessage() );
		}

	}

	
	public String[] getAlbumNames() {
		System.out.println("entrou em IAdapterFilesystem.getAlbumNames()");
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		return  filesystem.getAlbumNames();
	}

	
	public Image getImageFromRecordStore(String albumName, String imageName)
			throws ImageNotFoundException, PersistenceMechanismException {
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		try {
			return filesystem.getImageFromRecordStore(albumName, imageName);
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.ImageNotFoundException e) {
			throw new ImageNotFoundException( e.getMessage() );
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e.getMessage() );
		}
	}


	public void resetImageData() throws PersistenceMechanismException {
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		try {
			filesystem.resetImageData();
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException e) {
			throw new PersistenceMechanismException( e.getMessage() );
		}

	}


	 
	public ImageData getImageInfo(String imageName)
			throws br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.excep.ImageNotFoundException,
			NullAlbumDataReference {
		
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		
		try {
			
			return this.converteImageData( filesystem.getImageInfo(imageName) );
			
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.ImageNotFoundException e) {
			throw new ImageNotFoundException( e.getMessage() );
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.NullAlbumDataReference e) {
			throw new NullAlbumDataReference( e.getMessage() );
		}
	}

	private ImageData converteImageData( br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.dt.ImageData imageDT ){
		ImageData imageData = new ImageData( imageDT.getForeignRecordId() , imageDT.getParentAlbumName() , imageDT.getImageLabel() );
		
		imageData.setRecordId( imageDT.getRecordId() );
		// #ifdef includeSorting
		imageData.setNumberOfViews( imageDT.getNumberOfViews() );
		//#endif
		
		return imageData;
	}
	
	private br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.dt.ImageData converteImageData2( ImageData imageDT ){
		br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.dt. ImageData imageData = new br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.dt.ImageData( imageDT.getForeignRecordId() , imageDT.getParentAlbumName() , imageDT.getImageLabel() );
		
		imageData.setRecordId( imageDT.getRecordId() );
		
		// #ifdef includeSorting
		imageData.setNumberOfViews( imageDT.getNumberOfViews() );
		//#endif
		
		return imageData;
	}
	
	private ImageData[] converteImageDatas( br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.dt.ImageData[] imageDTs ){
		ImageData[] imageDatas = new ImageData[ imageDTs.length ];
		
		for( int i = 0 ; i < imageDTs.length ; i++ )
			imageDatas[ i ] = this.converteImageData( imageDTs[ i ] );
		
		return imageDatas;
	}
	
	 
	public ImageData[] getImages(String albumName)
			throws UnavailablePhotoAlbumException {
		
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		
		
		try {
			return this.converteImageDatas( filesystem.getImages(albumName) );
		} catch (br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.UnavailablePhotoAlbumException e) {
			throw new UnavailablePhotoAlbumException( e.getMessage() );
		}
	}


	 
	public void updateImageInfo(ImageData velhoID, ImageData novoID)
			throws InvalidImageDataException,
			PersistenceMechanismException {
		
		IManager mgr = ComponentFactory.createInstance();
		IFilesystem filesystem = (IFilesystem) mgr.getRequiredInterface("IFilesystem");
		
		try{
			filesystem.updateImageInfo(this.converteImageData2( velhoID ), this.converteImageData2( novoID ) );
		} catch ( br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.InvalidImageDataException e ) {
			throw new InvalidImageDataException( e.getMessage() );
		}catch( br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.excep.PersistenceMechanismException e){
			throw new PersistenceMechanismException( e.getMessage() );
		}
	}

}
