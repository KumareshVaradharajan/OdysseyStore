Feature: Browse and purchase books

  @BooksPage
  Scenario: Verify that the list of Books are getting displayed on the Books page

    Given I am on the "Home page"
    And I click on the "Books" link in the navigation menu
    Then I should see a list of products on the "Books" page

  @AddingBookToCart
  Scenario: Add the first Best Seller book to Cart
    Given I am on the "Home page"
    And I click on the "Books" link in the navigation menu
    Then I should see a list of products on the "Books" page
    And Sort the books with descending order
    And Find the first Best Seller book name
    And Add the "ZERO TO ONE" Book to Cart
    And I am on the "My Cart page"

  @EndToEnd
  Scenario: Verify that user is able to Complete the Order

    Then I am on the "Home page"
    And I click on the "Books" link in the navigation menu
    Then I should see a list of products on the "Books" page
    And Sort the books with descending order
    And Find the first Best Seller book name
    And Add the "ZERO TO ONE" Book to Cart
    And I am on the "My Cart page"
    And Checkout and Add contact information
    And Complete the Order

