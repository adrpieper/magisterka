package pl.edu.ug.inf.am.nfc;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import pl.edu.ug.inf.am.game.dagger.PerGame;
import pl.edu.ug.inf.am.game.view.GameActivity;

import javax.inject.Inject;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

import static android.content.ContentValues.TAG;
//https://code.tutsplus.com/tutorials/reading-nfc-tags-with-android--mobile-17278
@PerGame
public class NFC {
    private final Context context;
    private final NfcAdapter nfcAdapter;
    private TagReaderListener listener;

    @Inject
    public NFC(Context context,@Nullable NfcAdapter nfcAdapter ) {
        this.context = context;
        this.nfcAdapter = nfcAdapter;
    }

    public boolean isEnabled() {
        return nfcAdapter != null;
    }

    public void setListener(TagReaderListener listener) {
        this.listener = listener;
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

        String action = intent.getAction();

        if (NfcAdapter.ACTION_NDEF_DISCOVERED.equals(action)) {

            String type = intent.getType();
            if ("text/plain".equals(type)) {

                Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
                read(tag);
            } else {
                Log.d(TAG, "Wrong mime type: " + type);
            }
        }
    }

    private void read(Tag tag) {
        Ndef ndef = Ndef.get(tag);
        if (ndef == null) {
            Toast.makeText(context, "NDEF is not supported by this Tag", Toast.LENGTH_SHORT).show();
        }

        NdefMessage ndefMessage = ndef.getCachedNdefMessage();
        NdefRecord[] records = ndefMessage.getRecords();

        for (NdefRecord ndefRecord : records) {
            if (ndefRecord.getTnf() == NdefRecord.TNF_WELL_KNOWN && Arrays.equals(ndefRecord.getType(), NdefRecord.RTD_TEXT)) {
                try {

                    if (listener != null) {

                        listener.onRead(readText(ndefRecord));
                    }
                } catch (UnsupportedEncodingException e) {}
            }
        }
    }

    private String readText(NdefRecord record) throws UnsupportedEncodingException {

        byte[] payload = record.getPayload();
        String textEncoding = ((payload[0] & 128) == 0) ? "UTF-8" : "UTF-16";
        int languageCodeLength = payload[0] & 0063;
        return new String(payload, languageCodeLength + 1, payload.length - languageCodeLength - 1, textEncoding);
    }

    public interface TagReaderListener {
        void onRead(String tagMessage);
    }
}
