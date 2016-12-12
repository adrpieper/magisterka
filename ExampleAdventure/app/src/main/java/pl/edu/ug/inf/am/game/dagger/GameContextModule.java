package pl.edu.ug.inf.am.game.dagger;

import android.content.Context;
import android.nfc.NfcAdapter;
import android.support.annotation.Nullable;
import dagger.Module;
import dagger.Provides;
import pl.edu.ug.inf.am.game.view.GameView;
import pl.edu.ug.inf.am.game.view.GameActivity;
import pl.edu.ug.inf.am.game.view.GameViewContainer;

@Module
public class GameContextModule {

    @Provides
    @PerGame
    public GameView provideGameView(GameViewContainer container) {
        return container;
    }

    @Nullable
    @Provides
    @PerGame
    public NfcAdapter provideNfcAdapter(Context context){
        return NfcAdapter.getDefaultAdapter(context);
    }
}
