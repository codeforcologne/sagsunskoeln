package de.illilli.opendata.service.sagsunskoeln.jdbc;

import java.sql.Timestamp;

import org.postgis.PGgeometry;

/**
 * <pre>
 * 	CREATE TABLE sagsuns (
 *	    id                varchar(16),
 *	    status            varchar(16),
 *	    serviceCode       integer NOT NULL,
 *	    serviceName       varchar(128),
 *	    description       varchar(1024),
 *	    requesteddatetime timestamp,
 *	    updateddatetime   timestamp,
 *	    address           varchar(128),
 *	    mediaurl          varchar(128),
 *	    statusnotes       varchar(1024),
 *	    modtime           timestamp DEFAULT current_timestamp
 *	);
 *	SELECT AddGeometryColumn ('public','sagsuns','geom',4326,'POINT',2);
 * 
 * </pre>
 */
public class SagsUnsDto {

	private String id;
	private String status;
	private int serviceCode;
	private String serviceName;
	private String description;
	private Timestamp requesteddatetime;
	private Timestamp updateddatetime;
	private String address;
	private PGgeometry geom;
	private String mediaUrl;
	private String statusnotes;
	private Timestamp modtime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(int serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getRequesteddatetime() {
		return requesteddatetime;
	}

	public void setRequesteddatetime(Timestamp requesteddatetime) {
		this.requesteddatetime = requesteddatetime;
	}

	public Timestamp getUpdateddatetime() {
		return updateddatetime;
	}

	public void setUpdateddatetime(Timestamp updateddatetime) {
		this.updateddatetime = updateddatetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public PGgeometry getGeom() {
		return geom;
	}

	public void setGeom(PGgeometry geom) {
		this.geom = geom;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getStatusnotes() {
		return statusnotes;
	}

	public void setStatusnotes(String statusnotes) {
		this.statusnotes = statusnotes;
	}

	public Timestamp getModtime() {
		return modtime;
	}

	public void setModtime(Timestamp modtime) {
		this.modtime = modtime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((geom == null) ? 0 : geom.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((mediaUrl == null) ? 0 : mediaUrl.hashCode());
		result = prime * result + ((modtime == null) ? 0 : modtime.hashCode());
		result = prime * result + ((requesteddatetime == null) ? 0 : requesteddatetime.hashCode());
		result = prime * result + serviceCode;
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((statusnotes == null) ? 0 : statusnotes.hashCode());
		result = prime * result + ((updateddatetime == null) ? 0 : updateddatetime.hashCode());
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
		SagsUnsDto other = (SagsUnsDto) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (geom == null) {
			if (other.geom != null)
				return false;
		} else if (!geom.equals(other.geom))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (mediaUrl == null) {
			if (other.mediaUrl != null)
				return false;
		} else if (!mediaUrl.equals(other.mediaUrl))
			return false;
		if (modtime == null) {
			if (other.modtime != null)
				return false;
		} else if (!modtime.equals(other.modtime))
			return false;
		if (requesteddatetime == null) {
			if (other.requesteddatetime != null)
				return false;
		} else if (!requesteddatetime.equals(other.requesteddatetime))
			return false;
		if (serviceCode != other.serviceCode)
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusnotes == null) {
			if (other.statusnotes != null)
				return false;
		} else if (!statusnotes.equals(other.statusnotes))
			return false;
		if (updateddatetime == null) {
			if (other.updateddatetime != null)
				return false;
		} else if (!updateddatetime.equals(other.updateddatetime))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SagsUnsDto [id=" + id + ", status=" + status + ", serviceCode=" + serviceCode + ", serviceName="
				+ serviceName + ", description=" + description + ", requesteddatetime=" + requesteddatetime
				+ ", updateddatetime=" + updateddatetime + ", address=" + address + ", geom=" + geom + ", mediaUrl="
				+ mediaUrl + ", statusnotes=" + statusnotes + ", modtime=" + modtime + "]";
	}

}
