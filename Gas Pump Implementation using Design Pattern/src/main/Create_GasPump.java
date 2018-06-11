package main;

import input_processor.Input_Processor;
import output_processor_strategy.Output_Processor;
import mda_esfm_state_pattern.MDA_ESFM;
import data_store.Data_Store;
import fixed_values.GasPump_values;
import abstract_factory_pattern.Abstract_Factory;
import abstract_factory_pattern.GasPump1_Factory;
import abstract_factory_pattern.GasPump2_Factory;

public class Create_GasPump {

	private static Create_GasPump ourInstance = new Create_GasPump();

    public static Create_GasPump getInstance() {
        return ourInstance;
    }

    public void assign(GasPump_values account) {
    	
        final Abstract_Factory accountFactory = createFactory(account);
        final Data_Store data_store = accountFactory.create_data_store();
        Output_Processor op = accountFactory.createOutput_Processor(data_store);
        MDA_ESFM model = new MDA_ESFM(op);
        Input_Processor inputProcessor = accountFactory.createInputProcessor(data_store, model);
        inputProcessor.input();
    }
    
    public static Abstract_Factory createFactory(GasPump_values account) {
        if (GasPump_values.GasPump1.equals(account)) {
            return new GasPump1_Factory();
        } else if (GasPump_values.GasPump2.equals(account)) {
            return new GasPump2_Factory();
        } else {
            System.out.println("Invalid parameter");
        }
		return null;
    }
}



