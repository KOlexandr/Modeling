package lab2.utils

import scala.reflect.io.Path

object Utils {
  val EMPTY_STRING = ""

  /**
   * make string from list of pairs
   * @param list - list of points (number pairs)
   * @param first - title of first column
   * @param second - title of second column
   * @param lineCsvSeparator - line separator for string representation
   * @param wordCsvSeparator - word separator for string representation
   */
  def toCSV[T](list: List[(T, T)], first: String, second: String, lineCsvSeparator: String, wordCsvSeparator: String): String = {
    def toCSVIn(list: List[(T, T)]): String = {
      if(list.isEmpty) EMPTY_STRING
      else list.head._1 + wordCsvSeparator + list.head._2 + lineCsvSeparator + toCSVIn(list.tail)
    }
    first + wordCsvSeparator + second + lineCsvSeparator + toCSVIn(list)
  }

  /**
   * write string to file
   * @param text - string
   * @param path - path to file
   */
  def writeToFile(text: String, path: String) = Path(path).toFile.writeAll(text)
}