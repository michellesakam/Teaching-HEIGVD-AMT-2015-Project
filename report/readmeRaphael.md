# Rapport de projet

## Introduction
Ce rapport présente notre projet de groupe à la HEIG-VD dans le cadre du cours Applications Multi-Tiers de Monsieur Olivier Liechti.

## Manuel utilisateur

### Comment exécuter et accéder à l'application

Premièrement, il faut installer NetBeans avec l'extension Glassfish à partir de ce [lien](https://netbeans.org/downloads/) (prendre la colonne Java EE ou bien la colonne All)

Ensuite, il faut avoir un serveur MySQL avec une base de données vide appelée <b>projetamt</b> avec la configuration suivante :
<li>Nom d'utilisateur : root
<li>Mot de passe : toor
<li>Serveur : localhost
<li>Port : 3306

Ces paramètres peuvent être réglés dans le pool MySQL une fois qu'il aura été créer automatiquement par NetBeans à la compilation du projet.

Ensuite, il faut ouvrir dans NetBeans le projet qui se trouve dans le répertoire src et qui se nomme GamificationProject.

Il se peut que dans Glassfish il faille ajouter un JNDI dans le répertoire JDBC Resources nommé jdbc/projetamt et qui se connecte à un poll (nommé mysql_projetAMT_rootPool)

Démarrer le serveur glassfish et ensuite compiler le projet avec clean and build, et ensuite exécuter l'application du projet et si tout se passe bien la page de bienvenue s'affiche dans le navigateur.

L'application peut être accédée grâce à l'URL : [http://localhost:8080/GamificationProject](http://localhost:8080/GamificationProject)

### Comment utiliser l'application

Une fois l'application démarrée, vous arrivez sur la page d'acceuil.

Ensuite vous pouvez créer un compte en cliquant sur Create Account, saisir les informations du compte et valider.

Vous arrivez ensuite sur la page où il y a toutes les applications qui vous appartiennent. Au début la liste est vide.

Pour créer une nouvelle application, cliquez sur le bouton Register New App et entrez les informations (la clé de l'application sera générée après sa création) et choisissez aussi si elle est disponible ou non simplement en cliquant sur le bouton adéquat. Une fois que c'est fini, confirmez.

Vous êtes de retour dans la liste des applications et elle apparaît maintenant dans votre liste. Il est possible de changer son statut dynamiquement (activée ou désactivée) en cliquant sur le bouton adéquat.

Le bouton Edit permet d'éditer l'application pour changer ses propriétés.

Il a également le nombre d'utilisateurs finaux qui utilisent vos applications qui apparait dans la liste des applications. Si il y a au moins un utilisateur, il est possible de cliquer sur le chiffre qui apparait pour afficher la liste des utilisateurs finaux, et vous pouvez naviguez dans les pages dans le cas où il y en a beaucoup (pagination).

Le menu à gauche vous permet d'afficher la liste de vos applications (Apps) ou bien d'éditer votre compte (Account). Dans ce dernier cas, vous pouvez changer les proprietés de votre compte utilisateur (sauf l'adresse e-mail).

### Comment mettre à jour, compiler et déployer l'application

Editer les fichiers sources, ensuite recompiler et redémarrer l'application (attention la base de données est effacée lors du redéployement par défaut).

Pour éviter ceci : Modifier le fichier persistence.xml qui se trouve dans Other Sources/src/main/resources/META-INF/ et mettre la propriété Table Generation Strategy sur None.

### Comment exécuter les tests automatisés
Pour lancer les tests automatisés, il faut ouvrir le projet nommé GamificationProjectTest dans NetBeans, et le démarrer.

Attention : Pour que tous les tests fonctionnent, il faut que la base de données soit vide et ensuite il faut démarrer l'application et accéder à l'URL /generate qui va générer des données de test. Et ensuite lancer les tests.

Important : Pour relancer les tests, il faut a nouveau que la base de données soit vide et suivre la même procédure que précédemment.

Vous trouverez plus de détails un peu plus loin dans le chapitre [Tests](#testsChapter)


## Design

### Description du système
Le système permet de se connecter avec un compte utilisateur afin de gérer sa propre liste d'application et consulter la liste des utilisateurs finaux de ces applications.

### Fonctionnalités du système
Avec ce système, il est possible actuellement de :

<li>S'enregistrer avec un compte pour gérer ses propres applications
<li>Modifier les informations du compte
<li>Créer une nouvelle application qui aura une clé de licence auto-attribuée
<li>Modifier une application (nom, description, état)
<li>Activer ou désactiver une application
<li>Consulter la liste des utilisateurs finaux d'une application

### Interface utilisateur
<b>VANESSA METTRE LES VUES ICI ET EXPLIQUER</b>

### API Rest
Les API Rest ne sont pas encore implémentées

### Modèles de conception utilisés
L'application utilise les design pattern suivants :

<li>MVC (Model - View - Controller)
<li>DAO (Data Access Object)
<li>DTO (Data Transfer Object)


## Implémentation et architecture
Voici une description de l'implémentation actuelle de l'application.

### Structure des packages
Les packages ont été organisés de la manière suivante :

<li><b>controllers :</b> Ce package contient les contrôleurs de l'applications.

<li><b>controllers.ajax :</b> Ce package contient les contrôleurs qui permettent de traiter des requêtes Ajax

<li><b>filters :</b> Ce package contient les middlewares (filtres) de l'application

<li><b>model.entities :</b> Ce package contient les entités du modèle relationnel de l'application

<li><b>rest.dto :</b> Ce package contient les DTO (Data Transfert Object) (il concernera la prochaine partie du rapport)

<li><b>services :</b> Ce package contient les services de l'application

<li><b>services.dao :</b> Ce package contient les services DAO de l'application qui permettent d'accéder au modèle relationnel qui se trouve dans la base de données

<li><b>services.passwordvalidation :</b> Ce package contient les services permettant de vérifier qu'un mot de passe d'un compte utilisateur respecte la politique des mots de passe (par exemple le nombre de caractères doit être plus grand ou égal à 8...)

<li><b>forms :</b> Ce package contient des classes représentant des formulaires de saisie (afin de récupérer les données d'un formulaire et éventuellement les renvoyer)

<li><b>util :</b> Ce package contient des classes utiles à l'application

### Rôles des classes
Voici le rôles des différentes classes de l'application ainsi qu'une description de leur méthodes, regroupées par catégorie.

#### Servlets (contrôleurs)
<li><b>AccountServlet.java </b>

Ce contrôleur est mappé sur l'url :

```
/pages/account
```

Le rôle de cet URL est d'afficher la page qui permet de créer ou de modifier un compte utilisateur.

Si la méthode de la requête est GET, le paramètre nommé edit (qui est obligatoire et qui vaut true si on veut modifier un compte, et false si on veut créer un compte) permet de déterminer si on affiche la page pour créer un nouveau compte ou bien celle pour modifier un compte. Le fichier JSP qui est lié est "account_registration.jsp".

Si la méthode de la requête est POST, grâce au même paramètre edit on peut savoir si on est en train d'éditer ou de créer un compte (il est à noter que comme l'attribut method="PUT" n'existe pas dans la balise form de l'html, on doit spécifier dans le POST le paramètre edit (false ou true)).

Si on est en train d'éditer un compte, le controleur a une méthode privée create account qui s'occupe de récupérer les paramètres de la requête (ce que l'utilisateur a saisi) et même principe pour la modification d'un compte.

<li><b>ApplicationsServlet.java</b>

Ce contrôleur est mappé sur l'url :

```
/pages/application
```

Le rôle de cet URL est d'afficher la page qui permet de créer ou de modifier une application.

Si la méthode de la requête est GET, le paramètre nommé edit (qui est obligatoire et qui vaut true si on veut modifier une application, et false si on veut créer une application) permet de déterminer si on affiche la page pour créer une nouvelle application ou bien celle pour modifier une application. Le fichier JSP qui est lié est "application_registration.jsp".

Bien entendu pour éditer une application, il faut passer un autre paramètre nommé idApplication pour dire l'id de l'application à modifier.

Si une demande de modification de l'application est faite, le contrôleur vérifie que l'application appartient au compte actuellement connecté, sinon il refuse de modifier.

Si la méthode de la requête est POST, grâce au même paramètre edit on peut savoir si on est en train d'éditer ou de créer une application (il est à noter que comme l'attribut method="PUT" n'existe pas dans la balise form de l'html, on doit spécifier dans le POST le paramètre edit (false ou true)).

Si on est en train d'éditer une application, le controleur a une méthode privée createApplication qui s'occupe de récupérer les paramètres de la requête (ce que l'utilisateur a saisi) et même principe pour la modification.

<li><b>AuthenticationServlet.java</b>

Ce contrôleur est mappé sur l'url :

```
/auth
```

Ce contrôleur est du style "back-end" car il n'affiche pas de page, il permet à un utilisateur de s'authentifier avec un compte dans l'application.

Pour s'authentifier, il faut spécifier trois paramètres dans un POST :
<li>action (login pour s'authentifier, logout pour se déconnecter)
<li>email (email du compte utilisateur)
<li>password (le mot de passe de l'utilisateur)

Lors d'une action login, le controleur vérifie que le mot de passe et l'e-mail de l'utilisateur correspondent et si c'est le cas il créer une variable de session nommé "principal" qui contient le compte de l'utilisateur qui vient de se connecter.

Lors d'une action logout, le contrôleur détruit la variable de session nommée "principal".

<li><b>DataGeneratorServlet.java</b>

Ce contrôleur est mappé sur l'url :

```
/generate
```

Il permet de générer des données de tests (à condition que la base de données projetamt soit vide).

<li><b>ListApplicationsAccountServlet.java</b>

Ce contrôleur est mappé sur l'url :

```
/pages/yourApps
```

Ce contrôleur permet d'afficher la liste des applications de l'utilisateur actuellement connecté, il renvoie une vue générée par le fichier JSP nommé "applications_of_account.jsp".

<li><b>ListUsersApplicationServlet.java</b>

Ce contrôleur est mappé sur l'url :

```
/pages/listUsersApps
```

Il permet d'afficher la liste des utilisateurs finaux d'une application en paginant les résultats. La liste est paginée par le controleur à partir des paramètres de la requête suivants :
<li>currentNumPage : Le numéro de la page a afficher
<li>nbEndUsersPerPage : Le nombre d'utilisateurs finaux à afficher par page

Le contrôleur les valeurs de ces paramètres et les adapte le cas échéant (par exemple si le numéro de la page est trop grand et n'existe pas...

Par défaut, 10 utilisateurs finaux sont affichés dans une page et la première page est affichée, si les paramètres ne sont pas spécifiés.

Le controleur calcule la liste des utilisateurs finaux et les transmets à la vue nommée "list_user_of_application.jsp".

<li><b>WelcomeServlet.java</b>

Ce contrôleur est mappé sur l'url :

```
/pages/welcome
```

Il permet d'afficher la page d'acceuil du site nommé "welcome.jsp" et calcul le nombre d'utilisateurs finaux créées les 30 derniers jours (le nombre de jours peut être changé dans le contrôleur), le nombre d'applications qui sont managées par l'application, ainsi que le nombre de comptes existants et les affiche sur cette page.

<li><b>AjaxApplicationsServlet.java</b>

Ce contrôleur est mappé sur l'url :

```
/applicationsAjax
```

Il permet au client d'envoyer une requête de type POST ajax pour activer ou désactiver une application.

Pour activer une application, il faut mettre un paramètre action=enableApplication et un paramètre idApplicatino=id de l'application à modifier.

Pour désactiver une application, il faut mettre un paramètre action=disableApplication avec également l'id de l'application.

Ce contrôleur vérifie également que l'application appartient au compte actuellement connecté. 

#### Filtres

<li><b>SecurityFilter.java</b>

Ce filtre est mappé sur l'url :

```
/*  (n'importe laquelle)
```

Ce filtre permet de vérifier à partir de l'url demandée si la ressource demandée est protégée ou pas.

Si l'url est protégée, le filtre vérifie si un utilisateur est connecté grâce à la variable de session nommé "principal". Si c'est le cas, le filtre transmets la requête et la réponse au filtre / controleurs suivant et laisse le client accéder à la ressource demandée. Si ça n'est pas le cas, le filtre fait une redirection sur la page de bienvenue et ne créer pas de session.

Si l'url n'est pas protégée, le filtre ne fait rien et transmets simplement la requête.

#### Services

<li><b>AccountsManagerLocal.java</b>

Ce service est une interface qui permet de gérer les comptes utilisateurs notamment pour questionner la banque de données qui les concerne.

La classe AccountsManager.java implémente cet interface et elle fait appel à un service du type AccountDAOLocal pour les opérations de CRUD.

```
public void updateAccount(Account account) throws GamificationDomainEntityNotFoundException, BadPasswordException;
```

Cette méthode permet de mettre à jour un compte utilisateur.
Elle prend en paramètre le compte à modifier (qui doit posséder un id).

Elle renvoi une exception du type GamificationDomainEntityNotFoundException dans le cas où le compte utilisateur n'a pas été trouvée dans la base de données.

Elle renvoi une exception du type BadPasswordException si le nouveau mot de passe ne respecte pas la politique des mots de passe (voir classe PasswordPoliticValidator.java).

```
public void createAccount(Account account) throws BadPasswordException;
```

Cette méthode permet de créer un compte utilisateur.
Elle prend en paramètre le compte à créer.

Elle renvoi une exception du type BadPasswordException si le mot de passe ne respecte pas la politique des mots de passe.

```
public Account retrieveAccount(String email);
```

Cette méthode permet de récupérer un compte utilisateur a partir de son adresse e-mail (passée en paramètre).

Si le compte n'existe pas, la méthode renvoi null.

Cette méthode est utilisée par exemple dans AuthenticationServlet.java pour vérifier la connexion d'un utilisateur.

```
public long numbersOfAccount();
```

Cette méthode permet de récupérer le nombre de comptes existants.

<li><b>ApplicationsManagerLocal.java</b>

Ce service est une interface qui permet de gérer les applications notamment pour questionner la banque de données qui les concerne.

La classe ApplicationsManager.java implémente cet interface et elle fait appel à un service du type ApplicationDAOLocal pour les opérations de CRUD.

```
public void assignApplicationToAccount(Application application, Account account);
```

Cette méthode permet d'assigner un propriétaire à une application.
Elle prend en paramètre l'application et le propriétaire de l'application (l'objet account doit posséder un id).

Attention : L'application est créée également à ce moment là, et une ApiKey est générée automatiquement pour l'application.

```
public List<Application> applicationsOfAnAccountWithEndUsersNumber(Account account);
```

Cette méthode permet d'obtenir la liste des applications d'un compte et elle renvoi une liste d'application avec également le nombre d'utilisateurs finaux qui utilisent l'application. Elle est de la forme :
```[{application1, 34}, {application2, 102}, ...]```

```
public Application findById(Long id) throws GamificationDomainEntityNotFoundException;
```

Cette méthode permet de trouver une application à l'aide de son id.

Elle prend en paramètre l'id de l'application.

Elle renvoi une exception du type GamificationDomainEntityNotFoudException si l'application n'a pas été trouvée.


```
public long nbEndUsersOfApplication(Application application);
```

Cette méthode renvoi le nombre d'utilisateurs finaux d'une application. Si l'application n'existe pas, elle renvoi 0.


```
public void assignApplicationToAnEndUser(Application application, EndUser endUser);
```

Cette méthode permet d'inscrire un utilisateur final dans une application. L'application passée en paramètre doit être managée, mais pas le EndUser car il sera créer en même temps.


```
public void enableApplication(Application app) throws GamificationDomainEntityNotFoundException;
```

Cette méthode permet d'activer une application.

Elle renvoi une exception si l'application n'existe pas.

```
public void disableApplication(Application app) throws GamificationDomainEntityNotFoundException;
```

Cette méthode permet de désactiver une application.

Elle renvoi une exception si l'application n'existe pas.

```
    public List<EndUser> findEndUsersAndPaginate(Application app, int numPage, int nbEndUsersPerPage) throws GamificationDomainEntityNotFoundException;
```

Cette méthode permet d'obtenir la liste des utilisateurs finaux dans une version paginée, en spéciafiant le numéro de la page que l'on veut et le nombre d'utilisateurs finaux à afficher dans la page.

La pagination s'effectue au niveau de la base de données, pour des raisons de performances.

```
public void updateApplication(Application app) throws GamificationDomainEntityNotFoundException;
```

Cette méthode permet de mettre à jour une application.

Elle renvoi également une exception si l'application n'existe pas.

```
public boolean checkAccountIsOwnerOfApplication(Account account, Application application);
```

Cette méthode permet de savoir si un compte utilisateur est propriétaire d'une application.

Application et account doivent avoir un id et l'application doit être managée.

<li><b>EndUsersManagerLocal.java</b>

Ce service est une interface qui permet de gérer les utilisateurs finaux des applications notamment pour questionner la banque de données qui les concerne.

La classe EndUsersManager.java implémente cet interface et elle fait appel à un service du type EndUserDAOLocal pour les opérations de CRUD.

```
public long numberOfEndUsersCreatedDuringLastNbDays(int nbDays);
```

Cette méthode permet de compter le nombre d'utilisateurs finaux enregistrés depuis les nbDays derniers jours.

<li><b>TestDataManagerLocal.java</b>

Ce service permet de générer des données de tests.

La classe  TestDataManager implémente cette interface et se connecte aux services AccountsManager, ApplicationsManager pour créer des données de tests.

Ce service est appelé lorsque l'on accède à l'url /generate.

#### Entités


#### Formulaires


#### Classes utilitaires


### Diagramme de classes
Sera disponible prochainement.

### Aspects sélectionnés
Sera disponible prochainement

## Fichier d'auto évaluation
On peut trouver l'auto-evalution [ici](evaluation/evaluation.docx).

