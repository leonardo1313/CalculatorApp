package com.optimahorizonapps.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display_et = findViewById(R.id.display_et);
        display_et.setShowSoftInputOnFocus(false);

        display_et.setOnClickListener(view -> {
            if(getString(R.string.display_text).equals(display_et.getText().toString())) {
                display_et.setText("");
            }
        });
    }

    private void updateDisplay(String addedString) {
        String oldStr = display_et.getText().toString();
        int cursorPosition = display_et.getSelectionStart();  //gets cursor position
        String leftStr = oldStr.substring(0, cursorPosition);
        String rightStr = oldStr.substring(cursorPosition);
        if(getString(R.string.display_text).equals(display_et.getText().toString())) {
            display_et.setText(addedString);
            display_et.setSelection(cursorPosition + 1);  //moves cursor one place to the right
        } else {
            display_et.setText(String.format("%s%s%s", leftStr, addedString, rightStr));
            display_et.setSelection(cursorPosition + 1);  //moves cursor one place to the right
        }


    }

    public void zeroBtn(View v) {
        updateDisplay("0");
    }

    public void oneBtn(View v) {
        updateDisplay("1");
    }

    public void twoBtn(View v) {
        updateDisplay("2");
    }

    public void threeBtn(View v) {
        updateDisplay("3");
    }

    public void fourBtn(View v) {
        updateDisplay("4");
    }

    public void fiveBtn(View v) {
        updateDisplay("5");
    }

    public void sixBtn(View v) {
        updateDisplay("6");
    }

    public void sevenBtn(View v) {
        updateDisplay("7");
    }

    public void eightBtn(View v) {
        updateDisplay("8");
    }

    public void nineBtn(View v) {
        updateDisplay("9");
    }

    public void plusMinusBtn(View v) {
        updateDisplay("-");
    }

    public void pointBtn(View v) {
        updateDisplay(".");
    }

    public void addBtn(View v) {
        updateDisplay("+");
    }

    public void subtractBtn(View v) {
        updateDisplay("-");
    }

    public void multiplyBtn(View v) {
        updateDisplay("×");
    }

    public void divideBtn(View v) {
        updateDisplay("÷");
    }

    public void exponentBtn(View v) {
        updateDisplay("^");
    }

    public void parenthesesBtn(View v) {
        int cursorPosition = display_et.getSelectionStart();
        int openPar = 0;
        int closedPar = 0;
        int textLength = display_et.getText().length();

        for(int i = 0; i < cursorPosition; i++) {
            if (display_et.getText().toString().substring(i, i + 1).equals("(")) {
                openPar += 1;
            }
            if (display_et.getText().toString().substring(i, i + 1).equals(")")) {
                closedPar += 1;
            }
        }

        if(openPar == closedPar || display_et.getText().toString().substring(textLength - 1, textLength).equals("(")) {
            updateDisplay("(");
        } else if(closedPar < openPar && display_et.getText().toString().substring(textLength - 1, textLength).equals("(")) {
            updateDisplay(")");
        }
        display_et.setSelection(cursorPosition + 1);
    }

    public void clearBtn(View v) {
        display_et.setText("");
    }

    public void equalsBtn(View v) {

    }

    public void backspaceBtn(View v) {
        int cursorPosition = display_et.getSelectionStart();
        int textLength = display_et.getText().length();

        if(cursorPosition != 0 && textLength != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display_et.getText();
            selection.replace(cursorPosition - 1, cursorPosition, "");
            display_et.setText(selection);
            display_et.setSelection(cursorPosition - 1);
        }
    }
}