package pl.aml.character;

public class SkillTree {
    private final SkillNode[] rootNodes;

    public SkillTree(SkillNode... rootNodes) {
        this.rootNodes = rootNodes;
    }

    public SkillNode[] getRootNodes() {
        return rootNodes;
    }
}
