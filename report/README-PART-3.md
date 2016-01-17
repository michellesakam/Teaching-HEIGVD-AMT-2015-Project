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

## Test de l'annontation @Asynchronous
Tout d'abord, nous avons voulu vérifié le fonctionnement de l'annontation @Asynchronous qui <b>permet de répondre tout de suite au client</b> avant même que le serveur traite sa requête.

Cela permet d'éviter au client d'attendre que le traitement de sa requête (qui peut prendre du temps), se termine.

<b>Avantage :</b> Le client a tout de suite une réponse et n'attends pas.

<b>Inconvénient :</b> Si une erreur a eu lieu dans le traitement de la demande du client, il ne le saura pas à moins de questionner le serveur plus tard pour voir si cela c'est bien passé, mais il faut l'implémenter.

Pour que cette annotation fonctionne, il suffit de la placer au dessus de la méthode qu'on a envie de rendre asynchrone, c'est à partir de l'appel de cette méthode que le serveur répond au client et ensuite exécute la méthode en question.

Nous avons décider de placer cette annotation dans la méthode qui se trouve dans la classe <b>EventsProcessor.java</b> dans la méthode postDTO (autrement dit la méthode qui est appelée lors de la réception d'un événement).

### Vérification du fonctionnement
Pour vérifier que cette annotation fonctionne correctement, nous avons simulé un seul client avec JMeter et mesuré le temps de réponse en ayant mis un <b>Thread.sleep(10000);</b> dans la méthode en question (afin de simuler que le serveur travail).

Résultat du test en mode <b>synchrone</b>

## Tests effectués sans amélioration
Voici les tests que nous avons effectuée sans avoir pour le moment apporté d'amélioration dans notre code de réception des événements.


## Amélioration(s) effectuée(s)
<font color=red>A COMPLETER</font>


### Tests effectués après amélioration
Voici les tests que nous avons effectuée après avoir mis en place le système de cache pour les règles.


# Améliorations futures possibles
<font color=red>A COMPLETER</font>


# Conclusion
<font color=red>A COMPLETER</font><font color=red>A COMPLETER</font>