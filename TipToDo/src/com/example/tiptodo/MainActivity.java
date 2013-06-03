package com.example.tiptodo;


import java.math.BigDecimal;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	Button buttonTen, buttonFifteen, buttonTwenty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        buttonTen = (Button)findViewById(R.id.ten);
        buttonFifteen = (Button)findViewById(R.id.fifteen);
        buttonTwenty = (Button)findViewById(R.id.twenty);
        
        buttonTen.setOnClickListener(new ButtonClick());
        buttonFifteen.setOnClickListener(new ButtonClick());
        buttonTwenty.setOnClickListener(new ButtonClick());
        
    }
    
    class ButtonClick implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			switch (v.getId()){
			case R.id.ten:
				setResult(computeTip(getMoney(),0.1));
				break;
			case R.id.fifteen:
				setResult(computeTip(getMoney(),0.15));
				break;
			case R.id.twenty:
				setResult(computeTip(getMoney(),0.2));
				break;
			default:
				break;
			}
			
		}
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    

    private Double getMoney(){
    	EditText moneyInput = (EditText) findViewById(R.id.moneyinput);
    	String money = moneyInput.getText().toString();
    	return Double.parseDouble(money);
    }
    
    private BigDecimal computeTip(Double money, Double percentage){
    	Double sourceTip = money*percentage;
    	BigDecimal result= new BigDecimal(sourceTip);   
    	result = result.setScale(2, BigDecimal.ROUND_HALF_UP);
    	return result;
    }
    
    private void setResult(BigDecimal money){
    	TextView resultText = (TextView)findViewById(R.id.result);
    	resultText.setText(String.valueOf(money));
    }
    
    
}
