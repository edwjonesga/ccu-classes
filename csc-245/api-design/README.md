
# Procrastinot — Hands-On OpenAPI (JSON) Lab

You’ll build a small REST API spec (JSON, not YAML) in VS Code, in bite-size steps.

## Prereqs (2 min)

1. Open VS Code → Extensions (Ctrl/Cmd+Shift+X).
2. Install an OpenAPI/Swagger extension that validates/previews OpenAPI.
3. Create a file named **`procrastinot.json`** in your repo.

---

## Step 1 — Empty shell (copy-paste)

Paste this as your starting file and replace the `<PLACEHOLDERS>`:

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

**What these mean (super short):**

* `openapi` → spec version
* `info` → human metadata
* `servers` → where the API will run
* `paths` → endpoints live here
* `components.schemas` → reusable data shapes

---

## Step 2 — Create Room (build one endpoint fully)

We’ll model **rooms**. Start with the **POST /rooms** endpoint and its request/response shapes.

### 2a) Add request/response schemas

Add these **inside** `"components": { "schemas": { ... } }`:

```json
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
},
"Error": {
  "type": "object",
  "required": ["message"],
  "properties": { "message": { "type": "string" } }
}
```

### 2b) Add `POST /rooms` to `paths`

Inside `"paths": { ... }`, add:

```json
"/rooms": {
  "post": {
    "summary": "Create Room",
    "requestBody": {
      "required": true,
      "content": {
        "application/json": {
          "schema": { "$ref": "#/components/schemas/CreateRoomRequest" },
          "examples": {
            "happyPath": {
              "summary": "Valid create payload",
              "value": { "name": "Algebra Hour", "mode": "pomodoro" }
            }
          }
        }
      }
    },
    "responses": {
      "201": {
        "description": "Room created",
        "content": {
          "application/json": {
            "schema": { "$ref": "#/components/schemas/Room" },
            "examples": {
              "happyPath": {
                "summary": "Typical response",
                "value": {
                  "id": "r_123",
                  "name": "Algebra Hour",
                  "mode": "pomodoro",
                  "inviteCode": "AB12CD"
                }
              }
            }
          }
        }
      },
      "400": {
        "description": "Bad Request",
        "content": {
          "application/json": {
            "schema": { "$ref": "#/components/schemas/Error" },
            "examples": { "bad": { "value": { "message": "invalid payload" } } }
          }
        }
      }
    }
  }
}
```

✅ You’ve fully described **Create Room**.

---

## Step 3 — Simple **GET** (return a room)

Add this under the **same** `"/rooms/{roomId}"` path object (create it if needed). If you paste separate blocks, remember to **merge** them under the same path key.

```json
"/rooms/{roomId}": {
  "get": {
    "summary": "Get Room",
    "parameters": [
      { "name": "roomId", "in": "path", "required": true, "schema": { "type": "string" } }
    ],
    "responses": {
      "200": {
        "description": "OK",
        "content": {
          "application/json": {
            "schema": { "$ref": "#/components/schemas/Room" },
            "examples": {
              "happyPath": {
                "summary": "Typical room",
                "value": {
                  "id": "r_123",
                  "name": "Algebra Hour",
                  "mode": "pomodoro",
                  "inviteCode": "AB12CD"
                }
              }
            }
          }
        }
      },
      "404": {
        "description": "Not Found",
        "content": {
          "application/json": {
            "schema": { "$ref": "#/components/schemas/Error" },
            "examples": { "nf": { "value": { "message": "roomId not found" } } }
          }
        }
      }
    }
  }
}
```

---

## Step 4 — Simple **PATCH** (update room name/mode)

Add a small update schema in `components.schemas`:

```json
"UpdateRoomRequest": {
  "type": "object",
  "properties": {
    "name": { "type": "string", "minLength": 1, "maxLength": 60 },
    "mode": { "type": "string", "enum": ["pomodoro", "deep"] }
  },
  "additionalProperties": false
}
```

Then add the endpoint under `"/rooms/{roomId}"` (merge with GET):

```json
"patch": {
  "summary": "Update Room",
  "description": "Change name and/or mode.",
  "parameters": [
    { "name": "roomId", "in": "path", "required": true, "schema": { "type": "string" } }
  ],
  "requestBody": {
    "required": true,
    "content": {
      "application/json": {
        "schema": { "$ref": "#/components/schemas/UpdateRoomRequest" },
        "examples": {
          "rename": { "value": { "name": "Geometry Jam" } },
          "toggle": { "value": { "mode": "deep" } }
        }
      }
    }
  },
  "responses": {
    "200": {
      "description": "Updated",
      "content": {
        "application/json": {
          "schema": { "$ref": "#/components/schemas/Room" },
          "examples": {
            "afterRename": {
              "value": { "id": "r_123", "name": "Geometry Jam", "mode": "pomodoro", "inviteCode": "AB12CD" }
            }
          }
        }
      }
    },
    "400": {
      "description": "Bad Request",
      "content": {
        "application/json": { "schema": { "$ref": "#/components/schemas/Error" } }
      }
    },
    "404": {
      "description": "Not Found",
      "content": {
        "application/json": { "schema": { "$ref": "#/components/schemas/Error" } }
      }
    }
  }
}
```

---

## Step 5 — Simple **DELETE** (remove a room)

Add under `"/rooms/{roomId}"` (merge with GET/PATCH):

```json
"delete": {
  "summary": "Delete Room",
  "parameters": [
    { "name": "roomId", "in": "path", "required": true, "schema": { "type": "string" } }
  ],
  "responses": {
    "204": { "description": "No Content" },
    "404": {
      "description": "Not Found",
      "content": {
        "application/json": { "schema": { "$ref": "#/components/schemas/Error" } }
      }
    }
  }
}
```

> Teaching beat: **201** for create, **200** for read/update success with body, **204** for delete success without body, **4xx** for client errors.

---

## Step 6 — (Optional) List Rooms, briefly

Add a minimal summary now; you can flesh it out later with a `RoomSummary` array.

```json
"/rooms": {
  "get": {
    "summary": "List Rooms",
    "responses": { "200": { "description": "OK" } }
  },
  "post": { ... Create Room from Step 2 ... }
}
```

---

## Step 7 — Actions: small example (room state update)

Sometimes you need **state transitions** that aren’t simple CRUD. Two patterns:

### A) REST-y state patch (recommended)

Create a sub-resource `session` you can **PATCH**:

**Schemas (add to components.schemas):**

```json
"Session": {
  "type": "object",
  "properties": {
    "state": { "type": "string", "enum": ["idle", "running", "break"] },
    "startedAt": { "type": "string", "format": "date-time", "nullable": true },
    "durationSec": { "type": "integer", "nullable": true }
  }
},
"UpdateSessionRequest": {
  "type": "object",
  "oneOf": [
    {
      "description": "Start a work session",
      "required": ["action", "durationSec"],
      "properties": {
        "action": { "type": "string", "enum": ["startWork"] },
        "durationSec": { "type": "integer", "minimum": 60 }
      }
    },
    {
      "description": "Stop session",
      "required": ["action"],
      "properties": { "action": { "type": "string", "enum": ["stop"] } }
    }
  ]
}
```

**Endpoint (add under `paths`):**

```json
"/rooms/{roomId}/session": {
  "patch": {
    "summary": "Update Room Session (action via PATCH)",
    "parameters": [
      { "name": "roomId", "in": "path", "required": true, "schema": { "type": "string" } }
    ],
    "requestBody": {
      "required": true,
      "content": {
        "application/json": {
          "schema": { "$ref": "#/components/schemas/UpdateSessionRequest" },
          "examples": {
            "start": { "value": { "action": "startWork", "durationSec": 1500 } },
            "stop": { "value": { "action": "stop" } }
          }
        }
      }
    },
    "responses": {
      "200": {
        "description": "Session state",
        "content": {
          "application/json": {
            "schema": { "$ref": "#/components/schemas/Session" },
            "examples": {
              "running": {
                "value": { "state": "running", "startedAt": "2025-09-04T16:00:00Z", "durationSec": 1500 }
              }
            }
          }
        }
      },
      "400": { "description": "Bad Request" },
      "404": { "description": "Not Found" },
      "409": { "description": "Invalid state transition" }
    }
  }
}
```

### B) Action-ish method (optional to discuss)

Some APIs use custom methods like `POST /rooms/{roomId}:start`. This is pragmatic, but less resource-oriented. Use it sparingly for teaching best practices.

---

## What to do next (student instructions)

### Part 1 — Finish the Room basics

* Ensure your spec includes:

  * `POST /rooms` (201 with `Room`)
  * `GET /rooms/{roomId}` (200 with `Room`, 404 error body)
  * `PATCH /rooms/{roomId}` (200 with `Room`, 400/404)
  * `DELETE /rooms/{roomId}` (204, 404)
  * `GET /rooms` (200 with a list you define later)
* Validate your spec (no JSON errors, no duplicate path keys).

### Part 2 — Add the Action example

* Add **either** the REST-y `PATCH /rooms/{roomId}/session` from Step 7 **or** propose your own state action.
* Include at least **one** example for request and response.

### Part 3 — Take-home user stories (design the endpoints)

Design your endpoints (paths, methods, basic schemas, status codes). You don’t have to fully implement every response schema—focus on clean resource design, parameters, and the right HTTP semantics.

1. **Join a Room**
   *As a student, I want to join an existing room using an invite code.*
   **Hint A (resource-oriented):** create a membership resource under the room; consider **idempotency** (first join 201, repeat 204).
   **Hint B (action-ish):** `POST` with `{ inviteCode }` in the body; decide what 4xx to return for a bad/expired code.

2. **Leave a Room**
   *As a participant, I want to leave a room so I no longer appear in the list.*
   **Hint:** delete your membership; respond **204**.

3. **List Participants**
   *As a participant, I want to see who’s in the room.*
   **Hint:** a `GET` that returns an array (decide minimal fields: `uid`, `displayName`).

4. **See Current Session Details**
   *As a participant, I want to see the current mode/timer.*
   **Hint:** reuse your `Session` schema or define a small read-only projection.

5. **(Optional) Start Break**
   *As an owner, I want to switch the session to a short break.*
   **Hint:** another action/state transition—extend `UpdateSessionRequest` or add a second method.

**Grading ideas (rubric):**

* Correct method/status code choices (201/200/204/4xx).
* Clean resource naming (`rooms`, `roomId`, `participants`).
* Reusable schemas (`Room`, `Error`, etc.).
* At least one **example** per request/response where applicable.
* Clear justifications for action vs resource modeling.

### Validation & Types (optional but recommended)

```bash
npx @redocly/cli lint procrastinot.json
npx openapi-typescript procrastinot.json -o api-types.d.ts
```

---

If you want, I can bundle this into a ready-to-ship **starter `procrastinot.json`** that includes the Create/GET/PATCH/DELETE examples above plus the session action endpoint, with TODO markers for the take-home stories.
