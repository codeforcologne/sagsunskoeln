package de.illilli.opendata.service.sagsunskoeln;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SagsUns {

	public String service_request_id;
	public String status;
	public String service_code;
	public String service_name;
	public String description;
	public String agency_responsible;
	public String service_notice;
	public String address_id;
	public String requested_datetime;
	public String updated_datetime;
	public String address;
	public String zipcode;
	public String lat;
	@JsonProperty("long")
	public String lng;
	public String media_url;
	public String status_notes;

	@Override
	public String toString() {
		return "SagsUns [service_request_id=" + service_request_id + ", status=" + status + ", service_code="
				+ service_code + ", service_name=" + service_name + ", description=" + description
				+ ", agency_responsible=" + agency_responsible + ", service_notice=" + service_notice + ", address_id="
				+ address_id + ", requested_datetime=" + requested_datetime + ", updated_datetime=" + updated_datetime
				+ ", address=" + address + ", zipcode=" + zipcode + ", lat=" + lat + ", lng=" + lng + ", media_url="
				+ media_url + ", status_notes=" + status_notes + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((address_id == null) ? 0 : address_id.hashCode());
		result = prime * result + ((agency_responsible == null) ? 0 : agency_responsible.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((lat == null) ? 0 : lat.hashCode());
		result = prime * result + ((lng == null) ? 0 : lng.hashCode());
		result = prime * result + ((media_url == null) ? 0 : media_url.hashCode());
		result = prime * result + ((requested_datetime == null) ? 0 : requested_datetime.hashCode());
		result = prime * result + ((service_code == null) ? 0 : service_code.hashCode());
		result = prime * result + ((service_name == null) ? 0 : service_name.hashCode());
		result = prime * result + ((service_notice == null) ? 0 : service_notice.hashCode());
		result = prime * result + ((service_request_id == null) ? 0 : service_request_id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((status_notes == null) ? 0 : status_notes.hashCode());
		result = prime * result + ((updated_datetime == null) ? 0 : updated_datetime.hashCode());
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
		SagsUns other = (SagsUns) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (address_id == null) {
			if (other.address_id != null)
				return false;
		} else if (!address_id.equals(other.address_id))
			return false;
		if (agency_responsible == null) {
			if (other.agency_responsible != null)
				return false;
		} else if (!agency_responsible.equals(other.agency_responsible))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (lat == null) {
			if (other.lat != null)
				return false;
		} else if (!lat.equals(other.lat))
			return false;
		if (lng == null) {
			if (other.lng != null)
				return false;
		} else if (!lng.equals(other.lng))
			return false;
		if (media_url == null) {
			if (other.media_url != null)
				return false;
		} else if (!media_url.equals(other.media_url))
			return false;
		if (requested_datetime == null) {
			if (other.requested_datetime != null)
				return false;
		} else if (!requested_datetime.equals(other.requested_datetime))
			return false;
		if (service_code == null) {
			if (other.service_code != null)
				return false;
		} else if (!service_code.equals(other.service_code))
			return false;
		if (service_name == null) {
			if (other.service_name != null)
				return false;
		} else if (!service_name.equals(other.service_name))
			return false;
		if (service_notice == null) {
			if (other.service_notice != null)
				return false;
		} else if (!service_notice.equals(other.service_notice))
			return false;
		if (service_request_id == null) {
			if (other.service_request_id != null)
				return false;
		} else if (!service_request_id.equals(other.service_request_id))
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
		if (updated_datetime == null) {
			if (other.updated_datetime != null)
				return false;
		} else if (!updated_datetime.equals(other.updated_datetime))
			return false;
		if (zipcode == null) {
			if (other.zipcode != null)
				return false;
		} else if (!zipcode.equals(other.zipcode))
			return false;
		return true;
	}

}
