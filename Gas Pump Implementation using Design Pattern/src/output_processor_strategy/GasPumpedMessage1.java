package output_processor_strategy;

import data_store.Data_Store_GasPump1;

public class GasPumpedMessage1 extends GasPumpedMessage {

private  Data_Store_GasPump1 gas_data1;
	
	public GasPumpedMessage1(Data_Store_GasPump1 gas_data1) {
        this.gas_data1 = gas_data1;
    }
	@Override
	public void gasPumpedMsg() {
		float g = gas_data1.getG();
    	System.out.printf("Gas is pumped sucessfully and " +g +"gallon is filled \n");
		
	}

}
