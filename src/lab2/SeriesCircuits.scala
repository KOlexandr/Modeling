package lab2

import lab2.utils.{Utils, Euler}

object SeriesCircuits extends App {

  /**
   * Consider the single-loop LRC-series circuit shown in containing an inductor, resistor, and capacitor
   * L*d2q/dt2 + R*dq/dt + 1/C*q = E(t)
   * L, R, and C are generally constants
   * 
   * L*di/dt=L*d2q/dt2 - inductor, 
   * i*R=R*dq/dt - resisto, 
   * 1/C*q - capacito
   * q(t) - charge on a capacitor at time t
   * i = dq/dt
   * E(t) - the impressed voltage on a closed loop
   *
   * @param L - inductance
   * @param R - resistance
   * @param C - capacitance
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def seriesCircuits(L: Double, R: Double, C: Double, dt: Double, allSteps: Int) = {
    def E = 1
    val result = Euler.euler2((x, y) => (Math.sin(x) - R*x - 1/C*y)/L, x => x > 0, 0, E, 0, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (impressed voltage)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\SeriesCircuits.csv")
    println(resultCSVStr)
  }

  seriesCircuits(1, 1, 0.01, 0.01, 1000)
}
