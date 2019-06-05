/**<ul>
 * <li>AAnnotProjectMigrated</li>
 * <li>com.android2ee.formation.librairies.androidannotation.exo.migrated.adapter</li>
 * <li>2 août 2013</li>
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
package com.android2ee.formation.librairies.androidannotation.exo.migrated.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.android2ee.formation.librairies.androidannotation.exo.migrated.Human;
import com.android2ee.formation.librairies.androidannotation.exo.migrated.R;
import com.googlecode.androidannotations.annotations.AfterInject;
import com.googlecode.androidannotations.annotations.EBean;
import com.googlecode.androidannotations.annotations.RootContext;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to:
 *        <ul>
 *        <li></li>
 *        </ul>
 */
@EBean
public class HumanAAAdapter extends ArrayAdapter<Human> {
	/**
	 * The list of selected humans
	 */
	List<Human> selectedGuys;
	/**
	 * The list of position of selected human
	 */
	SparseArray<Boolean> selectedPosition;
	/**
	 * The token to avoid the check.setCheck=>l'appel au listener
	 */
	boolean token;

	@RootContext
	Context context;
	// Temp variables: avoid create temp variables : use static
	private static Human tempHuman;
	private static Boolean isSelected;

	@AfterInject
	void initAdapter() {
		// instantiate the list
		selectedGuys = new ArrayList<Human>();
		selectedPosition = new SparseArray<Boolean>();
	}

	/**
	 * Define the list of human
	 * 
	 * @param humans
	 */
	public void setData(List<Human> humans) {
		// set the list
		addAll(humans);
		// notify data changed
		notifyDataSetChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final int positionS = position;
		HumanAdapterViewIntf rowView;
		// instantiate the rowView
		if (null == convertView) {
			// Manage if the line is odd or even
			if (getItemViewType(positionS) == 0) {
				// if odd use that layout
				rowView = HumanAdapterViewOdd_.build(context);
			} else {
				// if even use that one
				rowView = HumanAdapterViewEven_.build(context);
			}
		} else {
			rowView = (HumanAdapterViewIntf) convertView;
		}
		// rowView != null et s'il peut il vaut convertView
		// find the object
		tempHuman = (Human) getItem(position);
		// bind the view and the item
		rowView.bind((Human) getItem(position));
		// find if it's selected or not
		isSelected = isSelected(position);
		// and update view
		if (isSelected != rowView.isSelected()) {
			// ensure the listener won't do anything when the setChecked is called
			token = true;
			// then update the component
			rowView.setSelection(isSelected);
		}
		// Listen for click
		final OnCheckedChangeListener onCheckedChangeListener = new OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// just select the associated human
				selectHuman(buttonView, positionS, isChecked);
			}
		};
		rowView.setOnCheckedChangeListener(onCheckedChangeListener);
		// ok, now we can listen click on that component, release the Token
		token = false;
		// return the view
		return (View) rowView;
	}

	/******************************************************************************************/
	/** Managing the selection **************************************************************************/
	/******************************************************************************************/

	/**
	 * Method called by the onClick on the checkBox of the ListView
	 * It (un)selects the human at that position
	 * 
	 * @param viewHolder
	 *            The ViewHolder to change the view
	 * @param position
	 *            The position of the selected elements
	 * @param isChecked
	 *            The state selected or not
	 */
	private void selectHuman(CompoundButton buttonView, int position, boolean isChecked) {
		// if it's not a change from code
		if (!token) {
			// find the selected human
			tempHuman = (Human) getItem(position);
			// remember the state of the element at that position
			selectedPosition.put(position, isChecked);
			// then add that human to the list of selected human
			if (isChecked) {
				if (!selectedGuys.contains(tempHuman)) {
					selectedGuys.add(tempHuman);
				}
			} else {
				if (selectedGuys.contains(tempHuman)) {
					selectedGuys.remove(tempHuman);
				}
			}
			// then update the view:
			if (isChecked) {
				buttonView.setChecked(true);
			} else {
				buttonView.setChecked(false);
			}
		}
	}

	/**
	 * Usefull method to know if an element is selected or not
	 * 
	 * @param position
	 *            The element position
	 * @return true if that element has been selected before, else false
	 */
	private boolean isSelected(int position) {
		isSelected = selectedPosition.get(position);
		if (isSelected != null && isSelected) {
			return true;
		}
		return false;
	}

	/******************************************************************************************/
	/** Managing the odd/even lines **************************************************************************/
	/******************************************************************************************/

	@Override
	public int getViewTypeCount() {
		// return the number of type managed by the list view:
		// We have two types, one for the even line, the other for the odd lines
		return 2;
	}

	@Override
	public int getItemViewType(int position) {
		// return the type of the element to be displayed at position position
		// We have two types, one for the even line, the other for the odd lines
		return position % 2;
	}

	/******************************************************************************************/
	/** Public method **************************************************************************/
	/******************************************************************************************/

	/**
	 * Return the list of selected guys
	 * 
	 * @return the selectedGuys
	 */
	public final List<Human> getSelectedGuys() {
		return selectedGuys;
	}

	/******************************************************************************************/
	/** Constructors **************************************************************************/
	/******************************************************************************************/

	/**
	 * @param context
	 * @param textViewResourceId
	 * @param objects
	 */
	public HumanAAAdapter(Context context) {
		super(context, R.layout.human_adapter_even);
	}
	//
	// /**
	// * @param context
	// * @param textViewResourceId
	// * @param objects
	// */
	// private HumanAAAdapter(Context context, int textViewResourceId, Human[] objects) {
	// super(context, textViewResourceId, objects);
	// }
	//
	// /**
	// * @param context
	// * @param resource
	// * @param textViewResourceId
	// * @param objects
	// */
	// private HumanAAAdapter(Context context, int resource, int textViewResourceId, Human[]
	// objects) {
	// super(context, resource, textViewResourceId, objects);
	// }
	//
	// /**
	// * @param context
	// * @param resource
	// * @param textViewResourceId
	// * @param objects
	// */
	// private HumanAAAdapter(Context context, int resource, int textViewResourceId, List<Human>
	// objects) {
	// super(context, resource, textViewResourceId, objects);
	// }
	//
	// /**
	// * @param context
	// * @param resource
	// * @param textViewResourceId
	// */
	// private HumanAAAdapter(Context context, int resource, int textViewResourceId) {
	// super(context, resource, textViewResourceId);
	// }
	//
	// /**
	// * @param context
	// * @param textViewResourceId
	// */
	// private HumanAAAdapter(Context context, int textViewResourceId) {
	// super(context, textViewResourceId);
	// }
}
