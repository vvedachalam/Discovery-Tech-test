@player

Feature: Use able to watch the Videos from Eurosport
  As an Eurosport Customer
  I want to watch my favourite sports videos streams
  So that I can enjoy and follow my favourite sports


  @controls, @tennis
  Scenario Outline: able to watch Tennis sports streaming

    Given I am an Eurosport Customer
    And On Videos Hub Page
    When I select to watch the videos from '<sports>' Section
    Then the selected video is playing
    And the following player controls are displayed
    |pause|
    |play|
    |maximise|

Examples:
    |sports|
    |tennis      |
    |football    |
    |champions league|
