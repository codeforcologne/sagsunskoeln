package de.illilli.opendata.service.sagsunskoeln;

import java.util.Date;

public class LoggingBo {

	private Date modtime;
	private int numberofinsert;

	public Date getModtime() {
		return modtime;
	}

	public void setModtime(Date modtime) {
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
		LoggingBo other = (LoggingBo) obj;
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
		return "LoggingBo [modtime=" + modtime + ", numberofinsert=" + numberofinsert + "]";
	}

}
