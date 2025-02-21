package com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.room;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.Guest;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public abstract class Room {
	
	private final Guest guest;
	
	Room(Guest guest) {
		this.guest = guest;
	}
	
	public Guest getGuest() {
        return guest;
    }
}
