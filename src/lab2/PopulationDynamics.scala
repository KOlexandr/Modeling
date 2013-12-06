package lab2

import lab2.utils.{Utils, Euler}

object PopulationDynamics extends App {

  /**
   * model human population growth by means of mathematics (dP/dt = k*P)
   * analytic solve : P = C*exp(k*t); C = startPopulation
   * @param k - constant of population  (k > 0)
   * @param startPopulation - population at the start of modeling (startPopulation > 0)
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def drainingTank(k: Double, startPopulation: Double, dt: Double, allSteps: Int) = {
    val result = Euler.euler(x => k*x, x => true, 0, startPopulation, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (population)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\PopulationDynamics.csv")
    println(resultCSVStr)
  }

  drainingTank(2, 2, 0.001, 1000)
}