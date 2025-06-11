package kr.or.ddit.dummy;

import java.time.Duration;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ExtenalCommunicator {
	@Async	// 비동기처리하라는 거랑 똑같음
	public void longTermJob() {
		int count = 1;
		while(count < 11) {
			try {
				// 1초마다 한번씩 슬립을 걸라는 얘기
				Thread.sleep(Duration.ofSeconds(1));
				System.out.println(count++ + "번째 메일 가져오는 중");	// 1초마다 한번씩 증가
			} catch (InterruptedException e) {}	
		}
	}
}
