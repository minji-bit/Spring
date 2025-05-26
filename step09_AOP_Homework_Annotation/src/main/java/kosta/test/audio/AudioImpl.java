package kosta.test.audio;

import org.springframework.stereotype.Component;

import kosta.test.service.Player;
@Component("audio")
public class AudioImpl implements Player {

	@Override
	public void start(int i) {
		System.out.println("AudioImpl start(int i)호출");

	}

	@Override
	public String pause() {
		System.out.println("AudioImpl pause() 호출");
		return "Audio pause 리턴!!";
	}

	@Override
	public void stop() {
		System.out.println("AudioImpl stop() 호출");
	}

}
