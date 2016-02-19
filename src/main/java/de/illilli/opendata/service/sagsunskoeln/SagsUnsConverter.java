package de.illilli.opendata.service.sagsunskoeln;

import java.sql.Timestamp;
import java.util.Date;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.postgis.PGgeometry;
import org.postgis.Point;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;

public class SagsUnsConverter {

	/**
	 * 2016-02-16T21:26:17+01:00
	 */
	public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ssZ";
	private DateTimeFormatter dtf = DateTimeFormat.forPattern(PATTERN);
	public static final int SRID = 4326;

	private SagsUns sagsUns;

	public SagsUnsConverter(SagsUns sagsUns) {
		this.sagsUns = sagsUns;
	}

	public SagsUnsBo getSagsUnsBo() {
		SagsUnsBo sagsUnsBo = new SagsUnsBo();
		sagsUnsBo.setId(sagsUns.service_request_id);
		sagsUnsBo.setStatus(sagsUns.status);
		int serviceCode = Integer.parseInt(sagsUns.service_code);
		sagsUnsBo.setServiceCode(serviceCode);
		sagsUnsBo.setServiceName(sagsUns.service_name);
		sagsUnsBo.setDescription(sagsUns.description);
		sagsUnsBo.setAgencyResponsible(sagsUns.agency_responsible);
		sagsUnsBo.setServiceNotice(sagsUns.service_notice);
		Date requestedDateTime = dtf.parseDateTime(sagsUns.requested_datetime).toDate();
		sagsUnsBo.setRequestedDatetime(requestedDateTime);
		Date updatedDatetime = dtf.parseDateTime(sagsUns.updated_datetime).toDate();
		sagsUnsBo.setUpdatedDatetime(updatedDatetime);
		sagsUnsBo.setAddress(sagsUns.address);
		sagsUnsBo.setZipcode(sagsUns.zipcode);
		double lat = Double.parseDouble(sagsUns.lat);
		sagsUnsBo.setLat(lat);
		double lng = Double.parseDouble(sagsUns.lng);
		sagsUnsBo.setLng(lng);
		sagsUnsBo.setMediaUrl(sagsUns.media_url);
		sagsUnsBo.setStatus_notes(sagsUns.status_notes);
		return sagsUnsBo;
	}

	public SagsUnsDto getSagsUnsDto() {
		SagsUnsDto dto = new SagsUnsDto();
		dto.setId(sagsUns.service_request_id);
		dto.setStatus(sagsUns.status);
		int serviceCode = Integer.parseInt(sagsUns.service_code);
		dto.setServiceCode(serviceCode);
		dto.setServiceName(sagsUns.service_name);
		dto.setDescription(sagsUns.description);
		Timestamp requestedDateTime = new Timestamp(dtf.parseDateTime(sagsUns.requested_datetime).toDate().getTime());
		dto.setRequesteddatetime(requestedDateTime);
		Timestamp updatedDatetime = new Timestamp(dtf.parseDateTime(sagsUns.updated_datetime).toDate().getTime());
		dto.setUpdateddatetime(updatedDatetime);
		dto.setAddress(sagsUns.address);
		double lat = Double.parseDouble(sagsUns.lat);
		double lng = Double.parseDouble(sagsUns.lng);
		Point point = new Point(lat, lng);
		point.setSrid(SagsUnsConverter.SRID);
		dto.setGeom(new PGgeometry(point));
		dto.setMediaUrl(sagsUns.media_url);
		dto.setStatusnotes(sagsUns.status_notes);
		return dto;
	}

}
