package com.tsilva.backend.engineer.coding.challenge.hotel.insfrastructure.http;

import com.tsilva.backend.engineer.coding.challenge.hotel.IntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

@AutoConfigureMockMvc
class RoomCommandResourceIT extends IntegrationTest {
	
	@Test
	void wellBuildCommandReturnResponseAndOkStatus() throws Exception {
		var requestBody = "{\"premiumRooms\": 7,\"economyRooms\": 5,\"potentialGuests\": " +
				"[23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]}";
		
		var expectedResponseBody = "{\"usagePremium\": 6,\"revenuePremium\":" +
				" 1054,\"usageEconomy\": 4,\"revenueEconomy\": 189.99}";
		mvc.perform(post("/api/room/occupancy")
						.contentType(MediaType.APPLICATION_JSON)
						.content(requestBody)
				)
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(content().json(expectedResponseBody));
	}
}