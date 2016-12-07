package pl.edu.ug.inf.am.trip.view;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v13.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import pl.adrian.util.Reflection;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.trip.items.ItemsFragment;
import pl.edu.ug.inf.am.trip.skills.SkillsFragment;

import static pl.adrian.util.Reflection.newInstance;

public class TripPagerFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        ViewPager viewPager = new ViewPager(getActivity());
        viewPager.setAdapter(new Adapter(getActivity().getFragmentManager()));
        viewPager.setId(R.id.trip_pager_view);
        return viewPager;
    }

    private class Adapter extends FragmentPagerAdapter{

        private Class<? extends Fragment> fragments[] = new Class[]{
                PlayerReviewFragment.class,
                SkillsFragment.class,
                ItemsFragment.class,
                LocationSelectFragment.class
        };

        public Adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return newInstance(fragments[position]);
        }

        @Override
        public int getCount() {
            return fragments.length;
        }
    }
}
