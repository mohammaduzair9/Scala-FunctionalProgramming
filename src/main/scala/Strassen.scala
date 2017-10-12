object Strassen {

  def addMat(matA: Array[Array[Int]], matB: Array[Array[Int]]) = {
    val rows = matA.length
    val cols = matB.length

    val result = Array.ofDim[Int](rows, cols)

    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        result(i)(j) = matA(i)(j) + matB(i)(j)
      }
    }
    result
  }

  def subMat(matA: Array[Array[Int]], matB:Array[Array[Int]]) = {
    val rows = matA.length
    val cols = matB.length

    val result = Array.ofDim[Int](rows, cols)

    for (i <- 0 until rows) {
      for (j <- 0 until cols) {
        result(i)(j) = matA(i)(j) - matB(i)(j)
      }
    }
    result
  }

  def simpleMul(matA: Array[Array[Int]], matB: Array[Array[Int]]) = {
    val rows = matA.length
    val cols = matB.length

    val result = Array.ofDim[Int](rows, cols)

    for (i <- 0 until rows) {
      for (k <- 0 until matB.length) {
        for (j <- 0 until cols) {
          result(i)(j) += matA(i)(k) * matB(k)(j)
        }
      }
    }
    result
  }

  def initMatrix(mat: Array[Array[Int]], dim: Int) = {
    val res = Array.ofDim[Int](dim, dim)
    for (i <- 0 until mat.length) {
      for (j <- 0 until mat(0).length) {
        res(i)(j) = i+j
      }
    }
    res
  }


  def strassen(matA:Array[Array[Int]], matB:Array[Array[Int]], baseDim:Int): Array[Array[Int]] = {
    if (matA.length <= baseDim) {
      simpleMul(matA, matB)
    }
    else {
      val newDim = matA.length / 2

      val a00 = Array.ofDim[Int](newDim, newDim)
      val a01 = Array.ofDim[Int](newDim, newDim)
      val a10 = Array.ofDim[Int](newDim, newDim)
      val a11 = Array.ofDim[Int](newDim, newDim)

      val b00 = Array.ofDim[Int](newDim, newDim)
      val b01 = Array.ofDim[Int](newDim, newDim)
      val b10 = Array.ofDim[Int](newDim, newDim)
      val b11 = Array.ofDim[Int](newDim, newDim)

      for (i <- 0 until newDim) {
        for (j <- 0 until newDim) {
          a00(i)(j) = matA(i)(j)
          a01(i)(j) = matA(i)(j + newDim)
          a10(i)(j) = matA(i + newDim)(j)
          a11(i)(j) = matA(i + newDim)(j + newDim)

          b00(i)(j) = matB(i)(j)
          b01(i)(j) = matB(i)(j + newDim)
          b10(i)(j) = matB(i + newDim)(j)
          b11(i)(j) = matB(i + newDim)(j + newDim)
        }
      }


      val p1 = strassen(addMat(a00, a11), addMat (b00, b11), baseDim)
      val p2 = strassen(addMat (a10, a11), b00, baseDim)
      val p3 = strassen(a00, subMat (b01, b11), baseDim)
      val p4 = strassen(a11, subMat (b10, b00), baseDim)
      val p5 = strassen(addMat (a00, a01), b11, baseDim)
      val p6 = strassen(subMat (a10, a00), addMat (b00, b01), baseDim)
      val p7 = strassen(subMat (a01, a11), addMat (b10, b11), baseDim)

      val c11 = subMat (addMat(addMat (p1, p4),p7),p5)
      val c12 = addMat (p3, p5)
      val c21 = addMat (p2, p4)
      val c22 = subMat (addMat(addMat (p1, p3),p6),p2)

      val result = Array.ofDim[Int](matA.length,matB.length)

      for (i <- 0 until newDim) {
        for (j <- 0 until newDim) {
          result(i)(j) = c11(i)(j)
          result(i)(j + newDim) = c12(i)(j)
          result(i + newDim)(j) = c21(i)(j)
          result(i + newDim)(j + newDim) = c22(i)(j)
        }
      }
      result
    }
  }

  def dispMat(matA: Array[Array[Int]]): Unit ={
    println()
    for (row <- 0 to matA.length-1) {
      for (col <- 0 to matA.length-1) {
        print(" " + matA(row)(col))
      }
      println()
    }
  }


  def main(args:Array[String]):Unit = {

    println("Welcome To matrix Multiplication by Strassen Alogorithm")
    println("Enter the dimenewDimion of arrays you want to create. The dimension must be of 2^n")
    val dim = scala.io.StdIn.readInt()

    if((dim & (dim - 1)) != 0){
        println("This is not a power of two")
    }
    else {

      val baseDim = 2 // break into 2 until dimension is less than or equal to baseDim

      val mat1 = Array.ofDim[Int](dim, dim)
      val mat2 = Array.ofDim[Int](dim, dim)

      val matA = initMatrix(mat1, dim)
      val matB = initMatrix(mat2, dim)

      println("The matrix A is :")
      dispMat(matA)
      println("The matrix B is :")
      dispMat(matB)

      println("Result with Strassen Multiplication: ")
      val result = strassen(matA, matB, baseDim)
      dispMat(result)

      println("Result with Simple Multiplication: ")
      val result2 = simpleMul(matA, matB)
      dispMat(result2)
    }
  }
}
