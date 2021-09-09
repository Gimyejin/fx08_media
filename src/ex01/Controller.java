package ex01;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Controller implements Initializable {
	Parent root;
	ListView<String> fxListview;
	ImageView fxImageView;
	ObservableList<String> phoneString;// arraylist처럼 생각하면 될 듯 (fxml에서 처라하는 list형식이다)
	ObservableList<Phone> phoneURL;

	public void setRoot(Parent root) {
		this.root = root;
		fxListview = (ListView) root.lookup("#fxListView");
		fxImageView = (ImageView) root.lookup("#fxImageView");
		setListView();
	}

	private void setListView() {
		setList();
		fxListview.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
			System.out.println("observable(형식)" + observable);
			System.out.println("oldValue(이전값)" + oldValue);
			System.out.println("newValue(현재값)" + newValue);
			System.out.println(phoneString.get((int) newValue));
			System.out.println(phoneURL.get((int) newValue).getSmartPhone());
			System.out.println(phoneURL.get((int) newValue).getImage());

			fxImageView.setImage(new Image("/img/phone/" + phoneURL.get((int) newValue).getImage()));// 이미지 보여주기
		});

	}

	private void setList() {
		phoneString = FXCollections.observableArrayList();
		phoneURL = FXCollections.observableArrayList();
		for (int i = 1; i < 8; i++) {
			phoneString.add("갤럭시S" + i);
			Phone phone = new Phone("갤럭시S" + i, "phone0" + i + ".png");
			phoneURL.add(phone);
		}
		fxListview.setItems(phoneString);

	}

	public void btn() {//버튼눌러서 화면 바꿔치기
		System.out.println("친구");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("aaa.fxml"));
		Parent newRoot = null;
		Scene sc = null;
		try {
			newRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc = new Scene(newRoot);

		// scene만 바꿔치기
		Stage stage = (Stage) root.getScene().getWindow();

		stage.setScene(sc);
		stage.show();

		// TextField id =(TextField)root.lookup("#id"); phoneString.add(id.getText());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
