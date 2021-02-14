package com.raon.core.framework.scope;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ScopeAttribute implements RequestScopeAttribute {
	
	final String VALUE_OF_EMPTY = "empty";
	
	private String userId = VALUE_OF_EMPTY;

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return StringUtils.defaultIfBlank(this.userId, VALUE_OF_EMPTY);
	}
	
	public String toJson() {
		try {
			return new ObjectMapper().writeValueAsString(this);
		}catch(Exception e) {
			return null;
		}
	}

}
