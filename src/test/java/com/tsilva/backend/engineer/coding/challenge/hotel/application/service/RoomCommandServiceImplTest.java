package com.tsilva.backend.engineer.coding.challenge.hotel.application.service;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommand;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommandDocument;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

class RoomCommandServiceImplTest {
	
	//[23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]
	private static final Collection<Double> POTENTIAL_GUESTS = List.of(
			23.0,
			45.0,
			155.0,
			374.0,
			22.0,
			99.99,
			100.0,
			101.0,
			115.0,
			209.0
	);
	private final Double premiumRoomThreshold = 100.0;
	private final RoomCommandService service = new RoomCommandServiceImpl(premiumRoomThreshold);
	
	@Test
	void assignRoomsWhenThereAreTooFewRoomsOfBothTypes() {
		var command = new OccupancyCommand(3, 3, POTENTIAL_GUESTS);
		
		var result = service.assignRooms(command);
		
		Assertions.assertThat(result)
				.usingRecursiveComparison()
				.isEqualTo(
						OccupancyCommandDocument.OccupancyCommandDocumentBuilder.builder()
								.usagePremium(3)
								.revenuePremium(738.0)
								.usageEconomy(3)
								.revenueEconomy(167.99)
								.build()
				);
	}
	
	@Test
	void assignRoomsWhenThereAreEnoughRooms() {
		var command = new OccupancyCommand(7, 5, POTENTIAL_GUESTS);
		
		var result = service.assignRooms(command);
		
		Assertions.assertThat(result)
				.usingRecursiveComparison()
				.isEqualTo(
						OccupancyCommandDocument.OccupancyCommandDocumentBuilder.builder()
								.usagePremium(6)
								.revenuePremium(1054.0)
								.usageEconomy(4)
								.revenueEconomy(189.99)
								.build()
				);
	}
	
	@Test
	void assignRoomsWhenThereAreTooFewPremiumRooms() {
		var command = new OccupancyCommand(2, 7, POTENTIAL_GUESTS);
		
		var result = service.assignRooms(command);
		
		Assertions.assertThat(result)
				.usingRecursiveComparison()
				.isEqualTo(
						OccupancyCommandDocument.OccupancyCommandDocumentBuilder.builder()
								.usagePremium(2)
								.revenuePremium(583.0)
								.usageEconomy(4)
								.revenueEconomy(189.99)
								.build()
				);
	}
	
	@Test
	void assignRoomsWhenThereAreTooFewEconomyRooms() {
		var command = new OccupancyCommand(7, 2, POTENTIAL_GUESTS);
		
		var result = service.assignRooms(command);
		
		Assertions.assertThat(result)
				.usingRecursiveComparison()
				.isEqualTo(
						OccupancyCommandDocument.OccupancyCommandDocumentBuilder.builder()
								.usagePremium(7)
								.revenuePremium(1153.99)
								.usageEconomy(2)
								.revenueEconomy(68.0)
								.build()
				);
	}
}
