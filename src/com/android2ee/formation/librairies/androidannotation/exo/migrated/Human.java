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

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to be an Human
 */
public class Human implements Parcelable{
/******************************************************************************************/
/** Attributes **************************************************************************/
/******************************************************************************************/

	/**
	 * The name
	 */
	private String name;
	/**
	 * The message
	 */
	private String message;
	
	/******************************************************************************************/
	/** Constructors **************************************************************************/
	/******************************************************************************************/


	/**
	 * Constructor
	 */
	private Human() {
		super();
	}

	/**
	 * @param name
	 * @param message
	 */
	public Human(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}
	/******************************************************************************************/
	/** Getters/Setters **************************************************************************/
	/******************************************************************************************/


	/**
	 * @return the name
	 */
	public final String getName() {
		if (null == name) {
			name = new String();
		}
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the message
	 */
	public final String getMessage() {
		if (null == message) {
			message = new String();
		}
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public final void setMessage(String message) {
		this.message = message;
	}
	
	/******************************************************************************************/
	/** Parcelable **************************************************************************/
	/******************************************************************************************/
	/*
	 * (non-Javadoc)
	 * @see android.os.Parcelable#writeToParcel(android.os.Parcel, int)
	 */
	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(name);
		dest.writeString(message);
		
	}
	/**
	 * Needed constructor
	 * @param in
	 */
	private Human(Parcel in) {
		name=in.readString();
		message=in.readString();
	}
	
	/**
	 * Needed creator
	 */
	public static final Parcelable.Creator<Human> CREATOR = new Parcelable.Creator<Human>() {
		public Human createFromParcel(Parcel in) {
			return new Human(in);
		}

		public Human[] newArray(int size) {
			return new Human[size];
		}
	};

	/* (non-Javadoc)
	 * @see android.os.Parcelable#describeContents()
	 */
	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

}
