package input_processor;

import java.util.Scanner;

import mda_esfm_state_pattern.MDA_ESFM;
import data_store.Data_Store_GasPump1;
import data_store.Data_Store_GasPump2;
import fixed_values.Operation_values;

public class Gas_Pump2_inp_proc extends Input_Processor {
	
	private Data_Store_GasPump2 ds_gas2;
	private MDA_ESFM mda_gas2;
	 
	 public Gas_Pump2_inp_proc(Data_Store_GasPump2 ds_gas2,  MDA_ESFM mda_gas2) {
	        this.mda_gas2 = mda_gas2;
	        this.ds_gas2 = ds_gas2;
	    }
 
	 
	public void Activate(float a,float  b,float c) {
        if ( (a > 0) && (b>0) && (c>0) ){
            ds_gas2.setTemp_a(a);
            ds_gas2.setTemp_b(b);
            ds_gas2.setTemp_c(c);
            mda_gas2.Activate();
        } else {
            System.out.println("Invalid Input");
        }
    }
 
 
 public void PayCash(int d){
	 
	 if(d>0)
	 { 
		 ds_gas2.setTemp_cash(d);
		 mda_gas2.Start();
		 mda_gas2.PayType(2);
	 }
	 else{
            System.out.println("Invalid Input");
        }
 }
 
 public void  PayCredit() 
 {
	 mda_gas2.Start();
	 mda_gas2.PayType(1);
	 }
 
 public void Reject(){
	 
	 mda_gas2.Reject();
 }
 
 public void Approved() {
	 mda_gas2.Approved();
 } 
  
 public void Cancel(){
	 
	 mda_gas2.Cancel();
 }


 public void Super(){
	 mda_gas2.SelectGas(3);
	 mda_gas2.Continue();
 }
 
 public void Regular(){
	 	 mda_gas2.SelectGas(1);
	 	mda_gas2.Continue();
 }

 public void Premium(){
 	 mda_gas2.SelectGas(2);
 	mda_gas2.Continue();
}
 
 public void StartPump(){
	 
		 mda_gas2.StartPump();
	 
 }
 
 public void PumpLiter(){
	 
	 	float cash = ds_gas2.getCash();
    	float price =ds_gas2.getPrice();
    	float L = ds_gas2.getL();
    	
    	if((cash >0) && (cash < (L+1) *price))
    	{
    		System.out.println("Cash isnt sufficient !"); 
    		mda_gas2.StopPump();
    	}
    	else
    	{
    		 mda_gas2.Pump();
    	}
	
 }
 
 public void StopPump(){
	 mda_gas2.StopPump();
	 
 }
 
 public void Receipt(){
	 mda_gas2.Receipt();
 }
 
 public void NoReceipt(){
	 
	 mda_gas2.NoReceipt();
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
				 float a = printOperationGetFloatInput(in, "Activate(a,b,c)", "a(RegularGas Price)):");
                 float b = getFloatOperationInput(in, "b(PremiumGas Price):");
                 float c = getFloatOperationInput(in, "c(SuperGas Price):");
               
               
               Activate(a,b,c);
               break;
               
			 
               
			 case PayCash:
				 int g = getIntOperationInput(in, "g(Enter cash):");
				 printOperation("PaybyCash()");

               PayCash(g);
               break;
               
			 case PayCredit:
				 printOperation("PayCredit()");

               PayCredit();
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
               
			   
			 case Super:
				 printOperation("SuperGas Selected()");
               Super();
               break;
               
			 case Regular:
				 printOperation("RegularGas Selected()");
               Regular();
               break;
               
			 case Premium:
				 printOperation("PremiumGas Selected()");

               Premium();
               break;

			 case Approved:
	               printOperation("Approved()");
	               Approved();
	               break;
               
			 case StartPump:
               printOperation("Start Pump");
               StartPump();
               break;
               
			 case Pump:
				 printOperation("Pump Gas");
               PumpLiter();
				 break;
			
			 case StopPump:
				 printOperation("Stop pump");
               StopPump();
				 break;
			
			 case Receipt:
				 printOperation("Receipt Requested");
               Receipt();
				 break;
			
			 case NoReceipt:
				 printOperation("No Receipt");
               NoReceipt();
				 break;
			
			 case Exit:
				 flag = false;
                break;
			
               
			 default:
               System.out.println("Invalid option");
               break;
			 }
			 System.out.println();
		 }catch(Exception e){
			 
		 }
	 }
	 System.out.println("GasPump 2 exiting.");
 }
 
 public void display() {
        System.out.println();
        System.out.println(" WELCOME TO GASPUMP 2");
        System.out.println("0. Activate(int,int,int) - TYPE 0");
        System.out.println("1. PayCash()  - TYPE 4");
        System.out.println("2. PayCredit() - TYPE  2");
        System.out.println("3. Approved() - TYPE 7");
        System.out.println("4. Reject()  - TYPE 5");
        System.out.println("5. Cancel()  - TYPE 6");
        System.out.println("6. Premium() - TYPE 13");
        System.out.println("7. Regular()  - TYPE 11");
        System.out.println("8. Super()  - TYPE 12");
        System.out.println("9. StartPump() - TYPE 8");
        System.out.println("10.PumpLiter()  - TYPE 9");
        System.out.println("11.Stop()  - TYPE 10");
        System.out.println("12.Receipt()  - TYPE 15");
        System.out.println("13.NoReceipt()  - TYPE 16");
        System.out.println("14. Exit  - TYPE 21");
    }




@Override
public void input() {
	process();	
}
}

		

