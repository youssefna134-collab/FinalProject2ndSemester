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
<img width="1012" height="347" alt="Screenshot 2026-05-15 013703" src="https://github.com/user-attachments/assets/69e4aa95-1e7b-4d88-9bd0-ff3842946904" />
<img width="700" height="300" alt="Screenshot 2026-05-15 013710" src="https://github.com/user-attachments/assets/6d6b12b5-731f-4817-a3e0-94a3a2bf9536" />


### 2. Borrowing Items
*   **Students:** Can borrow up to **5 Books**. The system will block attempts to borrow DVDs or Magazines.
*   **Teachers:** Can borrow up to **10 total items** (Books, DVDs, or Magazines).
  <img width="300" height="150" alt="Screenshot 2026-05-15 012949" src="https://github.com/user-attachments/assets/902e1b92-7ced-4dc7-adb0-eb4f4bc805ea" /> <img width="300" height="150" alt="Screenshot 2026-05-15 012955" src="https://github.com/user-attachments/assets/6016d504-90ee-4dc2-a040-65ba0c19b830" />
*   **Validation:** If you attempt to borrow an item that is already "Borrowed" or "Lost" 
* or if you exceed your limit, the system will display a specific error message.
<img width="700" height="400" alt="Screenshot 2026-05-15 013429" src="https://github.com/user-attachments/assets/b1b2230c-e762-4427-a6b4-a2d334e2f39b"/>

### 3. Returning Items
Items can be returned by entering the item. Once returned, the item status immediately reverts to "In Store," 
making it available for the next user.
<img width="600" height="200" alt="Screenshot 2026-05-15 013436" src="https://github.com/user-attachments/assets/675542bd-4828-4432-87d5-3f5eda80ed44" />

---

## Admin Features

### 1. Generating Reports
Admins can generate comprehensive reports using the `Reportable` interface. These reports categorize the inventory into:
*   **In Store:** Items ready for borrowing.
*   **Borrowed:** Items currently held by users.
*   **Lost:** Items flagged for replacement.
<img width="600" height="300" alt="Screenshot 2026-05-15 013508" src="https://github.com/user-attachments/assets/c5b0a690-ff86-4474-811a-c1390a9abe07" />

### 2. Data Backup
To ensure data safety, Admins can trigger a **Backup** command. This writes the current state of all users and library 
items back into the `users.csv` and `books.csv` files, saving any changes made during the session.

<img width="500" height="300" alt="Screenshot 2026-05-15 013532" src="https://github.com/user-attachments/assets/24ba252c-1d22-4c01-aad8-1abf6f7ae021" />

### 3. Sorting
Admins can view lists of users or items sorted by various criteria (ex: sorting users alphabetically by name or items by their title).
---

## Author
**Youssef Nagih**
**Student ID: 6372635**
