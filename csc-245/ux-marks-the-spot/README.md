# UX Marks the Spot
This assignment is all about creating the user experience for your users. Let's spend some time to mock up the designs and the
user flows to give our users a delightful experience.

In class today let's do some together on the board, then do some on paper and take pictures to present in class.

## 🎯 1. Focus Rooms (Groups)

> **Create a Room**
> *As a student, I want to create a focus room so I can bring my peers together in one place.*

> **Join a Room with Invite Code**
> *As a student, I want to join a focus room using a link or invite code so I can collaborate with others.*

> **See My Rooms**
> *As a user, I want to see all the rooms I belong to so I can quickly access them.*

### 🧩 UI Implications

* **Screens:** “My Rooms” dashboard, “Create Room” modal/form, “Join Room” screen.
* **UI Components:** room cards, invite code input, “Create” button, “Join” button.
* **API Interaction:**

  * `GET /rooms` – fetch user’s rooms
  * `POST /rooms` – create a room
  * `POST /rooms/join` – join with invite code

### 🏫 Classroom Design Activity

Each group designs:

1. The “My Rooms” page layout.
2. The “Create Room” and “Join Room” forms.
3. A simple success/failure message flow.
   Have them annotate where API calls occur and where client-side validation is needed.

---

## ⏱️ 2. Sessions (Study Time)

> **Start a Session**
> *As a user, I want to start a study session within a room so everyone can sync up.*

> **Choose Study Mode**
> *As a user, I want to pick a session mode (Pomodoro or Deep Study) so we can manage our time.*

> **Join a Session**
> *As a user, I want to join a session by specifying my tasks so I can commit to what I’ll accomplish.*

> **Track Progress**
> *As a user, I want to update my tasks during a session so others can see my progress.*

### 🧩 UI Implications

* **Screens:** session setup screen, live session dashboard, timer component, task list.
* **UI Components:**

  * Mode selector (Pomodoro / Deep Study)
  * Timer + progress bar
  * Task list with “completed” toggles
  * “Start Session” and “End Session” buttons
* **API Interaction:**

  * `POST /sessions` – create session
  * `GET /sessions/:id` – fetch session state
  * `PATCH /sessions/:id/tasks` – update progress

### 🏫 Classroom Design Activity

Groups storyboard the **session lifecycle**:

1. What happens before the session (select mode).
2. During the session (progress tracking).
3. After the session (summary).
   Ask them to consider: “How does UI feedback keep the user motivated and accountable?”

---

## 👥 3. Focus Friends (People Network)

> **See Focus Friends**
> *As a user, I want to see all my focus friends (people in my rooms) so I know who’s available.*

> **Join Friend’s Session with Tasks**
> *As a user, I want to join a friend’s active session by declaring my tasks so I can participate meaningfully.*

### 🧩 UI Implications

* **Screens:** friends list / network view, friend’s session pop-up.
* **UI Components:**

  * Avatar grid with status indicators (available, in session, offline).
  * “Join Session” modal with task entry form.
* **API Interaction:**

  * `GET /friends` – list friends
  * `GET /sessions/active` – friend’s active session
  * `POST /sessions/:id/join` – join with tasks

### 🏫 Classroom Design Activity

Teams design a **social presence** element:

* How do users see who’s online or studying?
* How will the UI convey “community” visually (colors, icons, subtle animations)?
* Encourage accessibility & visual clarity — not clutter.

---

## 🔔 4. Accountability & Nudges

> **Get Nudges**
> *As a user, I want to receive gentle nudges when I’m inactive so I can refocus.*

> **View Peer Progress**
> *As a user, I want to see how my peers are progressing so we can keep each other accountable.*

### 🧩 UI Implications

* **Screens:** dashboard with progress overview, nudge notifications.
* **UI Components:**

  * Progress feed (peer task completion %).
  * Notification panel or toast message (“Hey! Haven’t seen updates in a while…”).
* **API Interaction:**

  * `GET /sessions/:id/progress` – peer updates
  * WebSocket or polling for live nudges
  * `POST /nudge` – send nudge (optional)

### 🏫 Classroom Design Activity

Run a “micro-prototype” exercise:

* Teams sketch the notification style (pop-up, banner, sound, vibration).
* Discuss **tone** — how to make nudges encouraging rather than shaming.
* Connect it to stewardship: designing UIs that support focus and community.

---
