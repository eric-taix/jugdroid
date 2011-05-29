/**
 * 
 */
package org.jug.montpellier.jugdroid.ui;

/**
 * A NewInfoProvider returns the number of new informations available for a NewInfoButton.
 * @author etaix
 */
public interface NewInfoProvider {

	/**
	 * Returns the number of new informations available
	 * @return
	 */
	public int getNewInfoCount();
	
}
