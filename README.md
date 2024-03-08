# Blog Content Managment API

The aim of this project was to create a REST API that allows users to create and manage content that could be retrieved and displayed from a client blogging application.

API allows users creating posts and assigning specific chosen components to created posts, like paragraphs, images, headers and text lists. The main goal of the service was to give users opportunity to create any posts of flexible data, and decide of which components, their amount and order posts should consist.  


## Tech Stack

- Java
- Spring Boot
- PostgreSQL
- Hibernate
- Maven


## Features

- REST interface
- JSON Web Token authorization
- Relational database

## Database ER diagram

![er_diagram](https://github.com/WojK/ContentManagementBlogAPI/assets/106305960/a6136818-39c4-4d88-b5d7-4f640e1ee897)


## Functionalities Documantation
 - User 
    - Registration
    - Authentication
      
![auth](https://github.com/WojK/ContentManagementBlogAPI/assets/106305960/9ce38baf-fa3e-4bd0-b5cc-3824441264ef)

 - Category
    - Create
    - Update
    - Delete
    - Retrive all 
    - Retrive specific with details
      
![category](https://github.com/WojK/ContentManagementBlogAPI/assets/106305960/d81a4d88-c7fa-4208-869b-284ceaff739b)

 - Post
    - Create
    - Delete with cascade all assigned components
    - Retrive all user posts
    - Retrive specific with details
      
![post](https://github.com/WojK/ContentManagementBlogAPI/assets/106305960/63068a7b-bbdb-408c-9475-bcd315d77315)

 - Paragraph, Header, List
    - Create and assign to specific post
    - Update specific
    - Delete
      
 ![components](https://github.com/WojK/ContentManagementBlogAPI/assets/106305960/6c8e0bf0-58ee-4934-81ab-96c92c326e01)

 - Image 
    - Upload and assign to post
    - Retrive specific image by name
      
   ![image](https://github.com/WojK/ContentManagementBlogAPI/assets/106305960/4f728ec6-8b0d-4fac-8a2c-decbfe0438d7)
