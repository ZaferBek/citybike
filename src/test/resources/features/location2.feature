Feature: As a biker I would like to know the exact location of city bikes around the world in a given application

  Background: Given I set sample REST API url to http://api.citybik.es/v2/networks
@wip2
  Scenario:  As a user I want to verify that the city Frankfurt is in Germany and return their corresponding latitude and longitude

    Given a city bike exist within a company
    When a user retrieves the city by location
    Then the status code is 200
    And response includes the following
      | networks[1].location.city | Frankfurt |
      | networks[1].location.country | DE |
    And response includes the following in any order
      | networks.location.latitude | 50.1072 |
      | networks.location.longitude | 8.66375 |