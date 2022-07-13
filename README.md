# Animal Hospital System API
## Getting Started
* This is an improvement of the [Animal Hospital System](https://github.com/medzdev/Animal-Hospital-System) project.
* RESTful API to access information about an Animal Hospital System, you're able to execute the following commands:
  * GET - Request information of the animal owners records (all or single).
  * POST - Register a new record, this must follow a JSON syntax.
  * DELETE - Send a request to remove an animal owner's record.
  * PUT - Used to update a field in a record already registered.

## Tech Stack
Built with:
* Java
* Maven
* Spring Boot

## CRUD Operations
- GET 
  - This will return information from all the records or specific information based on and *id*.
    - Get all records:
    ```shell 
    curl -v http://localhost:8080/owners | json_pp
    ```
    ```json
    "animalOwnerRecordList" : [
         {
            "_links" : {
               "owners" : {
                  "href" : "http://localhost:8080/owners"
               },
               "self" : {
                  "href" : "http://localhost:8080/owners/1"
               }
            },
            "firstName" : "Gabriel",
            "id" : 1,
            "lastName" : "Mediotti",
            "name" : "Gabriel Mediotti",
            "petName" : "Lola",
            "phoneNumber" : "11999999999"
         },
         {
            "_links" : {
               "owners" : {
                  "href" : "http://localhost:8080/owners"
               },
               "self" : {
                  "href" : "http://localhost:8080/owners/2"
               }
            },
            "firstName" : "Giulia",
            "id" : 2,
            "lastName" : "Pugliesi",
            "name" : "Giulia Pugliesi",
            "petName" : "Luna",
            "phoneNumber" : "11999999999"
         }
    ```
    - Get single records
    ```shell 
    curl -v http://localhost:8080/owners/1 | json_pp
    ```
    ```json
    "animalOwnerRecordList" : [
         {
            "_links" : {
               "owners" : {
                  "href" : "http://localhost:8080/owners"
               },
               "self" : {
                  "href" : "http://localhost:8080/owners/1"
               }
            },
            "firstName" : "Gabriel",
            "id" : 1,
            "lastName" : "Mediotti",
            "name" : "Gabriel Mediotti",
            "petName" : "Lola",
            "phoneNumber" : "11999999999"
         }
    ```
    

- POST
  - This will create a new record in the Database
    - To request this operation, you should execute the following command in terminal, replacing the "INSERT" fields with the required data to be inserted in the Database:
      ```shell
      curl -v -X POST localhost:8080/owners -H 'Content-Type:application/json' -d '{"firstName": "INSERT_FIRST_NAME", "lastName": "INSERT_LAST_NAME", "phoneNumber": "INSERT_PHONE_NUMBER", "petName": "INSERT_PET_NAME"}'
      ```
      - The commands follows the <a id="json-syntax">JSON syntax</a> below:
      ```json
      {"firstName": "INSERT_FIRST_NAME", 
      "lastName": "INSERT_LAST_NAME",
      "phoneNumber": "INSERT_PHONE_NUMBER", 
      "petName": "INSERT_PET_NAME"}
      ```
- DELETE
  - This will delete a specific record, to execute the command, you should specify an id to indicate which record will be deleted.
    ```shell
      curl -v -X DELETE localhost:8080/owners/*id*
    ```
- PUT  
  - This will update a record field.
    - OBS: You're only able to update the whole record, to not lost the previous data, fill all the fields when updating it.
    - ```json
        curl -v -X PUT localhost:8080/owners -H 'Content-Type:application/json' -d '{"firstName": "INSERT_FIRST_NAME", "lastName": "INSERT_LAST_NAME", "phoneNumber": "INSERT_PHONE_NUMBER", "petName": "INSERT_PET_NAME"}'
      ```
    - This follows the same POST [JSON syntax](#json-syntax).
