public interface DispenserHandler {

  void setNextHandler(DispenserHandler nextChain);

  void dispense(Currency cur);
}