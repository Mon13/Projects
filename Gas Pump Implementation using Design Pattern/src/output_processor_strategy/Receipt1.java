package output_processor_strategy;

import data_store.Data_Store_GasPump1;

public class Receipt1 extends Receipt{
	
private  Data_Store_GasPump1 gas_data1;
	
	public Receipt1(Data_Store_GasPump1 gas_data1) {
        this.gas_data1 = gas_data1;
    }
	
	@Override
	public void printReceipt() {
		int G=gas_data1.getG();
      	System.out.printf(" \n Total Gallon's of Gas pumped is "+G);

		float total = gas_data1.getTotal();
      	System.out.printf("\n Amount is "+total);
      	
	}

}
