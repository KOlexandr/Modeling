package lab2

import lab2.utils.{Utils, Euler}

object FallingBodiesAndAirResistance extends App {

  /**
   * Falling Bodies and Air Resistance
   * (m*d2s/dt2 + k*ds/dt = mg, s(0)=s0, s'(0)=v0)
   * analytic solve: s = C1 + C2*exp(-k/m) + mg/k * t; C1 = s0, C2 = v0
   *
   * @param s0 - height of the building
   * @param v0 - initial velocity
   * @param m - is the mass of the body
   * @param k - positive constant of air resistance
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def fallingBodiesAndAirResistance(k: Double, m: Double, s0: Double, v0: Double, dt: Double, allSteps: Int) = {
    val g = 9.8
    val result = Euler.euler2(x => g - k/m*x, x => x > 0, 0, s0, v0, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (height/position of body)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\FallingBodiesAndAirResistance.csv")
    println(resultCSVStr)
  }

  fallingBodiesAndAirResistance(5, 5, 100, 1, 0.01, 1000)
}