package com.example.cowin.kanpur.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SessionDTO {

	@JsonProperty("center_id")
	int center_id;
	String name;
	String name_l;
	String address;
	String address_l;
	String state_name;
	String state_name_l;
	String district_name;
	String district_name_l;
	String block_name;
	String block_name_l;
	String pincode;
	int lat;
	long longitude ;
	String from;
	String to;
//could be a issue
	String []fee_type;
	String fee;
	String session_id;
	String date;
	int available_capacity;
	int available_capacity_dose1;
	int available_capacity_dose2;
	int min_age_limit;
	String vaccine;
	String slots[]	;
	
	
}
