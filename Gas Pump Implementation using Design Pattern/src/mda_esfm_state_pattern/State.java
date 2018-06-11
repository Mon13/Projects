package mda_esfm_state_pattern;

import output_processor_strategy.Output_Processor;

public abstract class State {
	
	protected MDA_ESFM mda_obj;

    protected Output_Processor op_obj = new Output_Processor();

    public State(MDA_ESFM mda_obj, Output_Processor op_obj) {
        this.mda_obj = mda_obj;
        this.op_obj = op_obj;
    }

	public void Activate() {
        
    }

    public void Start() {
     
    }

    public void PayType(int t) {
       
    }

    public void Reject() {
        
    }

    public void Cancel() {
        
    }

    public void Approved() {
       
    }

    public void StartPump() {
       
    }

    public void Pump() {
        
    }

    public void StopPump() {
       
    }

    public void SelectGas(int g) {
       
    }

    public void Receipt() {
     
    }

    public void NoReceipt() {
        
    }
    
    public void CorrectPin() {
       
    }

    public void IncorrectPin() {
        
    }

    public void Continue() {
       
    }
    
}
