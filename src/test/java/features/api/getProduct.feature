Feature: Verify The API Proses

  Scenario: Verify all the product from API
    Given Pointing The URL https://fakestoreapi.com
    When GET The /products Request
    Then Verify the response code is 200

  Scenario Outline: Verify all the response data is correct
    Given Pointing The URL https://fakestoreapi.com
    When GET The <endpoint> Request
    Then verify value of the [0].category is equals with<cat>
    Examples:
      | endpoint | cat|
      | /products | men's clothing|

  Scenario Outline: create data product
    Given Pointing The URL https://fakestoreapi.com
    When Create Product data Payload with title t-shirt
    Then POST /products The Request
    And Verify the response code is 200
    And verify value of the id is equals with<data>
    Examples:
      |data    |
      |21 |

  Scenario Outline: update data product
    Given Pointing The URL https://fakestoreapi.com
    When Create Product data Payload with title t-shirt
    Then POST /products The Request
    And Verify the response code is 200
    And verify value of the id is equals with<data>
    Examples:
      |data    |
      |21 |