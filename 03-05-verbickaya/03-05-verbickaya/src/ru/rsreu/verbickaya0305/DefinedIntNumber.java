package ru.rsreu.verbickaya0305;

public class DefinedIntNumber implements IntNumber {

	private Integer number;

	public DefinedIntNumber(int number) {
		this.setNumber(number);
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Integer getNumber() {
		return this.number;
	}

	@Override
	public String toString() {
		return this.getNumber().toString();
	}

}
