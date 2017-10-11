object coPrime {


  def areCoPrimes(num1: Int, num2: Int): Int =  {

    if(num1==0) num2
    else if(num2==0) num1
    else if(num1>num2) areCoPrimes(num1-num2,num2)
    else areCoPrimes(num1,num2-num1)
  }
}
