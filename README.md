**NIT3213 – Assignment 2
Mobile Application Development – F,SY**

Student Name: Manu Manvi
Student ID: s8088576
Project Title: Android App – Login, Dashboard, and Details
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Overview**

This Android application was developed as part of Assignment 2 for NIT3213 Mobile Application Development.
The objective is to demonstrate proficiency in:

-MVVM architecture

-Dependency Injection using Hilt

-REST API integration using Retrofit

-RecyclerView for data display

-Unit testing (ViewModel logic using JUnit and Mockito)

-Proper Git usage and documentation
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Project Structure**
com.s8088576.assignment2
 ├─ data
 │   ├─ api              → Retrofit API interfaces
 │   ├─ model            → Data models (LoginResponse, Entity, etc.)
 │   └─ repository       → Repository layer for API calls
 ├─ di                  → Hilt modules (provides Retrofit, Repository)
 ├─ ui
 │   ├─ login            → Login Activity and ViewModel
 │   ├─ dashboard        → Dashboard Activity and RecyclerView Adapter
 │   └─ details          → Details Activity
 ├─ viewmodel            → ViewModel classes
 └─ util                 → Utility classes and Result wrapper
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**API Information**

Base URL: https://nit3213api.onrender.com/

**Endpoints used:**
| Feature   | Endpoint                                                  | Method | Description                              |
| --------- | --------------------------------------------------------- | ------ | ---------------------------------------- |
| Login     | `/footscray/auth` (or `/sydney/auth` depending on campus) | POST   | Authenticates user and returns `keypass` |
| Dashboard | `/dashboard/{keypass}`                                    | GET    | Retrieves entities for logged-in user    |
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Sample Login Request:**
{
  "username": "Manu",
  "password": "8088576"
}


**Sample Login Response:**
{
  "keypass": "topicName"
}
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**How to Run**
1. Clone the Repository: git clone <https://github.com/manvi0003/s8088576Assignment2.git>
2. Open the project in Android Studio (2022 or later).
3. Sync Gradle dependencies.
4. Run the application on an emulator or a physical device (Android 10 or higher).
5. Log in using the following credentials:
    Username: Manu
    Password: 8088576

6. Expected flow:
    Login → Dashboard (list fetched from API) → Click item → Details screen displaying full information.
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Technologies Used**
1.Kotlin
2.Hilt (Dagger) for Dependency Injection
3.Retrofit + Moshi/Gson for networking
4.ViewModel + LiveData/StateFlow for MVVM
5.RecyclerView for data display
6.JUnit + Mockito/MockK for unit testing
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Unit Testing**

1. LoginViewModelTest – verifies success and error states on login.
2. DashboardViewModelTest – verifies data loading and error handling.
3. To run tests: ./gradlew test
4. or use Android Studio → Run Tests.
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Dependency Injection**

Hilt is configured in MyApp.kt and modules under di/.
The modules provide:
  - Retrofit client
  - ApiService instance
  - Repository bindings
  - ViewModel injection
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Git Usage and Branching**
Meaningful commits were made throughout development using feature-based branches.
Example commit history: 
  chore: initial project setup
  feat: add Hilt and Retrofit dependencies
  feat: implement Login screen and ViewModel
  feat: implement Dashboard RecyclerView and Details screen
  test: add ViewModel unit tests
  docs: update README with run instructions
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Assessment Alignment**
| Rubric Criterion                      | Evidence in Project                                  |
| ------------------------------------- | ---------------------------------------------------- |
| Project Completion (40%)              | Login, Dashboard, and Details implemented end-to-end |
| Code Organization & Cleanliness (15%) | MVVM architecture with clear package structure       |
| Dependency Injection (25%)            | Hilt modules implemented for Retrofit and Repository |
| Unit Testing (10%)                    | JUnit tests for ViewModels                           |
| Git Usage (5%)                        | Meaningful commits and branching                     |
| ReadMe File (5%)                      | This README provides clear setup and documentation   |
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
**Submission Details**

Student Name: Manu Manvi

Student ID: s8088576

Repository/Zip Name: s8088576Assignment2

Android Studio Version: 2022.3 or later

Minimum SDK: Android 10 (API 29)
---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
