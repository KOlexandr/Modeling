package lab2

import lab2.utils.{Utils, Euler}

object ChemicalReactions extends App {

  /**
   * model of a second-order reaction (dX/dt = k*(alpha - X)*(beta - X))
   * analytic solve: ln((x-alpha)/(x-beta)) = (alpha-beta)*k*t + C
   * @param k - negative constant
   * @param alpha - is the amounts of the two chemicals A at t = 0
   * @param beta - is the amounts of the two chemicals B at t = 0
   * @param x - the start amount of chemical
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def chemicalReactions(k: Double, alpha: Double, beta: Double, x: Double, dt: Double, allSteps: Int) = {
    val result = Euler.euler(x => k*(alpha - x)*(beta - x), x => x >= (alpha+beta), 0, x, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (amount of chemical)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\ChemicalReactions.csv")
    println(resultCSVStr)
  }

  chemicalReactions(-0.01, 2, 2, 100, 0.01, 5000)
}