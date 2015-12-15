# Rapport de projet - Partie 3
Ceci est le rapport de la partie 3 du projet

# Auteurs
<li>Raphaël Racine
<li>Parfait Plaisir de Pâques Noussibi
<li>Vanessa Michelle Meguep
<li>Samira Kouchali

# Introduction
Ce rapport concerne la partie 3 du projet de Gamification.

# Sujet choisi
Nous avons choisi comme sujet l'amélioration des performances et de la scalabilité concernant la réception des événements, autrement dit le sujet 1 proposé par le professeur.

# Tests JMeter
Pour tester les performances et la scalabilité, nous avons décidé d'utiliser JMeter et d'envoyer des requêtes HTTP sur l'API Rest recevant les événements.

Cette requête sera celle-ci :

<li> Une entête HTTP contentant les éléments Content-type et Authorization

![](pictures/Entete_HTTP.PNG)

<li> L'événement qui sera envoyé

![](pictures/Requete_HTTP.PNG)

## Introduction
Nous avons décidé dans le script qui génère des données de tests (/generate) d'ajouter une centaine de règle sur une même application avec le même type d'événement (celui qui sera utilisé dans les requêtes HTTP lors de l'envoi de beaucoup d'événement à la fois avec JMeter), afin d'obliger le serveur a avoir un traitement non négligeable à faire, ce qui nous permettra de comparer plus facilement les temps de réponse entre le mode synchrone et le mode asynchrone (avec réponse directe du serveur).

## Traitement synchrone


## Avec l'annontation @Asynchronous


# Conclusion