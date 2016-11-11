package pl.adrian.bindinge;

import android.content.Context;
import android.view.View;

public interface ViewFactory<V extends View> {

    V createView(Context context);
}
