package com.tsilva.backend.engineer.coding.challenge.hotel.application.service;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.converter.hotel.Hotel2OccupancyCommandDocument;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommand;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommandDocument;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.Guest;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.model.Hotel;
import jakarta.annotation.Nonnull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

@Service
public class RoomCommandServiceImpl implements RoomCommandService {
	
	private final Double premiumRoomThreshold;
	private final Hotel2OccupancyCommandDocument converter = new Hotel2OccupancyCommandDocument();
	
	public RoomCommandServiceImpl(@Value("${hotel.room.premium.threshold}") Double premiumRoomThreshold) {
        this.premiumRoomThreshold = premiumRoomThreshold;
    }
	
	@Nonnull
	@Override
	public OccupancyCommandDocument assignRooms(OccupancyCommand command) {
		var hotel = assignGuestsToRooms(initializeHotel(command), command.getPotentialGuests());
		return converter.convert(hotel);
	}
	
	private Hotel initializeHotel(OccupancyCommand command) {
		return new Hotel(command.getPremiumRooms(), command.getEconomyRooms());
	}
	
	private Hotel assignGuestsToRooms(Hotel hotel, Collection<Double> potentialGuests) {
		// sort potential guests from highest to lowest
		var sortedPotentialGuestsPayLimit = potentialGuests.stream()
				.sorted(Comparator.reverseOrder())
				.toList();
		var premiumGuests = sortedPotentialGuestsPayLimit.stream()
				.filter(payLimit -> payLimit >= premiumRoomThreshold)
				.toList();
		var economyGuests = sortedPotentialGuestsPayLimit.stream()
				.filter(payLimit -> payLimit < premiumRoomThreshold)
				.toList();
		var premiumGuestsCount = premiumGuests.size();
		var economyGuestsCount = economyGuests.size();
		var premiumRooms = hotel.getPremiumRooms();
		var economyRooms = hotel.getEconomyRooms();
		var premiumRoomsCount = premiumRooms.size();
		var economyRoomsCount = economyRooms.size();
		
		// Assign premium rooms to premium guests
		var premiumRoomIdx = 0;
		while (premiumRoomIdx < premiumGuestsCount && premiumRoomIdx < premiumRoomsCount) {
			premiumRooms.get(premiumRoomIdx)
					.attemptToAddLeadGuest(new Guest(premiumGuests.get(premiumRoomIdx)));
			premiumRoomIdx++;
		}
		
		// If there are more economy guests than economy rooms and premium rooms available,
		// assign highest-paying economy guests to remaining premium rooms
		var remainingPremiumRooms = premiumRoomsCount - premiumRoomIdx;
		var economyGuestIdx = 0;
		if (economyGuestsCount > economyRoomsCount) {
			while (remainingPremiumRooms > 0 && economyGuestIdx < economyGuestsCount) {
				premiumRooms.get(premiumRoomIdx)
						.attemptToAddLeadGuest(new Guest(economyGuests.get(economyGuestIdx)));
				premiumRoomIdx++;
				remainingPremiumRooms--;
				economyGuestIdx++;
			}
		}
		
		// Assign economy guests to economy rooms
		var economyRoomIdx = 0;
		while (economyRoomIdx < economyGuestsCount && economyRoomIdx < economyRoomsCount) {
			economyRooms.get(economyRoomIdx)
					.attemptToAddLeadGuest(new Guest(economyGuests.get(economyGuestIdx)));
			economyRoomIdx++;
			economyGuestIdx++;
		}
		return hotel;
	}
}
