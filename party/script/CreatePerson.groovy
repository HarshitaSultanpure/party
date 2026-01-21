// Required parameter validation
if (!partyId) {
    return [errorMessage: "partyId is required"]
}
if (!firstName) {
    return [errorMessage: "firstName is required"]
}
if (!lastName) {
    return [errorMessage: "lastName is required"]
}

// Check if Party exists
def party = ec.entity.find("party.Party")
        .condition("partyId", partyId)
        .one()

if (!party) {
    return [errorMessage: "Party with ID ${partyId} does not exist"]
}

// Create Person only if Party exists
def person = ec.entity.makeValue("party.Person")
person.partyId = partyId
person.firstName = firstName
person.lastName = lastName

if (dateOfBirth) {
    person.dateOfBirth = dateOfBirth
}

// Set any additional parameters dynamically
def ignoreFields = ["partyId", "firstName", "lastName", "dateOfBirth", "result", "moquiSessionToken"]

def validFields = person.getEntityDefinition().getAllFieldNames()

context.each { key, value ->
    if (!ignoreFields.contains(key) && validFields.contains(key)) {
        person.set(key, value)
    }
}

person.create()

// Return success message
responseMessage = "Person ${firstName} ${lastName} created successfully!"