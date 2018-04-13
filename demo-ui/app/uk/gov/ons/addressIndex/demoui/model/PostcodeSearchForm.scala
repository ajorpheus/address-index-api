package uk.gov.ons.addressIndex.demoui.model

import play.api.libs.json._

/**
  * Form for single address
  */

case class PostcodeSearchForm(
 address: String,
 filter: String,
 historical: Boolean
)

object PostcodeSearchForm {
  val jsonFmt = Json.format[PostcodeSearchForm]
}

