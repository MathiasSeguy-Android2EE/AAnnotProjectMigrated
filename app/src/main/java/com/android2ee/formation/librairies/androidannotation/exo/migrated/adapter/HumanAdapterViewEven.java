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

import android.content.Context;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

import com.android2ee.formation.librairies.androidannotation.exo.migrated.Human;
import com.android2ee.formation.librairies.androidannotation.exo.migrated.R;
import com.googlecode.androidannotations.annotations.EViewGroup;
import com.googlecode.androidannotations.annotations.ViewById;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 * This class aims to:
 * <ul><li></li></ul>
 */
@EViewGroup(R.layout.human_adapter_even)
public class HumanAdapterViewEven extends LinearLayout implements HumanAdapterViewIntf {
	@ViewById
    TextView human_message;

    @ViewById
    CheckBox selected;

    public HumanAdapterViewEven(Context context) {
        super(context);
    }

    public void bind(Human human) {
    	selected.setText(human.getName());
    	human_message.setText(human.getMessage());
    }
    /* (non-Javadoc)
     * @see com.android2ee.formation.librairies.androidannotation.exo.migrated.adapter.HumanAdapterViewIntf#setSelection(boolean)
     */
    public void setSelection(boolean selectionState) {
    	selected.setChecked(selectionState);
    }
	/* (non-Javadoc)
	 * @see android.view.View#isSelected()
	 */
	public boolean isSelected() {
		return selected.isChecked();
	}
	/* (non-Javadoc)
	 * @see com.android2ee.formation.librairies.androidannotation.exo.migrated.adapter.HumanAdapterViewIntf#setOnCheckedChangeListener(android.widget.CompoundButton.OnCheckedChangeListener)
	 */
	public void setOnCheckedChangeListener(OnCheckedChangeListener listener) {
		selected.setOnCheckedChangeListener(listener);
	}
}
