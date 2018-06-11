package input_processor;

import java.util.Scanner;

import abstract_factory_pattern.GasPump1_Factory;
import mda_esfm_state_pattern.MDA_ESFM;
import data_store.Data_Store_GasPump1;
import fixed_values.Operation_values;

public class Gas_Pump1_inp_proc extends Input_Processor {
	
	private Data_Store_GasPump1 ds_gas1;
	private MDA_ESFM mda_gas1;

	 public Gas_Pump1_inp_proc(Data_Store_GasPump1 ds_gas1,  MDA_ESFM mda_gas1) {
	        this.mda_gas1 = mda_gas1;
	        this.ds_gas1 = ds_gas1;
	    }
	
	public void Activate(float a,float  b) {
        if (( a > 0) && (b>0)) {
       
            ds_gas1.setTemp_a(a);
            ds_gas1.setTemp_b(b);
            mda_gas1.Activate();
        } else {
            System.out.println("Invalid Input");
        }
    }
 
 public void Start()
 {
	mda_gas1.Start();
	
 }
 
 public void PayCredit(){
	 
		mda_gas1.PayType(1);
		
	 
 }
 
 public void PayDebit(String p){
	 
	 	ds_gas1.setTemp_pin(p);
		mda_gas1.PayType(3);
	 
}

 
 public void Pin(String x) {
	 String pin = ds_gas1.getPin();

 if (pin.equals(x))
	 mda_gas1.CorrectPin(); 
 else 
	 mda_gas1.IncorrectPin();
 }
 
 public void Reject(){
	mda_gas1.Reject();
 }
 
 public void Cancel(){
	mda_gas1.Cancel();
 }

 public void Approved(){
	mda_gas1.Approved();
 }
 
 public void Diesel(){
	mda_gas1.SelectGas(4);
 }
 
 public void Regular(){
	 	mda_gas1.SelectGas(1);
	 
 }
 
 public void StartPump(){
	 float price = ds_gas1.getPrice();
	
	 if (price > 0) 
	 {
		 
		 mda_gas1.Continue();
		mda_gas1.StartPump();
	 }
 }
 
 public void PumpGallon(){
	mda_gas1.Pump();
 }
 
 public void StopPump(){
	mda_gas1.StopPump();
	mda_gas1.Receipt();
 }
 
 public void FullPump(){
	mda_gas1.StopPump();
	mda_gas1.Receipt();
 }

@Override
public void input() {
	process();
}

public void process(){
	boolean flag = true;
	 Operation_values opCode = null;
	 

	 
	 while(flag){
		 
		 display();
		 Scanner in = new Scanner(System.in);
		 
		 
		 try{
			 int option = getIntInput(in, null);
			 opCode = Operation_values.value(option);
			 
			 switch(opCode){
			 
			 case Activate:
			   float a = printOperationGetFloatInput(in, "Activate(a,b)", "a(RegularGas Price)):");
               float b = getFloatOperationInput(in, "b(DieselPrice Gas Price):");
               Activate(a,b);
               break;
               
			 case Start:
				   printOperation("Start()");
				   mda_gas1.Start();
                   break;
               
			 case PayCredit:
				 printOperation("PayCredit()");

               PayCredit();
               break;
               
               
			 case PayDebit:
				 
				 String pinx = printOperationGetStringInput(in, "PayDebit(String p)", "pin");
	         
	             PayDebit(pinx);
               break;
               
			 case Pin:
				// printOperation("Pin()");
				String pin_check = printOperationGetStringInput(in, "Pin(String x)", "Pin:");
	             
	             Pin(pin_check);
               break;
               
			 case Reject:
               printOperation("Rejected()");

               Reject();
               break;
               
			 case Cancel:
				 flag=false;
				 printOperation("Cancel()");

               Cancel();
            
               break;
               
			 case Approved:
               printOperation("Approved()");
               Approved();
               break;
               
			 case Diesel:
				 printOperation("Diesel Selected()");

               Diesel();
               break;
               
			 case Regular:
				 printOperation("Regular Selected()");

               Regular();
               break;
               
			 case StartPump:
               printOperation("Start Pump");
               StartPump();
               break;
               
			 case Pump:
				 printOperation("Pump Gas");
               PumpGallon();
				 break;
			
			 case StopPump:
				 printOperation("Stop pump");
               StopPump();
				 break;
				 
			 
				 
			 case Exit:
				 flag = false;
                break;
			
               
			 default:
               println("Invalid option");
               break;
			 }
			 System.out.println();
		 }catch(Exception e){
			 
		 }
	 }
	 System.out.println("GasPump 1 Exit");
}

public void display() {
	
	System.out.println("WELCOME TO GASPUMP1");
	System.out.println("Activate(float,float) - TYPE 0");	
	System.out.println("Start() - TYPE 1");	
	System.out.println("PayCredit() - TYPE 2");
	System.out.println("Reject() - TYPE 5");
	System.out.println("PayDebit(String p)  - TYPE 3");
	System.out.println("Pin(String x)  - TYPE 20");
	System.out.println("Cancel()  - TYPE 6");
	System.out.println("Approved()  - TYPE 7");
	System.out.println("Diesel() - TYPE 14");
	System.out.println("Regular() - TYPE 11");
	System.out.println("StartPump() - TYPE 8");
	System.out.println("PumpGallon() - TYPE 9");
	System.out.println("StopPump() - TYPE  10");
	System.out.println("FullTank() - TYPE 10");
	System.out.println("Exit  - TYPE 21");
     
   }

	
}
 


