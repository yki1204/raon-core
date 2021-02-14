package com.raon.core.framework.scope;

public class RequestScopeUtil {
	
	private static RequestScopeStore scopeStore = null;
	
	private static synchronized void defineScope() {
		if(scopeStore != null) {
			return;
		}
		scopeStore = new ScopeStore();
	}
	
	public static RequestScopeAttribute getAttribute() {
		if(scopeStore == null) {
			defineScope();
		}
		return scopeStore.getAttribute();
	}
	

}
