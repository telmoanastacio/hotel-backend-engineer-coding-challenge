package com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Collection;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public class OccupancyCommand {
	
	private final Integer premiumRooms;
	private final Integer economyRooms;
	private final Collection<Double> potentialGuests;
	
	@JsonCreator
	public OccupancyCommand(
			Integer premiumRooms,
			Integer economyRooms,
			Collection<Double> potentialGuests
	) {
        this.premiumRooms = premiumRooms;
        this.economyRooms = economyRooms;
        this.potentialGuests = potentialGuests;
    }
	
	public Integer getPremiumRooms() {
		return premiumRooms;
	}
	
	public Integer getEconomyRooms() {
		return economyRooms;
	}
	
	public Collection<Double> getPotentialGuests() {
		return potentialGuests;
	}
}
