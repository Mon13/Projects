package output_processor_strategy;

import data_store.Data_Store_GasPump1;

public class SetPrice1 extends SetPrice{
	
private  Data_Store_GasPump1 gas_data1;
	
	public SetPrice1(Data_Store_GasPump1 gas_data1) {
        this.gas_data1 = gas_data1;
    }

	@Override
	public void setPrice(int g, int m) {
		
		float a=gas_data1.getReg_price();
	    float b=gas_data1.getDiesel_price();
	    System.out.println("reg pri"+a);
	    System.out.println("dies pri"+b);
	    
	       if( g == 1){
	    	   gas_data1.setPrice(a);
	       }
	       else if (g == 4)
	    	   gas_data1.setPrice(b);
		
	}
}
