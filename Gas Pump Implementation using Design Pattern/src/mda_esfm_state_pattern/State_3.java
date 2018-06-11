package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class State_3 extends State{
	
	public  State_3 (MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
    }
	
	public void Cancel() {
		op_obj.cancelMsg();
		op_obj.returnCash();
	    mda_obj.changeState(S0);
    }
	 public void SelectGas(int g) {
		 
		 op_obj.setPrice(g,1);
		 //mda_obj.changeState(S3);
	    }
	 
	 public void Continue() {
		
		 mda_obj.changeState(S4);
	    }
}
