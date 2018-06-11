package output_processor_strategy;


public class Output_Processor {
	
    private StorePrice store_price;
    private PayMessage pay_message;
    private StoreCash store_cash;
    private DisplayMenu display_menu;
    private RejectMessage reject_message;
    private SetPrice set_price;
    private ReadyMessage ready_message;
    private InitialValues initial_values;
    private PumpGasUnit pump_gas_unit;
    private GasPumpedMessage gas_pump_message;
    private StopMessage stop_message;
    private Receipt receipt;
    private CancelMessage cancel_message;
    private ReturnCash return_cash;
    private WrongPinMessage wrong_pin_message; 
    private StorePin store_pin;
    private EnterPinMessage pin_message; 
    private InitializeData initialize_data;
    
	public void setStore_price(StorePrice store_price) {
		this.store_price = store_price;
	}
	public void setPay_message(PayMessage pay_message) {
		this.pay_message = pay_message;
	}
	public void setStore_cash(StoreCash store_cash) {
		this.store_cash = store_cash;
	}
	public void setDisplay_menu(DisplayMenu display_menu) {
		this.display_menu = display_menu;
	}
	public void setReject_message(RejectMessage reject_message) {
		this.reject_message = reject_message;
	}
	public void setSet_price(SetPrice set_price) {
		this.set_price = set_price;
	}
	public void setReady_message(ReadyMessage ready_message) {
		this.ready_message = ready_message;
	}
	public void setInitial_values(InitialValues initial_values) {
		this.initial_values = initial_values;
	}
	public void setPump_gas_unit(PumpGasUnit pump_gas_unit) {
		this.pump_gas_unit = pump_gas_unit;
	}
	public void setGas_pump_message(GasPumpedMessage gas_pump_message) {
		this.gas_pump_message = gas_pump_message;
	}
	public void setStop_message(StopMessage stop_message) {
		this.stop_message = stop_message;
	}
	public void setReceipt(Receipt receipt) {
		this.receipt = receipt;
	}
	public void setCancel_message(CancelMessage cancel_message) {
		this.cancel_message = cancel_message;
	}
	public void setReturn_cash(ReturnCash return_cash) {
		this.return_cash = return_cash;
	}
	public void setWrong_pin_message(WrongPinMessage wrong_pin_message) {
		this.wrong_pin_message = wrong_pin_message;
	}
	public void setStore_pin(StorePin store_pin) {
		this.store_pin = store_pin;
	}
	public void setPin_message(EnterPinMessage pin_message) {
		this.pin_message = pin_message;
	}
	public void setInitialize_data(InitializeData initialize_data) {
		this.initialize_data = initialize_data;
	}
	
	
	public void readyMsg() {
		ready_message.readyMsg();
		
	}
	
	public void wrongPinMsg() {
		wrong_pin_message.wrongPinMsg();
		
	}
	public void payMsg() {
		pay_message.payMsg() ;
		
	}
	public void displayMenu() {
		display_menu.displayMenu();
		
	}
	public void storeCash() {
		store_cash.storeCash();
		
	}
	public void returnCash() {
		return_cash.returnCash(); 
		
	}
	public void printReceipt() {
		receipt.printReceipt();
		
	}
	public void setInitialValues() {
		initial_values.setInitialValues();
		
	}
	public void cancelMsg() {
		cancel_message.cancelMsg();
		
	}
	public void enterPinMsg() {
		pin_message.enterPinMsg();
		
	}
	public void pumpGasUnit() {
		pump_gas_unit.pumpGasUnit();
		
	}
	public void gasPumpedMsg() {
		gas_pump_message.gasPumpedMsg();
		
	}
	public void stopMsg() {
		stop_message.stopMsg();
	}
	public void rejectMsg() {
		reject_message.rejectMsg();
		
	}
	public void storePin() {
		store_pin.storePin();
		
	}
	
	public void storePrice() {
		store_price.storePrice();
		
	}
    
	public void setPrice(int g, int M) {
		set_price.setPrice(g,M);
		
	}
	public void initializeData() {
		initialize_data.initializeData();
		
	}
    
}
