package com.example.cathaybankhomework.dto;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseObject {

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
