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

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/logging")
	public String getSagsUnsLogging()
			throws JsonParseException, JsonMappingException, IOException, SQLException, NamingException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		Facade facade = new LoggingFacade();
		logger.info("call '" + request.getRequestURI() + "'");
		return facade.getJson();
	}
}
