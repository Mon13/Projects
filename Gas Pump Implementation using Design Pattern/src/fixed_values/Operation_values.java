package fixed_values;

public enum Operation_values {
	
	Activate(0), 
	Start(1), 
	PayCredit(2), 
	PayDebit(3),
	PayCash(4),
	Reject(5), 
	Cancel(6), 
	Approved(7),
	StartPump(8),
	Pump(9), 
	StopPump(10),
	Regular(11),
	Super(12),
	Premium(13),
	Diesel(14),
	Receipt(15),
	NoReceipt(16), 
	CorrectPin(17), 
	IncorrectPin(18), 
	Continue(19),
	Pin(20),
	Exit(21);
	
	private int event;
	
	private Operation_values(int event){
		this.event=event;
	}
	
	public static Operation_values value(int code){
		final Operation_values[] val = Operation_values.class.getEnumConstants();
		for(Operation_values op_val:val){
			if(op_val.event==code)
				return op_val;
		}
		return null;
	}

}
