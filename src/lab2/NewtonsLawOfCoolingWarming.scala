package lab2

import lab2.utils.{Utils, Euler}

object NewtonsLawOfCoolingWarming extends App {

  /**
   * represents the temperature of a body at time t (dT/dt = k*(T-Tm))
   * analytic solve: T = Tm + C*exp(k*t); C = startTempOfBody - tM
   * @param k - constant of proportionality (k < 0)
   * @param tM - temperature of the surrounding
   * @param startTempOfBody - initial the temperature of a body
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def newtonsLawOfCoolingWarming(k: Double, startTempOfBody: Double, tM: Double, dt: Double, allSteps: Int) = {
    val result = Euler.euler(x => k*(x - tM), x => x > tM, 0, startTempOfBody, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (temperature)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\NewtonsLawOfCoolingWarming.csv")
    println(resultCSVStr)
  }

  newtonsLawOfCoolingWarming(-2, 100, 10, 0.001, 1000)
}