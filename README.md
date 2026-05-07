# Immobilière – Catalogue Immobilier en Ligne

## 🎯 Présentation professionnelle

**Immobilière** est une application web **full‑stack Java Spring Boot** qui propose un **catalogue moderne et premium** de biens immobiliers (appartements, maisons, terrains, bureaux & commerces) avec :
- Des images haute résolution tirées d’Unsplash, parfaitement adaptées aux types de biens (terrains tunisiens, villas, boutiques modernes, etc.).
- Un moteur de recherche avancé (filtrage par type, ville, prix, surface, nombre de pièces, statut).
- La prise de rendez‑vous en ligne et l’envoi d’emails de contact (simulation).
- Une UI **responsive** et **esthétique** (Thème sombre, effets micro‑animations, typographie Inter, couleurs harmonieuses).

> **Objectif** : Offrir aux agences immobilières tunisiennes un outil clé en main, élégant et fonctionnel pour présenter leurs biens à leurs clients.

---

## 🛠️ Technologies & Stack

| Domaine            | Technologie / Bibliothèque                              |
|--------------------|--------------------------------------------------------|
| **Backend**        | Java 17, Spring Boot 3, Spring Data JPA, Hibernate    |
| **Base de données**| MySQL (auto‑création via `spring.datasource.url`)      |
| **Frontend**       | Thymeleaf, HTML5, CSS3 (design premium, animations)  |
| **Gestion des assets** | Spring MVC multipart upload, dossier `uploads/` |
| **Build**          | Maven Wrapper (`./mvnw`)                               |
| **Versioning**     | Git & GitHub (https://github.com/AlaaBedouii/Immobiliere) |

---

## 🚀 Installation & Démarrage

1. **Pré‑requis**
   - JDK 17 (ou plus) installé.
   - Maven 3.9+ (ou utilisez le wrapper `./mvnw`).
   - MySQL en cours d’exécution (création de la base `immobilier` automatique).

2. **Cloner le dépôt**
   ```bash
   git clone https://github.com/AlaaBedouii/Immobiliere.git
   cd Immobiliere
   ```

3. **Configurer la base de données** (optionnel) – fichier `src/main/resources/application.properties` déjà prêt :
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/immobilier?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
   spring.datasource.username=root
   spring.datasource.password=   # ← mettre votre mot de passe MySQL
   ```

4. **Lancer l’application**
   ```bash
   ./mvnw spring-boot:run
   ```
   L’application démarre sur **http://localhost:8080**.

5. **Accéder au catalogue**
   - Ouvrez votre navigateur et rendez‑vous sur `http://localhost:8080/catalogue`.
   - Vous y verrez les biens avec leurs images premium.

---

## 🖼️ Screenshots (extraits du catalogue)

> *(Les images proviennent d’Unsplash et sont intégrées dans la base de données via le script `data.sql`.)*

| Terrain constructible | Terrain agricole |
|----------------------|-----------------|
| ![Terrain constructible](https://images.unsplash.com/photo-1599933334293-b097cc0f6990?w=800) | ![Terrain agricole](https://images.unsplash.com/photo-1467043237213-65f2da53396f?w=800) |
| Grand Terrain industriel | Boutique moderne |
| ![Industrial land](https://images.unsplash.com/photo-1590247813693-5541d1c609fd?w=800) | ![Boutique front](https://images.unsplash.com/photo-1441986300917-64674bd600d8?w=800) |

---

## 📂 Structure du projet

```
immobilier/
│
├─ src/main/java/com/fst/immobilier/        # Code Java (controllers, services, entities)
│   ├─ controller/        # VisiteController, CatalogueController, AdminController
│   ├─ dto/               # Data Transfer Objects
│   ├─ entity/            # Modèles JPA (Bien, PhotoBien, Agent, Client…)
│   └─ repository/        # Interfaces Spring Data JPA
│
├─ src/main/resources/                      # Configurations & templates
│   ├─ static/            # CSS, JS, images (front‑end)
│   ├─ templates/         # Thymeleaf – pages HTML
│   └─ data.sql           # Script d’initialisation (biens + photos)
│
├─ pom.xml                # Dépendances Maven
└─ README.md              # <‑‑ Ce fichier de présentation
```

---

## 🤝 Contribuer

1. **Fork** le dépôt.
2. Créez une branche `feature/…` ou `bugfix/…`.
3. Commitez vos changements avec des messages clairs.
4. Ouvrez une **Pull Request** décrivant vos modifications.

> Toutes les contributions respectant le **code‑style** (indentation 4 espaces, respect du naming convention Java) seront les bienvenues.

---

## 📄 Licence

Ce projet est sous licence **MIT** – vous êtes libre de l’utiliser, le modifier et le distribuer.

---

## 📞 Contact

- **Développeur principal** : *Alaa Bedouii* – alaa.bedouii@example.com
- **Support** : ouvrez une issue sur GitHub.

---

### 🚀 Lien du dépôt GitHub
[https://github.com/AlaaBedouii/Immobiliere](https://github.com/AlaaBedouii/Immobiliere)

---

*Cette présentation a été générée pour offrir une vue d’ensemble claire, professionnelle et prête à être partagée avec les parties prenantes ou les clients potentiels.*
