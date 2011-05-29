package org.jug.montpellier.jugdroid.ui;

import greendroid.app.GDActivity;
import greendroid.graphics.drawable.ActionBarDrawable;
import greendroid.widget.ActionBar;
import greendroid.widget.ActionBarItem;
import greendroid.widget.LoaderActionBarItem;
import greendroid.widget.NormalActionBarItem;

import org.jug.montpellier.jugdroid.R;

import android.os.Bundle;

import com.googlecode.androidannotations.annotations.BeforeCreate;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.ViewById;

/**
 * The Dashboard activity (the main activity).
 * 
 * @author etaix
 */
@EActivity
public class DashboardActivity extends GDActivity {

	// Define Dashboard buttons
	@ViewById(R.id.home_btn_schedule)
	NewInfoButton schedule;
	@ViewById(R.id.home_btn_sessions)
	NewInfoButton sessions;
	@ViewById(R.id.home_btn_partners)
	NewInfoButton partners;
	@ViewById(R.id.home_btn_members)
	NewInfoButton members;
	@ViewById(R.id.home_btn_news)
	NewInfoButton news;
	@ViewById(R.id.home_btn_about)
	NewInfoButton about;
	// The NewInfoProvider implementation
	private NewInfoProvider infoProvider = new RandomNewInfoProvider();
	
	/**
	 * Must be override to set the ActionBar.Type when used with AndroidAnnotations.
	 * Overriding GDApplication.getHomeClass() method is useless
	 */
	public DashboardActivity() {
		super(ActionBar.Type.Dashboard);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Inject the NewInfoProvider: may be we can do injection with RoboGuice ?
		schedule.setInfoProvider(infoProvider);
		sessions.setInfoProvider(infoProvider);
		partners.setInfoProvider(infoProvider);
		members.setInfoProvider(infoProvider);
		news.setInfoProvider(infoProvider);
		// Add action items
		addActionBarItem(getActionBar()
                .newActionBarItem(LoaderActionBarItem.class)
                .setDrawable(new ActionBarDrawable(getResources(), com.cyrilmottier.android.greendroid.R.drawable.gd_action_bar_refresh)), R.id.action_bar_refresh);		
		addActionBarItem(getActionBar()
	                .newActionBarItem(NormalActionBarItem.class)
	                .setDrawable(new ActionBarDrawable(getResources(), com.cyrilmottier.android.greendroid.R.drawable.gd_action_bar_info)), R.id.action_bar_info);		
	}

	/**
	 * Set the content view as we can't set it using EActivity annotation
	 * because GreenDroid doesn't use the conventionnal #setContentView method
	 */
	@BeforeCreate
	public void onBeforeCreate() {
		setActionBarContentView(R.layout.activity_home);
	}

	//======  Click handlers for Dashboard buttons  ======
	@Click(R.id.home_btn_schedule)
	void scheduleClicked() {
	}

	@Click(R.id.home_btn_sessions)
	void sessionsClicked() {
	}

	@Click(R.id.home_btn_partners)
	void partnersClicked() {
	}
	
	@Click(R.id.home_btn_members)
	void membersClicked() {
	}
	
	@Click(R.id.home_btn_news)
	void newsClicked() {
	}
	
	@Click(R.id.home_btn_about)
	void aboutClicked() {
	}
	
	/**
	 * Handle click on action items
	 */
    @Override
    public boolean onHandleActionBarItemClick(ActionBarItem item, int position) {
        switch (item.getItemId()) {
            case R.id.action_bar_refresh:
                return true;
            case R.id.action_bar_info:
                return true;
            default:
                return super.onHandleActionBarItemClick(item, position);
        }
    }

}