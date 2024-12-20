package my.utem.ftmk.ViewApp.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import my.utem.ftmk.ViewApp.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

//    @StringRes
//    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;
    private int totalTabs;

    public SectionsPagerAdapter(Context context, FragmentManager fm, int tabCount) {
        super(fm);
        mContext = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment.
        switch (position)
        {
            case 0:
                GetJokeActivityFrag jokeActivityFrag = new GetJokeActivityFrag();
                return jokeActivityFrag;

            case 1:
                GetUniversityFrag getUniversityFrag = new GetUniversityFrag();
                return getUniversityFrag;

            default:return null;
        }
    }

//    @Nullable
//    @Override
//    public CharSequence getPageTitle(int position) {
//        return mContext.getResources().getString(TAB_TITLES[position]);
//    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return totalTabs;
    }
}