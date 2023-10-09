Feature:Validating News Articles on Guardian news

  This feature is to verify whether the first news in guardian news is real or fake

# positive scenario to check news is valid. scenario will pass.
  Scenario: Verify the news article is valid from The Guardian news
    Given user is on guardian news page
    When they select the first news article on the page
      And they search for similar information on Google or other resources
    Then they find two or more articles on the same topic
      And the first Guardian news article is considered valid

# negative scenario to check news is fake. this scenario is intentionally failed to verify failure result & screenshots in cucumber report
  Scenario: Verify the news article is Invalid from The Guardian news
    Given user is on guardian news page
    When they select the first news article on the page
      And they search for similar information on Google or other resources
    Then they find two or more articles on the same topic
      And the first Guardian news article is considered fake