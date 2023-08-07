package csw.params

import java.nio.charset.StandardCharsets

import io.bullet.borer.{Decoder, Encoder, Json}
import play.api.libs.json.{Json => PJson, _}

object JsonSupport extends JsonSupport

/**
 * Supports conversion of commands, state variables and events to/from JSON
 */
trait JsonSupport {
  def writes[T: Encoder](x: T): JsValue = PJson.parse(Json.encode(x).toUtf8String)
  def reads[T: Decoder](x: JsValue): T  = Json.decode(x.toString().getBytes(StandardCharsets.UTF_8)).to[T].value
}
