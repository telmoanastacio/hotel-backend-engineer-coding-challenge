package com.tsilva.backend.engineer.coding.challenge.hotel.insfrastructure.http;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommand;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommandDocument;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

@RestController
@RequestMapping("/api/room")
public class RoomCommandResource {
	
	@PostMapping("/occupancy")
	public ResponseEntity<OccupancyCommandDocument> postOccupancy(@RequestBody OccupancyCommand command) {
		// TODO: run the logic and build the correct value
		return ResponseEntity.ok(
				OccupancyCommandDocument.OccupancyCommandDocumentBuilder.builder()
						.usagePremium(4)
						.revenuePremium(523.00)
						.usageEconomy(6)
						.revenueEconomy(189.99)
						.build()
		);
	}
}
