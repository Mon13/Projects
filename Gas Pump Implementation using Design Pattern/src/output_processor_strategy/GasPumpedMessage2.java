package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class GasPumpedMessage2 extends GasPumpedMessage{
	
	private  Data_Store_GasPump2 gas_data2;

	public GasPumpedMessage2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	@Override
	public void gasPumpedMsg() {
		float l = gas_data2.getL();
    	System.out.printf("Gas is pumped sucessfully and " + l +"litres is filled ");
		
	}

}
