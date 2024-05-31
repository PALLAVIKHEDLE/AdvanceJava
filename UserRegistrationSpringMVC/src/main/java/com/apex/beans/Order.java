package com.apex.beans;

public class Order {

	private String orderID;
	private String itemName;
	private String purchaseDate;
	private String amount;

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Order [orderID=" + orderID + ", itemName=" + itemName + ", purchaseDate=" + purchaseDate + ", amount="
				+ amount + "]";
	}

}
