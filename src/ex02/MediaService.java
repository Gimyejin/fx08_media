package ex02;

import javafx.scene.Parent;

public interface MediaService {
	public void play() ;
	public void pause();
	public void stop();
	public void setMedia(Parent root,String mediaName);
	public void volumeControl();
}
