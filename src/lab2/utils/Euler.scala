package lab2.utils

object Euler {
   /**
    * solve first-order differential equation with Euler method
    * @param f - function
    * @param p - function for stop counts
    * @param x - initial (first) value of x, default use 0 (time)
    * @param y - initial (first) value of y
    * @param dt - step of time
    * @param allSteps - number of all steps
    */
   def euler(f: Double => Double, p: Double => Boolean, x: Double, y: Double, dt: Double, allSteps: Int): List[(Double, Double)] = {
     def eulerIn(i: Int, points: List[(Double, Double)]): List[(Double, Double)] = {
       if(i >= allSteps || !p(points(i)._2)) points
       else eulerIn(i+1, points ::: List((points(i)._1 + dt, points(i)._2 + dt*f(points(i)._2))))
     }
     eulerIn(0, List[(Double, Double)]((x, y)))
   }

  /**
   * solve second-order differential equation with Euler method
   * @param f - function
   * @param p - function for stop counts
   * @param x - initial (first) value of x, default use 0 (time)
   * @param y = y(x) initial (first) value of y (coordinate)
   * @param u = y'(x)
   * @param dt - step of time
   * @param allSteps - number of all steps
   * @return
   */
   def euler2(f: Double => Double, p: Double => Boolean, x: Double, y: Double, u: Double, dt: Double, allSteps: Int): List[(Double, Double)] = {
     def eulerIn(i: Int, points: List[(Double, Double)], u: Double): List[(Double, Double)] = {
       if(i >= allSteps || !p(points(i)._2)) points
       else eulerIn(i+1, points ::: List((points(i)._1 + dt, points(i)._2 + dt*u)), u + dt*f(u))
     }
     eulerIn(0, List[(Double, Double)]((x, y)), u)
   }

  /**
   * solve second-order differential equation with Euler method
   * @param f - another function
   * @param p - function for stop counts
   * @param x - initial (first) value of x, default use 0 (time)
   * @param y = y(x) initial (first) value of y (coordinate)
   * @param u = y'(x)
   * @param dt - step of time
   * @param allSteps - number of all steps
   * @return
   */
  def euler2(f: (Double, Double) => Double, p: Double => Boolean, x: Double, y: Double, u: Double, dt: Double, allSteps: Int): List[(Double, Double)] = {
    def eulerIn(i: Int, points: List[(Double, Double)], u: Double): List[(Double, Double)] = {
      if(i >= allSteps || !p(points(i)._2)) points
      else eulerIn(i+1, points ::: List((points(i)._1 + dt, points(i)._2 + dt*u)), u + dt*f(u, points(i)._2 + dt*u))
    }
    eulerIn(0, List[(Double, Double)]((x, y)), u)
  }
 }