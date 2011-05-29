/**
 * 
 */
package org.jug.montpellier.jugdroid.ui;

import java.util.Random;

/**
 * @author etaix
 *
 */
public class RandomNewInfoProvider implements NewInfoProvider {

	private Random r = new Random();
	
	/* (non-Javadoc)
	 * @see org.jug.montpellier.jugdroid.ui.NewInfoProvider#getNewInfoCount()
	 */
	@Override
	public int getNewInfoCount() {
		return r.nextInt(11);
	}

}
