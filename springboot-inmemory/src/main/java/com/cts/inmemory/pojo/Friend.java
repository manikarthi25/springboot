package com.cts.inmemory.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friend {
	
	private Integer id;
	private String name;
	private String location;

}
