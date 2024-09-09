# Articles Application

## Overview

The WebChat application is a Spring Boot-based web application that allows users to manage and browse articles. It includes functionalities for user registration, login, profile management, and article management. Users can create, view, and delete articles, as well as manage their profiles.

## Features

- **User Management**: Register, login, and view user profiles.
- **Article Management**: Create, view, and delete articles.
- **Search Functionality**: Search for articles by title.

## Project Structure

### Configuration

- **`SecurityConfig`**: Configures Spring Security, including form login, logout, and password encoding.
  
### Controllers

- **`ArticleController`**: Handles requests related to article management:
  - `GET /` - List all articles or search by title.
  - `GET /article/{id}` - View article details.
  - `POST /article/delete/{id}` - Delete an article.
  - `GET /my/articles` - View articles created by the current user.
  - `GET /article/new` - Display form to create a new article.
  - `POST /article/new` - Create a new article.
  
- **`UserController`**: Manages user-related actions:
  - `GET /login` - Display the login page.
  - `GET /profile` - View the current user's profile.
  - `GET /registration` - Display the registration page.
  - `POST /registration` - Register a new user.
  - `GET /user/{user}` - View details of a specified user.

### Services

- **`CustomUserDetailsService`**: Implements `UserDetailsService` to load user details from the repository.
- **`ArticleService`**: Handles article-related operations, such as saving, deleting, and listing articles.
- **`UserService`**: Manages user operations, including user creation, role management, and banning/unbanning users.


- Java 11 or higher
- Maven 3.6 or higher
- MySQL or other supported database
