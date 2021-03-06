public class Dollar20Dispenser implements DispenserHandler {

  private DispenserHandler next;

  @Override
  public void setNextHandler(DispenserHandler nextChain) {
    this.next = nextChain;
  }

  @Override
  public void dispense(Currency cur) {
    if (cur.getAmount() >= 20) {
      int num = cur.getAmount() / 20;
      int remainder = cur.getAmount() % 20;
      System.out.println("Dispensing " + num + " 20$ note");
      if (remainder != 0) this.next.dispense(new Currency(remainder));
    } else {
      this.next.dispense(cur);
    }
  }

}