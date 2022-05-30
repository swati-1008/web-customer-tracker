# web-customer-tracker
Spring MVC Project that lists, creates, updates and deletes customer

This project uses Spring MVC, Hibernate, and JSP to create a web view of a customer relationship application.

Upon start, it lists all the customers present in the database

It provides an 'Add Customer' button to create new entries in the database.

For each entry, 2 actions are possible - update and delete.

On selecting the 'Update' option, the application provides a pre-populated form with the entries of that respective customer. The required changes may be done and submitted, upon which the changes will be reflected both in the application and in the database.

When selecting the 'Delete' option, the application uses JavaScript 'confirm' method to display a popup and confirm if the customer must be deleted.

Apart from these, the application also has a search functionality for the customers, where it searches for a match in both first name and last name and gives the search results upon submitting.

Also, sorting can be done by clicking on the column header. For example, the entries are required to be sorted on first name basis, then the respective column header (First Name) must be clicked and the entries will be sorted. Same applies to the other columns too.
