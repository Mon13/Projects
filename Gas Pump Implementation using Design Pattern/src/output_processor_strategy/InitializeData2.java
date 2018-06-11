package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class InitializeData2 extends InitializeData {

private  Data_Store_GasPump2 gas_data2;
	
	public InitializeData2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	
	@Override
	public void initializeData() {
		gas_data2.setPrice(0.0f);
		gas_data2.setCash(0);
	}

}
