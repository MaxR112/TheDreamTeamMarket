# TheDreamTeamMarket

### Project Name
- The Dream Team Marketplace
### Developers
- Max Raymond
- Gabe Kouki
- Bao Do
### Class
- CS-210, Professor Buvaneshwaran T
### Submission Date
- Monday, April 28th, 2025

## Documenation
### Introduction
- Summary
    - Our program introduces a powerful, custom made, graphical user interface that allows the user to interact with all of our programs capabilities through easily findable and interactable buttons and entry fields.
    - The buyer section of our program allows users to view our catalog and add products to their cart as well as update quantities of items and remove items. This cart also includes the ability for users to checkout with their items.
    - The sller section of our program allows sellers to modify their items in our catalog as well as add new items to the catalog.
    - The product section of our program allows for storage of products through cleverly designed classes with a parent class covering all of the basics as to follow design principles.

- The purpose of this project is to allow users to shop from our catalog in a easy way as well as give sellers a place to update their products.

- Technology Used
    - The language used for this project is Java.
    - We used two libraries in the development of our project (besides basic java libraries), Java Swing and Java AWT.
        - These were used for the GUI development.

### Instalation and Setup
- To run our program just follow these simple steps.
    - Open the [Github Repository](https://www.github.com/maxr112/thedreamteammarket)
    - Download the files or clone the repository
    - Open the repository folder in whatever IDE you please, making sure to have Java installed.
    - Click run!

- This program uses text based file storage which allows for all of the changes made within the program to carry over to future instances.

### Features
- GUI functionality
    - Our app uses java swing and AWT to create an easy to use GUI. All interactions in the GUI are done through buttons, dropdowns, and entry fields. This makes our app easy to use and navigate.

- Seller Features
    - Sellers can add new items by choosing the product type and filling in fields like name, company, price, and description.
    - They can also edit or remove existing products. When editing, the form fills in automatically with the current info to make changes easier.
    - All changes are saved to a file, so they stick around even after closing the program.

- Buyer Features
    - Buyers can browse products by category like Electronics, Clothing, and Furniture.
    - They can add items to their cart, update quantities, remove stuff, see the total price, and check out.
    - The cart updates instantly and shows a message when something changes. 

- File reader/writer more in depth (how it works/why we do it)
    - fileReader loads products from a file and turns them into objects in the app.
    - fileWriter takes those product objects and saves them back into the file.
    - This way, all updates are saved and carried over next time the app is opened.

- Product Classes
    - There's a main Product class that holds common stuff like name, price, and quantity.
    - Electronics, Clothing, and Furniture all extend that and add their own details. 

- Catalog
    - This is where all the products are stored. You can view them, search by name, update, remove, or add new ones.
    - It connects with the file system to keep everything saved.

- Cart
    - Tracks what buyers want to buy.
    - You can add, remove, update quantities, and check out.
    - It also calculates the total cost automatically.

- Driver
    - Loads the product catalog from the file and kicks off the app.
    - It shows the main screen where you choose to log in as a buyer or seller


### SOLID Principles
   - Single Responsibility Principle
     - Each class has a clear and singular purpose. productCatalog manages products, productCart manages the cart, fileReader handles file reading.
     
   - Open/Closed Principle
      - Product classes are designed to be extended like, Electronics, Clothing, Furniture without modifying the base Product class.

   - Liskov Substitution Principle
      - Subclasses like Electronics, Clothing, and Furniture can be used wherever a Product object is expected without breaking functionality.

   - Interface Segregation Principle
      - We organize product behavior cleanly; specific features are handled through subclassing rather than forcing a bloated Product class.

   - Dependency Inversion Principle
      - High-level modules like the GUI screens such as BuyerScreen, SellerScreen depend on abstractions like Product, ProductCatalog, not low-level file storage implementations.

### Design Patterns
 - Our project uses several classic object-oriented design patterns to keep the code organized, scalable, and easy to maintain

#### Factory Pattern
  -  Product Creation of Electronics, Clothing, Furniture
  -  We use a base Product class and extend it into specialized product types. This makes it easy to add new product types without touching existing code. 
  -  Supports the Open/Closed Principle — open for extension, closed for modification.

#### Singleton Pattern
  - Catalog Management
  - There is only one catalog instance that tracks all products throughout the program.
  - Ensures data consistency and provides a single global access point to the product list.

#### Observer Pattern
  - GUI Cart and Product Updates
  - When buyers add/remove items from the cart or sellers update the catalog, the GUI instantly reflects those changes.
  - Keeps the user interface in sync with backend data without tightly coupling the two.

#### Command Pattern
  - Cart Actions (Add, Remove, Update, Checkout)
  - User actions like adding to cart, removing items, or checking out are all handled cleanly and could be expanded for undo/redo support later.
  - Organizes user actions into clear, reusable commands, making the app more flexible.

### Architecture Design
- Overview
    - This application uses a Layered Architecture, which is a design pattern that organizes code into distinct layers based on their functionality.
    - The app starts with Driver.java, which reads in product data and sends it to the Window class. This class handles switching screens and stores shared stuff like the catalog and cart.
    - From the MainScreen, users choose between SellerScreen and BuyerScreen.
    - Sellers use screens like AddItemScreen and ModifyItemScreen to manage their listings.
    - Buyers use BuyerScreen to browse and buy.

- Class Breakdown
    - Product and subclasses: Define what each item is and what info it stores.
    - productCatalog: Holds and manages the list of all items.
    - productCart: Holds buyer selections and handles cart actions.
    - fileReader/fileWriter: Load and save product data.
    - Window: Stores the app state and manages switching between screens.
    - GUI screens (MainScreen, BuyerScreen, etc.): Handle the user interface and button clicks.
    
### OOP 
   - Encapsulation
      - All product data such as name, price, quantity is private and accessed through getter/setter methods.

   - Inheritance
      - Electronics, Clothing, and Furniture extend the Product base class.

   - Polymorphism
      - Methods like toString() and category-specific behaviors differ based on the product subclass.

   - Abstraction
      - Buyers and sellers interact with high-level GUI elements without worrying about underlying file operations.

### Exceptions
   - Our program uses two custom exceptions called CouldNotUpdateQuantityException and ProductNotFoundException.
      - These exceptions are responsible for telling us if a products quantity was unable to be updated or if a product was unable to be found using its name.
      - These exceptions were helpful when the seller or buyer was trying to update the quantity of an item or when we were trying to find a item to add to a cart/catalog.
   - We also used built in Java Exceptions such as IOExceptions for when we are handling files.

### Performance and Scalibility
   - We believe that our program has fairly good performance for what it is.
   - One thing that we think could increase scalbility of our program is to implement an actual database instead of using file readers and writers.
   - Another thing about our performance is that Java Swing is not thread safe which could cause issues.

### UML Diagram
![UML Diagram](UML.png)

### Sequence Diagram: Seller Adding Product
![Sequence Diagram](Sequence.png)

### Future Improvements
- Clean up the UI to make it look more modern.
- Add user login for different sellers and buyers.
- Switch from file storage to a real database.
- Let users upload product images and search by filters.

### Conclusion
- The Dream Team Marketplace is a Java Swing app that gives users a simple way to buy and sell items. It follows object-oriented design, saves all your data in a file, and has separate sections for buyers and sellers. It works great for a basic marketplace, and there's a lot of room to build on it with features like login systems and better visuals.

### References
- [Swing](https://docs.oracle.com/javase/8/docs/api/index.html?javax/swing/package-summary.html)
- [AWT](https://docs.oracle.com/javase/8/docs/api/java/awt/package-frame.html)
