package com.example.cowin.kanpur.dto;

import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
@JsonRootName(value="sessions")
public class Sessions {

	SessionDTO[] sessionDto;
	
	
}
