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

public class MainTemperature extends Fragment {
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
    private Conversion.Temp CT;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View maintemp = inflater.inflate(R.layout.activity_main_temperature, container, false);
        mDotB = (Button) maintemp.findViewById(R.id.bDot);
        mZeroB = (Button) maintemp.findViewById(R.id.bZero);
        mOneB = (Button) maintemp.findViewById(R.id.bOne);
        mTwoB = (Button) maintemp.findViewById(R.id.bTwo);
        mThreeB = (Button) maintemp.findViewById(R.id.bThree);
        mFourB = (Button) maintemp.findViewById(R.id.bFour);
        mFiveB = (Button) maintemp.findViewById(R.id.bFive);
        mSixB = (Button) maintemp.findViewById(R.id.bSix);
        mSevenB = (Button) maintemp.findViewById(R.id.bSeven);
        mEightB = (Button) maintemp.findViewById(R.id.bEight);
        mNineB = (Button) maintemp.findViewById(R.id.bNine);
        mEqualB = (Button) maintemp.findViewById(R.id.bEqual);
        mClearB = (Button) maintemp.findViewById(R.id.bClear);
        mTextView = (TextView) maintemp.findViewById(R.id.textView);
        mEditText = (EditText) maintemp.findViewById(R.id.editText);
        mSpinner = (Spinner) maintemp.findViewById(R.id.SOne);
        mSpinner1 = (Spinner) maintemp.findViewById(R.id.STwo);
        CT = new Conversion.Temp();

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
                result = conversion(item,item1,value);
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

        return maintemp;
    }

    public double conversion(int item1,int item2,double value)
    {
        double temp=0.0;
        if(item1==item2)
            return value;
        else
        {
            switch (item1)
            {
                case 0:
                    temp = CT.CelsiTokelvin(value);
                    break;
                case 1:
                    temp = CT.FerToKelvin(value);
                    break;
                case 2:
                    temp = value;
                    break;
            }

            switch (item2)
            {
                case 0:
                    temp = CT.KelvinToCelsi(temp);
                    break;
                case 1:
                    temp = CT.KelvinToFer(temp);
                    break;
            }
            return temp;
        }
    }
}
