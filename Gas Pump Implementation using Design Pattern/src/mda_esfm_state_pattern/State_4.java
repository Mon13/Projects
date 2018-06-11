package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class State_4 extends State  {
	
	public  State_4 (MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
    }
	
	public void StartPump() {
		op_obj.setInitialValues();
		op_obj.readyMsg();
	       mda_obj.changeState(S5);
    }
}
