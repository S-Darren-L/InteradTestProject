package models;

public class PaymentCardsModel {

	private String cardType = null;
	private String cardBalanceValue = null;
	private String cardCreditValue = null;
	private String cardNumber = null;
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	public String getCardBalanceValue() {
		return cardBalanceValue;
	}
	public void setCardBalanceValue(String cardBalanceValue) {
		this.cardBalanceValue = cardBalanceValue;
	}
	public String getCardCreditValue() {
		return cardCreditValue;
	}
	public void setCardCreditValue(String cardCreditValue) {
		this.cardCreditValue = cardCreditValue;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
}
