package com.xavier.calculator.ICS3A;

import android.app.Activity;
import android.os.*;
import android.view.*;
import android.widget.*;
import android.graphics.*;
import android.util.*;
import android.view.animation.*;
import java.util.*;

import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.content.SharedPreferences;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import android.graphics.Typeface;

public class MainActivity extends Activity {
	
	private Timer _timer = new Timer();
	
	private double a = 0;
	private double b = 0;
	
	private LinearLayout linear_main;
	private LinearLayout linear2;
	private LinearLayout linear_button;
	private LinearLayout linear19;
	private LinearLayout linear18;
	private EditText edittext;
	private LinearLayout line;
	private TextView text;
	private ImageView switch_image;
	private TextView textview_num1;
	private TextView textview_operator;
	private TextView textview_num2;
	private TextView textview_equal;
	private LinearLayout linear_num;
	private LinearLayout linear11;
	private LinearLayout linear_number;
	private LinearLayout linear14;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear9;
	private Button btn_del;
	private Button btn_c;
	private Button btn_percent;
	private Button num7;
	private Button num8;
	private Button num9;
	private Button num4;
	private Button num5;
	private Button num6;
	private Button num1;
	private Button num2;
	private Button num3;
	private Button num00;
	private Button num0;
	private Button numdot;
	private Button btn_equal;
	private Button btn_divide;
	private Button btn_multiple;
	private Button btn_min;
	private Button btn_add;
	
	private Intent inten = new Intent();
	private SharedPreferences theme;
	private TimerTask tmr;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear_main = (LinearLayout) findViewById(R.id.linear_main);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear_button = (LinearLayout) findViewById(R.id.linear_button);
		linear19 = (LinearLayout) findViewById(R.id.linear19);
		linear18 = (LinearLayout) findViewById(R.id.linear18);
		edittext = (EditText) findViewById(R.id.edittext);
		line = (LinearLayout) findViewById(R.id.line);
		text = (TextView) findViewById(R.id.text);
		switch_image = (ImageView) findViewById(R.id.switch_image);
		textview_num1 = (TextView) findViewById(R.id.textview_num1);
		textview_operator = (TextView) findViewById(R.id.textview_operator);
		textview_num2 = (TextView) findViewById(R.id.textview_num2);
		textview_equal = (TextView) findViewById(R.id.textview_equal);
		linear_num = (LinearLayout) findViewById(R.id.linear_num);
		linear11 = (LinearLayout) findViewById(R.id.linear11);
		linear_number = (LinearLayout) findViewById(R.id.linear_number);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear17 = (LinearLayout) findViewById(R.id.linear17);
		linear9 = (LinearLayout) findViewById(R.id.linear9);
		btn_del = (Button) findViewById(R.id.btn_del);
		btn_c = (Button) findViewById(R.id.btn_c);
		btn_percent = (Button) findViewById(R.id.btn_percent);
		num7 = (Button) findViewById(R.id.num7);
		num8 = (Button) findViewById(R.id.num8);
		num9 = (Button) findViewById(R.id.num9);
		num4 = (Button) findViewById(R.id.num4);
		num5 = (Button) findViewById(R.id.num5);
		num6 = (Button) findViewById(R.id.num6);
		num1 = (Button) findViewById(R.id.num1);
		num2 = (Button) findViewById(R.id.num2);
		num3 = (Button) findViewById(R.id.num3);
		num00 = (Button) findViewById(R.id.num00);
		num0 = (Button) findViewById(R.id.num0);
		numdot = (Button) findViewById(R.id.numdot);
		btn_equal = (Button) findViewById(R.id.btn_equal);
		btn_divide = (Button) findViewById(R.id.btn_divide);
		btn_multiple = (Button) findViewById(R.id.btn_multiple);
		btn_min = (Button) findViewById(R.id.btn_min);
		btn_add = (Button) findViewById(R.id.btn_add);
		theme = getSharedPreferences("theme_ui", Activity.MODE_PRIVATE);
		
		edittext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		switch_image.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (theme.getString("theme", "").equals("light")) {
					theme.edit().putString("theme", "dark").commit();
					_TransitionManager(linear_main, 200);
					_ui("dark");
				}
				else {
					theme.edit().putString("theme", "light").commit();
					_TransitionManager(linear_main, 0);
					_ui("light");
				}
			}
		});
		
		btn_del.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext.getText().toString().length() > 0) {
					edittext.setText(edittext.getText().toString().substring((int)(0), (int)(edittext.getText().toString().length() - 1)));
				}
				else {
					if (edittext.getText().toString().length() == 0) {
						
					}
				}
			}
		});
		
		btn_c.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText("");
				textview_num1.setText("");
				textview_operator.setText("");
				textview_num2.setText("");
				textview_equal.setText("");
			}
		});
		
		btn_percent.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext.getText().toString().equals("")) {
					textview_num1.setText(edittext.getText().toString());
					edittext.setText("%");
					if (edittext.getText().toString().contains("%")) {
						textview_operator.setText("%");
						edittext.setText("");
					}
				}
				else {
					
				}
			}
		});
		
		num7.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("7"));
			}
		});
		
		num8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("8"));
			}
		});
		
		num9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("9"));
			}
		});
		
		num4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("4"));
			}
		});
		
		num5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("5"));
			}
		});
		
		num6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("6"));
			}
		});
		
		num1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("1"));
			}
		});
		
		num2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("2"));
			}
		});
		
		num3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("3"));
			}
		});
		
		num00.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("00"));
			}
		});
		
		num0.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				edittext.setText(edittext.getText().toString().concat("0"));
			}
		});
		
		numdot.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext.getText().toString().length() == 0) {
					edittext.setText(edittext.getText().toString().concat("0."));
				}
				else {
					if (edittext.getText().toString().length() > 0) {
						edittext.setText(edittext.getText().toString().concat("."));
					}
				}
			}
		});
		
		btn_equal.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (textview_operator.getText().toString().contains("+")) {
					textview_num2.setText(edittext.getText().toString());
					a = Double.parseDouble(textview_num1.getText().toString());
					b = Double.parseDouble(textview_num2.getText().toString());
					edittext.setText(String.valueOf(a + b));
					textview_equal.setText("= ".concat(String.valueOf(a + b)));
				}
				if (textview_operator.getText().toString().contains("-")) {
					textview_num2.setText(edittext.getText().toString());
					a = Double.parseDouble(textview_num1.getText().toString());
					b = Double.parseDouble(textview_num2.getText().toString());
					edittext.setText(String.valueOf(a - b));
					textview_equal.setText("= ".concat(String.valueOf(a - b)));
				}
				if (textview_operator.getText().toString().contains("x")) {
					textview_num2.setText(edittext.getText().toString());
					a = Double.parseDouble(textview_num1.getText().toString());
					b = Double.parseDouble(textview_num2.getText().toString());
					edittext.setText(String.valueOf(a * b));
					textview_equal.setText("= ".concat(String.valueOf(a * b)));
				}
				if (textview_operator.getText().toString().contains("/")) {
					textview_num2.setText(edittext.getText().toString());
					a = Double.parseDouble(textview_num1.getText().toString());
					b = Double.parseDouble(textview_num2.getText().toString());
					edittext.setText(String.valueOf(a / b));
					textview_equal.setText("= ".concat(String.valueOf(a / b)));
				}
				if (textview_operator.getText().toString().contains("%")) {
					textview_num2.setText(edittext.getText().toString());
					a = Double.parseDouble(textview_num1.getText().toString());
					b = Double.parseDouble(textview_num2.getText().toString());
					edittext.setText(String.valueOf(a % b));
					textview_equal.setText("= ".concat(String.valueOf(a % b)));
				}
			}
		});
		
		btn_divide.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext.getText().toString().equals("")) {
					textview_num1.setText(edittext.getText().toString());
					edittext.setText("/");
					if (edittext.getText().toString().contains("/")) {
						textview_operator.setText("/");
						edittext.setText("");
					}
				}
				else {
					
				}
			}
		});
		
		btn_multiple.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext.getText().toString().equals("")) {
					textview_num1.setText(edittext.getText().toString());
					edittext.setText("x");
					if (edittext.getText().toString().contains("x")) {
						textview_operator.setText("x");
						edittext.setText("");
					}
				}
				else {
					
				}
			}
		});
		
		btn_min.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext.getText().toString().equals("")) {
					textview_num1.setText(edittext.getText().toString());
					edittext.setText("-");
					if (edittext.getText().toString().contains("-")) {
						textview_operator.setText("-");
						edittext.setText("");
					}
				}
				else {
					
				}
			}
		});
		
		btn_add.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (!edittext.getText().toString().equals("")) {
					textview_num1.setText(edittext.getText().toString());
					edittext.setText("+");
					if (edittext.getText().toString().contains("+")) {
						textview_operator.setText("+");
						edittext.setText("");
					}
				}
				else {
					
				}
			}
		});
	}
	private void initializeLogic() {
		_startData();
		_ui(theme.getString("theme", ""));
		final AlphaAnimation fadeIn = new AlphaAnimation(1.0f,0.0f);
		final AlphaAnimation fadeOut = new AlphaAnimation(0.0f,1.0f);
		
		text.startAnimation(fadeIn);
		text.startAnimation(fadeOut);
		fadeIn.setDuration(2000);
		fadeIn.setFillAfter(true);
		fadeOut.setDuration(2000);
		fadeOut.setFillAfter(true);
		fadeOut.setStartOffset(10+fadeIn.getStartOffset());
		edittext.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		btn_c.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		btn_del.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		btn_percent.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		btn_add.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		btn_min.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		btn_multiple.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		btn_divide.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		btn_equal.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		textview_num1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		textview_operator.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		textview_num2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num00.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		num0.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		numdot.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 0);
		text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/calculator.ttf"), 1);
		linear_main.setTranslationZ((int)5);
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	private void _setBackground (final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#9e9e9e")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	private void _circleRipple (final String _color, final View _v) {
		android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , null, null);
		_v.setBackground(ripdrb);
	}
	
	
	private void _SetStatusBarColor (final String _color) {
		Window w = this.getWindow();w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor(_color));
	}
	
	
	private void _startData () {
		if (theme.getString("theme", "").equals("")) {
			theme.edit().putString("theme", "light").commit();
		}
	}
	
	
	private void _ui (final String _theme) {
		if (true) {
			_circleRipple("#40000000", btn_add);
			_circleRipple("#40000000", btn_min);
			_circleRipple("#40000000", btn_multiple);
			_setBackground(line, 50, 10, "#f44336", false);
			_circleRipple("#40000000", btn_divide);
			_circleRipple("#40000000", switch_image);
		}
		if (_theme.equals("light")) {
			tmr = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							_TransitionManager(linear_main, 200);
							if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR); }
							getWindow().setStatusBarColor(Color.parseColor("#ffffff"));
							getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));
							_setBackground(linear_main, 0, 0, "#FFFFFF", false);
							_setBackground(btn_equal, 50, 10, "#f44336", true);
							switch_image.setImageResource(R.drawable.sun_grey);
							text.setTextColor(0xFF000000);
							btn_add.setTextColor(0xFFFFFFFF);
							btn_min.setTextColor(0xFFFFFFFF);
							btn_multiple.setTextColor(0xFFFFFFFF);
							btn_divide.setTextColor(0xFFFFFFFF);
							btn_equal.setTextColor(0xFFFFFFFF);
							btn_c.setTextColor(0xFF1DE9B6);
							btn_del.setTextColor(0xFFF44336);
							btn_percent.setTextColor(0xFF616161);
							num7.setTextColor(0xFF616161);
							num8.setTextColor(0xFF616161);
							num9.setTextColor(0xFF616161);
							num4.setTextColor(0xFF616161);
							num5.setTextColor(0xFF616161);
							num6.setTextColor(0xFF616161);
							num1.setTextColor(0xFF616161);
							num2.setTextColor(0xFF616161);
							num3.setTextColor(0xFF616161);
							num00.setTextColor(0xFF616161);
							num0.setTextColor(0xFF616161);
							numdot.setTextColor(0xFF616161);
							_setBackground(linear11, 100, 16, "#f44336", false);
							_setBackground(btn_c, 20, 16, "#FFFFFF", true);
							_setBackground(btn_del, 20, 16, "#FFFFFF", true);
							_setBackground(btn_percent, 20, 16, "#FFFFFF", true);
							_setBackground(num7, 20, 16, "#FFFFFF", true);
							_setBackground(num8, 20, 16, "#FFFFFF", true);
							_setBackground(num9, 20, 16, "#FFFFFF", true);
							_setBackground(num4, 20, 16, "#FFFFFF", true);
							_setBackground(num5, 20, 16, "#FFFFFF", true);
							_setBackground(num6, 20, 16, "#FFFFFF", true);
							_setBackground(num1, 20, 16, "#FFFFFF", true);
							_setBackground(num2, 20, 16, "#FFFFFF", true);
							_setBackground(num3, 20, 16, "#FFFFFF", true);
							_setBackground(num00, 20, 16, "#FFFFFF", true);
							_setBackground(num0, 20, 16, "#FFFFFF", true);
							_setBackground(numdot, 20, 16, "#FFFFFF", true);
							edittext.setTextColor(0xFF000000);
							textview_num1.setTextColor(0xFF757575);
							textview_operator.setTextColor(0xFF757575);
							textview_num2.setTextColor(0xFF757575);
							textview_equal.setTextColor(0xFF757575);
						}
					});
				}
			};
			_timer.schedule(tmr, (int)(200));
		}
		else {
			if (_theme.equals("dark")) {
				tmr = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								_TransitionManager(linear_main, 200);
								View decor = getWindow().getDecorView();
								decor.setSystemUiVisibility(0);
								getWindow().setStatusBarColor(Color.parseColor("#171717"));
								getWindow().setNavigationBarColor(Color.parseColor("#171717"));
								_setBackground(linear_main, 0, 0, "#171717", false);
								_setBackground(btn_equal, 50, 10, "#f44336", true);
								switch_image.setImageResource(R.drawable.sun_white);
								text.setTextColor(0xFFFFFFFF);
								btn_add.setTextColor(0xFF171717);
								btn_min.setTextColor(0xFF171717);
								btn_multiple.setTextColor(0xFF171717);
								btn_divide.setTextColor(0xFF171717);
								btn_equal.setTextColor(0xFF171717);
								btn_c.setTextColor(0xFF1DE9B6);
								btn_del.setTextColor(0xFFF44336);
								btn_percent.setTextColor(0xFFEEEEEE);
								num7.setTextColor(0xFFEEEEEE);
								num8.setTextColor(0xFFEEEEEE);
								num9.setTextColor(0xFFEEEEEE);
								num4.setTextColor(0xFFEEEEEE);
								num5.setTextColor(0xFFEEEEEE);
								num6.setTextColor(0xFFEEEEEE);
								num1.setTextColor(0xFFEEEEEE);
								num2.setTextColor(0xFFEEEEEE);
								num3.setTextColor(0xFFEEEEEE);
								num00.setTextColor(0xFFEEEEEE);
								num0.setTextColor(0xFFEEEEEE);
								numdot.setTextColor(0xFFEEEEEE);
								_setBackground(linear11, 100, 16, "#f44336", false);
								_setBackground(btn_c, 20, 16, "#252525", true);
								_setBackground(btn_del, 20, 16, "#252525", true);
								_setBackground(btn_percent, 20, 16, "#252525", true);
								_setBackground(num7, 20, 16, "#252525", true);
								_setBackground(num8, 20, 16, "#252525", true);
								_setBackground(num9, 20, 16, "#252525", true);
								_setBackground(num4, 20, 16, "#252525", true);
								_setBackground(num5, 20, 16, "#252525", true);
								_setBackground(num6, 20, 16, "#252525", true);
								_setBackground(num1, 20, 16, "#252525", true);
								_setBackground(num2, 20, 16, "#252525", true);
								_setBackground(num3, 20, 16, "#252525", true);
								_setBackground(num00, 20, 16, "#252525", true);
								_setBackground(num0, 20, 16, "#252525", true);
								_setBackground(numdot, 20, 16, "#252525", true);
								edittext.setTextColor(0xFFFFFFFF);
								textview_num1.setTextColor(0xFFBDBDBD);
								textview_operator.setTextColor(0xFFBDBDBD);
								textview_num2.setTextColor(0xFFBDBDBD);
								textview_equal.setTextColor(0xFFBDBDBD);
							}
						});
					}
				};
				_timer.schedule(tmr, (int)(200));
			}
			else {
				
			}
		}
	}
	
	
	private void _TransitionManager (final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
