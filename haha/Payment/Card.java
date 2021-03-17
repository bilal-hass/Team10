package Payment;

import Controller.Date;

public class Card extends Payment {
	private Integer _digits;
	private Date _expiryDate;
	private String _cardType;

	public Integer getDigits() {
		return this._digits;
	}

	public void setDigits(Integer aDigits) {
		this._digits = aDigits;
	}

	public Date getExpiryDate() {
		return this._expiryDate;
	}

	public void setExpiryDate(Date aExpiryDate) {
		this._expiryDate = aExpiryDate;
	}

	public String getCardType() {
		return this._cardType;
	}

	public void setCardType(String aCardType) {
		this._cardType = aCardType;
	}
}