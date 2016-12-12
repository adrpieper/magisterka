package pl.edu.ug.inf.am.trip.view;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import pl.aml.location.Place;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.trip.controller.LocationManager;
import pl.edu.ug.inf.am.trip.dagger.TripComponent;

import javax.inject.Inject;

public class LocationSelectFragment extends Fragment {

    @Inject
    LocationManager locationManager;
    private AbsListView listView;

    public LocationSelectFragment() {
        App.getComponent(TripComponent.class).inject(this);
    }

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

    private void selectLocation(Place place) {
        locationManager.enterInto(place);
    }

    class LocationApapter extends BaseAdapter {

        @Override
        public int getCount() {
            return Place.values().length;
        }

        @Override
        public Place getItem(int position) {
            return Place.values()[position];
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
