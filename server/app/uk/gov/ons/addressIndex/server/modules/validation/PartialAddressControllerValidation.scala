package uk.gov.ons.addressIndex.server.modules.validation

import javax.inject.{Inject, Singleton}
import play.api.mvc.Result
import uk.gov.ons.addressIndex.model.server.response.address.{EmptyQueryAddressResponseError, ShortQueryAddressResponseError}
import uk.gov.ons.addressIndex.server.modules.response.PartialAddressControllerResponse
import uk.gov.ons.addressIndex.server.modules.{ConfigModule, VersionModule}

import scala.concurrent.Future

@Singleton
class PartialAddressControllerValidation @Inject()(implicit conf: ConfigModule, versionProvider: VersionModule)
  extends AddressValidation with PartialAddressControllerResponse {

  val minimumTermLength = conf.config.elasticSearch.minimumPartial

  // minimum length only for partial so override
  override def validateInput(input: String): Option[Future[Result]] = {
    if (input.isEmpty) {
      logger.systemLog(badRequestMessage = EmptyQueryAddressResponseError.message)
      Some(futureJsonBadRequest(EmptySearch))
    } else if (input.length < 5) {
      logger.systemLog(badRequestMessage = ShortQueryAddressResponseError.message)
      Some(futureJsonBadRequest(ShortSearch))
    } else None
  }
  
}
