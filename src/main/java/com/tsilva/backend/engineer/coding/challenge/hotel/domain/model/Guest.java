package com.tsilva.backend.engineer.coding.challenge.hotel.domain.model;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public class Guest {
	
	private final Double payLimit;
	
	public Guest(Double payLimit) {
        this.payLimit = payLimit;
    }
	
	public Double retrievePayLimit() {
        return payLimit;
    }
}
