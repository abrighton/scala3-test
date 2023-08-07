package csw.params

class TestX {

  def shouldConvertPmToFromJSON(): Unit = {
    val pm = ProperMotion(0.5, 2.33)
    val pmjs = JsonSupport.writes(pm)
  }
}
