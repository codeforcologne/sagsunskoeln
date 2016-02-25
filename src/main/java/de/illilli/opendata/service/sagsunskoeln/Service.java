package de.illilli.opendata.service.sagsunskoeln;

import java.io.IOException;
import java.sql.SQLException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import de.illilli.opendata.service.Facade;

@Path("/")
public class Service {

	private final static Logger logger = Logger.getLogger(Service.class);

	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	/**
	 * <p>
	 * Dieser Service holt die Daten von sags-uns.stadt-koeln.de und schreibt
	 * die gefundenen Einträge in die Datenbank.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <code>curl -X PUT http://localhost:8080/sagunskoeln/service/put</code>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@PUT
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/put")
	public void putKvbradpositions()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		new PutSagUnsFacade();
		logger.info("call '" + request.getRequestURI() + "'");
	}

	/**
	 * <p>
	 * Diese Schnittstelle liefert alle Einträge zurück.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <a href="http://localhost:8080/sagsunskoeln/service/all">/sagsunskoeln/
	 * service/all</a>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/all")
	public String getSagsUnsAll()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new SagsUnsAllFacade();
		logger.info("call '" + request.getRequestURI() + "'");
		return facade.getJson();
	}

	/**
	 * 
	 * <p>
	 * Diese Schnittstelle liefert alle Einträge zurück, die mit der übergebenen
	 * ID zusammenhängen. Es wird wie bei '/sagsunskoeln/service/all' ein Array
	 * zurückgegeben, weil zum Zeitpunkt der Implementierung noch nicht klar
	 * war, ob es mehr als einen Rückgabewert geben kann.
	 * </p>
	 * <p>
	 * Beispiel: <a href="http://localhost:8080/sagsunskoeln/service/id/A-1745">
	 * /sagsunskoeln/service/id/{id}</a>
	 * </p>
	 * 
	 * @param id
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/id/{id}")
	public String getSagsUnsById(@PathParam("id") String id)
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new SagsUnsByIdFacade(id);
		logger.info("call '" + request.getRequestURI() + "'");
		return facade.getJson();
	}

	/**
	 * 
	 * <p>
	 * Diese Schnittstelle liefert alle Einträge zurück, die mit der übergebenen
	 * ID zusammenhängen. Es wird wie bei '/sagsunskoeln/service/all' ein Array
	 * zurückgegeben, weil zum Zeitpunkt der Implementierung noch nicht klar
	 * war, ob es mehr als einen Rückgabewert geben kann.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <a href="http://localhost:8080/sagsunskoeln/service/status/open">
	 * /sagsunskoeln/service/status/{status}</a>
	 * </p>
	 * 
	 * @param status
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/status/{status}")
	public String getSagsUnsByStatus(@PathParam("status") String status)
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new SagsUnsByStatusFacade(status);
		logger.info("call '" + request.getRequestURI() + "'");
		return facade.getJson();
	}

	/**
	 * 
	 * <p>
	 * Diese Schnittstelle liefert alle Datensätze mit dem übergebenen
	 * Statuscode zurück. Eine Kombination von Statuscode ist nicht möglich.
	 * Wird ein nicht vorhandener Wert angegeben, werden keine Datensätze
	 * zurückgeliefert. Die Datensätze werden immer als Liste zurückgegeben,
	 * auch wenn es sich nur um einen einzigen handelt.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <a href="http://localhost:8080/sagsunskoeln/service/servicecode/11">
	 * /sagsunskoeln/service/servicecode/{code}</a>
	 * </p>
	 * 
	 * @param code
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/servicecode/{code}")
	public String getSagsUnsByServiceCode(@PathParam("code") int code)
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new SagsUnsByCodeFacade(code);
		logger.info("call '" + request.getRequestURI() + "'");
		return facade.getJson();
	}

	/**
	 * 
	 * <p>
	 * Diese Schnittstelle kombiniert die Abfrage nach status und code.
	 * </p>
	 * <p>
	 * Beispiel: <a href=
	 * "http://localhost:8080/sagsunskoeln/service/status/open/servicecode/11">
	 * /sagsunskoeln/service/status/{status}/servicecode/{code}</a>
	 * </p>
	 * 
	 * @param status
	 * @param code
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/status/{status}/servicecode/{code}")
	public String getSagsUnsByStatusAndServiceCode(@PathParam("status") String status, @PathParam("code") int code)
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new SagsUnsByStatusAndCodeFacade(status, code);
		logger.info("call '" + request.getRequestURI() + "'");
		return facade.getJson();
	}

	/**
	 * 
	 * <p>
	 * Diese Schnittstelle liefert das Datum des letzten Insert und die Anzahl
	 * der eingefügten Daten zurück.
	 * </p>
	 * <p>
	 * Beispiel:
	 * <a href="http://localhost:8080/sagsunskoeln/service/log">/sagsunskoeln/
	 * service/log</a>
	 * </p>
	 * 
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @throws SQLException
	 * @throws NamingException
	 */
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/log")
	public String getSagsUnsLogging()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new LoggingFacade();
		logger.info("call '" + request.getRequestURI() + "'");
		return facade.getJson();
	}
}
