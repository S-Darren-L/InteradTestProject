package com.darren.liu.interadtestproject;

import java.util.ArrayList;

import beans.DragListAdapter;

import models.GiftCardsModel;

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
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;


public class GiftCardsActivity extends Activity {

	private ListView lvGiftCardsItem;
	private ArrayList<Object> giftCardsList = new ArrayList<Object>();
	private DragListAdapter giftCardsAdapter;
	private Activity mContext;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cards_list);
		mContext = this;
		
		GiftCardsModel giftCardsModel1 = new GiftCardsModel();
		giftCardsModel1.setCardName("Play Store");
		giftCardsModel1.setCardValue("50.00");
		giftCardsModel1.setCardNumber("67843289745");
		giftCardsList.add(giftCardsModel1);
		
		GiftCardsModel giftCardsModel2 = new GiftCardsModel();
		giftCardsModel2.setCardName("Sears");
		giftCardsModel2.setCardValue("100.00");
		giftCardsModel2.setCardNumber("875136953188459");
		giftCardsList.add(giftCardsModel2);
		
		GiftCardsModel giftCardsModel3 = new GiftCardsModel();
		giftCardsModel3.setCardName("Best Buy");
		giftCardsModel3.setCardValue("200.00");
		giftCardsModel3.setCardNumber("97421586283");
		giftCardsList.add(giftCardsModel3);
		
		GiftCardsModel giftCardsModel4 = new GiftCardsModel();
		giftCardsModel4.setCardName("Nike");
		giftCardsModel4.setCardValue("100.00");
		giftCardsModel4.setCardNumber("31851892869528");
		giftCardsList.add(giftCardsModel4);
		
		GiftCardsModel giftCardsModel5 = new GiftCardsModel();
		giftCardsModel5.setCardName("KFC");
		giftCardsModel5.setCardValue("150.00");
		giftCardsModel5.setCardNumber("452851369577");
		giftCardsList.add(giftCardsModel5);

		lvGiftCardsItem = (ListView) findViewById(R.id.list);
		giftCardsAdapter = new DragListAdapter(this, giftCardsList);		
		lvGiftCardsItem.setAdapter(giftCardsAdapter);
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
