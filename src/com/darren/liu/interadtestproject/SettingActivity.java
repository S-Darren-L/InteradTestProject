package com.darren.liu.interadtestproject;

import java.util.ArrayList;

import models.NavDrawerItemModel;
import beans.NavDrawerListAdapter;


import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SettingActivity extends Activity {
	
	Button tvMyAccount;
	Button tvNotifications;
	Button tvPrivacy;
	Button tvGeneral;
	Button tvAbout;
	
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
		setContentView(R.layout.activity_setting);
		
		tvMyAccount = (Button) findViewById(R.id.tvMyAccount);
		tvNotifications = (Button) findViewById(R.id.tvNotifications);
		tvPrivacy = (Button) findViewById(R.id.tvPrivacy);
		tvGeneral = (Button) findViewById(R.id.tvGeneral);
		tvAbout = (Button) findViewById(R.id.tvAbout);
		
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
	
	//fake button event
	public void onMyAccountClick(View view){
		Toast.makeText(this, "Start My Account Activity", Toast.LENGTH_SHORT).show();
	}
	
	
	public void onNotificationsClick(View view){
		Toast.makeText(this, "Start Notifications Activity", Toast.LENGTH_SHORT).show();
	}
	
	
	public void onPrivacyClick(View view){
		Toast.makeText(this, "Start Provacy Activity", Toast.LENGTH_SHORT).show();
	}
	
	
	public void onGeneralClick(View view){
		Toast.makeText(this, "Start General Activity", Toast.LENGTH_SHORT).show();
	}
	
	
	public void onAboutClick(View view){
		Toast.makeText(this, "Start About Activity", Toast.LENGTH_SHORT).show();
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
