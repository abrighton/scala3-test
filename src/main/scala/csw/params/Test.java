package csw.params;

public class Test {
    private final ProperMotion pm = new ProperMotion(0.5, 2.33);

    public void shouldConvertPmToFromJSON() {
         var pmjs = JsonSupport.writes(pm, ProperMotion.properMotionCodec().encoder());
    }
}
