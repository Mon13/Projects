package output_processor_strategy;

import data_store.Data_Store_GasPump2;

public class SetPrice2 extends SetPrice{

private  Data_Store_GasPump2 gas_data2;
	
	public SetPrice2(Data_Store_GasPump2 gas_data2) {
        this.gas_data2 = gas_data2;
    }
	@Override
	public void setPrice(int g, int m) {
		
		   float a=gas_data2.getSuper_price();
	       float c=gas_data2.getRegular_price();
	       float b=gas_data2.getPremium_price();
	       
	       if( g== 1)
	    	   gas_data2.setPrice(c);
	       else if (g == 2)
	    	   gas_data2.setPrice(b);
	       else if (g == 3)
	    	   gas_data2.setPrice(a);
	}

}
