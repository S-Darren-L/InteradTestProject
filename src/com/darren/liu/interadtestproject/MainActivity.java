package com.darren.liu.interadtestproject;


import java.util.ArrayList;

import beans.NavDrawerListAdapter;

import models.NavDrawerItemModel;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity  {
	
	private final String TAB_PAYMENT_CARDS = "Payment Cards";
	private final String TAB_GIFT_CARDS = "Gift Cards";
	private final String TAB_LOYALTY_CARDS = "Loyalty Cards";
		
	//slider menu
	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// nav drawer title
	private CharSequence mDrawerTitle;

	// used to store app title
	private CharSequence mTitle;

	// slide menu items
	private String[] navMenuTitles;

	private ArrayList<NavDrawerItemModel> navDrawerItems;
	private NavDrawerListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		TabHost tabHost = (TabHost)findViewById(android.R.id.tabhost);

        TabSpec paymentCardsTab = tabHost.newTabSpec(TAB_PAYMENT_CARDS);
        TabSpec giftCardsTab = tabHost.newTabSpec(TAB_GIFT_CARDS);
        TabSpec loyaltyCardsTab = tabHost.newTabSpec(TAB_LOYALTY_CARDS);

       // Set the Tab name and Activity
       // that will be opened when particular Tab will be selected
        paymentCardsTab.setIndicator(TAB_PAYMENT_CARDS);
        paymentCardsTab.setContent(new Intent(this,PaymentCardsActivity.class));
        
        giftCardsTab.setIndicator(TAB_GIFT_CARDS);
        giftCardsTab.setContent(new Intent(this,GiftCardsActivity.class));

        loyaltyCardsTab.setIndicator(TAB_LOYALTY_CARDS);
        loyaltyCardsTab.setContent(new Intent(this,LoyaltyCardsActivity.class));
        
        /** Add the tabs  to the TabHost to display. */
        tabHost.addTab(paymentCardsTab);
        tabHost.addTab(giftCardsTab);
        tabHost.addTab(loyaltyCardsTab);
        TextView tvPaymentCardsTab = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        tvPaymentCardsTab.setTextSize(10);
        tvPaymentCardsTab.setTextColor(Color.parseColor("#f5f5f5"));
        TextView tvGiftCardsTab = (TextView) tabHost.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        tvGiftCardsTab.setTextSize(10);
        tvGiftCardsTab.setTextColor(Color.parseColor("#f5f5f5"));
        TextView tvLoyaltyCardsTab = (TextView) tabHost.getTabWidget().getChildAt(2).findViewById(android.R.id.title);
        tvLoyaltyCardsTab.setTextSize(10);
        tvLoyaltyCardsTab.setTextColor(Color.parseColor("#f5f5f5"));
        
        //set slide menu
        mTitle = mDrawerTitle = getTitle();

		// load slide menu items
		navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.list_slidermenu);

		navDrawerItems = new ArrayList<NavDrawerItemModel>();

		// adding nav drawer items to array
		// Home
		navDrawerItems.add(new NavDrawerItemModel(navMenuTitles[0]));
		// Find People
		navDrawerItems.add(new NavDrawerItemModel(navMenuTitles[1]));
		// Photos
		navDrawerItems.add(new NavDrawerItemModel(navMenuTitles[2]));
		// Communities, Will add a counter here
		navDrawerItems.add(new NavDrawerItemModel(navMenuTitles[3]));
		mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

		// setting the nav drawer list adapter
		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);

		// enabling action bar app icon and behaving it as toggle button
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, //nav menu toggle icon
				R.string.app_name, // nav drawer open - description for accessibility
				R.string.app_name // nav drawer close - description for accessibility
		) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				// calling onPrepareOptionsMenu() to show action bar icons
				invalidateOptionsMenu();
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				// calling onPrepareOptionsMenu() to hide action bar icons
				invalidateOptionsMenu();
			}
		};
		mDrawerLayout.setDrawerListener(mDrawerToggle);

		if (savedInstanceState == null) {
			// on first time display view for first nav item
			displayView(0);
		}
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
			Intent intent = new Intent(getApplicationContext(),SettingActivity.class);
			startActivity(intent);
			return true;
		}
		if (id == R.id.action_exit) {			
			System.exit(0);
		}
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
			return true;
	}
	/**
	 * Slide menu item click listener
	 * */
	private class SlideMenuClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			// display view for selected nav drawer item
			displayView(position);
			Intent intent;
			switch (position) {
			case 0:
				intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				break;
			case 1:
				intent = new Intent(getApplicationContext(),HelpActivity.class);
				startActivity(intent);
				break;
			case 2:
				intent = new Intent(getApplicationContext(),MyBankActivity.class);
				startActivity(intent);
				break;
			case 3:
				intent = new Intent(getApplicationContext(),SettingActivity.class);
				startActivity(intent);
				break;
			
			default:
				break;
			}
		}
	}

	/* *
	 * Called when invalidateOptionsMenu() is triggered
	 */
	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// if nav drawer is opened, hide the action items
		boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
		menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	/**
	 * Diplaying fragment view for selected nav drawer list item
	 * */
	private void displayView(int position) {
		// update the main content by replacing fragments
		Activity activity = null;
		switch (position) {
		case 0:
			activity = new MainActivity();
			break;
		case 1:
			activity = new HelpActivity();
			break;
		case 2:
			activity = new MyBankActivity();
			break;
		case 3:
			activity = new SettingActivity();
			break;
		
		default:
			break;
		}
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

	/**
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()...
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		// Sync the toggle state after onRestoreInstanceState has occurred.
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		// Pass any configuration change to the drawer toggls
		mDrawerToggle.onConfigurationChanged(newConfig);
	}
}
