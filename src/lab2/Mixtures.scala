package lab2

import lab2.utils.{Utils, Euler}

object Mixtures extends App {

  /**
   * first-order differential equation for the amount of
   * salt contained in the mixture
   * analytic solve: A = iVolume*rOutWater*(C*exp(-t) + rInSalt*rInWater)
   * 
   * @param iVolume - initial (constant during all time) volume of water in tank
   * @param iSalt - initial concentration of the salt in tank (pounds per gallon)
   * @param rInSalt - concentration of salt in inflo (pounds per gallon)
   * @param rInWater - input rate of brine (gallon per minute)
   * @param rOutWater - output rate of brine (gallon per minute)
   * 
   * rOutSalt = A(t)/iVolume - concentration of salt in outflo
   * rIn = rInSalt*rInWater - input rate of salt (pounds per minute)
   * rOut = rOutSalt*rOutWater - output rate of salt (pounds per minute)
   * dA/dt=rIn-rOut => dA/dt=rInSalt*rInWater-A(t)/iVolume*rOutWater
   *
   * @param dt - step of time
   * @param allSteps - number of all steps
   */
  def mixtures(iVolume: Double, iSalt: Double, rInSalt: Double, rInWater: Double, rOutWater: Double, dt: Double, allSteps: Int) = {
    val result = Euler.euler(x => rInSalt*rInWater - x/iVolume*rOutWater, x => true, 0, iSalt, dt, allSteps)
    val resultCSVStr = Utils.toCSV(result, "x (time)", "y (amount of salt)", "\n", ", ")
    Utils.writeToFile(resultCSVStr, "d:\\Mixtures.csv")
    println(resultCSVStr)
  }

  mixtures(300, 1, 2, 3, 3, 0.01, 1000)
}