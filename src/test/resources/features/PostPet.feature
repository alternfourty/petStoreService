Feature: Add New Pet
  @PostPet
  Scenario Outline: Add pet succesfully
    When user send a post request to the "<endpoint>" and sent the pet "<id>", pet name "<petName>" and pet Category "<categoryName>"
    Then user will receive a response code <code>

  Examples:
    | id | petName | categoryName | endpoint | code |
    | 1  | Haru    | KaoManee     | /pet     | 200  |

