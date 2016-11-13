package pl.edu.ug.inf.am.common;

public abstract class StagesManager {

    private StageLifecycle stageLifecycle;

    protected void start(StageLifecycle<Void> lifecycle){
        start(lifecycle, null);
    }

    protected <T> void start(StageLifecycle<T> lifecycle, T startData){
        if (stageLifecycle != null) {
            stageLifecycle.onEnd();
        }
        lifecycle.onStart(startData);
        stageLifecycle = lifecycle;
    }

    public void onResume(){
        if (stageLifecycle != null) {
            stageLifecycle.onResume();
        }
    }

    public void onEnd(){
        if (stageLifecycle != null) {
            stageLifecycle.onEnd();
        }
    }

    public boolean isAnyStageRunning() {
        return stageLifecycle != null;
    }
}
