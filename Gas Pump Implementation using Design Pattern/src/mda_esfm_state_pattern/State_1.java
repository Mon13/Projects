package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class State_1 extends State {

	public  State_1 (MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
    }
	
public void PayType(int t) {
		
		if(t==1)	
		{
			mda_obj.changeState(S2);
		}
		else if(t==2)
		{
			op_obj.displayMenu();
			op_obj.storeCash();
			mda_obj.changeState(S3);
		}
		else if(t==3)
		{
			op_obj.enterPinMsg();
			op_obj.storePin();
			mda_obj.changeState(S7);
		}
			
    }
}
