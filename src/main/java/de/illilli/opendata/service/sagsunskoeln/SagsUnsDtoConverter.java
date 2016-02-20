package de.illilli.opendata.service.sagsunskoeln;

import java.util.Date;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;

public class SagsUnsDtoConverter {

	private SagsUnsDto sagsUns;

	public SagsUnsDtoConverter(SagsUnsDto sagsUns) {
		this.sagsUns = sagsUns;
	}

	public SagsUnsBo getSagsUnsBo() {
		SagsUnsBo sagsUnsBo = new SagsUnsBo();
		sagsUnsBo.setId(sagsUns.getId());
		sagsUnsBo.setStatus(sagsUns.getStatus());
		sagsUnsBo.setServiceCode(sagsUns.getServiceCode());
		sagsUnsBo.setServiceName(sagsUns.getServiceName());
		sagsUnsBo.setDescription(sagsUns.getDescription());
		Date requestedDateTime = sagsUns.getRequesteddatetime();
		sagsUnsBo.setRequestedDatetime(requestedDateTime);
		Date updatedDatetime = sagsUns.getUpdateddatetime();
		sagsUnsBo.setUpdatedDatetime(updatedDatetime);
		sagsUnsBo.setAddress(sagsUns.getAddress());
		double lat = sagsUns.getGeom().getGeometry().getFirstPoint().getX();
		sagsUnsBo.setLat(lat);
		double lng = sagsUns.getGeom().getGeometry().getFirstPoint().getY();
		sagsUnsBo.setLng(lng);
		sagsUnsBo.setMediaUrl(sagsUns.getMediaUrl());
		sagsUnsBo.setStatus_notes(sagsUns.getStatusnotes());
		return sagsUnsBo;
	}

}
