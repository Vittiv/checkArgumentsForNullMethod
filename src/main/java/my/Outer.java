package my;

public class Outer {
    private String privateString;
    String nonPrivateString;
    Boolean nonPrivateBoolean;
    public Boolean publicBoolean;

    public Outer(Boolean privateFinalBoolean) {
        this.privateFinalBoolean = privateFinalBoolean;
    }

    private final Boolean privateFinalBoolean;

    public Outer(String privateString,
                 String nonPrivateString,
                 Boolean nonPrivateBoolean,
                 Boolean publicBoolean,
                 Boolean privateFinalBoolean) {
        this.privateString = privateString;
        this.nonPrivateString = nonPrivateString;
        this.nonPrivateBoolean = nonPrivateBoolean;
        this.publicBoolean = publicBoolean;
        this.privateFinalBoolean = privateFinalBoolean;
    }

    class Inner {
        String inner;

        public Inner(String inner) {
            this.inner = inner;
        }

    }
    static class Nested {
        String nested;

        public Nested(String nested) {
            this.nested = nested;
        }
    }
}
