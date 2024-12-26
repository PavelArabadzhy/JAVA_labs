package org.example;

public class TEST {
    private enum State {
        S0, S1, S2, S3, F
    }

    public boolean containsTEST(String input) {
        State state = State.S0;

        for (char c : input.toCharArray()) {
            switch (state) {
                case S0:
                    if (c == 'T') state = State.S1;
                    break;
                case S1:
                    if (c == 'E') state = State.S2;
                    else if (c == 'T') state = State.S1;
                    else state = State.S0;
                    break;
                case S2:
                    if (c == 'S') state = State.S3;
                    else if (c == 'T') state = State.S1;
                    else state = State.S0;
                    break;
                case S3:
                    if (c == 'T') state = State.F;
                    else state = State.S0;
                    break;
                case F:
                    return true;
            }
        }
        return state == State.F;
    }
}

