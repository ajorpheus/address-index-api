package uk.gov.ons.addressIndex.demoui.model

import play.api.libs.json._

/**
  * Form for single address
  */

case class SingleSearchForm(
 address: String,
 filter: String,
 historical: Boolean,
 matchthreshold: Int,
 startdate: String,
 enddate: String
)

object SingleSearchForm {
  val jsonFmt = Json.format[SingleSearchForm]
}

