The "no HTML5 yet" Taskboard
============================

Ce d�p�t abrite l'application servant de support au concours HTML5 Nantes.

Deux branches sont disponibles :

* La branche `maven-branch` porte l'application au format Maven
* La branche `eclipse-branch` porte l'application dans un projet Eclipse

Basculez sur celle qui vous convient le mieux.

Lancer l'application Taskboard avec Maven
=================================================

Pr�-requis
----------
* JDK 6+ 
	* Installation : http://www.oracle.com/technetwork/java/javase/downloads/index.html
	
* Maven 3+
	* T�l�chargement : http://maven.apache.org/download.html
	* Instructions : http://maven.apache.org/download.html#Installation_Instructions
	
* MongoDB 2.0.6+
	* T�l�chargez et d�compressez l'archive : http://www.mongodb.org/downloads
	* Cr�ez un r�pertoire qui contiendra votre base de donn�es (ex : `d:\data`)
	* Lancez votre base (se placer dans le r�pertoire `bin` de mongodb et taper `mongod -dbpath d:\data`)

Lancement
---------

Le projet est un projet Java construit avec Maven et embarquant Jetty sous forme de plugin.
Pour construire et lancer l'application, un simple `mvn jetty:run` suffit.

Acc�dez � l'application en pointant le navigateur de votre choix sur l'URL `http://localhost:8080/`