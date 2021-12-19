package com.ederweb.eder.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMENT(1), //informando o valor em cada Status
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	private OrderStatus(int code) { //para informar o code nos valores
		this.code = code;
	}
	
	public int getCode() { //para o metodo ficar acessivel 
		return code;
	}
	
	public static OrderStatus valueOf(int code) { //converte numero em tipo enumerado
		for (OrderStatus value : OrderStatus.values()) { //vai percorrer o OrderStatus para buscar o valor do Status
			if (value.getCode()== code) {
				return value;
			}
		}
		
		throw new IllegalArgumentException("Incalid OrderStatus code"); 
		// caso o codigo informado não seja da lista dos enums
	}

}
