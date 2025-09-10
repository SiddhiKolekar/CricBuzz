# 🏏 CricBuzz  - Cricket Management System
A comprehensive Spring Boot application for managing cricket teams, players, matches, and statistics. This RESTful API provides complete functionality for cricket team management with features like player registration, match scheduling, statistics tracking, and email notifications.
## 🚀 Features
### Core Functionality
* **Player Management**: Register and manage cricket players with detailed profiles
* **Team Managemen**t: Create and manage cricket teams with rankings and ICC points
* **Match Management**: Schedule and track cricket matches between teams
* **Statistics Tracking**: Maintain detailed player statistics (batting, bowling averages)
* **Email Notifications**: Automatic email notifications for player registrations
### Technical Features
* **RESTful API**: Complete REST API with proper HTTP status codes
* **Database Integration**: MySQL database with JPA/Hibernate ORM
* **Email Service**: SMTP email integration for notifications
* **Exception Handling**: Custom exception handling with proper error responses
* **API Documentation**: Swagger/OpenAPI documentation
* **Data Validation**: Request/Response DTOs with proper validation
## 🛠️ Technology Stack
* **Framework**: Spring Boot 3.3.5
* **Language**: Java 17 or more
* **Database**: MySQL 8.0
* **ORM**: Spring Data JPA with Hibernate
* **Build Tool**: Maven
* **Email**: Spring Boot Mail Starter
* **Utilities**: Lombok for boilerplate reduction
## 📋 Prerequisites
Before running this application, ensure you have:

* **Java 21** or higher</br>
* **MySQL 8.0** or higher</br>
* **Maven 3.6** or higher</br>
* **Git** (for cloning the repository)</br>
## 📁 Project Structure
src/main/java/com/acciojob/CricBuzz/ </br>
├── controller/          # REST API Controllers</br>
│   ├── PlayerController.java</br>
│   ├── TeamController.java</br>
│   ├── MatchController.java</br>
│   └── StatsController.java</br>
├── service/            # Business Logic Layer
│   ├── PlayerService.java
│   ├── TeamService.java
│   ├── MatchService.java
│   └── StatsService.java
├── repository/         # Data Access Layer
│   ├── PlayerRepository.java
│   └── TeamRepository.java
├── model/             # Entity Classes
│   ├── Player.java
│   ├── Team.java
│   ├── CricketMatch.java
│   ├── Stats.java
│   └── Enum/
│       ├── Gender.java
│       ├── Speciality.java
│       └── MatchType.java
├── dto/               # Data Transfer Objects
│   ├── request/
│   └── response/
├── converter/         # Entity-DTO Converters
├── exception/         # Custom Exceptions
└── CricBuzzApplication.java
