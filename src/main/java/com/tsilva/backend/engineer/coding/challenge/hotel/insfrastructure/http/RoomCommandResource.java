package com.tsilva.backend.engineer.coding.challenge.hotel.insfrastructure.http;

import com.tsilva.backend.engineer.coding.challenge.hotel.application.service.RoomCommandService;
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
	
	private final RoomCommandService roomCommandService;
	
	public RoomCommandResource(RoomCommandService roomCommandService) {
        this.roomCommandService = roomCommandService;
    }
	
	@PostMapping("/occupancy")
	public ResponseEntity<OccupancyCommandDocument> postOccupancy(@RequestBody OccupancyCommand command) {
		return ResponseEntity.ok(roomCommandService.assignRooms(command));
	}
}
