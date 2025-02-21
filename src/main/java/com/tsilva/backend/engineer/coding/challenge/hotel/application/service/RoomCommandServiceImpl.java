package com.tsilva.backend.engineer.coding.challenge.hotel.application.service;

import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommand;
import com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room.OccupancyCommandDocument;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

@Service
public class RoomCommandServiceImpl implements RoomCommandService {
	
	private final Double premiumRoomThreshold;
	
	public RoomCommandServiceImpl(@Value("${hotel.room.premium.threshold}") Double premiumRoomThreshold) {
        this.premiumRoomThreshold = premiumRoomThreshold;
    }
	
	@Override
	public OccupancyCommandDocument assignRooms(OccupancyCommand command) {
		return null;
	}
}
