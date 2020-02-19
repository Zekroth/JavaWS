package core;

public abstract class Op<T extends Object> {

	public T Result;
	public char[] sign;

	public abstract T Solve();

	public T getResult() {
		return Result;
	}

	public void setResult(T result) {
		Result = result;
	}

	public char[] getSign() {
		return sign;
	}

	public void setSign(char[] sign) {
		this.sign = sign;
	}



}
