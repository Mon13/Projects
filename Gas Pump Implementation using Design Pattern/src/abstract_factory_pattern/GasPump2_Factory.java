package abstract_factory_pattern;

import input_processor.Gas_Pump2_inp_proc;
import input_processor.Input_Processor;
import mda_esfm_state_pattern.MDA_ESFM;
import output_processor_strategy.CancelMessage;
import output_processor_strategy.CancelMessage2;
import output_processor_strategy.DisplayMenu;
import output_processor_strategy.DisplayMenu2;
import output_processor_strategy.EnterPinMessage;

import output_processor_strategy.GasPumpedMessage;
import output_processor_strategy.GasPumpedMessage2;
import output_processor_strategy.InitialValues;
import output_processor_strategy.InitialValues2;
import output_processor_strategy.InitializeData;
import output_processor_strategy.InitializeData2;
import output_processor_strategy.PayMessage;
import output_processor_strategy.PayMessage2;
import output_processor_strategy.PumpGasUnit;
import output_processor_strategy.PumpGasUnit2;
import output_processor_strategy.ReadyMessage;
import output_processor_strategy.ReadyMessage2;
import output_processor_strategy.Receipt;
import output_processor_strategy.Receipt2;
import output_processor_strategy.RejectMessage;
import output_processor_strategy.RejectMessage2;
import output_processor_strategy.ReturnCash;
import output_processor_strategy.ReturnCash2;
import output_processor_strategy.SetPrice;
import output_processor_strategy.SetPrice2;
import output_processor_strategy.StopMessage;
import output_processor_strategy.StopMessage2;
import output_processor_strategy.StoreCash;
import output_processor_strategy.StoreCash2;
import output_processor_strategy.StorePin;

import output_processor_strategy.StorePrice;
import output_processor_strategy.StorePrice2;
import output_processor_strategy.WrongPinMessage;

import data_store.Data_Store;
import data_store.Data_Store_GasPump2;


public class GasPump2_Factory extends Abstract_Factory {

	@Override
	public Data_Store create_data_store() {
		
		return new Data_Store_GasPump2();
	}

	@Override
	public Input_Processor createInputProcessor(Data_Store data, MDA_ESFM mda) {
	
		return new Gas_Pump2_inp_proc((Data_Store_GasPump2)data, mda);
	}

	@Override
	public StorePrice create_store_price(Data_Store data) {
	
		return new StorePrice2((Data_Store_GasPump2)data);
	}

	@Override
	public PayMessage create_pay_message(Data_Store data) {
	
		return new PayMessage2();
	}

	@Override
	public StoreCash create_store_cash(Data_Store data) {
	
		return new StoreCash2((Data_Store_GasPump2)data);
	}

	@Override
	public DisplayMenu create_display_menu(Data_Store data) {
	
		return new DisplayMenu2();
	}

	@Override
	public RejectMessage create_reject_message(Data_Store data) {
	
		return new RejectMessage2();
	}

	@Override
	public SetPrice create_set_price(Data_Store data) {
	
		return new SetPrice2((Data_Store_GasPump2)data);
	}

	@Override
	public ReadyMessage create_ready_message(Data_Store data) {
	
		return new ReadyMessage2();
	}

	@Override
	public InitialValues create_initial_values(Data_Store data) {
	
		return new InitialValues2((Data_Store_GasPump2)data);
	}

	@Override
	public PumpGasUnit create_pump_gas_unit(Data_Store data) {
	
		return new PumpGasUnit2((Data_Store_GasPump2)data);
	}

	@Override
	public GasPumpedMessage create_gas_pump_message(Data_Store data) {
	
		return new GasPumpedMessage2((Data_Store_GasPump2)data);
	}

	@Override
	public StopMessage create_stop_message(Data_Store data) {
	
		return new StopMessage2();
	}

	@Override
	public Receipt create_receipt(Data_Store data) {
	
		return new Receipt2((Data_Store_GasPump2)data);
	}

	@Override
	public CancelMessage create_cancel_message(Data_Store data) {
	
		return new CancelMessage2();
	}

	@Override
	public ReturnCash create_return_cash(Data_Store data) {
	
		return new ReturnCash2((Data_Store_GasPump2)data);
	}

	@Override
	public WrongPinMessage create_wrong_pin_message(Data_Store data) {
	
		return null;
	}

	@Override
	public StorePin create_store_pin(Data_Store data) {
	
		return null;
	}

	@Override
	public EnterPinMessage create_pin_message(Data_Store data) {
	
		return null;
	}

	@Override
	public InitializeData create_initialize_data(Data_Store data) {
	
		return new InitializeData2((Data_Store_GasPump2)data);
	}

	
}
