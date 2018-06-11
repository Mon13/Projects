package data_store;

public class Data_Store_GasPump1 extends Data_Store {

	 float temp_a;
	 float temp_b;
	 String pin;
	 float price;
	 int G;
	 float reg_price;
	 float diesel_price;
	 int temp_cash;
	 String temp_pin;
	
	public Data_Store_GasPump1() {
		super();
		total=0;
	}

	public float getTemp_a() {
		return temp_a;
	}

	public void setTemp_a(float temp_a) {
		this.temp_a = temp_a;
	}

	public float getTemp_b() {
		return temp_b;
	}

	public void setTemp_b(float temp_b) {
		this.temp_b = temp_b;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getG() {
		return G;
	}

	public void setG(int g) {
		G = g;
	}

	public float getReg_price() {
		return reg_price;
	}

	public void setReg_price(float reg_price) {
		this.reg_price = reg_price;
	}

	public float getDiesel_price() {
		return diesel_price;
	}

	public void setDiesel_price(float diesel_price) {
		this.diesel_price = diesel_price;
	}

	public int getTemp_cash() {
		return temp_cash;
	}

	public void setTemp_cash(int temp_cash) {
		this.temp_cash = temp_cash;
	}

	public String getTemp_pin() {
		return temp_pin;
	}

	public void setTemp_pin(String temp_pin) {
		this.temp_pin = temp_pin;
	}

	
	
}
