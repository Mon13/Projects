package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class InitialValues2 extends InitialValues{

private  Data_Store_GasPump2 gas_data2;
	
	public InitialValues2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	
	@Override
	public void setInitialValues() {
		gas_data2.setL(0);
		gas_data2.setTotal(0.0f);
		
	}

}
