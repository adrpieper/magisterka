package pl.edu.ug.inf.am.nfc;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import pl.edu.ug.inf.am.game.dagger.PerGame;
import pl.edu.ug.inf.am.game.view.GameActivity;

import javax.inject.Inject;

import static android.content.ContentValues.TAG;

@PerGame
public class NFC {
    private final Context context;
    private final NfcAdapter nfcAdapter;

    @Inject
    public NFC(Context context, NfcAdapter nfcAdapter ) {
        this.context = context;
        this.nfcAdapter = nfcAdapter;
    }

    public boolean isRunning() {
        return nfcAdapter.isEnabled();
    }

    public void start(Activity activity){

        final Intent intent = new Intent(context, GameActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        final PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);
        String[][] techList = new String[0][0];
        nfcAdapter.enableForegroundDispatch(activity, pendingIntent, new IntentFilter[]{createFilter()}, techList);
    }

    @NonNull
    private IntentFilter createFilter() {
        IntentFilter filter = new IntentFilter();
        filter.addAction(NfcAdapter.ACTION_NDEF_DISCOVERED);
        filter.addCategory(Intent.CATEGORY_DEFAULT);
        try {
            filter.addDataType("text/plain");
        } catch (IntentFilter.MalformedMimeTypeException e) {
            throw new RuntimeException("Check your mime type.");
        }
        return filter;
    }

    public void stop(Activity activity) {
        nfcAdapter.disableForegroundDispatch(activity);
    }

    public void handleIntent(Intent intent) {
        Toast.makeText(context, "handleIntent", Toast.LENGTH_SHORT).show();

        String action = intent.getAction();
        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {

            String type = intent.getType();
            if ("text/plain".equals(type)) {

                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                Toast.makeText(context, tag.toString(), Toast.LENGTH_SHORT).show();

            } else {
                Log.d(TAG, "Wrong mime type: " + type);
            }
        } else if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(action)) {

            // In case we would still use the Tech Discovered Intent
            Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
            String[] techList = tag.getTechList();
            String searchedTech = Ndef.class.getName();

            for (String tech : techList) {
                if (searchedTech.equals(tech)) {
                    Toast.makeText(context, tag.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}
