
Feature: As a biker I would like to know the exact location of city bikes around the world in a given application.

    @wip
    Scenario: As a user I want to verify that the city
    Frankfurt is in Germany and return their corresponded latitude and longitude

      When user sends get request to endpoint
      Then verify that respond status code is 200 and content-type is "application/json"
      And verify that the city "Frankfurt" is in country "DE"
      And verify latitude and longitude of the city