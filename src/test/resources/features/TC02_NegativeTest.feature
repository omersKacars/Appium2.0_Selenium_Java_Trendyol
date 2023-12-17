Feature: Trendyol Smoke Test
  Scenario: TC02 | Negatif Test
    Then Click to Hesabim
    And Enter a invalid email address into the email textbox.
    And Enter a invalid password address into the password textbox.
    And click Giris Yap button
    But Verify that not logged in.
