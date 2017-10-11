object Operations {

  def solveForValue(n: Int): Unit =  {

    val num1 = rand()
    val num2 = rand()
    val num3 = rand()
    val num4 = rand()
    val num5 = rand()
    var myVal = 0

    println("Randomly Generated list of 5 numbers is " + num1+ " " + num2+ " " + num3+ " " + num4+ " " + num5)

    val target=17;
    val nums= List(3,4,5)

    func(avail = nums,expr="", res=0,target)


  }

  def func(avail: List[Int], expr: String, res:Int,tar:Int ): Unit ={
    if(avail==Nil && res==tar){
        println(expr)
        return
    }

    func()

  }

  val a = 252149017;
  val c = 11;
  var previous = 0;

  def rseed(seed: Int): Unit =  {
    previous = seed;
  }

  def rand(): Int =  {
    val r = a * previous + c;
    previous = r;
    return r;
  }


}
