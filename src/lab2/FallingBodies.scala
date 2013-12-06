package lab2

import lab2.utils.{Utils, Euler}

object FallingBodies extends App {

  /**
   * mathematical model of the motion of a body moving in a force field
   * (d2s/dt2 = -g, s(0)=s0, s'(0)=v0)
   * analytic solve: s = -g*(t^2)/2 + C1*t + C2; C1 = v0, C2 = s0
   *
   * @param s0 - height of the building
   * @param v0 - initial velocity
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def fallingBodies(s0: Double, v0: Double, dt: Double, allSteps: Int) = {
    val g = 9.8
    val result = Euler.euler2(x => -g, x => x > 0, 0, s0, v0, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (height/position of body)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\FallingBodies.csv")
    println(resultCSVStr)
  }

  fallingBodies(10, 1, 0.01, 1000)
}