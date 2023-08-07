# scala3-test

This repo demonstrates an issue with a Java-17 function calling a Scala 3.3.0 macro and getting this error:

```
[error] /testDir/scala3-test/src/main/scala/csw/params/Test.java:7:1: cannot access io.bullet.borer.Encoder
[error]   bad class file: /home/user/.cache/coursier/v1/https/repo1.maven.org/maven2/io/bullet/borer-core_3/1.11.0/borer-core_3-1.11.0.jar(/io/bullet/borer/Encoder.class)
[error]     undeclared type variable: B
[error]     Please remove or make sure it appears in the correct subdirectory of the classpath.
```

The Scala class:

```scala 3
import java.nio.charset.StandardCharsets
import io.bullet.borer.*
import io.bullet.borer.derivation.CompactMapBasedCodecs.deriveCodec
import play.api.libs.json.{Json => PJson, _}

object JsonSupport extends JsonSupport

trait JsonSupport {
  def writes[T: Encoder](x: T): JsValue = PJson.parse(Json.encode(x).toUtf8String)
  def reads[T: Decoder](x: JsValue): T  = Json.decode(x.toString().getBytes(StandardCharsets.UTF_8)).to[T].value
}

case class ProperMotion(pmx: Double, pmy: Double)

object ProperMotion {
  implicit val properMotionCodec: Codec[ProperMotion] = deriveCodec
}
```

The Java class:

```java
public class Test {

    public void shouldConvertPmToFromJSON() {
        var pm = new ProperMotion(0.5, 2.33);
        var pmjs = JsonSupport.writes(pm, ProperMotion.properMotionCodec().encoder());
    }
}
```

And deriveCodec looks like this:

```scala 3
  inline def deriveCodec[T]: Codec[T] = Codec(deriveEncoder[T], deriveDecoder[T])
```

The class file is not corrupted (I have tested with multiple versions).
This seems to be an issue with Java calling an inline Scala function.

The Scala version compiles:

```scala 3
class TestX {

  def shouldConvertPmToFromJSON(): Unit = {
    val pm = ProperMotion(0.5, 2.33)
    val pmjs = JsonSupport.writes(pm)
  }
}
```

This type of code compiled previously under Scala-2.13.
