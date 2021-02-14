package com.raon.core.framework.scope;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

public class ScopeStore implements RequestScopeStore {
	
	private static final ThreadLocal<RequestScopeAttribute> attributeThreaLocal = new ThreadLocal<>();

	@Override
	public RequestScopeAttribute getAttribute() {
		
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		
		// async 설정 (kafka subscribe 시)
		if(requestAttributes == null) {
			
			RequestScopeAttribute attribute = attributeThreaLocal.get();
			if(attribute == null) {
				attribute = emptyAttribute();
				setAttributeIntoThreadLocal((ScopeAttribute)attribute);
				return attribute;
			}
			
			return attribute;
		}
		
		return null;
	}
	
	private void setAttributeIntoThreadLocal(ScopeAttribute attribute) {
		attributeThreaLocal.set(attribute);
	}
	
	private RequestScopeAttribute emptyAttribute() {
		return new ScopeAttribute();
	}
	
	

}
