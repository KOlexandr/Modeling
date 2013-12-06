package lab2

import lab2.utils.{Utils, Euler}

object SuspendedCables extends App {

  /**
   * one of the two cables supporting the roadbed of a suspension bridge
   * (dy/dx = w/t1)
   * analytic solve: y = w/t1*x + C; C = w
   * @param t1, t2, w - the magnitudes of input vectors
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def suspendedCables(w: Double, t1: Double, t2: Double, dt: Double, allSteps: Int) = {
    val result = Euler.euler(x => w/t1, x => x > 0, 0, w, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (coordinate)", "y (coordinate)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\SuspendedCables.csv")
    println(resultCSVStr)
  }

  suspendedCables(5, 1, 1, 0.01, 1000)
}