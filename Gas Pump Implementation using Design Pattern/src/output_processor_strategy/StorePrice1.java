package output_processor_strategy;

import data_store.Data_Store_GasPump1;

public class StorePrice1 extends StorePrice {

private  Data_Store_GasPump1 gas_data1;
	
	public StorePrice1(Data_Store_GasPump1 gas_data1) {
        this.gas_data1 = gas_data1;
    }
	@Override
	public void storePrice() {
		float a, b;
		System.out.println("enterrrvasjcvjhvshkn");
	      a=gas_data1.getTemp_a();
	      gas_data1.setReg_price(a);
	      b=gas_data1.getTemp_b();
	      gas_data1.setDiesel_price(b);	
	      System.out.println(a +" values in store price "+ b );
		
	}

}
