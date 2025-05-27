package kosta.test.vedio;

import kosta.test.service.Player;

public class VedioImpl implements Player {

	@Override
	public void start(int i) {
		System.out.println("VedioImpl start(int i) 호출");

	}

	@Override
	public String pause() {
		System.out.println("VedioImpl pause() 호출");
		return "Vedio 리턴값!!";
	}

	@Override
	public void stop() {
		System.out.println("VedioImpl stop() 호출");

	}
}
