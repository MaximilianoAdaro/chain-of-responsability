public class Dollar10Dispenser implements DispenserHandler {

  private DispenserHandler next;

  @Override
  public void setNextHandler(DispenserHandler nextChain) {
    this.next = nextChain;
  }

  @Override
  public void dispense(Currency cur) {
    if (cur.getAmount() >= 10) {
      int num = cur.getAmount() / 10;
      int remainder = cur.getAmount() % 10;
      System.out.println("Dispensing " + num + " 10$ note");
      if (remainder != 0) this.next.dispense(new Currency(remainder));
    } else {
      this.next.dispense(cur);
    }
  }

}