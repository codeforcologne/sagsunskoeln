package de.illilli.opendata.service.sagsunskoeln;

import java.util.Date;

import de.illilli.opendata.service.sagsunskoeln.jdbc.SagsUnsDto;

public class SagsUnsDtoConverter {

	private SagsUnsDto dto;

	public SagsUnsDtoConverter(SagsUnsDto dto) {
		this.dto = dto;
	}

	public SagsUnsBo getData() {
		SagsUnsBo sagsUnsBo = new SagsUnsBo();
		sagsUnsBo.setId(dto.getId());
		sagsUnsBo.setStatus(dto.getStatus());
		sagsUnsBo.setServiceCode(dto.getServiceCode());
		sagsUnsBo.setServiceName(dto.getServiceName());
		sagsUnsBo.setDescription(dto.getDescription());
		Date requestedDateTime = dto.getRequesteddatetime();
		sagsUnsBo.setRequestedDatetime(requestedDateTime);
		Date updatedDatetime = dto.getUpdateddatetime();
		sagsUnsBo.setUpdatedDatetime(updatedDatetime);
		sagsUnsBo.setAddress(dto.getAddress());
		sagsUnsBo.setLat(dto.getLat());
		sagsUnsBo.setLng(dto.getLng());
		sagsUnsBo.setMediaUrl(dto.getMediaUrl());
		sagsUnsBo.setStatus_notes(dto.getStatusnotes());
		return sagsUnsBo;
	}

}
