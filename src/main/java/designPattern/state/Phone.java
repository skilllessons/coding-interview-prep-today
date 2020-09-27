package main.java.designPattern.state;

public class Phone {
    RingState s = new SoundState();

    void ring() {
        s.ring();
    }

    void volumeUp(){
        s =s.nextStateVolumeUp();
    }

    void volumeDown(){
       s = s.nextStateVolumeDown();
    }
}

abstract class RingState {
    abstract void ring();
    abstract RingState nextStateVolumeUp();
    abstract RingState nextStateVolumeDown();

}

class SoundState extends RingState {

    @Override
    void ring() {
        System.out.println("Phone is ringing");
    }

    @Override
    RingState nextStateVolumeUp() {
        return this;
    }

    @Override
    RingState nextStateVolumeDown() {
        return new VibrateState();
    }
}


class VibrateState extends RingState {

    @Override
    void ring() {
        System.out.println("Phone is Vibrate");
    }

    @Override
    RingState nextStateVolumeUp() {
        return new SoundState();
    }

    @Override
    RingState nextStateVolumeDown() {
        return new SilentState();
    }
}


class SilentState extends RingState {

    @Override
    void ring() {
        System.out.println("Phone is Silent");
    }

    @Override
    RingState nextStateVolumeUp() {
        return new VibrateState();
    }

    @Override
    RingState nextStateVolumeDown() {
        return this;
    }
}

class Test {
    public static void main(String[] args) {

        Phone p = new Phone();
        p.ring();
        p.volumeDown();
        p.ring();
        p.volumeDown();
        p.ring();
        p.volumeDown();
        p.ring();
        p.volumeDown();

        p.ring();
        p.volumeUp();
        p.ring();

    }

}
