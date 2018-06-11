package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class State_2 extends State{
	
	public  State_2 (MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
    }
	
	public void Reject() {
		op_obj.rejectMsg();
	       mda_obj.changeState(S0);
    }
	
	public void Approved() {
		op_obj.displayMenu();
	       mda_obj.changeState(S3);
    }

}
