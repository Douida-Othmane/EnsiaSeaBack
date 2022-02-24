# EnsiaSeaBack
# Welcome To EnsiaSea

## Introduction

**EnsiaSea** is a project built (or still in the buidling phase) by second year Software Engineering students from __ENSIAS__. As you can see from its name, it has combined the two words _ENSIAS_ and _SEA_, this combination was based on the website **OpenSea**, and if you can't guess yet, the goal of this project is to build a blockchain website for ENSIAS students to sell, buy, and exchange **NTF**s (**N**on **F**ungible **T**okens). To make this project come true, it was devided into 3 parts: The blockchain network, the back-end, and the front-end of the website. This repository is the main one, and it contains the **BackEnd** part of the project.


## Api Endpoints
 EnsiaSea API has multiple endpoints that follow the same structure  _/api/v1/endpoint_
 - ### For Authentication : 
     - #### Register a User : 
     **Endpoint** :__POST__ _/auth/register_

     **PayLoad** :
    ```
        {
            "email": Email of the user must be unique,
            "username": Username of the user must be unique,
            "password": ******
        }
    ```

    **OutPut** :
    ```
        {
            "success" : false || true ,
            "message" : success message || error message
        }
    ```
     - ### Login a User : 
     **Endpoint** : __POST__  _/auth/login_

    **PayLoad** :
    ```
        {
            "email": Email of the user,
            "password": ******
        }
    ```
    **OutPut** :
    ```
        {
            "success" : false || true ,
            "message" : success message || error message
        }
    ```
     - ### Logout a User : 
     **Endpoint** : __POST__  _/auth/logout_

    **OutPut** :
    ```
        {
            "success" : false || true ,
            "message" : success message || error message
        }
    ```
 - ### To Handle Users : 

     - #### Get All Users :
     **Endpoint** : __GET__  _/users/_

    **OutPut** :
    ```
        {
            "success" : false || true ,
            "message" : success message || error message,
            "count" : number of users in the database,
            "data" : [ Users...]
        }
    ``` 