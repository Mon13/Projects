package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class Receipt2 extends Receipt{
private  Data_Store_GasPump2 gas_data2;
	
	public Receipt2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	
	@Override
	public void printReceipt() {
		int L=gas_data2.getL();
      	System.out.printf(" \n Total Litres of Gas pumped is "+L);
      	
		float total = gas_data2.getTotal();
      	System.out.printf("\n Total amount is "+total);
      
	}

}
