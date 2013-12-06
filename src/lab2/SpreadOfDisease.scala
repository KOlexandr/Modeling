package lab2

import lab2.utils.{Utils, Euler}

object SpreadOfDisease extends App {

  /**
   * contagious disease—for example, a flu virus—is spread throughout
   * a community by people coming into contact with other people
   * analytic solve: x*(n+1-x) = C*exp((n+1)*k*t)
   *
   * (dx/dt = k*x*(n+1-x))
   * @param k - usual constant of proportionality
   * @param n - fixed population of people
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def spreadOfDisease(k: Double, n: Int, dt: Double, allSteps: Int) = {
    val result = Euler.euler(x => k*x*(n+1-x), x => x <= n, 0, 1, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (people)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\SpreadOfDisease.csv")
    println(resultCSVStr)
  }

  spreadOfDisease(2, 100, 0.001, 1000)
}
