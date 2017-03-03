package com.example.yihwe.a202sgicalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainArea extends Fragment {
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
    private Conversion.Area CA;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View mainarea = inflater.inflate(R.layout.activity_main_area, container, false);
        mDotB = (Button) mainarea.findViewById(R.id.bDot);
        mZeroB = (Button) mainarea.findViewById(R.id.bZero);
        mOneB = (Button) mainarea.findViewById(R.id.bOne);
        mTwoB = (Button) mainarea.findViewById(R.id.bTwo);
        mThreeB = (Button) mainarea.findViewById(R.id.bThree);
        mFourB = (Button) mainarea.findViewById(R.id.bFour);
        mFiveB = (Button) mainarea.findViewById(R.id.bFive);
        mSixB = (Button) mainarea.findViewById(R.id.bSix);
        mSevenB = (Button) mainarea.findViewById(R.id.bSeven);
        mEightB = (Button) mainarea.findViewById(R.id.bEight);
        mNineB = (Button) mainarea.findViewById(R.id.bNine);
        mEqualB = (Button) mainarea.findViewById(R.id.bEqual);
        mClearB = (Button) mainarea.findViewById(R.id.bClear);
        mTextView = (TextView)mainarea.findViewById(R.id.textView);
        mEditText = (EditText)mainarea.findViewById(R.id.editText);
        mSpinner = (Spinner)mainarea.findViewById(R.id.SOne);
        mSpinner1 = (Spinner)mainarea.findViewById(R.id.STwo);
        CA = new Conversion.Area();

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

        return mainarea;
    }

    public double conversion (int item, int item1, double value){
        double temp = 0.0;
        if(item == item1){
            return value;
        }
        else{
            switch (item){
                case 0:
                    temp = CA.sqMilliToMeter(value);
                    break;
                case 1:
                    temp = CA.sqCentiToMeter(value);
                    break;
                case 2:
                    temp = value;
                    break;
                case 3:
                    temp = CA.sqKiloToMeter(value);
                    break;
                case 4:
                    temp = CA.AcreToMeter(value);
                    break;
                case 5:
                    temp = CA.HectareToMeter(value);
                    break;
            }

            switch (item1){
                case 0:
                    temp = CA.sqMeterToMilli(temp);
                    break;
                case 1:
                    temp = CA.sqMeterToCenti(temp);
                    break;
                case 3:
                    temp = CA.sqMeterToKilo(temp);
                    break;
                case 4:
                    temp = CA.sqMeterToAcre(temp);
                    break;
                case 5:
                    temp = CA.sqMeterToHectare(temp);
                    break;
            }
            return temp;
        }
    }
}
