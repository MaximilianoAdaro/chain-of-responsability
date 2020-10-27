public class Dollar100Dispenser implements DispenserHandler {

  private DispenserHandler next;

  @Override
  public void setNextHandler(DispenserHandler nextChain) {
    this.next = nextChain;
  }

  @Override
  public void dispense(Currency cur) {
    if (cur.getAmount() >= 100) {
      int num = cur.getAmount() / 100;
      int remainder = cur.getAmount() % 100;
      System.out.println("Dispensing " + num + " 100$ note");
      if (remainder != 0) this.next.dispense(new Currency(remainder));
    } else {
      this.next.dispense(cur);
    }
  }

}