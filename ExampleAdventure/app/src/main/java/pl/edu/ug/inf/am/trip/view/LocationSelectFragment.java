package pl.edu.ug.inf.am.trip.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import pl.aml.Location;
import pl.edu.ug.inf.am.trip.LocationManager;
import pl.edu.ug.inf.am.view.GameFragment;

import javax.inject.Inject;

public class LocationSelectFragment extends GameFragment {

    @Inject
    LocationManager locationManager;
    private AbsListView listView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        listView = new ListView(getActivity());
        final LocationApapter adapter = new LocationApapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectLocation(adapter.getItem(position));
            }
        });
        return listView;
    }

    private void selectLocation(Location location) {
        locationManager.enterInto(location);
    }

    class LocationApapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Location.values().length;
        }

        @Override
        public Location getItem(int position) {
            return Location.values()[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            TextView textView;
            if (convertView instanceof TextView){
                textView = (TextView) convertView;
            }else {
                textView = new TextView(getActivity());
            }
            textView.setText(getItem(position).name());
            return textView;
        }
    }

}
