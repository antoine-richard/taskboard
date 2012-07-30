The "no HTML5 yet" Taskboard
============================

Ce dépôt abrite l'application servant de support au concours HTML5 Nantes.

Deux branches sont disponibles :

* La branche `maven-branch` porte l'application au format Maven [branche courante]
* La branche `eclipse-branch` porte l'application dans un projet Eclipse

Basculez sur celle qui vous convient le mieux.

Lancer l'application Taskboard avec Maven
=========================================

Pré-requis
----------
* JDK 6+ 
	* Installation : http://www.oracle.com/technetwork/java/javase/downloads/index.html
	
* Maven 3+
	* Téléchargement : http://maven.apache.org/download.html
	* Instructions : http://maven.apache.org/download.html#Installation_Instructions

Lancement
---------

Le projet est un projet Java construit avec Maven et embarquant Jetty sous forme de plugin.
Pour construire et lancer l'application, un simple `mvn jetty:run` suffit.

Une base MongoDB embarquée sera lancée et peuplée au démarrage de l'application.

Accédez à l'application en pointant le navigateur de votre choix sur l'URL `http://localhost:8080/`.