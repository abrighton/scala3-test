package csw.params

class TestX {
  private val pm = new ProperMotion(0.5, 2.33)

  def shouldConvertPmToFromJSON(): Unit = {
    val pmjs = JsonSupport.writes(pm)
  }

}
