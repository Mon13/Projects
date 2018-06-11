package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class StorePrice2 extends StorePrice{
private  Data_Store_GasPump2 gas_data2;
	
	public StorePrice2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	@Override
	public void storePrice() {
		float a,b,c;
	      a=gas_data2.getTemp_a();
	      gas_data2.setRegular_price(a);
	      b=gas_data2.getTemp_b();
	      gas_data2.setPremium_price(b);
	      c=gas_data2.getTemp_c();
	      gas_data2.setSuper_price(c);
		
	}

}
