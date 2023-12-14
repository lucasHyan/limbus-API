# Character Controller API

## Endpoints

### 1. Get All Characters

- **Endpoint:** `GET /character`
- **Description:** Retrieves a paginated list of characters.
- **Parameters:**
  - `size` (optional, default: 13) - Number of items per page.
  - `sort`  (optional), Sort by (name/gender/sinnerNumber).
  - `order` (optional, default: "") - Sorting order (asc/desc).
  - `page` (optional, default: 1) - Page number.

- **Response:**
  - **200 OK:** Returns a list of characters with pagination information.
  - **404 Not Found:** If no characters are found or if the request parameters are invalid.

### 2. Get Character by ID

- **Endpoint:** `GET /character/{id}`
- **Description:** Retrieves a character by its ID.
- **Parameters:**
  - `id` (path variable) - The ID of the character to retrieve.

- **Response:**
  - **200 OK:** Returns the character with the specified ID.
  - **404 Not Found:** If the character with the specified ID is not found.

### 3. Delete Character by ID

- **Endpoint:** `DELETE /character/{id}`
- **Description:** Deletes a character by its ID.
- **Parameters:**
  - `id` The ID of the character to delete.

- **Response:**
  - **200 OK:** Returns the deleted character.
  - **404 Not Found:** If the character with the specified ID is not found.

### 4. Update Character by ID

- **Endpoint:** `PUT /character/{id}`
- **Description:** Updates a character by its ID.
- **Parameters:**
  - `id` (path variable) - The ID of the character to update.
  - `character` (request body) - The updated character object.
    
Example request body
```
{
    "name": "New Character",
    "bookQuote": "New Character Book Quote",
    "englishBookQuote": "New Character English Book Quote",
    "gender": "New Character Gender",
    "sinnerNumber": 1,
    "color": "#newcolor",
    "literarySource": "New Character Literary Source",
    "voiceActor": "New Character Voice Actor",
    "egos": [
        {
            "name": "New Ego Name",
            "quote": "New Ego Quote",
            "affinity": "New Ego Affinity",
            "abnormality": "New Ego Abnormality",
            "riskLevel": "New Ego Risk Level"
        }
    ]
}
```
    

- **Response:**
  - **200 OK:** Returns the updated character.
  - **404 Not Found:** If the character with the specified ID is not found.

### 5. Create Character

- **Endpoint:** `POST /character/create`
- **Description:** Creates a new character.
- **Parameters:**
  - `character` (request body) - The character object to create.

Example request body
```
{
    "name": "New Character",
    "bookQuote": "New Character Book Quote",
    "englishBookQuote": "New Character English Book Quote",
    "gender": "New Character Gender",
    "sinnerNumber": 1,
    "color": "#newcolor",
    "literarySource": "New Character Literary Source",
    "voiceActor": "New Character Voice Actor",
    "egos": [
        {
            "name": "New Ego Name",
            "quote": "New Ego Quote",
            "affinity": "New Ego Affinity",
            "abnormality": "New Ego Abnormality",
            "riskLevel": "New Ego Risk Level"
        }
    ]
}
```

- **Response:**
  - **200 OK:** Returns the created character.
  - **400 Bad Request:** If there is an issue with the request body or if the character creation fails.

