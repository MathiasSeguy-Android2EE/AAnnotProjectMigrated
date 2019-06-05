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

import android.widget.CompoundButton.OnCheckedChangeListener;

import com.android2ee.formation.librairies.androidannotation.exo.migrated.Human;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 * This class aims to:
 * <ul><li></li></ul>
 */
public interface HumanAdapterViewIntf {
	/**
     * Set the selection state of the checkbox
     * @param selectionState
     */
	public void setSelection(boolean selectionState);
	/**
	 * @return the selection state of the checkbox
	 */
	public boolean isSelected();
	/**
	 * Attach OnCheckedChangeListener to the checkBox
	 * @param listener
	 */
	public void setOnCheckedChangeListener(OnCheckedChangeListener listener);
	/**
	 * Bind human and view
	 * @param human
	 */
	public void bind(Human human) ;
}
