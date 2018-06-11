package abstract_factory_pattern;

import input_processor.Input_Processor;
import mda_esfm_state_pattern.MDA_ESFM;
import output_processor_strategy.CancelMessage;
import output_processor_strategy.DisplayMenu;
import output_processor_strategy.EnterPinMessage;
import output_processor_strategy.GasPumpedMessage;
import output_processor_strategy.InitialValues;
import output_processor_strategy.InitializeData;
import output_processor_strategy.Output_Processor;
import output_processor_strategy.PayMessage;
import output_processor_strategy.PumpGasUnit;
import output_processor_strategy.ReadyMessage;
import output_processor_strategy.Receipt;
import output_processor_strategy.RejectMessage;
import output_processor_strategy.ReturnCash;
import output_processor_strategy.SetPrice;
import output_processor_strategy.StopMessage;
import output_processor_strategy.StoreCash;
import output_processor_strategy.StorePin;
import output_processor_strategy.StorePrice;
import output_processor_strategy.WrongPinMessage;
import data_store.Data_Store;

public abstract class Abstract_Factory {
	
	public abstract Data_Store create_data_store();
	
	public abstract Input_Processor createInputProcessor(Data_Store data,MDA_ESFM mda);
	
	public Output_Processor createOutput_Processor(Data_Store data){
		
	final Output_Processor op_obj = new Output_Processor();
	
	op_obj.setStore_price(create_store_price(data)); 
		
	op_obj.setPay_message(create_pay_message(data)); 
		
	op_obj.setStore_cash(create_store_cash(data));
		
	op_obj.setDisplay_menu(create_display_menu(data));
		
	op_obj.setReject_message(create_reject_message(data)); 
		
	op_obj.setSet_price(create_set_price(data)); 
		
	op_obj.setReady_message(create_ready_message(data));
		
	op_obj.setInitial_values(create_initial_values(data));
		
	op_obj.setPump_gas_unit(create_pump_gas_unit(data));
		
	op_obj.setGas_pump_message(create_gas_pump_message(data)); 
		
	op_obj.setStop_message(create_stop_message(data)); 
		
	op_obj.setReceipt(create_receipt(data)); 
		
	op_obj.setCancel_message(create_cancel_message(data)); 
		
	op_obj.setReturn_cash(create_return_cash(data)); 
		
	op_obj.setWrong_pin_message(create_wrong_pin_message(data)); 
		
	op_obj.setStore_pin(create_store_pin(data)); 
		
	op_obj.setPin_message(create_pin_message(data)); 
		
	op_obj.setInitialize_data(create_initialize_data(data)); 
	
	return op_obj;
}
	
	
    public abstract StorePrice create_store_price(Data_Store data);
    public abstract PayMessage create_pay_message(Data_Store data);
    public abstract StoreCash create_store_cash(Data_Store data);
    public abstract DisplayMenu create_display_menu(Data_Store data);
    public abstract RejectMessage create_reject_message(Data_Store data);
    public abstract SetPrice create_set_price(Data_Store data);
    public abstract ReadyMessage create_ready_message(Data_Store data);
    public abstract InitialValues create_initial_values(Data_Store data);
    public abstract PumpGasUnit create_pump_gas_unit(Data_Store data);
    public abstract GasPumpedMessage create_gas_pump_message(Data_Store data);
    public abstract StopMessage create_stop_message(Data_Store data);
    public abstract Receipt create_receipt(Data_Store data);
    public abstract CancelMessage create_cancel_message(Data_Store data);
    public abstract ReturnCash create_return_cash(Data_Store data);
    public abstract WrongPinMessage create_wrong_pin_message(Data_Store data);
    public abstract StorePin create_store_pin(Data_Store data);
    public abstract EnterPinMessage create_pin_message(Data_Store data); 
    public abstract InitializeData create_initialize_data(Data_Store data);

}
