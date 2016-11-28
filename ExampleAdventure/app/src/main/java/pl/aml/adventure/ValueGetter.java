package pl.aml.adventure;

public enum ValueGetter {
    INT {
        @Override
        int get(AContext aContext) {
            return aContext.playerInt();
        }
    },STR {
        @Override
        int get(AContext aContext) {
            return aContext.playerStr();
        }
    };

    abstract int get(AContext aContext);
}
