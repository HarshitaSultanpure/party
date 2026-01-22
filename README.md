# Custom Party Entity in Moqui

## About the Assignment  
In this assignment, I created a custom Party module in Moqui.  
The main goal was to understand how entities, enums, relationships, services, REST APIs and UI forms work together in Moqui.

The main goal was to learn:

* Entity modeling
* Service creation
* Business logic using Groovy
* REST API exposure
* UI form integration
  
## What I Implemented  

I created the following entities:

- **Party** – Base entity for all people and organizations  
- **Person** – Stores individual person details  
- **PartyGroup** – Stores organization or company details  
- **ContactMech** – Stores contact information (email, phone, etc.)  
- **PartyContactMech** – Links parties with their contact details  

I also added enums for:

- **PartyType** (PERSON, PARTY_GROUP)  
- **ContactMechType** (EMAIL, TELECOM_NUMBER, POSTAL_ADDRESS)

These were used to keep the data consistent.


## Seed Test Data  

To test everything, I added some sample data:

- One PERSON with personal details  
- One PARTY_GROUP for an organization  
- Email and phone contact records  
- Links between party and contact info  

This helped verify that the entities and relationships are working properly.

## Party Create Form (UI Implementation)

I implemented a **Create Party form** in the Moqui UI using XML Screens.

### Features:

- A **transition** to call the `create#party.Party` service  
- A **container-dialog** to open the form  
- A **form-single** with:
  - `auto-fields-entity` for input fields  
  - A submit button  
- Proper default response handling  

This allows users to create new Party records directly from the UI.

## Create a Custom Person Creation Service in Moqui

I implemented a custom service to create **Person** records with proper validation and business logic.


### Service Definition (XML)

**Service name:**  
`party.create#Person`

### Required inputs:
- `partyId`
- `firstName`
- `lastName`

### Optional input:
- `dateOfBirth`

### Output:
- `responseMessage`


## Business Logic (Groovy)

The Groovy script performs:

- Validation of required fields  
- Verification that the Party exists  
- Creation of the Person record  
- Safe handling of extra parameters  
- Setting the response message in the service context  

### Example Response
```
Person Harshita Sultanpure created successfully!
```


## Exposing the Service as a REST API

I exposed the Person creation service as a REST API using a `.rest.xml` file.

### REST Configuration

**Endpoint:**

``` POST /rest/s1/party/person ```

**Service mapped:**
```
party.create#Person
```

### Example Request (JSON)

```json
{
  "partyId": "P100",
  "firstName": "Harshita",
  "lastName": "Sultanpure"
}
```
### Example Response
```
{
  "responseMessage": "Person Harshita Sultanpure created successfully!"
}
```
This allows external systems to create Person records using HTTP.


## Testing in Moqui UI  

### Moqui UI Tools

- Verified entities
- Checked relationships
- Loaded sample data

### Service Tools

- Tested party.create#Person service
- Verified validation and response handling
### REST API
- Tested POST requests using Postman
- Confirmed successful Person creation

This helped confirm that the entities were properly defined and working as expected.


## Conclusion  

This assignment helped in understanding how to:
- Custom entity design in Moqui
- Enum usage for data consistency
- Seed data loading
- XML Screen UI development
- Service creation with Groovy logic
- REST API exposure
- Debugging Moqui runtime issues
- Managing code with Git






