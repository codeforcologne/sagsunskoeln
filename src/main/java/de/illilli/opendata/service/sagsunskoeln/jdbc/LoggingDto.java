package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.sql.Timestamp;

public class LoggingDto {

	private Timestamp modtime;
	private int numberofinsert;

	public Timestamp getModtime() {
		return modtime;
	}

	public void setModtime(Timestamp modtime) {
		this.modtime = modtime;
	}

	public int getNumberofinsert() {
		return numberofinsert;
	}

	public void setNumberofinsert(int numberofinsert) {
		this.numberofinsert = numberofinsert;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modtime == null) ? 0 : modtime.hashCode());
		result = prime * result + numberofinsert;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoggingDto other = (LoggingDto) obj;
		if (modtime == null) {
			if (other.modtime != null)
				return false;
		} else if (!modtime.equals(other.modtime))
			return false;
		if (numberofinsert != other.numberofinsert)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoggingDto [modtime=" + modtime + ", numberofinsert=" + numberofinsert + "]";
	}

}
