# Sags uns - Stadt Köln

Über die Seite [https://sags-uns.stadt-koeln.de/](https://sags-uns.stadt-koeln.de/) kann jede(r) die Stadt Köln über Probleme im Stadtbild informieren. Dieser Service sammelt diese Informationen über die Zeit in einer Datenbank.

## Überblick

## Schnittstellen

### /sagsunskoeln/service/put

Es handelt sich um eine Schnittstelle, die per PUT angesprochen wird:

    curl -X PUT http://localhost:8080/sagsunskoeln/service/put 
    
Durch Aufruf dieser Schnittstelle wird eine Abfrage gegen 'https://sags-uns.stadt-koeln.de/georeport/v2/requests.json' gemacht und die dort gefundenen Stellen in die Datenbank geschrieben.

### /sagsunskoeln/service/all

Diese Schnittstelle liefert alle Einträge zurück

### /sagsunskoeln/service/id/{id}

Diese Schnittstelle liefert alle Einträge zurück, die mit der übergebenen ID zusammenhängen. Es wird wie bei '/sagsunskoeln/service/all' ein Array zurückgegeben, weil zum Zeitpunkt der Implementierung noch nicht klar war, ob es mehr als einen Rückgabewert geben kann.

### /sagsunskoeln/service/status/{status} 

Diese Schnittstelle zeigt mit dem Wert "open" alle Datensätze die im Status "open" an. Mit dem Wert "closed" werden alle Datensätze angezeigt, die im Status "closed" sind. Wird ein nicht vorhandener Wert angegeben, werden keine Datensätze zurückgeliefert. Die Datensätze werden immer als Liste zurückgegeben, auch wenn es sich nur um einen einzigen handelt.

### /sagsunskoeln/service/servicecode/{code}

Diese Schnittstelle liefert alle Datensätze mit dem übergebenen Statuscode zurück. Eine Kombination von Statuscode ist nicht möglich. Wird ein nicht vorhandener Wert angegeben, werden keine Datensätze zurückgeliefert. Die Datensätze werden immer als Liste zurückgegeben, auch wenn es sich nur um einen einzigen handelt.

Folgende Codes sind möglich:
- 17: "Ampel defekt"
- 10: "Schrottfahrzeuge/Fahrräder"
- 16: "Straßenbaustellen"
- 13: "Straßenlaterne defekt"
- 11: "Wilder Müll"

### /sagsunskoeln/service/status/{status}/servicecode/{code}

Diese Schnittstelle kombiniert die Abfrage nach status und code.

### /sagsunskoeln/service/log

Diese Schnittstelle gibt alle Logging-Einträge in der Steuerungstabelle sagsunskoeln mit dem aktuellsten Wert oben zurück.

## Datenbank

### Ergebnistabelle

    CREATE TABLE sagsuns (
      id                varchar(16) NOT NULL,
      status            varchar(16),
      serviceCode       integer,
      serviceName       varchar(128),
      description       varchar(2048),
      requesteddatetime timestamp,
      updateddatetime   timestamp,
      address           varchar(256),
      mediaurl          varchar(256),
      statusnotes       varchar(2048),
      lat               DOUBLE PRECISION,
      lng               DOUBLE PRECISION,
      modtime           timestamp DEFAULT current_timestamp
    );


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

### DB-Driver

Des weiteren muss der relevante JDBC-Treiber im Tomcat ins Verzeichnis `$CATALINA_HOME/lib` (z.B. /tomcat/lib/) kopiert werden. Vergleiche auch [JNDI Datasource HOW-TO](https://tomcat.apache.org/tomcat-7.0-doc/jndi-datasource-examples-howto.html). Der Treiber kann unter [Postgres JDBC Driver Download](https://jdbc.postgresql.org/download.html) heruntergeladen werden.  

## Installation

Der Service kann über git heruntergeladen werden

    git clone https://github.com/codeforcologne/sagsunskoeln.git
    
Danach muss er noch installiert werden. Dabei wird vorausgesetzt, dass auf dem Rechner mindestens JAVA 7 und das aktuelle [maven](https://maven.apache.org/) installiert ist. 

Wechsel ins Verzeichnis

    cd sagsunskoeln

Aufruf des build-Skripts:

    mvn clean install
    
Danach befindet sich im Verzeichnis target die Datei 'sagsunskoeln.war'. Diese kann z.B. in einen Tomcat Server deployed werden.

    mv sagsunskoeln.war $CATALINA_HOME/webapps

## Betrieb

Der Betrieb des Service erfolgt z.B. auf einem Tomcat. Dieser muss, wie oben beschrieben eine Verbindung zur Datenbank definieren.

### crontab

Um regelmäßig Daten in die Datenbank zu schreiben, muss der Service /sagsunskoeln/service/put regelmäßig aufgerufen werden. Dies geschieht am einfachsten per crontab. Dafür wird die Datei sagsunskoeln.sh auf dem Server z.B. im /home/{user} Verzeichnis abgelegt. Dann wird der Zugriff in der crontab definiert.

    sudo EDITOR=vim.tiny crontab -e

Eintrag am Ende der Datei:

    4 4 * * * /home/pi/sagsunskoeln.sh
    
Führt die Abfrage jede Nacht um 03:03 aus.

## Configuration

Die Konfiguration wird über die Datei

    /src/main/resources/config.properties

vorgenommen.

## License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.
