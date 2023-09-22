Feature:
  Acceptance Criteria:

  1-All users can log in with valid credentials (We have 3 types of users: sales manager, store manager, truck driver).
  - Driver should land on the "Quick Launchpad" page after successful login
  - Sales Manager/ Store Manager should land on the "Dashboard" page after successful login

  Scenario:
    Given user is on login page
    When User enter to input username
    When User enter to input password
    When User clik to login button
    Then Users see dasbord page
