package br.unicamp.ic.sed.mobilemedia.mobilephonemgr;

import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.mobilephonecontroller.spec.req.IAlbumCtr;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.mobilephonemgr.spec.req.IAlbum;


public class IAdapterAlbum implements IAlbumCtr {

	
	
	
	
	public String getNewAlbumName() {
		IManager mgr = ComponentFactory.createInstance();
		IAlbum album = (IAlbum) mgr.getRequiredInterface("IAlbum");
		return album.getNewAlbumName();
	}

	
	public String getSelectedAlbum() {
		IManager mgr = ComponentFactory.createInstance();
		IAlbum album = (IAlbum) mgr.getRequiredInterface("IAlbum");
		return album.getSelectedAlbum();
	}

	
	public void initAlbumListScreen(String[] albumNames) {
		IManager mgr = ComponentFactory.createInstance();
		IAlbum album = (IAlbum) mgr.getRequiredInterface("IAlbum");
		if(album == null)
			System.err.println("album is null");
		album.initAlbumListScreen(albumNames);
		
		
	}

	
	public void initDeleteAlbumScreen(String albumName) {
		IManager mgr = ComponentFactory.createInstance();
		IAlbum album = (IAlbum) mgr.getRequiredInterface("IAlbum");
		album.initDeleteAlbumScreen(albumName);
		

	}


	public void initNewAlbumScreen() {
		IManager mgr = ComponentFactory.createInstance();
		IAlbum album = (IAlbum) mgr.getRequiredInterface("IAlbum");
		album.initNewAlbumScreen();

	}

}
