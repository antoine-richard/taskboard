The "no HTML5 yet" Taskboard
============================

Ce d�p�t abrite l'application servant de support au concours HTML5 Nantes.

Deux branches sont disponibles :

* La branche `maven-branch` porte l'application au format Maven
* La branche `eclipse-branch` porte l'application dans un projet Eclipse [branche courante]

Basculez sur celle qui vous convient le mieux.

Lancer l'application Taskboard avec Eclipse
===========================================

Pr�-requis
----------
* JDK 6+ 
	* Installation : http://www.oracle.com/technetwork/java/javase/downloads/index.html

* Tomcat 7+
	* Installation : http://tomcat.apache.org/download-70.cgi
	
* Eclipse
	* T�l�chargement : http://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/junor
	* Le projet est un Dynamic Web Project (cr�� sous Eclipse 3.7.2) et ayant Tomcat 7.0 en Targeted Runtime.
	
* MongoDB 2.0.6
	* T�l�chargez et d�compressez l'archive : http://www.mongodb.org/downloads
	* Cr�ez un r�pertoire qui contiendra votre base de donn�es (ex : `d:\data`)
	* Lancez votre base (se placer dans le r�pertoire `bin` de mongodb et taper `mongod -dbpath d:\data`)

Lancement
---------

Ex�cutez l'application taskboard sur votre Tomcat pr�alablement cr�� en tant que serveur dans Eclipse.
Notez que l'application est d�ployable sur le serveur d'application de votre choix.

Acc�dez � l'application en pointant votre navigateur favori sur l'URL `http://localhost:8080/taskboard/`.