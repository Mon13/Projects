package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class State_0 extends State{
	
	
	public  State_0 (MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
    }
	
	public void Start() {
		op_obj.payMsg();
	op_obj.initializeData();
		mda_obj.changeState(S1);
    }
}
