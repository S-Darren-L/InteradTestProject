package com.darren.liu.interadtestproject;

import java.util.ArrayList;

import beans.DragListAdapter;

import models.LoyaltyCardsModel;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class LoyaltyCardsActivity extends Activity {

	private ListView lvLoyaltyCardsItem;
	private ArrayList<Object> loyaltyCardsList = new ArrayList<Object>();
	private DragListAdapter loyaltyCardsAdapter;
	private Activity mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards_list);
		mContext = this;
		
		LoyaltyCardsModel loyaltyCardsModel1 = new LoyaltyCardsModel();
		loyaltyCardsModel1.setCardName("GoodLife Fitness");
		loyaltyCardsModel1.setHolderName("Alex Jones");
		loyaltyCardsModel1.setCardNumber("7515574242");
		loyaltyCardsList.add(loyaltyCardsModel1);
		
		LoyaltyCardsModel loyaltyCardsModel2 = new LoyaltyCardsModel();
		loyaltyCardsModel2.setCardName("Air Miles");
		loyaltyCardsModel2.setHolderName("Peter Paul");
		loyaltyCardsModel2.setCardNumber("6329228432");
		loyaltyCardsList.add(loyaltyCardsModel2);
		
		LoyaltyCardsModel loyaltyCardsModel3 = new LoyaltyCardsModel();
		loyaltyCardsModel3.setCardName("Shoppers");
		loyaltyCardsModel3.setHolderName("David Lee");
		loyaltyCardsModel3.setCardNumber("3259876358");
		loyaltyCardsList.add(loyaltyCardsModel3);
		
		LoyaltyCardsModel loyaltyCardsModel4 = new LoyaltyCardsModel();
		loyaltyCardsModel4.setCardName("Petro");
		loyaltyCardsModel4.setHolderName("Anni Miler");
		loyaltyCardsModel4.setCardNumber("214886258365");
		loyaltyCardsList.add(loyaltyCardsModel4);
		
		LoyaltyCardsModel loyaltyCardsModel5 = new LoyaltyCardsModel();
		loyaltyCardsModel5.setCardName("Canadian Tire");
		loyaltyCardsModel5.setHolderName("Sarah Smith");
		loyaltyCardsModel5.setCardNumber("1579231823");
		loyaltyCardsList.add(loyaltyCardsModel5);
		
		lvLoyaltyCardsItem = (ListView) findViewById(R.id.list);
		loyaltyCardsAdapter = new DragListAdapter(this, loyaltyCardsList);		
		lvLoyaltyCardsItem.setAdapter(loyaltyCardsAdapter);		
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
