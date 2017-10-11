object Prime {
  def isPrime(n: Int, i:Int): Int = {
    if(i==1)
      return 1
    else if(n%i==0)
      return 0
    else
      isPrime(n,i-1)
  }

}
