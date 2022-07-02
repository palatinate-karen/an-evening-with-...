# Bedienungsanleitung: an-evening-with-...

## Backend
Starte zuerst das Backend, indem du die Klasse <code>backend/src/main/java/com.example.backend/Applicaton</code> öffnest und die <code>main</code>-Methode ausführst.
Das Backend fährt sehr schnell hoch und ist dann über [localhost:8080](http://localhost:8080) erreichbar.
Alternativ kannst du die Applikation auch über die Konsole mit dem Befehl <code>mvn spring-boot:run</code> starten.
Deine Konsole muss sich dazu im Ordner <code>backend</code> befinden.

Um die Unit-Tests auszuführen, musst du <code>mvn clean install</code> ausführen.
Mit diesem Befehl werden nach dem Kompilieren die Unit-Tests ausgeführt und nach dem Install-Schritt die Integrationstests ausgeführt.

Um die Integrationstests auszuführen, muss das Backend gestartet sein und Postman installiert sein.
Im Ordner <code>integrationstests_postman</code> findest du eine JSON-Datei.
Diese kannst du in Postman als Collection importieren und mittels <code>Run Collection</code> ausführen.

## Frontend
Danach startest du das Frontend, indem du die Datei <code>frontend/package.json</code> aufrufst und Zeile 6 ("start") ausführst.
Auch das Frontend fährt sehr schnell hoch und ist dann über [localhost:4200](http://localhost:4200) erreichbar.
Alternativ kannst du auch das Frontend über die Konsole starten, indem du dich im Ordner <code>frontend</code> befindest und <code>ng serve</code> ausführst.

Es existiert ein Protractor End2End-Tests. Dazu musst du, wie in [dieser Anleitung](https://www.protractortest.org/#/tutorial) beschrieben,
Protractor aufsetzen (Schritt: Setup in der Anleitung) und kannst dann mit <code>protractor conf.js</code> den Test ausführen.
Dieser kann zur Zeit jedoch nicht erfolgreich ausgeführt werden.