package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.naming.NamingException;

import de.illilli.jdbc.Select;
import de.illilli.opendata.service.AskFor;
import de.illilli.opendata.service.sagsunskoeln.jdbc.InsertLastRunToDb;
import de.illilli.opendata.service.sagsunskoeln.jdbc.InsertSagsUns;
import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;
import de.illilli.opendata.service.sagsunskoeln.jdbc.SelectSagsUnsById;

/**
 * <p>
 * Mit Hilfe dieser Facade werden alle SagsUns-Einträge, die noch nicht
 * gespeichert waren, in der Datenbank gespeichert. Der Status wird in der
 * Tabelle SAGSUNSKOELN gespeichert und muss bei Bedarf hier abgefragt werden.
 * </p>
 * <p>
 * Vorgehensweise:
 * <ol>
 * <li>Abfrage der Sagsuns-Werte über AskForSagsuns()</li>
 * <li>Prüfung, ob der Datensatz bereits behoben wurde.</li>
 * <li>Ggf. Speichern eines Datensatzes in der Tabelle</li>
 * <li>Abschliessend: Speichern des Status dieser Operation</li>
 * </ol>
 * </p>
 */
public class PutSagUnsFacade {

	int count = 0;

	public PutSagUnsFacade() throws MalformedURLException, IOException, SQLException, NamingException {

		// get Data
		AskFor<SagsUns[]> askFor = new AskForSagsuns();
		// put to List
		for (SagsUns sagsUns : askFor.getData()) {
			SagsUnsDto dto = new SagsUnsConverter(sagsUns).getSagsUnsDto();
			// gibt es den Datensatz bereits?
			boolean exists = false;
			Select<SagsUnsDto> select = new SelectSagsUnsById(dto.getId());
			SagsUnsDto selectedDto = select.getDbObject();
			if (selectedDto == null) {
				// fuege ihn ein
				new InsertSagsUns(dto);
				count++;
			}
		}

		// vermerken, dass Daten geschrieben wurde
		new InsertLastRunToDb(count);
	}

}
