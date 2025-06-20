# NoteSync
# 📝 NoteSync

**NoteSync** is a simple Jetpack Compose-based  app to view notes from some public endpoint that demonstrates core modern Android development principles, including offline and online data management using Room and Retrofit, MVVM architecture, and the Repository Pattern.

---

## 🚀 Features

- 📋 View, and delete notes
- 🔄 Sync notes from a remote REST API (`jsonplaceholder.typicode.com`)
- 💾 Offline-first persistence with Room
- 🎨 Jetpack Compose UI
- 🧠 Clean architecture with MVVM + Repository Pattern
- 🔁 Reactive state management using StateFlow

---

## 🛠 Tech Stack

| Layer             | Tools / Libraries                               |
|-------------------|--------------------------------------------------|
| UI                | Jetpack Compose, Material3                       |
| State Management  | ViewModel, Kotlin StateFlow                     |
| Data (Local)      | Room Database                                    |
| Data (Remote)     | Retrofit + Gson                                  |
| Architecture      | MVVM, Repository Pattern                         |
| Language          | Kotlin                                           |
| Async             | Coroutines, Flows                                |

---

## 📦 Architecture Overview

```text
UI (Compose)
   ⬇️
ViewModel (StateFlow)
   ⬇️
Repository (syncs local & remote)
   ⬇️              ⬇️
Room DAO       Retrofit API

