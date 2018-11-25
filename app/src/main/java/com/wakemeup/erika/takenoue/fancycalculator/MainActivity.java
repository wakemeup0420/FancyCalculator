package com.wakemeup.erika.takenoue.fancycalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private Button mButton1, mButton2, mButton3, mButton4, mButton5, mButton6, mButton7, mButton8, mButton9, mButton0, mButton00;
    private Button mClear, mPercent, mDivision, mMultiply, mMinus, mPlus, mEqual, mDecimalPoint;
    private ImageView mNoDesign, mDesign1, mDesign2, mDesign3, mDesign4, mDesign5, mDesign6, mDesign7, mDesign8, mDesign9, mDesign10, mDesign11;
    private TextView mTextView, mTextView2, mTextView3, mSetting, mLink;
    private ImageView mDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //電卓のボタン
        mButton1 = findViewById(R.id.button1);
        mButton2 = findViewById(R.id.button2);
        mButton3 = findViewById(R.id.button3);
        mButton4 = findViewById(R.id.button4);
        mButton5 = findViewById(R.id.button5);
        mButton6 = findViewById(R.id.button6);
        mButton7 = findViewById(R.id.button7);
        mButton8 = findViewById(R.id.button8);
        mButton9 = findViewById(R.id.button9);
        mButton0 = findViewById(R.id.button0);
        mButton00 = findViewById(R.id.button00);
        mClear = findViewById(R.id.clear);
        mPercent = findViewById(R.id.percent);
        mDivision = findViewById(R.id.division);
        mMultiply = findViewById(R.id.multiply);
        mMinus = findViewById(R.id.minus);
        mPlus = findViewById(R.id.plus);
        mEqual = findViewById(R.id.equal);
        mDecimalPoint = findViewById(R.id.decimal_point);

        //表示画面
        mTextView = findViewById(R.id.textview);
        mTextView2 = findViewById(R.id.textview2);
        mTextView3 = findViewById(R.id.textview3);

        //設定ボタン
        mSetting = findViewById(R.id.setting);

        //フォント
        mButton1.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton2.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton3.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton4.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton5.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton6.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton7.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton8.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton9.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton0.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mButton00.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mClear.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mPercent.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mDivision.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mMultiply.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mMinus.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mPlus.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mEqual.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mDecimalPoint.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));
        mSetting.setTypeface(Typeface.createFromAsset(getAssets(),
                "MarshMallowPopHeartTTFLight-Regular.ttf"));

        mButton1.setOnClickListener(NumberListener);
        mButton2.setOnClickListener(NumberListener);
        mButton3.setOnClickListener(NumberListener);
        mButton4.setOnClickListener(NumberListener);
        mButton5.setOnClickListener(NumberListener);
        mButton6.setOnClickListener(NumberListener);
        mButton7.setOnClickListener(NumberListener);
        mButton8.setOnClickListener(NumberListener);
        mButton9.setOnClickListener(NumberListener);
        mButton0.setOnClickListener(NumberListener);
        mButton00.setOnClickListener(NumberListener);
        mDecimalPoint.setOnClickListener(DecimalListener);

        mPercent.setOnClickListener(PercentListener);
        mDivision.setOnClickListener(OperatorListener);
        mMultiply.setOnClickListener(OperatorListener);
        mMinus.setOnClickListener(OperatorListener);
        mPlus.setOnClickListener(OperatorListener);
        mEqual.setOnClickListener(OperatorListener);

        mClear.setOnClickListener(ClearListener);

        mSetting.setOnClickListener(SettingListener);

        //デザインの値を取得
        SharedPreferences sp = getSharedPreferences("hoge", MODE_PRIVATE);
        Design = sp.getInt("Design", Design);

        //ImageViewにセット
        mDisplay = findViewById(R.id.imageView);
        mDisplay.setImageResource(Design);
    }

    boolean OperatorKeyPushed; //計算ボタンタップ
    double answer; //答え
    int recent = R.id.equal; //最近押したボタン
    int number = R.id.setting; //押した数字キー
    int operate = R.id.setting; //押した計算ボタン
    int percent = R.id.setting; //％計算分岐
    boolean decimal = true; //「.」を正常に表示する
    boolean NumberPushed; //数字キータップ
    boolean Number;
    boolean Percent;

    //clearボタンタップ処理
    View.OnClickListener ClearListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            recent = R.id.equal;
            answer = 0;
            decimal = true;
            OperatorKeyPushed = false;
            mTextView.setText("");
            mTextView2.setText("");
            mTextView3.setText("");
            number = R.id.setting;
            operate = R.id.setting;
            NumberPushed = false;
            Number = false;
        }
    };

    //数字キータップ処理
    View.OnClickListener NumberListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            number = button.getId();
            if (OperatorKeyPushed == false) {
                mTextView.setText(button.getText());
                mTextView2.append(mTextView3.getText());
                decimal = true;
            } else {
                if (number == R.id.button0 && decimal == false || number == R.id.button00 && decimal == false) {
                    mTextView.append(button.getText());
                } else {
                    String price = mTextView.getText().toString().replaceAll(",", "");
                    String price2 = (String) button.getText();
                    String price3 = price + price2;
                    double price4 = Double.parseDouble(String.valueOf(price3));
                    DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###.##########");
                    String price5 = decimalFormat.format(price4);
                    if (price5.length() > 11) {
                    } else {
                        mTextView.setText(price5);
                    }
                }
            }
            NumberPushed = true;
            Number = true;
            OperatorKeyPushed = true;
            percent = button.getId();
            Percent = true;
        }
    };

    //「.」タップ処理
    View.OnClickListener DecimalListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            Percent = true;
                if (Number == false) {
                    OperatorKeyPushed = false;
                    number = button.getId();
                    NumberPushed = false;
                    Number = false;
                    percent = button.getId();
                } else {
                    if (decimal == true) {
                        String price = mTextView.getText().toString();
                        String price2 = (String) button.getText();
                        String price3 = price + price2;
                        mTextView.setText(price3);

                        OperatorKeyPushed = true;
                        number = button.getId();
                        decimal = false;
                        NumberPushed = true;
                        percent = button.getId();
                }
            }
        }
    };

    //計算記号タップ処理
    View.OnClickListener OperatorListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (NumberPushed == true) {
                if (number == R.id.button0 || number == R.id.button00 || number == R.id.button1 || number == R.id.button2 || number == R.id.button3 || number == R.id.button4 || number == R.id.button5 || number == R.id.button6 || number == R.id.button7 || number == R.id.button8 || number == R.id.button9) {
                    Button operatorButton = (Button) view;
                    double value = Double.parseDouble(mTextView.getText().toString().replaceAll(",", ""));
                    if (Percent == true) {
                        mTextView2.append(mTextView.getText());
                    }
                    if (recent == R.id.equal) {
                        answer = value;
                    } else {
                        answer = calc(recent, answer, value);
                        DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###.##########");
                        String price = decimalFormat.format(answer);
                        mTextView.setText(price);
                    }
                    operate = operatorButton.getId();
                    recent = operatorButton.getId();
                    number = R.id.setting;
                    Number = false;
                    mTextView3.setText(operatorButton.getText());
                    OperatorKeyPushed = false;
                } else {
                    Button operatorButton = (Button) view;
                    double value = Double.parseDouble(mTextView.getText().toString().replaceAll(",", ""));
                    answer = value;
                    DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###.##########");
                    String price = decimalFormat.format(answer);
                    mTextView.setText(String.valueOf(price));

                    operate = operatorButton.getId();
                    recent = operatorButton.getId();
                    number = R.id.setting;
                    Number = false;
                    mTextView3.setText(operatorButton.getText());
                    OperatorKeyPushed = false;
                }
            } else {
                mTextView.setText("");
            }
            Percent = true;
        }
    };

    //計算処理
    double calc(int recent, double value1, double value2) {
        if (recent == R.id.plus) {
            BigDecimal X = new BigDecimal(Double.toString(value1));
            BigDecimal Y = new BigDecimal(Double.toString(value2));
            BigDecimal result = X.add(Y);
            return Double.parseDouble(result.toString());
        } else if (recent == R.id.minus) {
            BigDecimal X = new BigDecimal(Double.toString(value1));
            BigDecimal Y = new BigDecimal(Double.toString(value2));
            BigDecimal result = X.subtract(Y);
            return Double.parseDouble(result.toString());
        } else if (recent == R.id.multiply) {
            BigDecimal X = new BigDecimal(Double.toString(value1));
            BigDecimal Y = new BigDecimal(Double.toString(value2));
            BigDecimal result = X.multiply(Y).setScale(3, BigDecimal.ROUND_HALF_UP);
            return Double.parseDouble(result.toString());
        } else if (recent == R.id.division) {
            if (value2 != 0) {
                BigDecimal X = new BigDecimal(Double.toString(value1));
                BigDecimal Y = new BigDecimal(Double.toString(value2));
                BigDecimal result = X.divide(Y, 3, BigDecimal.ROUND_HALF_UP);
                return Double.parseDouble(result.toString());
            } else {
                return 0;
            }
        } else {
            return value1;
        }
    }

    //「％」タップ処理
    View.OnClickListener PercentListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (percent == R.id.button0 || percent == R.id.button00 || percent == R.id.button1 || percent == R.id.button2 || percent == R.id.button3 || percent == R.id.button4 || percent == R.id.button5 || percent == R.id.button6 || percent == R.id.button7 || percent == R.id.button8 || percent == R.id.button9) {
                Button percentButton = (Button) view;
                double value = Double.parseDouble(mTextView.getText().toString().replaceAll(",", ""));
                if (Number == true) {
                    mTextView2.append(mTextView.getText());
                }
                if (operate == R.id.plus || operate == R.id.minus || operate == R.id.multiply || operate == R.id.division) {
                    answer = calc(recent, answer, value);
                    answer *= 0.01;
                    DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###.##########");
                    String price = decimalFormat.format(answer);
                    mTextView.setText(String.valueOf(price));
                    operate = percentButton.getId();
                    OperatorKeyPushed = false;
                } else {
                    answer = value * 0.01;
                    DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###.##########");
                    String price = decimalFormat.format(answer);
                    mTextView.setText(String.valueOf(price));
                    operate = percentButton.getId();
                    OperatorKeyPushed = false;
                }
                if (Number == false) {
                    answer = value * 0.01;
                    DecimalFormat decimalFormat = new DecimalFormat("#,###,###,###.##########");
                    String price = decimalFormat.format(answer);
                    mTextView.setText(String.valueOf(price));
                    operate = percentButton.getId();
                    OperatorKeyPushed = false;
                }
                mTextView2.append("%");
                recent = R.id.equal;
                Number = false;
                Percent = false;
            }
        }
    };

    //optionボタンタップ処理
    View.OnClickListener SettingListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
            final View dialog_view = inflater.inflate(R.layout.alert_layout, null);

            mLink = dialog_view.findViewById(R.id.link);
            SpannableString spannableString = new SpannableString(mLink.getText());
            spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
            mLink.setText(spannableString);
            mLink.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:xxx.karte@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "xxCuLCxx:ご意見・お問い合わせ");
                    intent.putExtra(Intent.EXTRA_TEXT, "");
                    startActivity(Intent.createChooser(intent, "MAiL SeLeCT"));
                }
            });

            mNoDesign = dialog_view.findViewById(R.id.no_design);
            mDesign1 = dialog_view.findViewById(R.id.design1);
            mDesign2 = dialog_view.findViewById(R.id.design2);
            mDesign3 = dialog_view.findViewById(R.id.design3);
            mDesign4 = dialog_view.findViewById(R.id.design4);
            mDesign5 = dialog_view.findViewById(R.id.design5);
            mDesign6 = dialog_view.findViewById(R.id.design6);
            mDesign7 = dialog_view.findViewById(R.id.design7);
            mDesign8 = dialog_view.findViewById(R.id.design8);
            mDesign9 = dialog_view.findViewById(R.id.design9);
            mDesign10 = dialog_view.findViewById(R.id.design10);
            mDesign11 = dialog_view.findViewById(R.id.design11);

            SharedPreferences sp = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickNoDesign = sp.getInt("ClickNoDesign", ClickNoDesign);
            SharedPreferences sp1 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign1 = sp1.getInt("ClickDesign1" , ClickDesign1);
            SharedPreferences sp2 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign2 = sp2.getInt("ClickDesign2" , ClickDesign2);
            SharedPreferences sp3 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign3 = sp3.getInt("ClickDesign3" , ClickDesign3);
            SharedPreferences sp4 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign4 = sp4.getInt("ClickDesign4" , ClickDesign4);
            SharedPreferences sp5 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign5 = sp5.getInt("ClickDesign5" , ClickDesign5);
            SharedPreferences sp6 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign6 = sp6.getInt("ClickDesign6" , ClickDesign6);
            SharedPreferences sp7 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign7 = sp7.getInt("ClickDesign7" , ClickDesign7);
            SharedPreferences sp8 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign8 = sp8.getInt("ClickDesign8" , ClickDesign8);
            SharedPreferences sp9 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign9 = sp9.getInt("ClickDesign9" , ClickDesign9);
            SharedPreferences sp10 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign10 = sp10.getInt("ClickDesign10" , ClickDesign10);
            SharedPreferences sp11 = getSharedPreferences("hoge", MODE_PRIVATE);
            ClickDesign11 = sp11.getInt("ClickDesign11" , ClickDesign11);

            mNoDesign.setImageResource(ClickNoDesign);
            mDesign1.setImageResource(ClickDesign1);
            mDesign2.setImageResource(ClickDesign2);
            mDesign3.setImageResource(ClickDesign3);
            mDesign4.setImageResource(ClickDesign4);
            mDesign5.setImageResource(ClickDesign5);
            mDesign6.setImageResource(ClickDesign6);
            mDesign7.setImageResource(ClickDesign7);
            mDesign8.setImageResource(ClickDesign8);
            mDesign9.setImageResource(ClickDesign9);
            mDesign10.setImageResource(ClickDesign10);
            mDesign11.setImageResource(ClickDesign11);

            mNoDesign.setOnClickListener(DesignListener);
            mDesign1.setOnClickListener(DesignListener);
            mDesign2.setOnClickListener(DesignListener);
            mDesign3.setOnClickListener(DesignListener);
            mDesign4.setOnClickListener(DesignListener);
            mDesign5.setOnClickListener(DesignListener);
            mDesign6.setOnClickListener(DesignListener);
            mDesign7.setOnClickListener(DesignListener);
            mDesign8.setOnClickListener(DesignListener);
            mDesign9.setOnClickListener(DesignListener);
            mDesign10.setOnClickListener(DesignListener);
            mDesign11.setOnClickListener(DesignListener);

           new AlertDialog.Builder(MainActivity.this)
           .setView(dialog_view)
                    .setTitle("✡Design✡")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            SharedPreferences sp = getSharedPreferences("hoge", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();
                            editor.putInt("Design", Design);
                            editor.commit();
                            mDisplay.setImageResource(Design);
                        }
                    })
                    .setNegativeButton("Close", null)
                    .show();
        }
    };

    int ClickNoDesign = R.drawable.no_design;
    int ClickDesign1 = R.drawable.design1;
    int ClickDesign2 = R.drawable.design2;
    int ClickDesign3 = R.drawable.design3;
    int ClickDesign4 = R.drawable.design4;
    int ClickDesign5 = R.drawable.design5;
    int ClickDesign6 = R.drawable.design6;
    int ClickDesign7 = R.drawable.design7;
    int ClickDesign8 = R.drawable.design8;
    int ClickDesign9 = R.drawable.design9;
    int ClickDesign10 = R.drawable.design10;
    int ClickDesign11 = R.drawable.design11;

    int design = R.id.setting; //押されたデザインボタン
    int Design = R.drawable.night; //画面に表示するデザイン

    //デザイン選択画面処理
    View.OnClickListener DesignListener = new View.OnClickListener() {
        public void onClick(View view) {
            ImageView imageView = (ImageView) view;
            design = imageView.getId();
            if (design == R.id.no_design) {
                Design = 0;
                ClickNoDesign = R.drawable.no_design_click;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design1) {
                Design = R.drawable.moreheart_illumination;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1_click;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design2) {
                Design = R.drawable.cosmo;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2_click;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design3) {
                Design = R.drawable.heart_purple;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3_click;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design4) {
                Design = R.drawable.cosmo2;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4_click;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design5) {
                Design = R.drawable.heart_purple2;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5_click;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design6) {
                Design = R.drawable.constellation;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6_click;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design7) {
                Design = R.drawable.night;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7_click;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design8) {
                Design = R.drawable.light;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8_click;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design9) {
                Design = R.drawable.pure;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9_click;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design10) {
                Design = R.drawable.design_heart;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10_click;
                ClickDesign11 = R.drawable.design11;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            } else if (design == R.id.design11) {
                Design = R.drawable.design_heart2;
                ClickNoDesign = R.drawable.no_design;
                ClickDesign1 = R.drawable.design1;
                ClickDesign2 = R.drawable.design2;
                ClickDesign3 = R.drawable.design3;
                ClickDesign4 = R.drawable.design4;
                ClickDesign5 = R.drawable.design5;
                ClickDesign6 = R.drawable.design6;
                ClickDesign7 = R.drawable.design7;
                ClickDesign8 = R.drawable.design8;
                ClickDesign9 = R.drawable.design9;
                ClickDesign10 = R.drawable.design10;
                ClickDesign11 = R.drawable.design11_click;
                ClickDesign(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
                Shared(ClickNoDesign,ClickDesign1,ClickDesign2,ClickDesign3,ClickDesign4,ClickDesign5,ClickDesign6,ClickDesign7,ClickDesign8,ClickDesign9,ClickDesign10,ClickDesign11);
            }
        }
    };

    //デザイン選択値保持
    public void Shared (int ClickNoDesign, int ClickDesign1, int ClickDesign2, int ClickDesign3, int ClickDesign4, int ClickDesign5, int ClickDesign6, int ClickDesign7, int ClickDesign8, int ClickDesign9, int ClickDesign10, int ClickDesign11) {
        SharedPreferences sp = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("ClickNoDesign", ClickNoDesign);
        editor.commit();
        SharedPreferences sp1 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sp1.edit();
        editor1.putInt("ClickDesign1", ClickDesign1);
        editor1.commit();
        SharedPreferences sp2 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor2 = sp2.edit();
        editor2.putInt("ClickDesign2", ClickDesign2);
        editor2.commit();
        SharedPreferences sp3 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor3 = sp3.edit();
        editor3.putInt("ClickDesign3", ClickDesign3);
        editor3.commit();
        SharedPreferences sp4 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor4 = sp4.edit();
        editor4.putInt("ClickDesign4", ClickDesign4);
        editor4.commit();
        SharedPreferences sp5 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor5 = sp5.edit();
        editor5.putInt("ClickDesign5", ClickDesign5);
        editor5.commit();
        SharedPreferences sp6 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor6 = sp6.edit();
        editor6.putInt("ClickDesign6", ClickDesign6);
        editor6.commit();
        SharedPreferences sp7 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor7 = sp7.edit();
        editor7.putInt("ClickDesign7", ClickDesign7);
        editor7.commit();
        SharedPreferences sp8 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor8 = sp8.edit();
        editor8.putInt("ClickDesign8", ClickDesign8);
        editor8.commit();
        SharedPreferences sp9 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor9 = sp9.edit();
        editor9.putInt("ClickDesign9", ClickDesign9);
        editor9.commit();
        SharedPreferences sp10 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor10 = sp10.edit();
        editor10.putInt("ClickDesign10", ClickDesign10);
        editor10.commit();
        SharedPreferences sp11 = getSharedPreferences("hoge", MODE_PRIVATE);
        SharedPreferences.Editor editor11 = sp11.edit();
        editor11.putInt("ClickDesign11", ClickDesign11);
        editor11.commit();
    }

    //デザイン選択
    public void ClickDesign (int ClickNoDesign, int ClickDesign1, int ClickDesign2, int ClickDesign3, int ClickDesign4, int ClickDesign5, int ClickDesign6, int ClickDesign7, int ClickDesign8, int ClickDesign9, int ClickDesign10, int ClickDesign11) {
        mNoDesign.setImageResource(ClickNoDesign);
        mDesign1.setImageResource(ClickDesign1);
        mDesign2.setImageResource(ClickDesign2);
        mDesign3.setImageResource(ClickDesign3);
        mDesign4.setImageResource(ClickDesign4);
        mDesign5.setImageResource(ClickDesign5);
        mDesign6.setImageResource(ClickDesign6);
        mDesign7.setImageResource(ClickDesign7);
        mDesign8.setImageResource(ClickDesign8);
        mDesign9.setImageResource(ClickDesign9);
        mDesign10.setImageResource(ClickDesign10);
        mDesign11.setImageResource(ClickDesign11);
    }
}