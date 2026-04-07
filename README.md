# 🏦 Banking Management System

A secure, desktop-based Banking Management Application developed to digitize and automate daily banking operations. Built with **Core Java (Swing)** for the frontend and **MS SQL Server** for robust data management, this system handles everything from account creation to real-time financial transactions.

## 🚀 Tech Stack & Tools
* **Frontend:** Java Swing, AWT
* **Backend / Database:** MS SQL Server
* **Database Connectivity:** JDBC (Java Database Connectivity) API
* **Architecture:** 3-Tier Client-Server Architecture
* **Tools:** IDE (Eclipse/IntelliJ), Git, GitHub

## ✨ Key Features & Functionalities
* **Secure Authentication:** Admin/Teller login system to prevent unauthorized access.
* **Full CRUD Operations:** * **Create:** Open new customer accounts with initial deposit validation.
  * **Read:** Search and retrieve account details instantly using Account Numbers.
  * **Update:** Modify existing customer profiles and contact information.
  * **Delete:** Securely close accounts (with zero-balance validation).
* **Real-Time Transactions:** Seamlessly process Deposits and Withdrawals. Includes logical validation to prevent overdrafts (withdrawing more than the available balance).
* **Transaction Ledger:** Automated logging of all financial activities, allowing staff to generate and view "Mini Statements" or transaction history in a clean grid layout.

## 🗄️ Database Schema Highlights
The project uses a normalized relational database design with primary tables such as:
* `Users` (For admin authentication)
* `Accounts` (Stores customer PII and current balance)
* `Transactions` (Logs transaction ID, date, type, and amount)

## ⚙️ How to Run Locally
1. Clone this repository:
   ```bash
   git clone [https://github.com/YourUsername/BankingManagementSystem.git](https://github.com/YourUsername/BankingManagementSystem.git)
