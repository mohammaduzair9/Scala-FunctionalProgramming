object logical {

  def XOR(expr1: Boolean, expr2:Boolean): Boolean = {
    if (expr1 == expr2) {
      false
    }
    else
      true
  }

  def AND(expr1: Boolean, expr2:Boolean): Boolean = {
    if (expr1 && expr2) {
      true
    }
    else
      false
  }

  def NAND(expr1: Boolean, expr2:Boolean): Boolean = {
    !AND(expr1, expr2)
  }
}

