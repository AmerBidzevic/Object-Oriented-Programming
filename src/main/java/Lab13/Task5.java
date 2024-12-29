package Lab13;
import java.util.*;

interface TrafficLightState {
    void transitionToRed(TrafficLightContext context);
    void transitionToGreen(TrafficLightContext context);
    void transitionToYellow(TrafficLightContext context);
}

class RedLightState implements TrafficLightState {
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Already in Red state.");
    }

    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Switching to Green state.");
        context.setState(new GreenLightState());
    }

    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Cannot transition directly from Red to Yellow.");
    }
}

class YellowLightState implements TrafficLightState {
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Switching to Red state.");
        context.setState(new RedLightState());
    }

    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Cannot transition directly from Yellow to Green.");
    }

    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Already in Yellow state.");
    }
}

class GreenLightState implements TrafficLightState {
    public void transitionToRed(TrafficLightContext context) {
        System.out.println("Cannot transition directly from Green to Red.");
    }

    public void transitionToGreen(TrafficLightContext context) {
        System.out.println("Already in Green state.");
    }

    public void transitionToYellow(TrafficLightContext context) {
        System.out.println("Switching to Yellow state.");
        context.setState(new YellowLightState());
    }
}

class TrafficLightContext {
    private TrafficLightState state;

    public TrafficLightContext() {
        state = new RedLightState();
    }

    public void setState(TrafficLightState state) {
        this.state = state;
    }

    public void transitionToRed() {
        state.transitionToRed(this);
    }

    public void transitionToGreen() {
        state.transitionToGreen(this);
    }

    public void transitionToYellow() {
        state.transitionToYellow(this);
    }
}

class Main5{
    public static void main(String[] args) {
        TrafficLightContext trafficLight = new TrafficLightContext();
        trafficLight.transitionToGreen();
        trafficLight.transitionToYellow();
        trafficLight.transitionToRed();
    }
}