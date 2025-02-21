package com.tsilva.backend.engineer.coding.challenge.hotel.domain.dto.room;

/**
 * Created by Telmo Silva on 21.02.2025.
 */

public class OccupancyCommandDocument {
	
	private final Integer usagePremium;
	private final Double revenuePremium;    // could be BigDecimal, using Double for the sake of simplicity
	private final Integer usageEconomy;
	private final Double revenueEconomy;    // same here
	
	private OccupancyCommandDocument(OccupancyCommandDocumentBuilder builder) {
		this.usagePremium = builder.usagePremium;
		this.revenuePremium = builder.revenuePremium;
		this.usageEconomy = builder.usageEconomy;
		this.revenueEconomy = builder.revenueEconomy;
	}
	
	public Integer getUsagePremium() {
		return usagePremium;
	}
	
	public Double getRevenuePremium() {
		return revenuePremium;
	}
	
	public Integer getUsageEconomy() {
		return usageEconomy;
	}
	
	public Double getRevenueEconomy() {
		return revenueEconomy;
	}
	
	public static class OccupancyCommandDocumentBuilder {
		
		private int usagePremium;
		private double revenuePremium;
		private int usageEconomy;
		private double revenueEconomy;
		
		public static OccupancyCommandDocumentBuilder builder() {
			return new OccupancyCommandDocumentBuilder();
		}
		
		public OccupancyCommandDocumentBuilder usagePremium(int usagePremium) {
			this.usagePremium = usagePremium;
			return this;
		}
		
		public OccupancyCommandDocumentBuilder revenuePremium(double revenuePremium) {
			this.revenuePremium = revenuePremium;
			return this;
		}
		
		public OccupancyCommandDocumentBuilder usageEconomy(int usageEconomy) {
			this.usageEconomy = usageEconomy;
			return this;
		}
		
		public OccupancyCommandDocumentBuilder revenueEconomy(double revenueEconomy) {
			this.revenueEconomy = revenueEconomy;
			return this;
		}
		
		public OccupancyCommandDocument build() {
			// run validation if required
			return new OccupancyCommandDocument(this);
		}
	}
}
