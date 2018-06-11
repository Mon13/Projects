package output_processor_strategy;

import data_store.Data_Store_GasPump1;

public class PumpGasUnit1 extends PumpGasUnit{

private  Data_Store_GasPump1 gas_data1;
	
	public PumpGasUnit1(Data_Store_GasPump1 gas_data1) {
        this.gas_data1 = gas_data1;
    }
	
	@Override
	public void pumpGasUnit() {
		
		   int g=gas_data1.getG();
	       g=g+1;
	       float total;
	       float price = gas_data1.getPrice();
	       total = price * g;
	       gas_data1.setG(g);
	       gas_data1.setTotal(total);
	
	}

}
