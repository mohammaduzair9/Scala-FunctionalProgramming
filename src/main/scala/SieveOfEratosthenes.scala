object SieveOfEratosthenes extends App{
  println("Enter a number you want to calculate primes till..")
  val end = scala.io.StdIn.readInt()
  println(calculatePrimesStream(end))

  def calculatePrimesStream(end: Int): List[Int] = {
    val odds = Stream.from(3, 2).takeWhile(_ <= Math.sqrt(end).toInt)
    val composites = odds.flatMap(i => Stream.from(i * i, 2 * i).takeWhile(_ <= end))
    2::Stream.from(3, 2).takeWhile(_ <= end).diff(composites).toList

  }
}
