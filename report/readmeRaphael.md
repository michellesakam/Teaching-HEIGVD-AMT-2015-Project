# Project Report

## Introduction
Ce rapport présente notre projet de groupe à la HEIG-VD dans le cadre du cours Applications Multi-Tiers de Monsieur Olivier Liechti.

## User Guide

### How to execute and access the application

### How to use the application
### How to update, build and deploy the application
### How to run the automated test procedure


## Design

### System overview
Le système permet de se connecter avec un compte utilisateur afin de gérer sa propre liste d'application et consulter la liste des utilisateurs finaux de ces applications.
### Gamification features
Avec ce système, il est possible de :

<li>S'enregistrer avec un compte pour gérer ses propres applications
<li>Modifier les informations du compte
<li>Créer une nouvelle application qui aura une clé de licence auto-attribuée
<li>Modifier une application (nom, description, état)
<li>Activer ou désactiver une application
<li>Consulter la liste des utilisateurs finaux d'une application

### User interface
<b>VANESSA METTRE LES VUES ICI ET EXPLIQUER</b>

### REST API
Les API Rest ne sont pas encore implémentées

### Design patterns
L'application utilise les design pattern suivants :

<li>MVC (Model - View - Controller)
<li>DAO (Data Access Object)
<li>DTO (Data Transfer Object)


## Implementation
Voici une description de l'implémentation actuelle de l'application.

### Package structure
Les packages ont été organisés de la manière suivante :

<li><b>controllers :</b> Ce package contient les contrôleurs de l'applications.

<li><b>controllers.ajax :</b> Ce package contient les contrôleurs qui permettent de traiter des requêtes Ajax

<li><b>filters :</b> Ce package contient les middlewares (filtres) de l'application

<li><b>model.entities :</b> Ce package contient les entités du modèle relationnel de l'application

<li><b>rest.dto :</b> Ce package contient les DTO (Data Transfert Object) (il concernera la prochaine partie du rapport)

<li><b>services :</b> Ce package contient les services de l'application

<li><b>services.dao :</b> Ce package contient les services DAO de l'application qui permettent d'accéder au modèle relationnel qui se trouve dans la base de données

<li><b>services.passwordvalidation :</b> Ce package contient les services permettant de vérifier qu'un mot de passe d'un compte utilisateur respecte la politique des mots de passe (par exemple le nombre de caractères doit être plus grand ou égal à 8...)

<li><b>util :</b> Ce package contient des classes utiles à l'application

### Selected aspects



## Appending A: Auto Evaluation
On peut trouver l'auto-evalution [ici](evaluation/evaluation.docx).

