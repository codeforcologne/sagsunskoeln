package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.NamingException;

import org.apache.log4j.Logger;

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
 * <li>Prüfung, ob der Datensatz bereits erhoben wurde.</li>
 * <li>Ggf. Speichern eines Datensatzes in der Tabelle</li>
 * <li>Abschliessend: Speichern des Status dieser Operation</li>
 * </ol>
 * </p>
 */
public class PutSagUnsFacade {

	private static final Logger logger = Logger.getLogger(PutSagUnsFacade.class);

	private int count = 0;
	private AskFor<SagsUns[]> askFor;

	/**
	 * Get Data from remote Location. Use AskForSagsuns.
	 * 
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 * @see AskForSagsuns
	 */
	public PutSagUnsFacade() throws MalformedURLException, IOException, SQLException, NamingException {
		askFor = new AskForSagsuns();
		putToList();
	}

	/**
	 * Get Data from anywhere.
	 * 
	 * @param askFor
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	public PutSagUnsFacade(AskFor<SagsUns[]> askFor)
			throws MalformedURLException, IOException, SQLException, NamingException {
		putToList();
	}

	void putToList() throws SQLException, NamingException, IOException {
		// put to List
		for (SagsUns sagsUns : askFor.getData()) {
			SagsUnsDto dto = new SagsUnsConverter(sagsUns).getSagsUnsDto();
			Select<SagsUnsDto> select = new SelectSagsUnsById(dto.getId());
			List<SagsUnsDto> dtoList = select.getDbObjectList();
			if (dtoList == null) {
				// dataset doesn't exists: insert
				new InsertSagsUns(dto);
				logger.debug("insert new data: " + dto.toString());
				count++;
			} else if (!dtoList.contains(dto)) {
				// dataset exists, but differs from dto: insert
				new InsertSagsUns(dto);
				logger.debug("insert different data: " + dto.toString());
				count++;
			}
		}
		// vermerken, dass Daten geschrieben wurde
		new InsertLastRunToDb(count);
	}

}
