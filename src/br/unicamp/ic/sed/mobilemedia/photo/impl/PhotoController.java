package br.unicamp.ic.sed.mobilemedia.photo.impl;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Image;
import javax.microedition.midlet.MIDlet;

import br.unicamp.ic.sed.mobilemedia.photo.spec.prov.IManager;
import br.unicamp.ic.sed.mobilemedia.photo.spec.req.IMobilePhone;
import br.unicamp.ic.sed.mobilemedia.photo.spec.req.IMobileResources;

class PhotoController implements CommandListener{

	private AddPhotoToAlbum addPhoto;

	private PhotoListScreen photoListScreen;

	private PhotoViewScreen photoViewScreen;

	private NewLabelScreen newLabelScreen;

	private PhotoListScreen getPhotoListScreen() {
		return photoListScreen;
	}


	private AddPhotoToAlbum getAddPhotoToAlbum(){
		return this.addPhoto;
	}



	public void commandAction(Command arg0, Displayable arg1) {
		// call required interface IMobilePhone
		IManager manager = ComponentFactory.createInstance();
		IMobilePhone mobilePhone = (IMobilePhone) manager.getRequiredInterface("IMobilePhone");
		mobilePhone.postCommand( arg0 );

	}


	protected void initPhotoListScreen ( String[] imageNames ){

		if( imageNames == null){
			System.err.println("No images in this album");
			return;
		}
		else{

			//Get all required interfaces for this method
			IManager manager = (IManager)ComponentFactory.createInstance();
			IMobileResources iMobileResources = (IMobileResources)manager.getRequiredInterface("IMobileResources");
			MIDlet midlet = iMobileResources.getMainMIDlet();

			this.photoListScreen = new PhotoListScreen();

			// add all image names to the screen
			for(int i = 0; i < imageNames.length ; i++){
				photoListScreen.append( imageNames[i], null);

			}

			photoListScreen.setCommandListener(this);
			photoListScreen.initMenu();
			Display.getDisplay( midlet ).setCurrent( photoListScreen );
		}
	}



	protected void initPhotoViewScreen ( Image image ){

		if( image == null ){
			System.err.println("Variable Image is null");
			return;
		}
		else{

			//Get all required interfaces for this method
			IManager manager = (IManager)ComponentFactory.createInstance();
			IMobileResources iMobileResources = (IMobileResources)manager.getRequiredInterface("IMobileResources");
			MIDlet midlet = iMobileResources.getMainMIDlet();



			//if( this.photoViewScreen == null)
			this.photoViewScreen = new PhotoViewScreen( image );


			this.photoViewScreen.setCommandListener(this);
			Display.getDisplay( midlet ).setCurrent( photoViewScreen );
		}


	} 

	protected String getSelectedPhoto(){
		PhotoListScreen photoList = getPhotoListScreen();
		int selectedIndex = photoList.getSelectedIndex();
		return photoList.getString( selectedIndex );	
	}

	protected String getAddedPhotoName() {
		AddPhotoToAlbum add = getAddPhotoToAlbum();
		if( add == null ){
			System.err.println("There is no photo");
			return null;
		}
		else{
			String photoName = add.getPhotoName();
			return photoName;
		}

	}

	protected String getAddedPhotoPath() {
		AddPhotoToAlbum add = getAddPhotoToAlbum();
		if( add == null ){
			System.err.println("There is no photo");
			return null;
		}
		else{
			String photoPath = add.getPath();
			return photoPath;
		}
	}


	protected void initAddPhotoToAlbum(String albumName) {


		//Get all required interfaces for this method
		IManager manager = (IManager)ComponentFactory.createInstance();
		IMobileResources iMobileResources = (IMobileResources)manager.getRequiredInterface("IMobileResources");
		MIDlet midlet = iMobileResources.getMainMIDlet();

		if( albumName == null){
			System.err.println("Image name is null");
			return;
		}
		else{
			this.addPhoto = new AddPhotoToAlbum( albumName );
			addPhoto.setCommandListener(this);
			Display.getDisplay( midlet ).setCurrent( addPhoto );
			System.out.println("albumname = "+albumName);
		}
	}


	public String getNewLabel() {
		return newLabelScreen.getLabelName();
	}


	public void initEditLabelScreen( ) {

		//Get all required interfaces for this method
		IManager manager = (IManager)ComponentFactory.createInstance();
		IMobileResources iMobileResources = (IMobileResources)manager.getRequiredInterface("IMobileResources");
		MIDlet midlet = iMobileResources.getMainMIDlet();

		newLabelScreen = new NewLabelScreen( "Edit label photo" , NewLabelScreen.LABEL_PHOTO );

		newLabelScreen.setCommandListener( this );
		Display.getDisplay( midlet ).setCurrent( newLabelScreen );
	} 




}
