## Beadandó feladat második körre

---

Egyedül a REST API működik rendesen (`ablakozo-server`). 
A CLI client pedig csak próbálkozás ameddig kinem futottam az időből.

---

REST API endpoints:
- **GET** `http://localhost:8080/api/user/all`                fetch all user
- **GET** `http://localhost:8080/api/user={userId}`           fetch user by id
- **GET** `http://localhost:8080/api/user={userId}/apps`      fetch all app by user_id
- **POST** `http://localhost:8080/api/user={userId}/add`      add user
- **POST** `http://localhost:8080/api/user={userId}/apps/add` add app
- **PUT** `http://localhost:8080/api/{userId}/edit`           edit user
- **PUT** `http://localhost:8080/api/{appId}/edit`            edit app
- **DELETE** `http://localhost:8080/api/{userId}/delete`      delete user
- **DELETE** `http://localhost:8080/api/app={appId}/delete`   delete app
