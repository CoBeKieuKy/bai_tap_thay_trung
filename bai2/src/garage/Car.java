package garage;

public class Car {
	private String modelID;
	private double price;
	private double speed;
	
	public Car(String model, double price, double speed) {
		this.setModelID(model);
		this.setPrice(price);
		this.setSpeed(speed);
	}

	public String getModelID() {
		return modelID;
	}

	public void setModelID(String model) {
		this.modelID = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getSpeed() {
		return speed;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}
}
