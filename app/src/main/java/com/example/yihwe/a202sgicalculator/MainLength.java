package com.example.yihwe.a202sgicalculator;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainLength extends Fragment {

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
    private Button mEqualB;
    private Button mClearB;
    private TextView mTextView;
    private EditText mEditText;
    private Spinner mSpinner;
    private Spinner mSpinner1;
    private int item;
    private int item1;
    private double value;
    private double result;
    private Conversion.Length CL;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View mainlength = inflater.inflate(R.layout.activity_main_length, container, false);
        mDotB = (Button) mainlength.findViewById(R.id.bDot);
        mZeroB = (Button) mainlength.findViewById(R.id.bZero);
        mOneB = (Button) mainlength.findViewById(R.id.bOne);
        mTwoB = (Button) mainlength.findViewById(R.id.bTwo);
        mThreeB = (Button) mainlength.findViewById(R.id.bThree);
        mFourB = (Button) mainlength.findViewById(R.id.bFour);
        mFiveB = (Button) mainlength.findViewById(R.id.bFive);
        mSixB = (Button) mainlength.findViewById(R.id.bSix);
        mSevenB = (Button) mainlength.findViewById(R.id.bSeven);
        mEightB = (Button) mainlength.findViewById(R.id.bEight);
        mNineB = (Button) mainlength.findViewById(R.id.bNine);
        mEqualB = (Button) mainlength.findViewById(R.id.bEqual);
        mClearB = (Button) mainlength.findViewById(R.id.bClear);
        mTextView = (TextView)mainlength.findViewById(R.id.textView);
        mEditText = (EditText)mainlength.findViewById(R.id.editText);
        mSpinner = (Spinner)mainlength.findViewById(R.id.SOne);
        mSpinner1 = (Spinner)mainlength.findViewById(R.id.STwo);
        CL = new Conversion.Length();

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

        mEqualB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                item = mSpinner.getSelectedItemPosition();
                item1 = mSpinner1.getSelectedItemPosition();
                value = Double.parseDouble(mEditText.getText().toString());
                result = evaluate(item,item1,value);
                mTextView.setText(result + "");
            }
        });

        mClearB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mEditText.getText().length() > 0) {
                    CharSequence currentText = mEditText.getText();
                    mEditText.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    mEditText.setText("");
                    mTextView.setText("");
                }
            }
        });

        return mainlength;
    }

    public double evaluate(int item1,int item2,double value)
    {
        double temp=0.0;
        if(item1==item2)
            return value;
        else
        {
            switch (item1)
            {
                case 0:
                    temp = CL.NanoToMeter(value);
                    break;
                case 1:
                    temp = CL.MilliToMeter(value);
                    break;
                case 2:
                    temp = CL.CentiToMeter(value);
                    break;
                case 3:
                    temp = value;
                    break;
                case 4:
                    temp = CL.KiloToMeter(value);
                    break;
                case 5:
                    temp = CL.InchToMeter(value);
                    break;
                case 6:
                    temp = CL.FootToMeter(value);
                    break;
                case 7:
                    temp = CL.YardToMeter(value);
                    break;
                case 8:
                    temp = CL.MileToMeter(value);
                    break;
            }

            switch (item2)
            {
                case 0:
                    temp = CL.MeterToNano(temp);
                    break;
                case 1:
                    temp = CL.MeterToMilli(temp);
                    break;
                case 2:
                    temp = CL.MeterToCenti(temp);
                    break;
                case 4:
                    temp = CL.MeterToKilo(temp);
                    break;
                case 5:
                    temp = CL.MeterToInch(temp);
                    break;
                case 6:
                    temp = CL.MeterToFoot(temp);
                    break;
                case 7:
                    temp = CL.MeterToYard(temp);
                    break;
                case 8:
                    temp = CL.MeterToMile(temp);
                    break;
            }
            return temp;
        }
    }
}
