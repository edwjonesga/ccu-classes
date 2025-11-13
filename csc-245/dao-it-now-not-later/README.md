# DAO It Now, Not Later

### Building the Procrastinot Data Access Layer

Welcome to the next step in building **Procrastinot** — your productivity platform designed to help students stay on track and avoid delaying their work.
In this assignment, you will create the **entire Data Access Layer (DAL)** for Procrastinot using **DAOs, repositories, and a mini-ORM mapper**, all inside a single JavaScript module.

The main goal:

> **Abstract all data access behind clean interfaces so the rest of the app never depends on the underlying storage.**

This ensures we can later swap the in-memory database for Firebase, Firestore, Cloud SQL, or anything else — **without changing the rest of the codebase.**

---

## 🚀 Objectives

By completing this assignment, you will:

* Understand and apply the **Repository Pattern**
* Implement **DAO abstractions** for all models
* Use **Dependency Inversion (SOLID)** to depend on interfaces instead of concrete classes
* Build a **mini-ORM style mapper** for shaping entity objects
* Create a consistent, well-structured **data model** across all Procrastinot layers
* Prepare the foundation for the upcoming **API layer assignment**

---

## 📦 Entities to Implement

Your data layer must define these models:

### **User**

```
{
  id: string,
  displayName: string,
  email: string,
  avatarUrl: string,
  createdAt: number
}
```

### **Room**

```
{
  id: string,
  name: string,
  description: string,
  ownerId: string,
  createdAt: number
}
```

### **RoomMembership**

```
{
  id: string,
  roomId: string,
  userId: string,
  role: "member" | "admin",
  joinedAt: number
}
```

### **Session**

```
{
  id: string,
  roomId: string,
  userId: string,
  startTime: number,
  endTime: number,
  mode: "focus" | "break",
  durationMinutes: number
}
```

### **Task**

```
{
  id: string,
  userId: string,
  roomId: string | null,
  title: string,
  completed: boolean,
  createdAt: number,
  completedAt: number | null
}
```

### **Message** (optional but recommended)

```
{
  id: string,
  roomId: string,
  userId: string,
  text: string,
  createdAt: number
}
```

---

## 🧱 In-Memory Database

Your module should contain a simple in-memory database object:

```
const db = {
  users: {},
  rooms: {},
  memberships: {},
  sessions: {},
  tasks: {},
  messages: {}
};
```

Repositories will operate against this object.

---

## 🧩 Repository Requirements

For **each model**, create:

### ✔ An Interface

Defines the contract for CRUD + domain queries.

Example for Rooms:

```
class IRoomRepository {
  createRoom(room) {}
  getRoomById(id) {}
  getRoomsByOwner(ownerId) {}
  updateRoom(id, fields) {}
  deleteRoom(id) {}
}
```

### ✔ A Concrete Implementation

Stored in-memory and fulfilling the interface.

Example:

```
class InMemoryRoomRepository extends IRoomRepository {
  constructor(database) {
    super();
    this.db = database.rooms;
  }

  createRoom(room) {
    this.db[room.id] = room;
    return room;
  }

  getRoomById(id) {
    return this.db[id] || null;
  }

  getRoomsByOwner(ownerId) {
    return Object.values(this.db).filter(r => r.ownerId === ownerId);
  }

  updateRoom(id, fields) {
    if (!this.db[id]) return null;
    this.db[id] = { ...this.db[id], ...fields };
    return this.db[id];
  }

  deleteRoom(id) {
    delete this.db[id];
  }
}
```

---

## 🧠 Mini-ORM Mapper

You must implement a simple mapping utility for shaping raw JS objects into properly structured entities.

Example:

```
function mapToEntity(schema, data) {
  const obj = {};
  for (const key of Object.keys(schema)) {
    const def = schema[key].default;
    obj[key] = data[key] ?? (typeof def === "function" ? def() : def);
  }
  return obj;
}
```

Each model should have:

* A schema definition
* A mapper function

---

## 🔍 Domain Queries

Each repository must also include **model-specific queries**, e.g.:

### Users

* getUserByEmail(email)
* getUsersInRoom(roomId)

### Rooms

* getRoomsByOwner(ownerId)
* getRoomsForUser(userId)

### Tasks

* getTasksForUser(userId)
* getIncompleteTasks(userId)
* getCompletedTasks(userId)

### Sessions

* getSessionsForRoom(roomId)
* getSessionsForUser(userId)

### Memberships

* getMembers(roomId)

---

## 📁 File Requirements

Submit **one JavaScript file**:

### `dataLayer.js`

This file must contain:

1. All schemas
2. Mini-ORM mapper
3. In-memory database
4. Repository interfaces
5. Repository implementations
6. Exports for use in the API layer

---

## 📬 Submission

Submit your final file:

```
dataLayer.js
```

through the course portal or GitHub Classroom (if applicable).

---

## 🎉 Final Notes

This assignment lays the foundation for the full Procrastinot backend.
Once you implement the data layer, we will build and/or connect it to the:

* Authentication layer
* REST API
* UI integration
* Firestore-backed implementation (later)

**DAO It Now, Not Later — don’t procrastinate your Procrastinot data layer!**
Happy coding!
