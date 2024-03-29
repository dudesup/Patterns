package de.tum.cs.i1.pse;

public class MusicPlayer {

	private State currentState;

	public MusicPlayer() {
		// TODO: Set initial state to Inactive State
	}

	public void setCurrentState(State currentState) {
		if (this.currentState != null) {
			this.currentState.exit();
		}
		this.currentState = currentState;
		this.currentState.entry();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void handle(Event event) {
		// TODO: Handle State specific behavior here.
	}

	public void playMusic() {
		System.out.println("Playing Music");
	}

	public void pauseMusic() {
		System.out.println("Pausing the Music");
	}

	public void turnOn() {
		System.out.println("Music Player turned On");
	}

	public void turnOff() {
		System.out.println("Music Player turned Off");
	}
}
