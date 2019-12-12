package m3.model.filter;

public class InputException extends Exception{
	private String string;
	public InputException(String string) {
		this.string = string;
	}
	
	public String toString() {
		return string;
	}

}
