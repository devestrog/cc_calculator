package com.test.cc_calculator;

import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

public class MainActivity extends Activity
{
	Spinner sp_age, sp_engine;
	EditText et_engine;
	TextView txt_stavka, txt_nds, txt_sum;
	int pos_age, pos_engine;
	double k_age, k_engine, k_engine_type, stavka, nds, sum;
	String engine;
	Boolean tocontinue;

	public static boolean isNumeric(String strNum) {
		if (strNum == null) {
			return false;
		}
		try {
			double d = Double.parseDouble(strNum);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

		Button btn_calc = findViewById(R.id.btn_calc);
		btn_calc.setOnClickListener(cl_calc);
    }

	OnClickListener cl_calc = new OnClickListener() {

		@Override
		public void onClick(View v)
		{
			sp_age = findViewById(R.id.sp_age);
			sp_engine = findViewById(R.id.sp_engine);
			et_engine = findViewById(R.id.et_engine);
			txt_stavka = findViewById(R.id.txt_stavka);
			txt_nds = findViewById(R.id.txt_nds);
			txt_sum = findViewById(R.id.txt_sum);

			pos_age = sp_age.getSelectedItemPosition();
			switch(pos_age) {
				case 0:
					k_age = 2.2;
					break;
				case 1:
					k_age = 1.9;
					break;
				case 2:
					k_age = 1.65;
					break;
				case 3:
					k_age = 1.55;
					break;
				case 4:
					k_age = 1.45;
					break;
				case 5:
					k_age = 1.35;
					break;
				case 6:
					k_age = 1;
					break;
				case 7:
					k_age = 0.9;
					break;
				case 8:
					k_age = 0.85;
					break;
				case 9:
					k_age = 0.8;
					break;
				case 10:
					k_age = 0.75;
					break;
				case 11:
					k_age = 0.7;
					break;
			}

			engine = et_engine.getText().toString();
			if (isNumeric(engine)) {
				k_engine = Double.parseDouble(et_engine.getText().toString());
				if (k_engine > 1 && k_engine < 10000) {
					tocontinue = true;
				} else {
					tocontinue = false;
					Toast.makeText(v.getContext(), "Неверный объем двигателя", Toast.LENGTH_SHORT).show();
				}
			} else {
				tocontinue = false;
				Toast.makeText(v.getContext(), "Введите объем двигателя", Toast.LENGTH_SHORT).show();
			}

			pos_engine = sp_engine.getSelectedItemPosition();
			switch(pos_engine) {
				case 0:
					k_engine_type = 1;
					break;
				case 1:
					k_engine_type = 1.2;
					break;
				case 2:
					k_engine_type = 0.5;
					break;
				case 3:
					k_engine_type = 0;
					break;
			}

			if (tocontinue) {
				stavka = k_age * k_engine * k_engine_type;
				txt_stavka.setText(String.valueOf(stavka));

				nds = stavka * 3.5 * 0.2;
				txt_nds.setText(String.valueOf(nds));

				sum = stavka + nds;
				txt_sum.setText(String.valueOf(sum));
			}
		}


	};
}

