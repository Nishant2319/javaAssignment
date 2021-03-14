package com.blackpool.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    EditText e1;
    EditText e2;
    TextView e3;
    TextView operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.firstN);
        e2=(EditText)findViewById(R.id.secondN);
        e3=(TextView)findViewById(R.id.resutlText);
        operator=(TextView)findViewById(R.id.operatText);
    }


    public void click(android.view.View view){
        String text=(String) ((Button)findViewById(view.getId())).getText();
        int i;

        try{
            i=Integer.valueOf(text);
            String text1=e1.getText().toString();
            int len1=text1.length();
            if(len1<4){
                if(text1.equals("0"))
                    text1="";
                e1.setText(text1+i);
                return;
            }

            String text2=e2.getText().toString();
            int len2=text2.length();
            if(len2<4){
                if(text2.equals("0"))
                    text2="";
                e2.setText(text2+i);
            }

        }
        catch(Exception ex){
            String btnText=((Button)findViewById(view.getId())).getText().toString();
            if(btnText.equals("C")){
                e1.setText("0");
                e2.setText("0");
                e3.setText("0");
                operator.setText("");
            }
            else if(btnText.equals("Ce")){
                String text2=e2.getText().toString();
                int len2=text2.length();
                if(!text2.equals("0")){
                    if(len2==1)
                        e2.setText("0");
                   else
                        e2.setText(text2.subSequence(0,len2-1));
                   return;
                }
                String text1=e1.getText().toString();
                int len1=text1.length();
                if(!text1.equals("0")){
                    if(len1==1)
                        e1.setText("0");
                    else
                        e1.setText(text1.subSequence(0,len1-1));
                }
            }
            else if(btnText.equals("=")){
                int first,second;
                String oper=operator.getText().toString();
                switch (oper){
                    case "%":
                        first=Integer.valueOf(e1.getText().toString());
                        second=Integer.valueOf(e2.getText().toString());
                        e3.setText(first%second+"");
                        break;
                    case "/":
                        first=Integer.valueOf(e1.getText().toString());
                        second=Integer.valueOf(e2.getText().toString());
                        e3.setText(first/second+"");
                        break;
                    case "x":
                        first=Integer.valueOf(e1.getText().toString());
                        second=Integer.valueOf(e2.getText().toString());
                        e3.setText(first*second+"");
                        break;
                    case "-":
                        first=Integer.valueOf(e1.getText().toString());
                        second=Integer.valueOf(e2.getText().toString());
                        e3.setText(first-second+"");
                        break;
                    case "+":
                        first=Integer.valueOf(e1.getText().toString());
                        second=Integer.valueOf(e2.getText().toString());
                        e3.setText(first+second+"");
                        break;

                }
            }
            else{
                operator.setText(btnText);
            }

        }

    }
}