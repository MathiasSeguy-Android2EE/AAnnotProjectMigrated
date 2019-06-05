/**<ul>
 * <li>PremierTP_Rennes_Avril13</li>
 * <li>com.android2ee.formation.librairies.androidannotation.exo.migrated</li>
 * <li>24 avr. 2013</li>
 * 
 * <li>======================================================</li>
 *
 * <li>Projet : Mathias Seguy Project</li>
 * <li>Produit par MSE.</li>
 *
 /**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br> 
 * Produced by <strong>Dr. Mathias SEGUY</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 *  Belongs to <strong>Mathias Seguy</strong></br>
 ****************************************************************************************************************</br>
 * This code is free for any usage except training and can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * 
 * *****************************************************************************************************************</br>
 *  Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 *  Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br> 
 *  Sa propriété intellectuelle appartient à <strong>Mathias Seguy</strong>.</br>
 *  <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * *****************************************************************************************************************</br>
 */
package com.android2ee.formation.librairies.androidannotation.exo.migrated;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.android2ee.formation.librairies.androidannotation.exo.migrated.adapter.HumanAAAdapter;
import com.googlecode.androidannotations.annotations.AfterViews;
import com.googlecode.androidannotations.annotations.Bean;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to display a EditText, a button and a list view (ok, two listView)
 */


@EActivity(R.layout.activity_main)
public class MainActivity extends Activity {
	/******************************************************************************************/
	/** Constant **************************************************************************/
	/******************************************************************************************/

	private static final String TXV_VALUE = "txv_value";
	private static final String tag = "MainActivity";

	/******************************************************************************************/
	/** Fields **************************************************************************/
	/******************************************************************************************/
	@ViewById(R.id.edt_id)
	EditText edt = null;
	@ViewById(R.id.btn_add_id)
	Button btnAdd = null;
	@ViewById(R.id.btn_flush_id)
	Button btnFlush = null;
	/**
	 * The listView that manages human
	 */
	@ViewById(R.id.ltv_id)
	ListView humanListView = null;
	/**
	 * The human list to display
	 */
	ArrayList<Human> items;
	/**
	 * The arrayAdapter of humanListView
	 */
	@Bean
	HumanAAAdapter humanAAAdapter;

	/******************************************************************************************/
	/** Constructors **************************************************************************/
	/******************************************************************************************/
	@AfterViews
	void updateTextWithDate() {
		edt.setText("");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		Log.e(tag, "onCreate called");
		super.onCreate(savedInstanceState);
		Log.e(tag, "onCreate over");
	}

	/**
	 * Finish the views initialisation
	 * You not be in onCreate, the view fields are null in onCreate
	 */
	@AfterViews
	public void finishViewsInitialization() {
		humanListView.setHeaderDividersEnabled(true);
		humanListView.addFooterView(LayoutInflater.from(this).inflate(R.layout.list_header, null));
		// instantiate the list of object to displays
		items = new ArrayList<Human>();
		Human toto = new Human("Mathias", "A Table!!!");
		items.add(toto);
		humanAAAdapter.setData(items);
		humanListView.setAdapter(humanAAAdapter);
	}

	/******************************************************************************************/
	/** Managing life cycle **************************************************************************/
	/******************************************************************************************/

	@Override
	protected void onResume() {
		Log.e(tag, "onResume called");
		super.onResume();
		// on recharge les champs
		Log.e(tag, "onResume over");
	}

	@Override
	protected void onPause() {
		Log.e(tag, "onPause called");
		super.onPause();
		// on sauvegarde les champs
		Log.e(tag, "onPause over");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		Log.e(tag, "onRestoreInstanceState called");
		super.onRestoreInstanceState(savedInstanceState);
		for (Parcelable par : savedInstanceState.getParcelableArrayList(TXV_VALUE)) {
			items.add((Human) par);
		}
		Log.e(tag, "onRestoreInstanceState over");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		Log.e(tag, "onSaveInstanceState called");
		super.onSaveInstanceState(outState);
		outState.putParcelableArrayList(TXV_VALUE, items);
		Log.e(tag, "onSaveInstanceState over");
	}

	/******************************************************************************************/
	/** Managing Data **************************************************************************/
	/******************************************************************************************/

	/**
	 * Add an Item
	 */
	@Click(R.id.btn_add_id)
	public void addItem() {
		// find the element to add
		String str = edt.getText().toString();
		// create the associated human
		Human toto = new Human("Toto", str);
		// add it to the list
		humanAAAdapter.add(toto);
		// notify the arrayAdapter that its data has changed
		flushEdt();
	}

	/**
	 * Flush the EditText
	 */
	@Click(R.id.btn_flush_id)
	public void flushEdt() {
		edt.setText("");
	}

	/******************************************************************************************/
	/** Managing menu **************************************************************************/
	/*********** new O *******************************************************************************/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
