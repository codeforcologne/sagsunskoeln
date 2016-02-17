package de.illilli.opendata.service.sagsunskoeln;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SagsUnsDao {

	public static final String DATE_FORMAT = "";

	private SagsUnsBo sagsUnsBo;

	public SagsUnsDao(SagsUns sagsUns) {

		this.sagsUnsBo = new SagsUnsBo();
		this.sagsUnsBo.setId(sagsUns.service_request_id);
		this.sagsUnsBo.setStatus(sagsUns.status);
		this.sagsUnsBo.setServiceCode(sagsUns.service_code);
		this.sagsUnsBo.setServiceName(sagsUns.service_name);
		this.sagsUnsBo.setDescription(sagsUns.description);
		this.sagsUnsBo.setAgencyResponsible(sagsUns.agency_responsible);
		this.sagsUnsBo.setServiceNotice(sagsUns.service_notice);
		Date requestedDateTime = null;
		try {
			requestedDateTime = new SimpleDateFormat(DATE_FORMAT).parse(sagsUns.requested_datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.sagsUnsBo.setRequestedDatetime(requestedDateTime);
		Date updatedDatetime = null;
		try {
			updatedDatetime = new SimpleDateFormat(DATE_FORMAT).parse(sagsUns.updated_datetime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		this.sagsUnsBo.setUpdatedDatetime(updatedDatetime);
		this.sagsUnsBo.setAddress(sagsUns.address);
		this.sagsUnsBo.setZipcode(sagsUns.zipcode);
		double lat = Double.parseDouble(sagsUns.lat);
		this.sagsUnsBo.setLat(lat);
		double lng = Double.parseDouble(sagsUns.lng);
		this.sagsUnsBo.setLng(lng);
		this.sagsUnsBo.setMediaUrl(sagsUns.media_url);
		this.sagsUnsBo.setStatus_notes(sagsUns.status_notes);
	}

	public SagsUnsBo getSagsUnsBo() {
		return sagsUnsBo;
	}

}
