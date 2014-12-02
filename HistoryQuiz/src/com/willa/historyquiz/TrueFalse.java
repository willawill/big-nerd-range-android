package com.willa.historyquiz;

public class TrueFalse {
	private int mQuestion;
	private boolean mTrueQuestion;
	
	public TrueFalse(int question, boolean trueQuestion){
		this.mQuestion = question;
		this.mTrueQuestion = trueQuestion;
	}

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}
}
