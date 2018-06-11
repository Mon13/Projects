package output_processor_strategy;

import data_store.Data_Store_GasPump1;

public class StorePin1 extends StorePin {
private  Data_Store_GasPump1 gas_data1;
	
	public StorePin1(Data_Store_GasPump1 gas_data1) {
        this.gas_data1 = gas_data1;
    }
	@Override
	public void storePin() {
		String pin;
		pin=gas_data1.getTemp_pin();
		
		gas_data1.setPin(pin);
		
	}

}
