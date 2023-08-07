package csw.params

import io.bullet.borer.*
import io.bullet.borer.derivation.CompactMapBasedCodecs.deriveCodec

case class ProperMotion(pmx: Double, pmy: Double)

object ProperMotion {
  implicit val properMotionCodec: Codec[ProperMotion] = deriveCodec

  val encoder: Encoder[ProperMotion] = properMotionCodec.encoder
}


