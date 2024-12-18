Feature: User verify login page

#---------------------------Exploratory Scenario------------------------------------------

  Scenario: UI Verification login page
    Given User open the demo_url url
    When User verify loginPage.label_web appears
    And User verify loginPage.field_user_name appears
    And User verify loginPage.field_password appears
    And User verify loginPage.login_button appears
    Then User verify loginPage.login_credentials_section appears
    And close browser

  Scenario: UI verification login proces Successfully
    Given User open the demo_url url
    When User input standard_user text on loginPage.field_user_name field
    And User input secret_sauce text on loginPage.field_password field
    And User click on loginPage.login_button
    Then User verify HomePage.label_home appears
    And close browser

  Scenario: username and password doesn't match
    Given User open the demo_url url
    When User input standard_user text on loginPage.field_user_name field
    And User input false_password text on loginPage.field_password field
    And User click on loginPage.login_button
    Then User verify loginPage.error_message appears
    And close browser

  Scenario: UI verification remove item from cart
    Given User login to the demo_url with username_demo and password_demo
    When User click on HomePage.add_cart_button
    And User verify HomePage.badge_icon appears
    And User click on HomePage.remove_button
    Then User ensure that HomePage.badge_icon not appears
    And close browser

#First Task
#1.  Automate Login Flow, add 1 item to cart and verify that item is added to cart

  Scenario: UI verification adding item to cart
    Given User login to the demo_url with username_demo and password_demo
    When User click on HomePage.add_cart_button
    And User verify HomePage.remove_button appears
    And User verify HomePage.badge_icon appears
    And User click on HomePage.cart
    Then User verify value HomePage.item_added is Sauce Labs Backpack
    And close browser

#---------------------------Exploratory Scenario------------------------------------------
  Scenario: Verify the side bar is appears
    Given User login to the demo_url with username_demo and password_demo
    When User click on SideBar.open_bar
    And User verify SideBar.all_item_bar appears
    And User verify SideBar.about_bar appears
    And User verify SideBar.logout_bar appears
    And User verify SideBar.reset_bar appears
    Then User click on SideBar.close_bar
    And close browser

  Scenario: Verify the reset side bar is works
    Given User login to the demo_url with username_demo and password_demo
    When User click on HomePage.add_cart_button
    And User verify HomePage.remove_button appears
    And User verify HomePage.badge_icon appears
    And User click on SideBar.open_bar
    And User click on SideBar.reset_bar
    Then User ensure that HomePage.badge_icon not appears
    And close browser

  Scenario: Verify the logout side bar is works
    Given User login to the demo_url with username_demo and password_demo
    When User click on SideBar.open_bar
    And User click on SideBar.logout_bar
    And User verify loginPage.label_web appears
    And User verify loginPage.field_user_name appears
    And User verify loginPage.field_password appears
    And User verify loginPage.login_button appears
    Then User verify loginPage.login_credentials_section appears
    And close browser

#Second Task
#2.  Automate Login Flow, click on hamburger button (top left), navigate to 'About' and verify if it successfully navigate or not
  Scenario: Verify the navigating to about bar is works
    Given User login to the demo_url with username_demo and password_demo
    When User click on SideBar.open_bar
    And User click on SideBar.about_bar
    And User verify about_menu.icon_web appears
    Then User verify text appears contains 'The world relies on your code'
    And User verify text appears contains 'Products'
    And User verify text appears contains 'Solutions'
    And User verify text appears contains 'Pricing'
    And User verify text appears contains 'Resources'
    And close browser