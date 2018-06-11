package input_processor;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Input_Processor {

	public abstract void input();

    protected int getIntOperationInput(Scanner in, String msg) {
        return getIntInput(in, "Enter parameter " + msg);
    }

    protected int getIntInput(Scanner in, String msg) {
        int p = -1;
        if (msg != null) {
            println(msg);
        }
        try {
            p = in.nextInt();
        } catch (InputMismatchException e) {
            println("Invalid data entered");
        }
        return p;
    }

    protected String getStringOperationInput(Scanner in, String msg) {
        return getStringInput(in, "Enter parameter " + msg);
    }

    protected String getStringInput(Scanner in, String msg) {
        String p = null;
        println(msg);
        try {
            p = in.next();
        } catch (InputMismatchException e) {
            println("Invalid data entered"); 
        }
        return p;
    }

    protected Float getFloatOperationInput(Scanner in, String msg) {
        return getFloatInput(in, "Enter parameter " + msg);
    }

    protected Float getFloatInput(Scanner in, String msg) {
        Float p = null;
        println(msg);
        try {
            p = in.nextFloat();
        } catch (InputMismatchException e) {
            println("Invalid data entered");
        }
        return p;
    }

    protected void println() {
        System.out.println();
    }

    protected void printOperation(String msg) {
        System.out.println("Operation performed " + msg);
    }

    protected void println(String msg) {
        System.out.println(msg);
    }

    protected int printOperationGetIntInput(Scanner in, String operationMsg, String inputMsg) {
        printOperation(operationMsg);
        return getIntOperationInput(in, inputMsg);
    }

    protected float printOperationGetFloatInput(Scanner in, String operationMsg, String inputMsg) {
        printOperation(operationMsg);
        return getFloatOperationInput(in, inputMsg);
    }

    protected String printOperationGetStringInput(Scanner in, String operationMsg, String inputMsg) {
        printOperation(operationMsg);
        return getStringOperationInput(in, inputMsg);
    }

    protected boolean isNonEmpty(String p) {
        return p != null && !p.isEmpty();
    }

}
