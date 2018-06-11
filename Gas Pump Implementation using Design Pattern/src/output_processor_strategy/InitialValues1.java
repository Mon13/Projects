package output_processor_strategy;

import data_store.Data_Store_GasPump1;

public class InitialValues1 extends InitialValues{

private  Data_Store_GasPump1 gas_data1;
	
	public InitialValues1(Data_Store_GasPump1 gas_data1) {
        this.gas_data1 = gas_data1;
    }
	
	@Override
	public void setInitialValues() {
		gas_data1.setTotal(0.0f);
		gas_data1.setG(0);
		
	}

}
