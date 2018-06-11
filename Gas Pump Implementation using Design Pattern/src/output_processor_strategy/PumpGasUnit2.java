package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class PumpGasUnit2 extends PumpGasUnit {

private  Data_Store_GasPump2 gas_data2;
	
	public PumpGasUnit2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	
	@Override
	public void pumpGasUnit() {
		
		   int l=gas_data2.getL();
	       l=l+1;
	       float total;
	       float price = gas_data2.getPrice();
	       total = price * l;
	       gas_data2.setL(l);
	       gas_data2.setTotal(total);
	
	}

}
