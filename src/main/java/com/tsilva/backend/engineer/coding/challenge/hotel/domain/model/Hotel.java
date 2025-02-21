package com.tsilva.backend.engineer.coding.challenge.hotel.domain.model;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.room.Room;

import java.util.Collection;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public class Hotel {
	
	private final Collection<Room> rooms;
	
	public Hotel(Collection<Room> rooms) {
        this.rooms = rooms;
    }
	
	public Collection<Room> getRooms() {
        return rooms;
    }
}
