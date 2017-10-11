object basic {
  def main(args: Array[String]): Unit = {

    //Task 1
    val myList =  List.fill(10)(100).map(scala.util.Random.nextInt)
    val nth = 3
    val lastN = lastNthElement.lastNth(n = nth,list = myList)
    println("The Generated list is")
    println(myList)
    println("The element number " + nth + " of this list is   " + lastN)

    //Task2
    val lastN2 = lastNthElement.lastNthRecursive(n = nth,list = myList)
    println("The Generated list is")
    println(myList)
    println("The element number " + nth + " of this list is   " + lastN2)

    //Task3
    val checkPrime = 4
    val resPrime = Prime.isPrime(checkPrime,checkPrime/2)
    print(resPrime)
    if(resPrime==1) println("The number "+ checkPrime + " is a prime number")
    else println("The number "+ checkPrime + " is not a prime number")

    //Task4
    val num1 = 21
    val num2 = 18
    val checkCoPrime = coPrime.areCoPrimes(num1,num2)
    if(checkCoPrime==1) println("The numbers "+ num1 +"and" + num2 + " are co primes")
    else println("The numbers "+ num1 +" and " + num2 + " are not co primes")

    val expr1=true
    val expr2=false

    //Task5
    val resXOR = XOR(expr1,expr2)
    println("The result of XOR of "+expr1 +" and " +expr2+" is " + resXOR)

    //Task6
    val resAND = AND(expr1,expr2)
    println("The result of AND of "+expr1 +" and " +expr2+" is " + resAND)

    //Task7
    val resNAND = AND(expr1,expr2)
    println("The result of NAND of "+expr1 +" and " +expr2+" is " + resNAND)

  }




}

