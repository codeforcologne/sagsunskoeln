package de.illilli.opendata.service.sagsunskoeln;

import de.illilli.opendata.service.sagsunskoeln.jdbc.LoggingDto;

public class LoggingConverter {

	private LoggingDto dto;

	public LoggingConverter(LoggingDto dto) {
		this.dto = dto;
	}

	public LoggingBo getData() {
		LoggingBo bo = new LoggingBo();
		bo.setNumberofinsert(dto.getNumberofinsert());
		bo.setModtime(dto.getModtime());
		return bo;
	}

}
