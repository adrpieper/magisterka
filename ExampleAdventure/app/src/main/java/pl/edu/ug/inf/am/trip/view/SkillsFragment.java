package pl.edu.ug.inf.am.trip.view;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.unnamed.b.atv.model.TreeNode;
import com.unnamed.b.atv.view.AndroidTreeView;
import pl.aml.character.SkillNode;
import pl.aml.character.SkillTree;
import pl.edu.ug.inf.am.R;
import pl.edu.ug.inf.am.app.App;
import pl.edu.ug.inf.am.databinding.SkillFragmentBinding;
import pl.edu.ug.inf.am.databinding.SkillNodeViewBinding;
import pl.edu.ug.inf.am.player.state.PlayerState;
import pl.edu.ug.inf.am.trip.controller.SkillsController;
import pl.edu.ug.inf.am.trip.dagger.TripComponent;
import pl.edu.ug.inf.am.trip.model.SkillsModel;

import javax.inject.Inject;

public class SkillsFragment extends Fragment{

    @Inject
    PlayerState playerState;

    @Inject
    SkillsController controller;

    @Inject
    SkillsModel skillsModel;

    private AndroidTreeView androidTreeView;

    public SkillsFragment() {
        App.getComponent(TripComponent.class).inject(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, Bundle savedInstanceState) {


        SkillFragmentBinding binding = SkillFragmentBinding.inflate(inflater);
        binding.setSkills(skillsModel);
        binding.treeFrame.addView(createTreeView(playerState.getCharacterType().getSkillTree()));
        binding.acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.accept();
            }
        });
        binding.resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                controller.reset();
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        androidTreeView.expandAll();
    }

    private View createTreeView(SkillTree skillTree) {
        TreeNode root = TreeNode.root();

        for (SkillNode skillNode : skillTree.getRootNodes()) {
            root.addChild(createTreeNode(skillNode));
        }

        androidTreeView = new AndroidTreeView(getActivity(), root);
        androidTreeView.setUseAutoToggle(false);
        androidTreeView.setDefaultContainerStyle(R.style.TreeNodeStyleCustom);
        androidTreeView.setDefaultNodeClickListener(new TreeNode.TreeNodeClickListener() {
            @Override
            public void onClick(TreeNode node, Object value) {
                Toast.makeText(getActivity(), "OK", Toast.LENGTH_LONG).show();
                controller.unlockSkill((SkillNode) value);
            }
        });
        root.setViewHolder(new SkillHolder(getActivity()));
        return androidTreeView.getView();
    }

    private TreeNode createTreeNode(SkillNode skillNode){
        TreeNode result = new TreeNode(skillNode);
        result.setViewHolder(new SkillHolder(getActivity()));

        for (SkillNode childSkillNode : skillNode.getUnlockedSkills()) {
            result.addChild(createTreeNode(childSkillNode));
        }
        return result;
    }

    private class SkillHolder extends TreeNode.BaseNodeViewHolder<SkillNode> {

        public SkillHolder(Context context) {
            super(context);
        }

        @Override
        public View createNodeView(TreeNode node, SkillNode value) {
            SkillNodeViewBinding binding = SkillNodeViewBinding.inflate(LayoutInflater.from(context));
            binding.setSkillNode(value);
            binding.setSkills(skillsModel);
            return binding.getRoot();
        }
    }
}
