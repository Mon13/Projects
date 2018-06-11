package output_processor_strategy;

import data_store.Data_Store_GasPump1;

public class InitializeData1 extends InitializeData {

private  Data_Store_GasPump1 gas_data1;
	
	public InitializeData1(Data_Store_GasPump1 gas_data1) {
        this.gas_data1 = gas_data1;
    }
	
	@Override
	public void initializeData() {
		gas_data1.setPrice(0.0f);
		
	}

}
