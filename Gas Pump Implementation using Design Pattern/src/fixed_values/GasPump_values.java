package fixed_values;

public enum GasPump_values {
	
	GasPump1(1),
	GasPump2(2);
	
	private int num;
	
	private GasPump_values(int num){
		this.num=num;
	}
	
	public int getNum(){
		return num;
	}

}
