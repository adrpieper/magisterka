package pl.edu.ug.inf.am.menu.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import pl.adrian.bindinge.AdapterBuilder;
import pl.adrian.bindinge.Adapters;
import pl.adrian.bindinge.ModelBinder;
import pl.adrian.bindinge.ViewFactories;
import pl.aml.character.CharacterType;
import pl.aml.character.CharacterTypesProvider;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.CharacterTypeViewBinding;
import pl.edu.ug.inf.am.game.view.GameActivity;
import pl.edu.ug.inf.am.menu.dagger.MenuComponent;
import pl.edu.ug.inf.am.menu.logic.NewGameCreator;

import javax.inject.Inject;
import java.util.List;

public class SelectCharacterActivity extends Activity{

    @Inject
    CharacterTypesProvider characterTypesProvider;

    @Inject
    NewGameCreator newGameCreator;

    private CharacterType selectedCharacterType;
    private CharacterTypeViewBinding characterTypeViewBinding;
    public SelectCharacterActivity() {
        App.getComponent(MenuComponent.class).inject(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.select_character_activity);

        characterTypeViewBinding = CharacterTypeViewBinding.bind(findViewById(R.id.selectedCharcterView));
        bindListView();

        Button newGameButton = (Button) findViewById(R.id.startGameButton);
        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startGame();
            }
        });

    }

    private void bindListView() {
        final ListView listView = (ListView) findViewById(R.id.selectCharaterListView);
        final List<CharacterType> list = characterTypesProvider.provideAll();
        select(list.get(0));

        Adapters.createFor(listView, list)
                .withListener(new AdapterBuilder.OnDataClickListener<CharacterType>() {
                    @Override
                    public void click(CharacterType characterType) {
                        select(characterType);
                    }
                })
                .withViewFactory(ViewFactories.textViewFactory())
                .withBinder(new ModelBinder<TextView, CharacterType>() {
                    @Override
                    public void bind(TextView view, CharacterType model) {
                        view.setText(model.getName());
                    }
                })
                .bind();
    }

    private void select(CharacterType characterType) {
        selectedCharacterType = characterType;
        characterTypeViewBinding.setType(selectedCharacterType);
    }

    private void startGame() {
        if (selectedCharacterType != null) {
            newGameCreator.startNew(selectedCharacterType);
            Intent intent = new Intent(this,GameActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }
}
