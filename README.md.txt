# Incident Tracker Mini App

## Overview
Full stack application to manage production incidents.

## Tech Stack
Backend: Spring Boot, JPA, H2
Frontend: HTML, CSS, JavaScript

---

## How to Run

### Backend
1. Open terminal inside backend folder
2. Run:
   mvnw.cmd spring-boot:run
3. Runs on:
   http://localhost:8081

Swagger:
http://localhost:8081/swagger-ui/index.html

---

### Frontend
1. Open frontend/index.html using Live Server
2. Runs on:
   http://127.0.0.1:5500

---

## APIs

POST /api/incidents  
GET /api/incidents  
GET /api/incidents/{id}  
PATCH /api/incidents/{id}

---

## Improvements
- Add search & filter
- Seed 200 records
- Improve UI styling
- Add authentication
