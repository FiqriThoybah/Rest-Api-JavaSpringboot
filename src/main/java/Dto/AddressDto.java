package Dto;

import javax.validation.constraints.NotEmpty;

public class AddressDto {

	@NotEmpty (message = "detail address is required")
	private String detail_address;
	
	@NotEmpty (message = "city is required")
	private String city;
	
	@NotEmpty (message = "zipcode is required")
	private String zipcode;

	public String getDetail_address() {
		return detail_address;
	}

	public void setDetail_address(String detail_address) {
		this.detail_address = detail_address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	
	
}
