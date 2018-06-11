package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class Created_State extends State{

	public  Created_State(MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
    }
	
	public void Activate() {
		
		op_obj.storePrice();
		
		mda_obj.changeState(S0);
    }
}
