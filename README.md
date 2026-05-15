# Library Management System - User Guide
This guide provides instructions on how to use the Library Management System covering all admin tasks.

## Description
The Library Management System is a specialized Java application designed to streamline the borrowing, returning, and 
tracking of library inventory. By categorizing users into Students, Teachers, and Admins, the system ensures that 
borrowing policies such as item limits and type restrictions are automatically enforced.

The application features advanced searching capabilities, data persistence through CSV files and detailed status 
reporting.

## User Features

### 1. Searching for Items
Users can search the library catalog by **Title** or **Author**.
*   **Recursive Search:** A deep search method used for navigating structured data.
*   **Stream Search:** A fast, functional search that filters out duplicate copies and provides a clean list 
*  of available titles.
*   *Note:* All searches are case-insensitive.

### 2. Borrowing Items
*   **Students:** Can borrow up to **5 Books**. The system will block attempts to borrow DVDs or Magazines.
*   **Teachers:** Can borrow up to **10 total items** (Books, DVDs, or Magazines).
*   **Validation:** If you attempt to borrow an item that is already "Borrowed" or "Lost" 
* or if you exceed your limit, the system will display a specific error message.

### 3. Returning Items
Items can be returned by entering the unique Item ID. Once returned, the item status immediately reverts to "In Store," 
making it available for the next user.

---

## Admin Features

### 1. Generating Reports
Admins can generate comprehensive reports using the `Reportable` interface. These reports categorize the inventory into:
*   **In Store:** Items ready for borrowing.
*   **Borrowed:** Items currently held by users.
*   **Lost:** Items flagged for replacement.

### 2. Data Backup
To ensure data safety, Admins can trigger a **Backup** command. This writes the current state of all users and library 
items back into the `users.csv` and `books.csv` files, saving any changes made during the session.

### 3. Sorting
Admins can view lists of users or items sorted by various criteria (e.g., sorting users alphabetically by name or items
by their unique ID).

---

## Author
**Youssef Nagih**
**Student ID: 6372635**