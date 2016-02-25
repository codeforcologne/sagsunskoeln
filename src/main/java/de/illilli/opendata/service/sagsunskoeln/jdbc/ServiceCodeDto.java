package de.illilli.opendata.service.sagsunskoeln.jdbc;

public class ServiceCodeDto {

	private int servicecode;
	private String servicename;

	public int getServicecode() {
		return servicecode;
	}

	public void setServicecode(int servicecode) {
		this.servicecode = servicecode;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + servicecode;
		result = prime * result + ((servicename == null) ? 0 : servicename.hashCode());
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
		ServiceCodeDto other = (ServiceCodeDto) obj;
		if (servicecode != other.servicecode)
			return false;
		if (servicename == null) {
			if (other.servicename != null)
				return false;
		} else if (!servicename.equals(other.servicename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ServiceCodesDto [servicecode=" + servicecode + ", servicename=" + servicename + "]";
	}

}
