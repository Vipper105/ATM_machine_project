//package kits.atmmachine;
//
//public class Coins2 {
//
//	public enum Season {
//		ONE_DOLLAR(1, 5), TEN_DOLLAR(10, 10), THIRTY_DOLLAR(30, 15), FIFTY_DOLLAR(50, 20), ONEHUNRED_DOLLAR(100, 5),
//		TWOHUNRED_DOLLAR(200, 10), FIVEHUNDRED_DOLLAR(500, 15), ONETHOUSAND_DOLLAR(1000, 20),
//		TWOTHOUSAND_DOLLAR(2000, 30);
//
//		private int priceTag;
//		private int quantity;
//		private long sumOfCoin;
//
//		private Season(int priceTag, int quantity) {
//			this.priceTag = priceTag;
//			this.quantity = quantity;
////			sumOfCoin = priceTag * quantity;
//
//		}
//
//		public int getPriceTag() {
//			return priceTag;
//		}
//
//		public void setPriceTag(int priceTag) {
//			this.priceTag = priceTag;
//		}
//
//		public int getQuantity() {
//			return quantity;
//		}
//
//		public void setQuantity(int quantity) {
//			this.quantity = quantity;
//		}
//
//		public long sumOfCoins() {
//			Season coin = Season.ONE_DOLLAR;
//			sumOfCoin = coin.getPriceTag() * coin.getPriceTag();
//			return sumOfCoin;
//		}
//
//	}
//
////	public static void main(String args[]) {
////        for (Season s : Season.values()) {
////            System.out.println(s + " " + s.value);
////        }
////    }
//
//}
