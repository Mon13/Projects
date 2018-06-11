package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class ReturnCash2 extends ReturnCash{

private  Data_Store_GasPump2 gas_data2;
	
	public ReturnCash2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	@Override
	public void returnCash() {
		
		float return_cash=gas_data2.getCash()-gas_data2.getTotal();
		if(return_cash >0 && return_cash!=0)
		{
			System.out.println("Remaining Cash is " + return_cash);
		}
		
	}

}
