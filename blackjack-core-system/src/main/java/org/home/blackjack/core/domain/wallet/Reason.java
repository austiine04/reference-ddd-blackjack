package org.home.blackjack.core.domain.wallet;

import org.home.blackjack.util.ddd.pattern.ValueObject;

public class Reason extends ValueObject {

	private final String reasonMsg;

	public Reason(String reasonMsg) {
		this.reasonMsg = reasonMsg;
	}
	
	public String reasonMsg() {
		return reasonMsg;
	}

}
