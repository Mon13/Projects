package mda_esfm_state_pattern;

import fixed_values.States_values;
import static fixed_values.States_values.*;

import output_processor_strategy.Output_Processor;

public class MDA_ESFM {

	private State states[];
	private State current_State;
	private Output_Processor op_obj ;
	
	
	public MDA_ESFM(Output_Processor op){
		this.op_obj =  op;
		initialize();
	}
	
	public void initialize() {
		
        states = new State[States_values.total()];
        
        states[Created_State.getState_val()] = new Created_State(this, op_obj);
        states[S0.getState_val()] = new State_0(this, op_obj);
        states[S1.getState_val()] = new State_1(this, op_obj);
        states[S2.getState_val()] = new State_2(this, op_obj);
        states[S3.getState_val()] = new State_3(this, op_obj);
        states[S4.getState_val()] = new State_4(this, op_obj);
        states[S5.getState_val()] = new State_5(this, op_obj);
        states[S6.getState_val()] = new State_6(this, op_obj);
        states[S7.getState_val()] = new State_7(this, op_obj);
        changeState(Created_State);
    }
	
	public void changeState(States_values state_val) {
        if (state_val != null) {
            current_State = states[state_val.getState_val()];
        }
    }
	
	public void Activate() {
		
        current_State.Activate();
    
    }

    public void Start() {
        current_State.Start();
    }

    public void PayType(int t) {
        current_State.PayType(t);
    }

    public void Reject() {
        current_State.Reject();
    }

    public void Cancel() {
        current_State.Cancel();
    }

    public void Approved() {
        current_State.Approved();
    }

    public void StartPump() {
        current_State.StartPump();
      
    }

    public void Pump() {
        current_State.Pump();
        
    }

    public void StopPump() {
        current_State.StopPump();
        
    }

    public void SelectGas(int g) {
        current_State.SelectGas(g);
       
    }

    public void Receipt() {
        current_State.Receipt();
    
    }

    public void NoReceipt() {
        current_State.NoReceipt();
  
    }
    
    public void CorrectPin() {
        current_State.CorrectPin();
    }

    public void IncorrectPin() {
        current_State.IncorrectPin();
    }

    public void Continue() {
        current_State.Continue();
    }
    

}

