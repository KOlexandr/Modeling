package lab2

import lab2.utils.{Utils, Euler}

object RadioactiveDecay extends App {

  /**
   * model the phenomenon of radioactive decay (dA/dt = k*A)
   * analytic solve: A = C*exp(k*t); C = startRadioactiveAtomsCount
   * @param k - constant of decay (k < 0)
   * @param startRadioactiveAtomsCount - radioactive decay init value (number of radioactive atoms)
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def radioactiveDecay(k: Double, startRadioactiveAtomsCount: Double, dt: Double, allSteps: Int) = {
    val result = Euler.euler(x => k*x, x => x > 0, 0, startRadioactiveAtomsCount, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (decay)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\RadioactiveDecay.csv")
    println(resultCSVStr)
  }

  radioactiveDecay(-2, 2, 0.001, 1000)
}