package com.rms.entities;

public enum Roles {
	MANAGER,
	CHEF,
	WAITER,
	CASHIER;
	
	public static Roles convert(String role) {
		return switch(role.toUpperCase()) {
		case "MANAGER"-> Roles.MANAGER;
		case "CHEF"-> Roles.CHEF;
		case "CASHIER"-> Roles.CASHIER;
		default -> Roles.WAITER;
		};
	}
}
