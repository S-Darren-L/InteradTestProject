package com.darren.liu.interadtestproject;

import java.util.ArrayList;

import models.PaymentCardsModel;

import beans.DragListAdapter;
import beans.DragListView;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class PaymentCardsActivity extends Activity {
	
	private DragListView lvPaymentCardsItem;
	private ArrayList<Object> paymentCardsList = new ArrayList<Object>();
	private DragListAdapter paymentCardsAdapter;
	private Activity mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards_list);
		mContext = this;
		
		PaymentCardsModel paymentCardsModel1 = new PaymentCardsModel();
		paymentCardsModel1.setCardType("Debit Card");
		paymentCardsModel1.setCardBalanceValue("5647.00");
		paymentCardsModel1.setCardCreditValue("");
		paymentCardsModel1.setCardNumber("498654286157");
		paymentCardsList.add(paymentCardsModel1);

		PaymentCardsModel paymentCardsModel2 = new PaymentCardsModel();
		paymentCardsModel2.setCardType("Credit Card");
		paymentCardsModel2.setCardBalanceValue("9864.50");
		paymentCardsModel2.setCardCreditValue("5000.00");
		paymentCardsModel2.setCardNumber("974135843875");
		paymentCardsList.add(paymentCardsModel2);
		
		PaymentCardsModel paymentCardsModel3 = new PaymentCardsModel();
		paymentCardsModel3.setCardType("Debit Card");
		paymentCardsModel3.setCardBalanceValue("11552.00");
		paymentCardsModel3.setCardCreditValue("");
		paymentCardsModel3.setCardNumber("789495436518");
		paymentCardsList.add(paymentCardsModel3);
		

		PaymentCardsModel paymentCardsModel4 = new PaymentCardsModel();
		paymentCardsModel4.setCardType("Credit Card");
		paymentCardsModel4.setCardBalanceValue("9875.75");
		paymentCardsModel4.setCardCreditValue("600.00");
		paymentCardsModel4.setCardNumber("981357415824");
		paymentCardsList.add(paymentCardsModel4);

		PaymentCardsModel paymentCardsModel5 = new PaymentCardsModel();
		paymentCardsModel5.setCardType("Credit Card");
		paymentCardsModel5.setCardBalanceValue("84556.00");
		paymentCardsModel5.setCardCreditValue("3000.00");
		paymentCardsModel5.setCardNumber("754364578912");
		paymentCardsList.add(paymentCardsModel5);
		
		lvPaymentCardsItem = (DragListView) findViewById(R.id.list);
		paymentCardsAdapter = new DragListAdapter(this, paymentCardsList);		
		lvPaymentCardsItem.setAdapter(paymentCardsAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.action_exit) {			
			System.exit(0);
		}
		return super.onOptionsItemSelected(item);
	}
}
