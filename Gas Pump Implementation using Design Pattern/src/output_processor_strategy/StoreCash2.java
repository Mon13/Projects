package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class StoreCash2 extends StoreCash{

private  Data_Store_GasPump2 gas_data2;
	
	public StoreCash2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	@Override
	public void storeCash() {
		int d;
		d=gas_data2.getTemp_cash();
		
		gas_data2.setCash(d);
		
	}

}
