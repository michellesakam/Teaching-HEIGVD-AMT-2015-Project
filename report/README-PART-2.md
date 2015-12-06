# Rapport de projet - Partie 2
Ceci est le rapport de la partie 2 du projet

# Introduction
Ce rapport concerne la partie 2 du projet de Gamification.

Il concerne la Gamification en elle-même, c'est à dire attribuer des points ou des badges (pour le moment) à des utilisateurs d'une application gamifiée, suite à la réception d'événements, par exemple poser une question ou poster un commentair, ou encore tirer sur un ennemi dans un jeu de guerre par exemple.

# Auteurs
<li>Raphaël Racine
<li>Parfait Plaisir de Pâques Noussibi
<li>Vanessa Michelle Meguep
<li>Samira Kouchali

# Specifications
<font color=red>A FAIRE</font>

# Modèles
## Nouvelles Entités créées
Voici les différentes entités que nous avons créées pour la gamification.

### Diagramme
![](pictures/modeles_part_2.PNG)

### Explications
<li><b>Rule</b>

Cet entité représente une règle à appliquer lorsque un événement avec un certain type correspondant arrive (eventType).

Cette entité possède les attributs suivants :
<li>reason : C'est la raison pourquoi la règle s'applique
<li>conditions : C'est les conditions pour que la règle s'applique
<li>eventType : C'est le type d'événement auquel on applique cette règle

<b>Remarques sur les conditions</b>

Il est à noter que les conditions sont modélisées sous forme d'une Map<String, Object>.

Cette map doit être vide si la règle peut s'appliquer à chaque fois qu'un événement du type
eventType arrive (par exemple : A chaque fois que l'eventType est "Poser une question", alors on donne 5 points systèmatiquement)

Par contre si elle n'est pas vide, elle doit avoir la forme suivante :
<li>Clé : Nom d'une propriété de l'événement
<li>Valeur : Valeur que la propriété spécifiée doit avoir (<b>égalité</b>)

Par exemple si on a :
<li>"proprieteX" = 50
<li>"proprieteY = 80

Ceci signifiera que la règle sera appliquuée <b>uniquement</b> si ces deux propriétés existent
dans l'événement et qu'elle ont respectivement ces valeurs.

Appliquer une règle, ça signifie ici donner des points ou bien donner un badge à un EndUser.

<li><b>Award</b>

Cet entité représente le fait qu'un EndUser ait gagné une récompense suite à l'application d'une
règle lors de la réception d'un événement.

Ses attributs sont les suivants :
<li> reason : Raison pour laquelle l'utilisateur a remporté une récompense
<li> receptionDate : Date de réception de la récompense

<li><b>AwardPoint</b>

Cet entité représente le fait qu'un EndUser a gagné (ou perdu) des points.

Elle hérite de Award car elle possède aussi une raison et une date de réception.

Elle a un attribut supplémentaire qui est le nombre de points que l'utilisateur
a remporté (nbPoints)

<li><b>AwardBadge</b>

Cet entité représente le fait qu'un EndUSer a remporté un Badge.

Elle hérite de Award car elle possède aussi une raison et une date de réception.

<li><b>Action</b>

Cet entité représente une action à effectuer lorsqu'une règle peut être appliquée.

Elle permet de stocker pour une règle X donnée, le nombre de points à donner ou
bien le badge a donné au cas où la même règle X est appliquée.

<li><b>ActionAwardPoint</b>

Cet entité représente une action "Donner ou retirer des points".

Elle permet de stocker pour une règle X donnée, le nombre de points à donner ou retirer au cas où la même règle X est appliquée.

<li><b>ActionAwardBadge</b>

Cet entité représente une action "Donner un badge".

Elle permet de stocker pour une règle X donnée, le badge à donner au cas où la même règle X est appliquée.

<li><b>Badge</b>

Cet entité représente un badge d'une application. Chaque application définit ses propres badges.

Chaque badge possède un nom.

<li><b>Level</b>

Cet entité représente un niveau par rapport à un nombre de points. Elle possède deux attributs :

<li>minimumPoints : C'est le nombre de points minimum à avoir pour avoir ce niveau
<li>name : Le nom du niveau

# API REST
Voici ce que nous avons réalisé au niveau de l'API Rest de notre application.

## Préambule
Tout d'abord, il est à noter que dans la plupart des ressources de notre API Rest (respectivement les événements, badges, niveaux et règles) peuvent être envoyées ou reçues par le serveur uniquement si l'utilisateur de l'API Rest a spécifié l'API Key de l'application concernée.

Cette API Key est à spécifier dans l'entête Authorization de http.

Il est à noter que toutes les URL's de l'api commencent par /api.

Pour qu'on puisse accéder à l'API Rest, nous avons dû adapter la classe SecurityFilter afin de ne pas avoir besoin de s'authentifier. Par contre il faut spécifier l'API Key dans l'entête Authorization (on suppose que les utilisateurs ne connaissent pas les API-Key...)

Voici donc les différentes ressources de notre API Rest.

## Evénements
```
POST /api/events
Authorization: "Une API KEY (celle de l'application concernée)"

{
	"eventType": "Add question",
	"timestamp": "2015-01-31T18:00:00.000Z",
	"endUserNumber": "458GDFR",
	"properties": {
		"nbQuestions": 100
	}
}
```
Permet d'envoyer d'envoyer un événement dans l'application.

On doit spécifier :
<li>Type d'événement : Il s'agit du type de l'événement qui permet à notre serveur de pouvoir appliquer toutes les règles qui ont ce type d'événement.
<li>Date de l'événement : On doit spécifier la date à laquelle arrive l'événement (il faut que le format soit identique à celui de l'exemple) afin que dans le cas où une des règles s'applique et qu'elle donne une récompse à l'utilisateur spécifié, la date de réception de la récompense soit enregistrée.
<li>Numéro de l'utilisateur : Le numéro de l'utilisateur doit être spécifié afin de savoir à qui il faut donner un badge ou des points
<li>Propriétés de l'événement : Ces propriétés seront analysées par les règes qui s'applique à ce type d'événement. Dans le cas où ces propriétés "matchent" correctement dans une règle, alors la règle s'applique. Il est à noter que si la règle s'applique systèmatiquement (donc qu'elle n'a pas de conditions) alors les propriétés sont de l'événement sont ignorée et la règle s'applique quand même).

## Badges
```
GET /api/badges
Authorization: "Une API KEY (celle de l'application concernée)"
```
Permet d'obtenir tous les badges de l'application spécifiée.

```
POST /api/badges
Authorization: "Une API KEY (celle de l'application concernée)"

{
	name: "Warrior"
}
```
Permet d'ajouter un badge dans une application.

```
PUT /api/badges/{id}
Authorization: "Une API KEY (celle de l'application concernée)"

{
	name: "President of questions"
}
```

Permet de modifier un badge dans une application (en spécifiant son id dans l'url)

```
DELETE /api/badges/{id}
Authorization: "Une API KEY (celle de l'application concernée)"
```
Permet d'effacer un badge dans une application (en spécifiant son id dans l'url)

## Niveaux
```
GET /api/levels
Authorization: "Une API KEY (celle de l'application concernée)"
```
Permet d'obtenir tous les niveaux de l'application spécifiée.

```
POST /api/levels
Authorization: "Une API KEY (celle de l'application concernée)"

{
	name: "Soldat",
	minimumOfPoints: 0
}
```
Permet d'ajouter un niveau dans une application

```
PUT /api/levels/{id}
Authorization: "Une API KEY (celle de l'application concernée)"

{
	name: "Sergent",
	minimumOfPoints: 450
}
```

Permet de modifier un niveau dans une application (en spécifiant son id dans l'url)

```
DELETE /api/levels/{id}
Authorization: "Une API KEY (celle de l'application concernée)"
```
Permet d'effacer un niveau dans une application (en spécifiant son id dans l'url)

## Règles

```
GET /api/rules
Authorization: "Une API KEY (celle de l'application concernée)"
```
Permet d'obtenir la liste des règles de l'application concernée.

```
POST /api/rules
Authorization: "Une API KEY (celle de l'application concernée)"

{
	"conditionsToApply": {
		"nbQuestions": 100
	},
	"eventType": "Add question",
	"reason" : "100 questions posted",
	"awardType" : "AwardBadge",
	"awardValue" : 3	
}
```
Permet d'ajouter une nouvelle règle dans une application donnée.

On doit spécifier :
<li>Les conditions pour que la règle s'applique : La règle sera appliquée uniquement si les conditions "matchent" avec un événement qui aimerait appliquer cette règle (bien entendu le type de l'événement doit être le même)
<li>Type d'événement : C'est le type d'événement au quel on veut appliquer cette règle. Il est à noter qu'il peut y avoir plusieurs règles avec le même type d'événement.
<li>Raison : C'est la raison pour laquelle la règle s'applique (il est important de la spécifié car si cette règle est appliquée dans un événement, il faut se rappeler la raison pour laquelle elle s'applique afin que si on distribue une récompense, on sache pour quelle raison cette récompense a été remportée)
<li>Le type de récompense : Il s'agit ici de spécifier le type de récompense à distribuer (AwardBadge si on veut donner un badge ou bien AwardPoints si on veut donner ou retirer des points)
-Valeur de la récompense : Si le type de récompense est AwardBadge, il faut spécifier ici l'id du badge à distribuer. Si le type de récompense est AwardBadge, il faut spécifier ici le nombre de points à donner ou à retirer.

Malheureusement, par manque de temps, nous n'avons pas eu le temps d'implémenter la suppression et l'édition d'une règle.

# Controleurs
Voici une description des nouveaux contrôleurs.

<font color=red>A FAIRE</font>

# Services
Voici une description des nouveaux services.

<font color=red>A FAIRE</font>

# Vues (Widgets)
Nous avons décider d'utiliser anularjs pour afficher les widgets. Dans un premier temps nous nous sommes contenter de mettre sur pieds
tous les éléments qu'il faut pour afficher un graphe dans angularjs avec la librairie chart: 
<li> chart: qui permet de désinner les graph.
<li> ui-router: qui permet d'effectuer le routage côté serveur. 
<li> angular.js
<li> angular-chart.js
<li> ...
Par la suite, nous avons mis des données codées en dure pour tester le bon fonctionnement, et enfin  nous avons implémenté les scripts
avec http de angularjs pour aller cherche les données. 
comment ça marche ?
  Une fois l'application lancée, il faut comment utiliser /generate pour renerer les utilisateurs.
  en suite, il faut exécuter le script de teste pour effectuer les requêtes sur l'api rest 

Voici une description des nouvelles vues.

<font color=red>A FAIRE</font>

# Transactions
Voici la manière dont nous avons gérer les transactions par rapport aux
événements.

## Problème constaté

## Résolution

## Captures test pour bon fonctionnement

## Remarque
Malheureusement, nous n'avons pas eu le temps de gérer les transactions
concernant la configuration des badges, niveaux et points. Nous avons donc uniquement mis en place la gestion des transactions uniquement pour la réception des événements.

# DTO
<font color=red>A FAIRE</font>

# Tests
<b><font color=red>Vanessa parler de cette partie</font></b>

## Programme client (Java)
<font color=red>A FAIRE</font>

## Comment exécuter les tests
<font color=red>A FAIRE</font>

# Problèmes connus
<font color=red>A FAIRE</font>

# Conclusion
<font color=red>A FAIRE</font>



