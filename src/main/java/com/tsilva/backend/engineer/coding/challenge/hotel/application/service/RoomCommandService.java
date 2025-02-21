package com.tsilva.backend.engineer.coding.challenge.hotel.application.service;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommand;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommandDocument;
import jakarta.annotation.Nonnull;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public interface RoomCommandService {
	
	@Nonnull
	OccupancyCommandDocument assignRooms(OccupancyCommand command);
}
