package ex02;

public class Hotel {
	
	private Chef chef;
	
	// 일체형 모델
	public Hotel(Chef chef) {
		this.chef = chef;
	}

	public Chef getChef() {
		return chef;
	}

}
