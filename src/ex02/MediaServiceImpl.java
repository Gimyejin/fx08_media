package ex02;

import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.Slider;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class MediaServiceImpl implements MediaService {
	MediaPlayer mediaPlayer;// 동영상을 컨트롤하는 기능들을 담당하고 있다.
	MediaView mediaView;
	Button btnPaly, btnPause, btnStop;
	boolean endofMedia;

	Label labelTime;
	Slider sliderVolume;
	ProgressBar progressBar;
	ProgressIndicator progressIndicator;

	@Override
	public void play() {
		mediaPlayer.play();
	}

	@Override
	public void pause() {// 일시정지
		mediaPlayer.pause();
	}

	@Override
	public void stop() {// 종료
		mediaPlayer.stop();
	}

	@Override
	public void setMedia(Parent root, String mediaName) {
		setControl(root);
		// System.out.println(getClass().getResource(mediaName));미디어의 위치를 확인해봤음
		Media media = new Media(getClass().getResource(mediaName).toString());// 동영상을 가져옴
		mediaPlayer = new MediaPlayer(media);// 동영상을 컨트롤 기능을 연결

		mediaView.setMediaPlayer(mediaPlayer);// 해당하는 뷰로 올리기

		mediaPlayer.setOnReady(new Runnable() {

			@Override
			public void run() {
				btnPaly.setDisable(false);// 버튼 잠금(비활성화) 기능를 비활성화
				btnPause.setDisable(true);// 버튼 잠금
				btnStop.setDisable(true);// 버튼 잠금
				
				mediaPlayer.currentTimeProperty().addListener((a,b,c)->{
													//  흐르는 시간             /           최종시간
					double progress = mediaPlayer.getCurrentTime().toSeconds()/mediaPlayer.getTotalDuration().toSeconds();
					progressBar.setProgress(progress);
					progressIndicator.setProgress(progress);
					labelTime.setText((int)(mediaPlayer.getCurrentTime().toSeconds())+"/"+(int)(mediaPlayer.getTotalDuration().toSeconds())+"초");
				});

			}
		});
		// 동영상이 play중이라면
		mediaPlayer.setOnPlaying(() -> {
			sliderVolume.setValue(50.0);//시작할때 소리 50퍼로 맞춤
			
			btnPaly.setDisable(true);
			btnPause.setDisable(false);
			btnStop.setDisable(false);
		});
		// 동영상이 멈췄다면
		mediaPlayer.setOnStopped(() -> {
			btnPaly.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});

		// 일시정지라면
		mediaPlayer.setOnPaused(() -> {
			btnPaly.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(false);
		});
		// 완전히 종료가 되었다면
		mediaPlayer.setOnEndOfMedia(() -> {
			btnPaly.setDisable(false);
			btnPause.setDisable(true);
			btnStop.setDisable(true);
		});
	}

	private void setControl(Parent root) {
		mediaView = (MediaView) root.lookup("#fxMediaView");
		btnPaly = (Button) root.lookup("#btnPlay");
		btnPause = (Button) root.lookup("#btnPause");
		btnStop = (Button) root.lookup("#btnStop");
		
		labelTime = (Label) root.lookup("#labelTime");
		sliderVolume = (Slider) root.lookup("#sliderVolume");
		progressBar = (ProgressBar) root.lookup("#progressBar");
		progressIndicator = (ProgressIndicator) root.lookup("#progressIndicator");
	}

	@Override
	public void volumeControl() {// 볼륨조절바
		mediaPlayer.setVolume(sliderVolume.getValue()/100.0);

	}

}
