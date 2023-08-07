package csw.params

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
