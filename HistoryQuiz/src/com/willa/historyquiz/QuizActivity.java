package com.willa.historyquiz;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends ActionBarActivity {
	private Button mTrueButton;
	private Button mFalseButton;
	private Button mNextButton;
	private TextView mQuestionView;
	private TrueFalse[] mQuestionBank = new TrueFalse[] {
			new TrueFalse(R.string.question_china, true),
			new TrueFalse(R.string.question_america, false) };
	private int mCurrentIndex = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		mTrueButton = (Button) findViewById(R.id.true_button);
		mFalseButton = (Button) findViewById(R.id.false_button);
		mNextButton = (Button) findViewById(R.id.next_button);

		mQuestionView = (TextView) findViewById(R.id.question_text_view);
		setQuestion();

		mTrueButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkAnswer(true);
			}
		});

		mFalseButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				checkAnswer(false);
			}
		});

		mNextButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
				setQuestion();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.quiz, menu);
		return true;
	}

	private void setQuestion(){
		int question = mQuestionBank[this.mCurrentIndex].getQuestion();
		mQuestionView.setText(question);
	}

	private void checkAnswer(boolean userInput){
		boolean answerIsTrue = this.mQuestionBank[mCurrentIndex].isTrueQuestion();
		int messageId;
		if ( userInput == answerIsTrue ){
			messageId = R.string.correct_toast;
		}
		else{
			messageId = R.string.incorrect_toast;
		}
		Toast.makeText(QuizActivity.this, messageId, Toast.LENGTH_SHORT).show();
	}
}