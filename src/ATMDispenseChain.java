import java.util.Scanner;

public class ATMDispenseChain {

  private final DispenserHandler c1;

  public ATMDispenseChain() {
    // initialize the chain
    this.c1 = new Dollar100Dispenser();
    DispenserHandler c2 = new Dollar50Dispenser();
    DispenserHandler c3 = new Dollar20Dispenser();
    DispenserHandler c4 = new Dollar10Dispenser();

    // set the chain of responsibility
    c1.setNextHandler(c2);
    c2.setNextHandler(c3);
    c3.setNextHandler(c4);
  }

  public static void main(String[] args) {
    ATMDispenseChain atmDispenser = new ATMDispenseChain();
    while (true) {
      int amount;
      System.out.println("Enter amount to dispense");
      Scanner input = new Scanner(System.in);
      amount = input.nextInt();
      if (amount % 10 != 0) {
        System.out.println("Amount should be in multiple of 10s.");
      } else {
        // process the request
        atmDispenser.c1.dispense(new Currency(amount));
      }
      System.out.println();
    }

  }

}