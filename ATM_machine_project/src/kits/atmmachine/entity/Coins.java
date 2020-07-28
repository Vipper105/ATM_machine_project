package kits.atmmachine.entity;

public class Coins {
	private int coinID; // auto increament
	private int priceTag;
	private long quantity;
	private int machineID;

	public Coins() {
	}

	public Coins(int priceTag, long quantity, int machineID) {

		this.priceTag = priceTag;
		this.quantity = quantity;
		this.machineID = machineID;
	}

	public Coins(int coinID, int priceTag, long quantity, int machineID) {
		this.coinID = coinID;
		this.priceTag = priceTag;
		this.quantity = quantity;
		this.machineID = machineID;
	}

	public int getCoinID() {
		return coinID;
	}

	public void setCoinID(int coinID) {
		this.coinID = coinID;
	}

	public int getPriceTag() {
		return priceTag;
	}

	public void setPriceTag(int priceTag) {
		this.priceTag = priceTag;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public int getMachineID() {
		return machineID;
	}

	public void setMachineID(int machineID) {
		this.machineID = machineID;
	}

}
