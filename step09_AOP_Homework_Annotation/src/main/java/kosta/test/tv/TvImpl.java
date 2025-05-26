package kosta.test.tv;

import org.springframework.stereotype.Component;

import kosta.test.service.Player;
@Component("tv")
public class TvImpl implements Player {

	@Override
	public void start(int i) {
		System.out.println("TvImpl start(int i) 호출");

	}

	@Override
	public String pause() {
		System.out.println("TvImpl pause() 호출 ");
		return "TvImpl 리턴값!!";
	}

	@Override
	public void stop() {
		System.out.println("TvImpl stop() 호출");

	}

}
