package com.tsilva.backend.engineer.coding.challenge.hotel.domain.model;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.room.EconomyRoom;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.room.PremiumRoom;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public class Hotel {
	
	private final List<PremiumRoom> premiumRooms;
	private final List<EconomyRoom> economyRooms;
	
	public Hotel(Integer premiumRoomsCount, Integer economyRoomsCount) {
		var initializedPremiumRooms = new ArrayList<PremiumRoom>(premiumRoomsCount);
		for (var roomIdx = 0; roomIdx < premiumRoomsCount; roomIdx++) {
			initializedPremiumRooms.add(new PremiumRoom());
		}
		var initializedEconomyRooms = new ArrayList<EconomyRoom>(economyRoomsCount);
		for (var roomIdx = 0; roomIdx < economyRoomsCount; roomIdx++) {
			initializedEconomyRooms.add(new EconomyRoom());
		}
		this.premiumRooms = initializedPremiumRooms;
		this.economyRooms = initializedEconomyRooms;
	}
	
	public List<PremiumRoom> getPremiumRooms() {
        return premiumRooms;
    }
	
	public List<EconomyRoom> getEconomyRooms() {
		return economyRooms;
	}
}
