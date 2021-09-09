package ex02;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class Controller implements Initializable{
	Parent root;
	MediaService ms;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms=new MediaServiceImpl();
		
	}
	public void setRoot(Parent root) {
		this.root=root;
		ms.setMedia(root, "/media/video.m4v");//미디어 이름(경로)
		
	}
	public void play() {
		ms.play();
	}
	public void pause() {
		ms.pause();
	}
	public void stop() {
		ms.stop();
	}
	public void volumeControl() {
		ms.volumeControl();
	}
}
