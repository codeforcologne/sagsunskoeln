package de.illilli.opendata.service.sagsunskoeln;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.postgis.PGgeometry;
import org.postgis.Point;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;

public class SagsUnsConverter {

	/**
	 * 2016-02-16T21:26:17+01:00
	 */
	public static final String DATE_FORMAT = "yyyy-MM-ddThh24:mm:ss";

	private SagsUns sagsUns;

	public SagsUnsConverter(SagsUns sagsUns) {
		this.sagsUns = sagsUns;
	}

	public SagsUnsBo getSagsUnsBo() {
		SagsUnsBo sagsUnsBo = new SagsUnsBo();
		sagsUnsBo.setId(sagsUns.service_request_id);
		sagsUnsBo.setStatus(sagsUns.status);
		sagsUnsBo.setServiceCode(sagsUns.service_code);
		sagsUnsBo.setServiceName(sagsUns.service_name);
		sagsUnsBo.setDescription(sagsUns.description);
		sagsUnsBo.setAgencyResponsible(sagsUns.agency_responsible);
		sagsUnsBo.setServiceNotice(sagsUns.service_notice);
		Date requestedDateTime = null;
		try {
			requestedDateTime = new SimpleDateFormat(DATE_FORMAT).parse(sagsUns.requested_datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sagsUnsBo.setRequestedDatetime(requestedDateTime);
		Date updatedDatetime = null;
		try {
			updatedDatetime = new SimpleDateFormat(DATE_FORMAT).parse(sagsUns.updated_datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
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
		Timestamp requestedDateTime = null;
		try {
			requestedDateTime = new Timestamp(
					new SimpleDateFormat(DATE_FORMAT).parse(sagsUns.requested_datetime).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setRequesteddatetime(requestedDateTime);
		Timestamp updatedDatetime = null;
		try {
			updatedDatetime = new Timestamp(
					new SimpleDateFormat(DATE_FORMAT).parse(sagsUns.updated_datetime).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		dto.setUpdateddatetime(updatedDatetime);
		dto.setAddress(sagsUns.address);
		double lat = Double.parseDouble(sagsUns.lat);
		double lng = Double.parseDouble(sagsUns.lng);
		Point point = new Point(lat, lng);
		dto.setGeom(new PGgeometry(point));
		dto.setMediaUrl(sagsUns.media_url);
		dto.setStatusnotes(sagsUns.status_notes);
		return dto;
	}

}
