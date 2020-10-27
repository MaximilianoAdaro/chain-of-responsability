public class Dollar50Dispenser implements DispenserHandler {

  private DispenserHandler next;

  @Override
  public void setNextHandler(DispenserHandler nextChain) {
    this.next = nextChain;
  }

  @Override
  public void dispense(Currency cur) {
    if (cur.getAmount() >= 50) {
      int num = cur.getAmount() / 50;
      int remainder = cur.getAmount() % 50;
      System.out.println("Dispensing " + num + " 50$ note");
      if (remainder != 0) this.next.dispense(new Currency(remainder));
    } else {
      this.next.dispense(cur);
    }
  }

}