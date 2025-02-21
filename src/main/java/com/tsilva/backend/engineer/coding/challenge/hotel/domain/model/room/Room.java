package com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.room;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.Guest;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public abstract class Room {
	
	private Guest guest;
	
	Room() {
	}
	
	public void attemptToAddLeadGuest(Guest guest) {
		if (Objects.isNull(this.guest)) {
			this.guest = guest;
		}
		else {
			throw new UnsupportedOperationException("Guest is already defined.");
		}
	}
	
	public Optional<Guest> retrieveGuest() {
		return Optional.ofNullable(guest);
	}
}
