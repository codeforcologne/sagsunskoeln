# Sags uns - Stadt Köln

Über die Seite [https://sags-uns.stadt-koeln.de/](https://sags-uns.stadt-koeln.de/) kann jede(r) die Stadt Köln über Probleme im Stadtbild informieren. Dieser Service sammelt diese Informationen über die Zeit in einer Datenbank.

## Überblick

## Schnittstellen

### /sagunskoeln/service/put

Es handelt sich um eine Schnittstelle, die per PUT angesprochen wird:

    curl -X PUT http://localhost:8080/sagunskoeln/service/put 
    
Durch Aufruf dieser Schnittstelle wird eine Abfrage gegen 'https://sags-uns.stadt-koeln.de/georeport/v2/requests.json' gemacht und die dort gefundenen Stellen in die Datenbank geschrieben.

## Datenbank

### Ergebnistabelle

    CREATE TABLE sagsuns (
      id                varchar(16) NOT NULL,
      status            varchar(16),
      serviceCode       integer,
      serviceName       varchar(128),
      description       varchar(1024),
      requesteddatetime timestamp,
      updateddatetime   timestamp,
      address           varchar(128),
      mediaurl          varchar(128),
      statusnotes       varchar(1024),
      modtime           timestamp DEFAULT current_timestamp
    );
    SELECT AddGeometryColumn ('public','sagsuns','geom',4326,'POINT',2);


### Steuerungstabelle

	CREATE TABLE sagsunskoeln (
	    numberofinsert      integer,
	    modtime      timestamp DEFAULT current_timestamp
	);

### Connection

Dieser Service unterstellt, dass die Datenbankverbindung per JNDI gesetzt ist. Für den Server bedeutet dies, dass der Container für die Definition der DB-Verbindung zurständig ist. Dafür muss z.B. im Tomcat die Datei context.xml angepasst werden. Folgende Einstellungen müssen eingetragen werden.

    <Resource 
      name="jdbc/kvbraeder" 
      auth="Container" 
      type="javax.sql.DataSource"
      username="username"
      password="password"
      driverClassName="org.postgresql.Driver"
      url="jdbc:postgresql://server:5432/dbname" 
      maxTotal="25" 
      maxIdle="10"
      validationQuery="select 1" />

## Installation

Der Service kann über git heruntergeladen werden

    git clone https://github.com/weberius/sagunskoeln.git
    
Danach muss er noch installiert werden. Dabei wird vorausgesetzt, dass auf dem Rechner mindestens JAVA 7 und das aktuellen maven installiert ist. 

    cd sagsunskoeln
    mvn clean install
    
Danach befindet sich im Verzeichnis target die Datei 'sagsunskoeln.war'. Diese kann z.B. in einen Tomcat Server deployed werden.

## Betrieb

Der Betrieb des Service erfolgt z.B. auf einem Tomcat. Dieser muss, wie oben beschrieben eine Verbindung zur Datenbank definieren.

### crontab

Um regelmäßig Daten in die Datenbank zu schreiben, muss der Service /sagsunskoeln/service/put regelmäßig aufgerufen werden. Dies geschieht am einfachsten per crontab. Dafür wird die Datei sagsunskoeln.sh auf dem Server z.B. im /home/{user} Verzeichnis abgelegt. Dann wird der Zugriff in der crontab definiert.

    3 3 * * * /home/pi/sagunskoeln.sh
    
Führt die Abfrage jede Nacht um 03:03 aus.