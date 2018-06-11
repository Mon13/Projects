package output_processor_strategy;

public class CancelMessage1 extends CancelMessage{

	@Override
	public void cancelMsg() {
		System.out.println("\n Operation is cancelled \n");
	}

}
