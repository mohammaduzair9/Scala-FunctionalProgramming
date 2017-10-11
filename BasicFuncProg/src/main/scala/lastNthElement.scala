object lastNthElement {

  //[T] defines Generic type
  //Function to calculate nth last element from a list

  def lastNth(list: List[Int], n: Int): Int = {

    if (n > list.length) throw new NoSuchElementException
    if (n <= 0) throw new IllegalArgumentException
    val reversed = reverse(list)
    reversed(n-1)
  }

  @annotation.tailrec
  def lastNthRecursive(list: List[Int], n: Int): Int = list match {
    case tail if (tail.length == n) => tail.head
    case _ :: tail => lastNthRecursive(tail, n)
    case _ => throw new IllegalArgumentException
  }

  def reverse(list: List[Int]): List[Int] = list match {
    case Nil => Nil
    case head :: Nil => List(head)
    case e1 :: e2 :: tail => reverse(tail) ++ List(e2, e1)
  }





}
