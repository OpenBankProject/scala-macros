import java.util.UUID.randomUUID

import com.tesobe.{CacheKeyFromArguments, CacheKeyOmit}


object TestCacheKey extends App {

  def memoizeSyncWithProvider[A](cacheKey: (String, String, String))(f: => A)(implicit m: Manifest[A]): A = {
    println("Cache key: " + cacheKey)
    f
  }

  def someFunction(father: String, mother: String, son: Option[String], daughter: Option[String]): String = {
    var cacheKey = (randomUUID().toString, randomUUID().toString, randomUUID().toString)
    CacheKeyFromArguments.buildCacheKey {
      memoizeSyncWithProvider (cacheKey) {
        val y: String = father + " - " + mother + " - " + son.getOrElse("") + " - " + daughter.getOrElse("")
        y
      }
    }
  }

  def someFunctionWithOmit(father: String, mother: String, son: Option[String], @CacheKeyOmit daughter: Option[String]): String = {
    var cacheKey = (randomUUID().toString, randomUUID().toString, randomUUID().toString)
    CacheKeyFromArguments.buildCacheKey {
      memoizeSyncWithProvider (cacheKey) {
        val y: String = father + " - " + mother + " - " + son.getOrElse("") + " - " + daughter.getOrElse("")
        y
      }
    }
  }

  val functionCall = someFunction("Marko", "Emilija", Some("Boris"), Some("Kalina"))
  println(functionCall)

  val functionCallWithOit = someFunctionWithOmit("Marko", "Emilija", Some("Boris"), Some("Kalina"))
  println(functionCallWithOit)

}