package pl.edu.ug.inf.am.game.dagger;

import android.content.Context;
import android.nfc.NfcAdapter;
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

    @Provides
    @PerGame
    public NfcAdapter provideNfcAdapter(Context context){
        return NfcAdapter.getDefaultAdapter(context);
    }
}
