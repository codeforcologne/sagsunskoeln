package de.illilli.opendata.service.sagsunskoeln;

import java.util.Date;

public class SagsUnsBo {

	private String id;
	private String status;
	private String serviceCode;
	private String serviceName;
	private String description;
	private String agencyResponsible;
	private String serviceNotice;
	private String addressId;
	private Date requestedDatetime;
	private Date updatedDatetime;
	private String address;
	private String zipcode;
	private double lat;
	private double lng;
	private String mediaUrl;
	private String status_notes;

	public SagsUnsBo() {
	}

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

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
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

	public String getAgencyResponsible() {
		return agencyResponsible;
	}

	public void setAgencyResponsible(String agencyResponsible) {
		this.agencyResponsible = agencyResponsible;
	}

	public String getServiceNotice() {
		return serviceNotice;
	}

	public void setServiceNotice(String serviceNotice) {
		this.serviceNotice = serviceNotice;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public Date getRequestedDatetime() {
		return requestedDatetime;
	}

	public void setRequestedDatetime(Date requestedDatetime) {
		this.requestedDatetime = requestedDatetime;
	}

	public Date getUpdatedDatetime() {
		return updatedDatetime;
	}

	public void setUpdatedDatetime(Date updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public String getMediaUrl() {
		return mediaUrl;
	}

	public void setMediaUrl(String mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getStatus_notes() {
		return status_notes;
	}

	public void setStatus_notes(String status_notes) {
		this.status_notes = status_notes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((addressId == null) ? 0 : addressId.hashCode());
		result = prime * result + ((agencyResponsible == null) ? 0 : agencyResponsible.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		long temp;
		temp = Double.doubleToLongBits(lat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(lng);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((mediaUrl == null) ? 0 : mediaUrl.hashCode());
		result = prime * result + ((requestedDatetime == null) ? 0 : requestedDatetime.hashCode());
		result = prime * result + ((serviceCode == null) ? 0 : serviceCode.hashCode());
		result = prime * result + ((serviceName == null) ? 0 : serviceName.hashCode());
		result = prime * result + ((serviceNotice == null) ? 0 : serviceNotice.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((status_notes == null) ? 0 : status_notes.hashCode());
		result = prime * result + ((updatedDatetime == null) ? 0 : updatedDatetime.hashCode());
		result = prime * result + ((zipcode == null) ? 0 : zipcode.hashCode());
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
		SagsUnsBo other = (SagsUnsBo) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (addressId == null) {
			if (other.addressId != null)
				return false;
		} else if (!addressId.equals(other.addressId))
			return false;
		if (agencyResponsible == null) {
			if (other.agencyResponsible != null)
				return false;
		} else if (!agencyResponsible.equals(other.agencyResponsible))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (Double.doubleToLongBits(lat) != Double.doubleToLongBits(other.lat))
			return false;
		if (Double.doubleToLongBits(lng) != Double.doubleToLongBits(other.lng))
			return false;
		if (mediaUrl == null) {
			if (other.mediaUrl != null)
				return false;
		} else if (!mediaUrl.equals(other.mediaUrl))
			return false;
		if (requestedDatetime == null) {
			if (other.requestedDatetime != null)
				return false;
		} else if (!requestedDatetime.equals(other.requestedDatetime))
			return false;
		if (serviceCode == null) {
			if (other.serviceCode != null)
				return false;
		} else if (!serviceCode.equals(other.serviceCode))
			return false;
		if (serviceName == null) {
			if (other.serviceName != null)
				return false;
		} else if (!serviceName.equals(other.serviceName))
			return false;
		if (serviceNotice == null) {
			if (other.serviceNotice != null)
				return false;
		} else if (!serviceNotice.equals(other.serviceNotice))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (status_notes == null) {
			if (other.status_notes != null)
				return false;
		} else if (!status_notes.equals(other.status_notes))
			return false;
		if (updatedDatetime == null) {
			if (other.updatedDatetime != null)
				return false;
		} else if (!updatedDatetime.equals(other.updatedDatetime))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SagsUnsBo [id=" + id + ", status=" + status + ", serviceCode=" + serviceCode + ", serviceName="
				+ serviceName + ", description=" + description + ", agencyResponsible=" + agencyResponsible
				+ ", serviceNotice=" + serviceNotice + ", addressId=" + addressId + ", requestedDatetime="
				+ requestedDatetime + ", updatedDatetime=" + updatedDatetime + ", address=" + address + ", zipcode="
				+ zipcode + ", lat=" + lat + ", lng=" + lng + ", mediaUrl=" + mediaUrl + ", status_notes="
				+ status_notes + "]";
	}

}
