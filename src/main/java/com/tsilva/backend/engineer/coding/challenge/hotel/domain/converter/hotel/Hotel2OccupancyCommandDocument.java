package com.tsilva.backend.engineer.coding.challenge.hotel.domain.converter.hotel;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommandDocument;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.Hotel;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public class Hotel2OccupancyCommandDocument {
	
	public OccupancyCommandDocument convert(Hotel hotel) {
		var occupiedPremiumRooms = hotel.getPremiumRooms().stream()
				.filter(room -> room.retrieveGuest().isPresent())
				.toList();
		var occupiedEconomyRooms = hotel.getEconomyRooms().stream()
				.filter(room -> room.retrieveGuest().isPresent())
				.toList();
		//noinspection OptionalGetWithoutIsPresent
		return OccupancyCommandDocument.OccupancyCommandDocumentBuilder.builder()
				.usagePremium(occupiedPremiumRooms.size())
				.revenuePremium(
						occupiedPremiumRooms.stream()
								.map(room -> room.retrieveGuest()
										.get()
										.retrievePayLimit()
								).reduce(0.0, Double::sum)
				)
				.usageEconomy(occupiedEconomyRooms.size())
				.revenueEconomy(
						occupiedEconomyRooms.stream()
								.map(room -> room.retrieveGuest()
										.get()
										.retrievePayLimit()
								).reduce(0.0, Double::sum)
				)
				.build();
	}
}
