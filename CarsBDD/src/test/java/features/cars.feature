Feature:

  Scenario: Сheck the characteristics of the cars
    Given Site is opened

    When Add machine for comparison

    When Go to the Research page
      And Click on the Side-by-Side Comparisons section
      And Select the characteristics of the first car
      And Add a second machine for comparison
    Then The characteristics of the car on the page correspond to those obtained earlier


