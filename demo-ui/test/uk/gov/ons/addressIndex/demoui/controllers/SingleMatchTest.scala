package uk.gov.ons.addressIndex.demoui.controllers

import org.scalatestplus.play.PlaySpec
import play.api.i18n.{Langs, MessagesApi}
import play.api.mvc.{ControllerComponents, Results}
import play.api.test.Helpers._
import play.api.test.{FakeRequest, WithApplication}
import uk.gov.ons.addressIndex.demoui.client.{AddressIndexClientInstance, AddressIndexClientMock}
import uk.gov.ons.addressIndex.demoui.modules.{DemoUIAddressIndexVersionModule, DemouiConfigModule}
import uk.gov.ons.addressIndex.demoui.utils.{ClassHierarchy, RelativesExpander}

import scala.concurrent.ExecutionContext.Implicits.global

/**
  * Tests for single match controller
  */
class SingleMatchTest extends PlaySpec with Results {

  "Single match controller" should {
    "return a page containing a heading" in new WithApplication {
      // Given
      val messagesApi = app.injector.instanceOf[MessagesApi]
      val langs = app.injector.instanceOf[Langs]
      val configuration = app.injector.instanceOf[DemouiConfigModule]
      val apiClient = app.injector.instanceOf[AddressIndexClientMock]
      val version = app.injector.instanceOf[DemoUIAddressIndexVersionModule]
      val controllerComponents = app.injector.instanceOf[ControllerComponents]
      val expectedString = "Search for an address"
      val classHierarchy  = app.injector.instanceOf(classOf[ClassHierarchy])
      val expandedRels = app.injector.instanceOf(classOf[RelativesExpander])

      // When
      val response = new SingleMatchController(
        controllerComponents,
        configuration,
        messagesApi,
        langs,
        apiClient,
        classHierarchy,
        expandedRels,
        version)
        .showSingleMatchPage().apply(FakeRequest().withSession("api-key" -> ""))
      val content = contentAsString(response)

      // Then
      status(response) mustBe OK
      content must include(expectedString)
    }

    "return a page including a single match form" in new WithApplication {
      // Given
      val messagesApi = app.injector.instanceOf[MessagesApi]
      val langs = app.injector.instanceOf[Langs]
      val configuration = app.injector.instanceOf[DemouiConfigModule]
      val apiClient = app.injector.instanceOf[AddressIndexClientMock]
      val version = app.injector.instanceOf[DemoUIAddressIndexVersionModule]
      val controllerComponents = app.injector.instanceOf[ControllerComponents]
      val expectedString = "<form action=\"/addresses/search\" method=\"POST\" >"
      val classHierarchy  = app.injector.instanceOf(classOf[ClassHierarchy])
      val expandedRels = app.injector.instanceOf(classOf[RelativesExpander])

      // When
      val response = new SingleMatchController(
        controllerComponents,
        configuration,
        messagesApi,
        langs,
        apiClient,
        classHierarchy,
        expandedRels,
        version)
        .showSingleMatchPage().apply(FakeRequest().withSession("api-key" -> ""))
      val content = contentAsString(response)

      // Then
      status(response) mustBe OK
      content must include(expectedString)
    }

    "return a page including an appropriate error message when empty address posted" in new WithApplication {
      // Given
      val messagesApi = app.injector.instanceOf[MessagesApi]
      val langs = app.injector.instanceOf[Langs]
      val configuration = app.injector.instanceOf[DemouiConfigModule]
      val apiClient = app.injector.instanceOf[AddressIndexClientMock]
      val version = app.injector.instanceOf[DemoUIAddressIndexVersionModule]
      val controllerComponents = app.injector.instanceOf[ControllerComponents]
      val expectedString = "<div class=\"warning-error-suggestion mars\" role=\"alert\"><span onclick=\"setFocus('address');\">Please enter an address</span></div>"
      val classHierarchy  = app.injector.instanceOf(classOf[ClassHierarchy])
      val expandedRels = app.injector.instanceOf(classOf[RelativesExpander])
      // When
      val response = new SingleMatchController(
        controllerComponents,
        configuration,
        messagesApi,
        langs,
        apiClient,
        classHierarchy,
        expandedRels,
        version)
        .doMatch().apply(FakeRequest(POST,"/addresses/search").withFormUrlEncodedBody("address" -> "").withSession("api-key" -> ""))
      val content = contentAsString(response)

      // Then
      status(response) mustBe OK
      content must include(expectedString)
    }

    "return a page including some search results" in new WithApplication {
      // Given
      val messagesApi = app.injector.instanceOf[MessagesApi]
      val langs = app.injector.instanceOf[Langs]
      val configuration = app.injector.instanceOf[DemouiConfigModule]
      val apiClient = app.injector.instanceOf[AddressIndexClientMock]
      val version = app.injector.instanceOf[DemoUIAddressIndexVersionModule]
      val controllerComponents = app.injector.instanceOf[ControllerComponents]
      val expectedString = "<div class=\"standout\">We have matched 1 addresses</div>"
      val inputAddress = "7 EX2 6GA"
      val filter = ""
      val classHierarchy  = app.injector.instanceOf(classOf[ClassHierarchy])
      val expandedRels = app.injector.instanceOf(classOf[RelativesExpander])

      // When
      val response = new SingleMatchController(
        controllerComponents,
        configuration,
        messagesApi,
        langs,
        apiClient.asInstanceOf[AddressIndexClientInstance],
        classHierarchy,
        expandedRels,
        version)
      .doMatchWithInput(inputAddress, Some(filter), Some(1)).apply(FakeRequest().withSession("api-key" -> ""))
      val content = contentAsString(response)

      // Then
      status(response) mustBe OK
      content must include(expectedString)
    }

    "return a page including some search results with a filter" in new WithApplication {
      // Given
      val messagesApi = app.injector.instanceOf[MessagesApi]
      val langs = app.injector.instanceOf[Langs]
      val configuration = app.injector.instanceOf[DemouiConfigModule]
      val apiClient = app.injector.instanceOf[AddressIndexClientMock]
      val version = app.injector.instanceOf[DemoUIAddressIndexVersionModule]
      val controllerComponents = app.injector.instanceOf[ControllerComponents]
      val expectedString = "[ R ] [ Residential ]"
      val inputAddress = "7 EX2 6GA"
      val filter = "RD"
      val classHierarchy  = app.injector.instanceOf(classOf[ClassHierarchy])
      val expandedRels = app.injector.instanceOf(classOf[RelativesExpander])

      // When
      val response = new SingleMatchController(
        controllerComponents,
        configuration,
        messagesApi,
        langs,
        apiClient.asInstanceOf[AddressIndexClientInstance],
        classHierarchy,
        expandedRels,
        version)
        .doMatchWithInput(inputAddress, Some(filter), Some(1)).apply(FakeRequest().withSession("api-key" -> ""))
      val content = contentAsString(response)

      // Then
      status(response) mustBe OK
      content must include(expectedString)
    }

  }
}
