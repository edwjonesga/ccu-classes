love this. here’s a clean, classroom-friendly walkthrough you can drop into your LMS or handout. it’s broken into your 8 steps, uses JSON (not YAML), and keeps copy-paste blocks tiny with fill-in-the-blank placeholders.

# 1) Empty shell (basics) — copy/paste, then explain

Create `openapi.json` in VS Code and paste:

```json
{
  "openapi": "3.1.0",
  "info": {
    "title": "<YOUR_API_TITLE>",
    "version": "<YOUR_VERSION>",
    "description": "<ONE_SENTENCE_DESCRIPTION>"
  },
  "servers": [
    { "url": "<http://localhost:3000>", "description": "dev" }
  ],
  "paths": {},
  "components": { "schemas": {} }
}
```

**Basics to explain (very briefly):**

* `openapi` — spec version.
* `info` — human metadata.
* `servers` — where this API lives (dev/prod).
* `paths` — the endpoints go here.
* `components` — reusable bits (schemas, responses, etc.).

---

# 2) HTTP action snippets (tiny drop-ins)

> Paste **inside** `"paths": { ... }`. Replace `<RESOURCE>` and `<idParam>`.

**POST (create)**

```json
"/<RESOURCE>": {
  "post": {
    "summary": "Create <Resource>",
    "requestBody": {
      "required": true,
      "content": { "application/json": { "schema": { "$ref": "#/components/schemas/<Resource>" } } }
    },
    "responses": { "201": { "description": "Created" }, "400": { "description": "Bad Request" } }
  }
}
```

**GET one (read)**

```json
"/<RESOURCE>/{<idParam>}": {
  "get": {
    "summary": "Get one <Resource>",
    "parameters": [{ "name": "<idParam>", "in": "path", "required": true, "schema": { "type": "string" } }],
    "responses": { "200": { "description": "OK" }, "404": { "description": "Not Found" } }
  }
}
```

**GET many (list)**

```json
"/<RESOURCE>": {
  "get": {
    "summary": "List <Resource>",
    "responses": { "200": { "description": "OK" } }
  }
}
```

**PATCH (partial update)**

```json
"/<RESOURCE>/{<idParam>}": {
  "patch": {
    "summary": "Update <Resource>",
    "parameters": [{ "name": "<idParam>", "in": "path", "required": true, "schema": { "type": "string" } }],
    "requestBody": {
      "required": true,
      "content": { "application/json": { "schema": { "type": "object" } } }
    },
    "responses": { "200": { "description": "Updated" }, "400": { "description": "Bad Request" } }
  }
}
```

**DELETE (remove)**

```json
"/<RESOURCE>/{<idParam>}": {
  "delete": {
    "summary": "Delete <Resource>",
    "parameters": [{ "name": "<idParam>", "in": "path", "required": true, "schema": { "type": "string" } }],
    "responses": { "204": { "description": "No Content" }, "404": { "description": "Not Found" } }
  }
}
```

---

# 3) Talk through them (what to stress)

* **Nouns, not verbs**: endpoints are resources (`/rooms`), verbs are HTTP methods.
* **Status codes**: `201` create, `200` read/update, `204` delete, `400/404` errors.
* **Schemas**: requests/responses should be described in `components/schemas`.

---

# 4) First user story (create rooms)

**As a student, I want to create a focus room so I can invite my peers and study together.**
**Acceptance:** provide a name and mode (`pomodoro` or `deep`), get back an `id` and an `inviteCode`.

---

# 5) Copy-paste starter for “Create Room” (with blanks)

Drop this in your shell:

```json
{
  "openapi": "3.1.0",
  "info": { "title": "Study Rooms API", "version": "1.0.0", "description": "Minimal spec for class" },
  "servers": [ { "url": "http://localhost:3000" } ],
  "paths": {
    "/rooms": {
      "post": {
        "summary": "Create Room",
        "requestBody": {
          "required": true,
          "content": {
            "application/json": {
              "schema": { "$ref": "#/components/schemas/CreateRoomRequest" },
              "example": { "name": "Algebra Hour", "mode": "pomodoro" }
            }
          }
        },
        "responses": {
          "201": {
            "description": "Room created",
            "content": {
              "application/json": {
                "schema": { "$ref": "#/components/schemas/Room" },
                "example": { "id": "r_123", "name": "Algebra Hour", "mode": "pomodoro", "inviteCode": "AB12CD" }
              }
            }
          },
          "400": { "description": "Bad Request" }
        }
      }
    }
  },
  "components": {
    "schemas": {
      "CreateRoomRequest": {
        "type": "object",
        "required": ["name", "mode"],
        "properties": {
          "name": { "type": "string", "minLength": 1, "maxLength": 60 },
          "mode": { "type": "string", "enum": ["pomodoro", "deep"] }
        }
      },
      "Room": {
        "type": "object",
        "required": ["id", "name", "mode", "inviteCode"],
        "properties": {
          "id": { "type": "string" },
          "name": { "type": "string" },
          "mode": { "type": "string", "enum": ["pomodoro", "deep"] },
          "inviteCode": { "type": "string" }
        }
      }
    }
  }
}
```

**Student TODOs:**

* Make up your own examples (change `name`, try `deep`).
* Add a validation rule you care about (e.g., max 40 chars).
* Explain why this returns **201** instead of **200**.

---

# 6) List & CRUD for rooms (lighter guidance)

Add endpoints for:

* **List all rooms**: `GET /rooms` → `200` with an array of `RoomSummary`.
* **Get one**: `GET /rooms/{roomId}` → `200` with `Room`.
* **Update**: `PATCH /rooms/{roomId}` → allow changing `name` or `mode`.
* **Delete**: `DELETE /rooms/{roomId}` → `204`.

Hints (don’t fully spoon-feed):

* Create a `RoomSummary` schema with fewer fields than `Room`.
* For `PATCH`, define a tiny schema with **optional** `name` and `mode`.
* Error responses: at least `404` for unknown `roomId`.

---

# 7) “Join a room” — subtle direction, not the answer

**Goal:** “As a student, I want to join an existing room by invite code.”

Two common designs—pick one and implement:

* **Resource-oriented (more RESTy)**
  *Hint:* treat a membership as a new resource under the room.
  – Where would you `POST` or `PUT`?
  – What path would include the **user**?
  – What status should repeat joins return (idempotency)?

* **Action-ish (pragmatic)**
  *Hint:* a one-off action hanging off the room path.
  – What verb (POST/PATCH) best matches “performing an action”?
  – Where does the `inviteCode` live—in the body or the path?

Don’t forget: on **success**, what should the response body include so the UI can immediately show **participants**?

---

# 8) Remaining assignments — trimmed user stories

Follow the patterns above and design endpoints (no full answers here):

1. **Rename Room**
   *As an owner, I want to rename my room.*
   *Acceptance:* valid non-empty name updates successfully; invalid names get `400`.

2. **Toggle Mode**
   *As an owner, I want to switch between Pomodoro and Deep Study.*
   *Acceptance:* changing `mode` updates the room and is visible on subsequent `GET`.

3. **Leave Room**
   *As a participant, I want to leave a room so I no longer appear in the list.*
   *Acceptance:* leaving succeeds with `204`; subsequent participant list excludes me.

4. **See Participants**
   *As a participant, I want to view who’s in the room.*
   *Acceptance:* `GET` returns an array of participants with names.

5. **Start/Stop Session (timer)**
   *As an owner, I want to start/stop a study session so everyone sees the same timer.*
   *Acceptance:* starting sets a start time + duration; stopping clears or resets.
   *Design prompt:* would you “patch room state” or “create a separate `session` resource”? Why?

**Rubric ideas for grading:**

* Correct use of HTTP methods/status codes.
* Clear, reusable schemas under `components/schemas`.
* Consistent naming (`rooms`, `roomId`, `participants`).
* At least one example per request/response.
* Thoughtful error responses (`400`, `404`).

If you want, I can bundle this into a single `openapi.json` with TODO comments removed and just placeholders, so students don’t fight the linter.
