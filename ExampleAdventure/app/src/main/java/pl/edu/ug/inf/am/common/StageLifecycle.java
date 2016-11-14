package pl.edu.ug.inf.am.common;

public interface StageLifecycle<StartDataType> {

    void onStart(StartDataType startData);
    void onEnd();
}
