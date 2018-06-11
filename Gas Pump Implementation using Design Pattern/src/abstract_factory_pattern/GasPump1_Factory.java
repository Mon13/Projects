package abstract_factory_pattern;

import input_processor.Gas_Pump1_inp_proc;
import input_processor.Input_Processor;
import mda_esfm_state_pattern.MDA_ESFM;
import output_processor_strategy.CancelMessage;
import output_processor_strategy.CancelMessage1;
import output_processor_strategy.DisplayMenu;
import output_processor_strategy.DisplayMenu1;
import output_processor_strategy.EnterPinMessage;
import output_processor_strategy.EnterPinMessage1;
import output_processor_strategy.GasPumpedMessage;
import output_processor_strategy.GasPumpedMessage1;
import output_processor_strategy.InitialValues;
import output_processor_strategy.InitialValues1;
import output_processor_strategy.InitializeData;
import output_processor_strategy.InitializeData1;
import output_processor_strategy.Output_Processor;
import output_processor_strategy.PayMessage;
import output_processor_strategy.PayMessage1;
import output_processor_strategy.PumpGasUnit;
import output_processor_strategy.PumpGasUnit1;
import output_processor_strategy.ReadyMessage;
import output_processor_strategy.ReadyMessage1;
import output_processor_strategy.Receipt;
import output_processor_strategy.Receipt1;
import output_processor_strategy.RejectMessage;
import output_processor_strategy.RejectMessage1;
import output_processor_strategy.ReturnCash;
import output_processor_strategy.SetPrice;
import output_processor_strategy.SetPrice1;
import output_processor_strategy.StopMessage;
import output_processor_strategy.StopMessage1;
import output_processor_strategy.StoreCash;
import output_processor_strategy.StorePin;
import output_processor_strategy.StorePin1;
import output_processor_strategy.StorePrice;
import output_processor_strategy.WrongPinMessage1;

import output_processor_strategy.StorePrice1;
import output_processor_strategy.WrongPinMessage;
import data_store.Data_Store;
import data_store.Data_Store_GasPump1;

public class GasPump1_Factory extends Abstract_Factory{

	@Override
	public Data_Store create_data_store() {
		
		return new Data_Store_GasPump1();
	}

	@Override
	public Input_Processor createInputProcessor(Data_Store data, MDA_ESFM mda) {
	
		return new Gas_Pump1_inp_proc((Data_Store_GasPump1)data, mda);
	}

	@Override
	public StorePrice create_store_price(Data_Store data) {
	
		return new StorePrice1((Data_Store_GasPump1)data);
	}

	@Override
	public PayMessage create_pay_message(Data_Store data) {
	
		return new PayMessage1();
	}

	@Override
	public StoreCash create_store_cash(Data_Store data) {
	
		return null;
	}

	@Override
	public DisplayMenu create_display_menu(Data_Store data) {
	
		return new DisplayMenu1();
	}

	@Override
	public RejectMessage create_reject_message(Data_Store data) {
	
		return new RejectMessage1();
	}

	@Override
	public SetPrice create_set_price(Data_Store data) {
	
		return new SetPrice1((Data_Store_GasPump1)data);
	}

	@Override
	public ReadyMessage create_ready_message(Data_Store data) {
	
		return new ReadyMessage1();
	}

	@Override
	public InitialValues create_initial_values(Data_Store data) {
	
		return new InitialValues1((Data_Store_GasPump1)data);
	}

	@Override
	public PumpGasUnit create_pump_gas_unit(Data_Store data) {
	
		return new PumpGasUnit1((Data_Store_GasPump1)data);
	}

	@Override
	public GasPumpedMessage create_gas_pump_message(Data_Store data) {
	
		return new GasPumpedMessage1((Data_Store_GasPump1)data);
	}

	@Override
	public StopMessage create_stop_message(Data_Store data) {
	
		return new StopMessage1();
	}

	@Override
	public Receipt create_receipt(Data_Store data) {
	
		return new Receipt1((Data_Store_GasPump1)data);
	}

	@Override
	public CancelMessage create_cancel_message(Data_Store data) {
	
		return new CancelMessage1();
	}

	@Override
	public ReturnCash create_return_cash(Data_Store data) {
	
		return null;
	}

	@Override
	public WrongPinMessage create_wrong_pin_message(Data_Store data) {
	
		return new WrongPinMessage1();
	}

	@Override
	public StorePin create_store_pin(Data_Store data) {
	
		return new StorePin1((Data_Store_GasPump1)data);
	}

	@Override
	public EnterPinMessage create_pin_message(Data_Store data) {
	
		return new EnterPinMessage1();
	}

	@Override
	public InitializeData create_initialize_data(Data_Store data) {
	
		return new InitializeData1((Data_Store_GasPump1)data);
	}

}
