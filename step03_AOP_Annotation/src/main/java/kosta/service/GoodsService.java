package kosta.service;

import org.springframework.stereotype.Service;

@Service("target2")
public class GoodsService {
	public void insert() {
		System.out.println("GoodsService insert() 핵심기능~~");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public int goodsSelect(String code) {
		System.out.println("GoodsService goodsSelect(String code) 핵심기능~~");
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return 300;
	}
}
