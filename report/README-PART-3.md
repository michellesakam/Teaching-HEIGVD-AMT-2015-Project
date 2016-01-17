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
Pour vérifier que cette annotation fonctionne correctement, nous avons simulé cinq client avec JMeter et mesuré le temps de réponse en ayant mis un <b>Thread.sleep(10000);</b> dans la méthode en question (afin de simuler que le serveur travail).

Résultat du test en mode <b>synchrone</b>

![](pictures/picturesPartie3/Sync5user.PNG)

On voit clairement que le thread.sleep s'est effectué avant de renvoyer la réponse au client car le temps de réponse est de 10 secondes ici (10'000 millisecondes...)

Résultat du test en mode <b>asynchrone</b>

![](pictures/picturesPartie3/Async5user.PNG)

En mode asynchrone, cest tout le contraire, le serveur répond avant même d'avoir effectué le thread.sleep (qui a été fixé à 10 secondes), il est évident que le fonctionnement de l'annontation @Asynchrone fonctionne puisque si il ne fonctionnait pas le serveur aurait répondu au minimum 10 seconde après une requête, ce qui n'est pas le cas ici.

On est donc garantit que notre annotation fonctionne correctement.

Il est à noter que ce mode n'apporte pas de gain de performance au niveau de ce que le serveur doit effectuer comme travail à chaque événement (malgré le fait qu'il réponde tout de suite, il doit évidemment quand même effectuer tout le travail derrière, à savoir traiter toutes les règles de l'événement et communiquer avec la base de données). C'est juste que le client aura l'impression que le serveur traite sa demande plus rapidement, alors que c'est faux.

## Tests effectués sans amélioration
Voici les tests que nous avons effectuée sans avoir pour le moment apporté d'amélioration dans notre code de réception des événements (<b>sachant que le nombre de règles est de 100 pour le même type d'événement et la même application et qu'il faudra traiter 100 règles à chaque réception de cet événement</b>).

### Mode Synchrone
Ici, le mode synchrone est activé (donc pas d'annotation @Asynchronous) (le serveur ne répond pas tout de suite)

#### Test 1 - 100 utilisateurs avec un Thread Pool de 5
![](pictures/picturesPartie3/VersionSansCache/Sync/Pool5.PNG)

#### Test 2 - 100 utilisateurs avec un Thread Pool de 10
![](pictures/picturesPartie3/VersionSansCache/Sync/Pool10.PNG)

#### Test 3 - 100 utilisateurs avec un Thread Pool de 50
![](pictures/picturesPartie3/VersionSansCache/Sync/Pool50.PNG)

### Mode Asynchrone
Ici, le mode asynchrone est activé (le serveur répond tout de suite)

#### Test 4 - 100 utilisateurs avec un Thread Pool de 5
![](pictures/picturesPartie3/VersionSansCache/Async/Pool5.PNG)

#### Test 5 - 100 utilisateurs avec un Thread Pool de 10
![](pictures/picturesPartie3/VersionSansCache/Async/Pool10.PNG)

### Commentaires tests
<font color=red>A COMPLETER</font>


## Ce qui pose des problèmes de performance
<font color=red>A COMPLETER</font>

### Amélioration effectuée
<font color=red>A COMPLETER</font>

#### Tests effectués après amélioration
Voici les tests que nous avons effectuée après avoir mis en place le système de cache pour les règles (à savoir qu'il y a toujours 100 règles pour le même type d'événement et la même application).

##### Mode Synchrone
Ici, le mode synchrone est activé (donc pas d'annotation @Asynchronous) (le serveur ne répond pas tout de suite)

####### Test 1 - 100 utilisateurs avec un Thread Pool de 5
![](pictures/picturesPartie3/VersionAvecCache/Sync/Pool5.PNG)

####### Test 2 - 100 utilisateurs avec un Thread Pool de 10
![](pictures/picturesPartie3/VersionAvecCache/Sync/Pool10.PNG)

####### Test 3 - 100 utilisateurs avec un Thread Pool de 50
![](pictures/picturesPartie3/VersionAvecCache/Sync/Pool50.PNG)

##### Mode Asynchrone
Ici, le mode asynchrone est activé (le serveur répond tout de suite)

###### Test 4 - 100 utilisateurs avec un Thread Pool de 5
![](pictures/picturesPartie3/VersionAvecCache/Async/Pool5.PNG)

###### Test 5 - 100 utilisateurs avec un Thread Pool de 10
![](pictures/picturesPartie3/VersionAvecCache/Async/Pool10.PNG)

##### Commentaires tests
<font color=red>A COMPLETER</font>

# Améliorations futures possibles
<font color=red>A COMPLETER</font>


# Conclusion
<font color=red>A COMPLETER</font><font color=red>A COMPLETER</font>