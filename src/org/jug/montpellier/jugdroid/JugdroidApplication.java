/**
 * 
 */
package org.jug.montpellier.jugdroid;

import greendroid.app.GDApplication;

import org.acra.ACRA;
import org.acra.ReportingInteractionMode;
import org.acra.annotation.ReportsCrashes;
import org.jared.jugdroid.ui.DashboardActivity_;

/**
 * To use GDActivity, the application class MUST override GDApplication. This
 * application is set in the manifest.
 * 
 * @author etaix
 * 
 */ 
@ReportsCrashes(formKey = "dF8wYXJuSHY2cDVCRHlWYXp0bWxwSlE6MQ",
        mode = ReportingInteractionMode.TOAST,
        resToastText = R.string.crash_toast_text)
public class JugdroidApplication extends GDApplication {

	@Override
    public void onCreate() {
        // The following line triggers the initialization of ACRA
        ACRA.init(this);
        super.onCreate();
    }
	
	/**
	 * Return the main activity, then GDActivity is able to add or not the home icon<br/>
	 * When used with AndroidAnnotations, this method is called too late. We must override the constructor to set the ActionBar.Type 
	 */
	@Override
    public Class<?> getHomeActivityClass() {
        return DashboardActivity_.class;
    }
	
	
}
