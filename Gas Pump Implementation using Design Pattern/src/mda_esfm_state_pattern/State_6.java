package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class State_6 extends State {
	public  State_6 (MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
    }
	
	public void Receipt() {
		op_obj.printReceipt();
		op_obj.returnCash();
        mda_obj.changeState(S0); 
    }

	public void NoReceipt() {
		op_obj.returnCash();
        mda_obj.changeState(S0); 
    }
}
