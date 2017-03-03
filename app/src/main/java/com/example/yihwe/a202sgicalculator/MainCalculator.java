package com.example.yihwe.a202sgicalculator;

import java.text.DecimalFormat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainCalculator extends Fragment {
    private double valueOne = Double.NaN;
    private double valueTwo;

    private static final char ADD = '+';
    private static final char SUB = '-';
    private static final char MUL = '*';
    private static final char DIV = '/';

    private char operation;
    private DecimalFormat mDecimalFormat;

    private Button mDotB;
    private Button mZeroB;
    private Button mOneB;
    private Button mTwoB;
    private Button mThreeB;
    private Button mFourB;
    private Button mFiveB;
    private Button mSixB;
    private Button mSevenB;
    private Button mEightB;
    private Button mNineB;
    private Button mAdditionB;
    private Button mSubtractionB;
    private Button mMultiplicationB;
    private Button mDivisionB;
    private Button mEqualB;
    private Button mClearB;
    private TextView mTextView;
    private EditText mEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View maincalculator = inflater.inflate(R.layout.activity_main_calculator, container, false);

        mDotB = (Button) maincalculator.findViewById(R.id.bDot);
        mZeroB = (Button) maincalculator.findViewById(R.id.bZero);
        mOneB = (Button) maincalculator.findViewById(R.id.bOne);
        mTwoB = (Button) maincalculator.findViewById(R.id.bTwo);
        mThreeB = (Button) maincalculator.findViewById(R.id.bThree);
        mFourB = (Button) maincalculator.findViewById(R.id.bFour);
        mFiveB = (Button) maincalculator.findViewById(R.id.bFive);
        mSixB = (Button) maincalculator.findViewById(R.id.bSix);
        mSevenB = (Button) maincalculator.findViewById(R.id.bSeven);
        mEightB = (Button) maincalculator.findViewById(R.id.bEight);
        mNineB = (Button) maincalculator.findViewById(R.id.bNine);
        mAdditionB = (Button) maincalculator.findViewById(R.id.bAddition);
        mSubtractionB = (Button) maincalculator.findViewById(R.id.bSubtraction);
        mMultiplicationB = (Button) maincalculator.findViewById(R.id.bMultiplication);
        mDivisionB = (Button) maincalculator.findViewById(R.id.bDivision);
        mEqualB = (Button) maincalculator.findViewById(R.id.bEqual);
        mClearB = (Button) maincalculator.findViewById(R.id.bClear);
        mTextView = (TextView)maincalculator.findViewById(R.id.textView);
        mEditText = (EditText)maincalculator.findViewById(R.id.editText);
        mDecimalFormat = new DecimalFormat("#.##########");

        mDotB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + ".");
            }
        });

        mZeroB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "0");
            }
        });

        mOneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "1");
            }
        });

        mTwoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "2");
            }
        });

        mThreeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "3");
            }
        });

        mFourB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "4");
            }
        });

        mFiveB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "5");
            }
        });

        mSixB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "6");
            }
        });

        mSevenB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "7");
            }
        });

        mEightB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "8");
            }
        });

        mNineB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditText.setText(mEditText.getText() + "9");
            }
        });

        mAdditionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MathsOperation();
                operation = ADD;
                mTextView.setText(mDecimalFormat.format(valueOne) + " + ");
                mEditText.setText(null);
            }
        });

        mSubtractionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MathsOperation();
                operation = SUB;
                mTextView.setText(mDecimalFormat.format(valueOne) + " - ");
                mEditText.setText(null);
            }
        });

        mMultiplicationB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MathsOperation();
                operation = MUL;
                mTextView.setText(mDecimalFormat.format(valueOne) + " * ");
                mEditText.setText(null);
            }
        });

        mDivisionB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MathsOperation();
                operation = DIV;
                mTextView.setText(mDecimalFormat.format(valueOne) + " / ");
                mEditText.setText(null);
            }
        });

        mEqualB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MathsOperation();
                mTextView.setText(mTextView.getText().toString() + mDecimalFormat.format(valueTwo) + " = " + mDecimalFormat.format(valueOne));
                valueOne = Double.NaN;
                operation = '0';
            }
        });

        mClearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().length() > 0) {
                    CharSequence currentText = mEditText.getText();
                    mEditText.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    mEditText.setText("");
                    mTextView.setText("");
                }
            }
        });

        return maincalculator;
    }

    private void MathsOperation() {
        if (!Double.isNaN(valueOne)) {
            valueTwo = Double.parseDouble(mEditText.getText().toString());
            mEditText.setText(null);
            if (operation == ADD)
                valueOne = this.valueOne + valueTwo;
            else if (operation == SUB)
                valueOne = this.valueOne - valueTwo;
            else if (operation == MUL)
                valueOne = this.valueOne * valueTwo;
            else if (operation == DIV)
                valueOne = this.valueOne / valueTwo;
        }
        else {
            try {
                valueOne = Double.parseDouble(mEditText.getText().toString());
            }
            catch (Exception e) {
            }
        }
    }
}