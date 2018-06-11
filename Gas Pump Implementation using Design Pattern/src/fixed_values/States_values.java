package fixed_values;

public enum States_values {
	Created_State(8),
	S0(0),
	S1(1),
	S2(2),
	S3(3),
	S4(4),
	S5(5),
	S6(6),
	S7(7);
	
	private int state_val;
	
	private States_values(int state_val){
		this.state_val=state_val;
	}
	public int getState_val(){
		return state_val;
	}
	
	public static int total(){
		return States_values.class.getEnumConstants().length;
	}
}
