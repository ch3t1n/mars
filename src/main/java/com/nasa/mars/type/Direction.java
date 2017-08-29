package com.nasa.mars.type;

public enum Direction {
    N("North") {
        public Direction left() {
            return W;
        }
        public Direction right() {
            return E;
        }
    },
    S("South"){
        public Direction left() {
            return E;
        }
        public Direction right() {
            return W;
        }
    },
    E("East") {
        public Direction left() {
            return N;
        }
        public Direction right() {
            return S;
        }
    },
    W("West") {
        public Direction left() {
            return S;
        }
        public Direction right() {
            return N;
        }
    };

    private String direction;

    Direction(String direction) {
        this.direction = direction;
    }

    public abstract Direction left();
    public abstract Direction right();
}
