# Custom Party Entity in Moqui

## About the Assignment  
In this assignment, I created a custom Party module in Moqui.  
The main goal was to understand how entities, enums, relationships, and UI forms work in Moqui.


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

### Add Create Form

In `PartyScreen.xml`, I added:

- A **transition** to call the `create#party.Party` service  
- A **container-dialog** to open the form  
- A **form-single** with:
  - `auto-fields-entity` for input fields  
  - A submit button  
- Proper default response handling  

This allows users to create new Party records directly from the UI.

## Testing in Moqui UI  

The Moqui application was started and the Party screen was accessed via the configured URL.  
New Party records were added using the Create Party form and the records were verified in the Party list.

The Moqui application was run and the **Entity Tools** section was used to:

- Check that all entities were listed correctly  
- Verify the entity fields and relationships  
- Add sample data using the **Data Import** tool  

This helped confirm that the entities were properly defined and working as expected.


## Conclusion  

This assignment helped in understanding how to:
- Design custom entities in Moqui  
- Use enums and relationships  
- Load seed data
- Build UI forms using XML Screens
- Call Services using transitions
- Manage code using Git






