package lab2

import lab2.utils.{Utils, Euler}

object DrainingTank extends App {

  /**
   * model draining a tank (dh/dt = -aH/aW*sqrt(2*g*h))
   * analytic solve: h = (Ah/Aw * t - C)^2 * g/2; C = sqrt(2*startHeightOfWater/g)
   *
   * @param aH - area of the hole
   * @param aW - the constant area of the upper surface of the water
   * @param startHeightOfWater - initial height of water in tank
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def drainingTank(aH: Double, aW : Double, startHeightOfWater: Double, dt: Double, allSteps: Int) = {
    def aHW = -aH/aW
    def g = 9.8
    val result = Euler.euler(x => aHW*Math.sqrt(2*g*x), x => x > 0, 0, startHeightOfWater, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (height of water)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\DrainingTank.csv")
    println(resultCSVStr)
  }

  drainingTank(1, 2, 10, 0.01, 1000)
}