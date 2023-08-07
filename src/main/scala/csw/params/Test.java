package csw.params;

public class Test {

    public void shouldConvertPmToFromJSON() {
        var pm = new ProperMotion(0.5, 2.33);
        var pmjs = JsonSupport.writes(pm, ProperMotion.properMotionCodec().encoder());
    }
}
