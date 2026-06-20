# E-Commerce Search & Filter Automation

## 📋 Project Overview
This project is an automated testing suite designed to validate the search, filtering, and sorting functionalities of an online e-commerce platform (specifically modeled for Flipkart). The automation script mimics a user journey: searching for specific mobile phones, dynamically handling auto-suggestions, applying complex filters (price sliders and OS versions), sorting the results, and extracting product data for validation.

## 🎯 Problem Statement & Automation Scope
The core objective is to ensure that search results accurately reflect user-applied constraints and to validate product pricing. 

**Key Automation Challenges Solved:**
*   **Cross-Browser Testing:** Dynamic browser launching based on user input (Chrome/Firefox).
*   **Popup Handling:** Automatically detecting and dismissing initial login overlays or promotional popups.
*   **Advanced Synchronization:** Implementing Explicit and Fluent Waits to handle dynamic page loading and AJAX calls without hardcoding delays.
*   **Complex Interactions:** Using WebDriver Actions to drag-and-drop price sliders.
*   **Precise Locators:** Utilizing robust XPath and CSS Selectors to find dynamic web elements.
*   **Exception Handling:** Gracefully managing `NoSuchElementException`, `TimeoutException`, and `StaleElementReferenceException`.

## ⚙️ Tech Stack
*   **Automation Tool:** Selenium WebDriver
*   **Programming Language:** Java / Python *(Edit to match your project)*
*   **Testing Framework:** TestNG / JUnit / PyTest *(Edit to match your project)*
*   **Build/Dependency Manager:** Maven / pip *(Edit to match your project)*

## 🚀 Automated Workflow (Test Steps)
1.  **Launch Browser:** Initializes Chrome or Firefox based on configuration.
2.  **Navigate:** Opens `https://www.flipkart.com/` (or equivalent target site).
3.  **Handle Pop-ups:** Closes the login/registration popup if it appears upon loading.
4.  **Auto-Suggest Search:** Types "mobiles" into the search bar and dynamically selects "mobiles under 15000" from the auto-populated dropdown.
5.  **Apply Price Filter:** Uses Action classes to drag the price range slider, setting the maximum price to ₹10,000.
6.  **Apply OS Filter:** Locates and selects the "Pie" Operating System checkbox.
7.  **Sort Results:** Clicks the "Newest First" tab to reorder the displayed items.
8.  **Data Extraction:** Scrapes the DOM to fetch and display the "Name" and "Price" of the top 5 mobile phones.
9.  **Validation Checkpoint:** Asserts that the price of the first displayed mobile is strictly less than ₹30,000.
10. **Teardown:** Closes the browser and terminates the WebDriver session gracefully.

## 🛠️ Setup & Execution

### Prerequisites
*   [Language installed, e.g., Java JDK 11+ or Python 3.8+]
*   Browser drivers (ChromeDriver, GeckoDriver) configured in the system PATH, or managed via a library like `WebDriverManager`.

### Running the Tests
1. Clone the repository:
```bash
   git clone [https://github.com/YourUsername/your-repo-name.git](https://github.com/YourUsername/your-repo-name.git)
