package ancestry;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


abstract class Car{
	private  boolean isSedan;
	private String seats;
	
	public Car(boolean isSedan, String seats) {
		super();
		this.isSedan = isSedan;
		this.seats = seats;
	}

	public boolean getIsSedan() {
		return isSedan;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}
	
	
	abstract public String getMileage();
	
}


class WagonR extends Car{

	public int mileage;

	public WagonR(int mileage) {
		super(false, "4");
		this.mileage = mileage;
	}

	@Override
	public String getMileage() {
		return Integer.valueOf(this.mileage).toString()+"kmpl";
	}
	
}

class HondaCity extends Car{
	
	public int mileage;

	public HondaCity(int mileage) {
		super(true, "4");
		this.mileage = mileage;
	}

	@Override
	public String getMileage() {
		return Integer.valueOf(this.mileage).toString()+"kmpl";
	}
	
}

class InnovaCrysta extends Car{

	public int mileage;

	public InnovaCrysta(int mileage) {
		super(false, "6");
		this.mileage = mileage;
	}

	@Override
	public String getMileage() {
		return Integer.valueOf(this.mileage).toString()+"kmpl";
	}
	
}