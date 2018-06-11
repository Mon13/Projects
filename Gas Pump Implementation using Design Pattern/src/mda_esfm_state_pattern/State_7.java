package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class State_7 extends State{

	public  State_7 (MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
    }
	
	public void CorrectPin() {
		op_obj.displayMenu();
        mda_obj.changeState(S3); 
    }
	
	public void IncorrectPin() {
		op_obj.wrongPinMsg();
        mda_obj.changeState(S0); 
    }

}
