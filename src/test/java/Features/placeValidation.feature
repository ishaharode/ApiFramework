Feature: Validation of Add Place API
#@AddPlace
  #Scenario: verify if place is being successfully added through AddPlace API
   # Given Add place payload
   # When user calls "addPlaceAPI" API post http request
    #Then API call is success with status code is 200
   # And "status" in response body is "OK"
    #And "scope" in response body is "APP"

  @AddPlace
  Scenario Outline: verify if place is being successfully added through AddPlace API
    Given Add place payload with "<name>", "<language>" and "<address>"
    When user calls "addPlaceAPI" API "POST" http request
    Then API call is success with status code is 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    Then verify placeID created maps to "<name>" using "getPlaceAPI"

    Examples:
      |name|language|address|
      |White house|English|Washington DC USA|
      |bungkingham palace|british English|London UK|

  @deletePlace
  Scenario: verify Delete Place API is working
    Given delete Place payload
    When user calls "deletePlaceAPI" API "DELETE" http request
    Then API call is success with status code is 200
    And "status" in response body is "OK"
