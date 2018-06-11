package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;
import static fixed_values.States_values.*;

public class State_5 extends State{
	public  State_5 (MDA_ESFM mda_obj, Output_Processor op_obj) {
        super(mda_obj, op_obj);
     
    }
	
	public void Pump() {
		op_obj.pumpGasUnit();
		op_obj.gasPumpedMsg();
        //mda_obj.changeState(S5);
        
    }
	
	public void StopPump() {
		op_obj.stopMsg();
        mda_obj.changeState(S6);
    }

}
