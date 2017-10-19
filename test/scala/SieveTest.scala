import org.scalatest.{Matchers, FunSuite}

class  SieveTest extends FunSuite with Matchers {
  test("A"){SieveOfEratosthenes.calculatePrimesStream(10) should be (List(2, 3, 5, 7))}

  test("B"){SieveOfEratosthenes.calculatePrimesStream(20) should be (List(2, 3, 5, 7, 11, 13, 17, 19))}

  test("C"){SieveOfEratosthenes.calculatePrimesStream(30) should be (List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29))}

  test("D"){SieveOfEratosthenes.calculatePrimesStream(40) should be (List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37))}

  test("E"){SieveOfEratosthenes.calculatePrimesStream(50) should be (List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47))}

}
