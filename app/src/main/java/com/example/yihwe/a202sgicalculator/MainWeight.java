package com.example.yihwe.a202sgicalculator;

import android.os.Bundle;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainWeight extends Fragment {

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
    private Conversion.Weight CW;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View mainweight = inflater.inflate(R.layout.activity_main_weight, container, false);
        mDotB = (Button) mainweight.findViewById(R.id.bDot);
        mZeroB = (Button) mainweight.findViewById(R.id.bZero);
        mOneB = (Button) mainweight.findViewById(R.id.bOne);
        mTwoB = (Button) mainweight.findViewById(R.id.bTwo);
        mThreeB = (Button) mainweight.findViewById(R.id.bThree);
        mFourB = (Button) mainweight.findViewById(R.id.bFour);
        mFiveB = (Button) mainweight.findViewById(R.id.bFive);
        mSixB = (Button) mainweight.findViewById(R.id.bSix);
        mSevenB = (Button) mainweight.findViewById(R.id.bSeven);
        mEightB = (Button) mainweight.findViewById(R.id.bEight);
        mNineB = (Button) mainweight.findViewById(R.id.bNine);
        mEqualB = (Button) mainweight.findViewById(R.id.bEqual);
        mClearB = (Button) mainweight.findViewById(R.id.bClear);
        mTextView = (TextView)mainweight.findViewById(R.id.textView);
        mEditText = (EditText)mainweight.findViewById(R.id.editText);
        mSpinner = (Spinner)mainweight.findViewById(R.id.SOne);
        mSpinner1 = (Spinner)mainweight.findViewById(R.id.STwo);
        CW = new Conversion.Weight();

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

        return mainweight;
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
                    temp = CW.MilliToKilo(value);
                    break;
                case 1:
                    temp = CW.CentiToKilo(value);
                    break;
                case 2:
                    temp = CW.DeciToKilo(value);
                    break;
                case 3:
                    temp = CW.GramToKilo(value);
                    break;
                case 4:
                    temp=value;
                    break;
                case 5:
                    temp = CW.MetricTonnesToKilo(value);
                    break;
                case 6:
                    temp = CW.PoundsToKilo(value);
                    break;
                case 7:
                    temp = CW.OuncesToKilo(value);
                    break;
            }

            switch (item2)
            {
                case 0:
                    temp = CW.KiloToMilli(temp);
                    break;
                case 1:
                    temp = CW.KiloToCenti(temp);
                    break;
                case 2:
                    temp = CW.KiloToDeci(temp);
                    break;
                case 3:
                    temp = CW.KiloToGram(temp);
                    break;
                case 5:
                    temp = CW.KiloToMetricTonnes(temp);
                    break;
                case 6:
                    temp = CW.KiloToPounds(temp);
                    break;
                case 7:
                    temp = CW.KiloToOunces(temp);
                    break;
            }
            return temp;
        }
    }

}
