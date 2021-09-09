package ex01;

import javafx.beans.property.SimpleStringProperty;

public class Phone {
	private SimpleStringProperty smartPhone;
	private SimpleStringProperty image;

	
	//지금 list와 이미지 이름이 다름. -> 폰이라는 공간에다가 이름을 넣어주기 위해
	//smartPhone에는 갤럭시~ image는 phone~ 
	//여기는 맵핑작업을 하는 클래스
	
	//SimpleStringProperty는 여기서는 그렇게 필요하지 않지만 후에는 꼭 필요하게 됨.(fx에서 쓰는 String이라고 생각하자)
	
	public Phone(String smartPhone, String image) {
		this.smartPhone = new SimpleStringProperty(smartPhone);
		this.image = new SimpleStringProperty(image);
	}

	public String getSmartPhone() {
		return smartPhone.get();
	}

	public void setSmartPhone(String smartPhone) {
		this.smartPhone = new SimpleStringProperty(smartPhone);
	}

	public String getImage() {
		return image.get();
	}

	public void setImage(String image) {
		this.image = new SimpleStringProperty(image);
	}
	
}
