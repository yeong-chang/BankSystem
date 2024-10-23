package com.pcwk.ehr.user;

import java.util.Scanner;

public class Withdraw {
	
	AccountDao dao = new AccountDao();
	Scanner scanner = new Scanner(System.in);
	
	public Withdraw() {
		
	}
	
	public void withdraw() {
		if (AccountVO.userLoginVO != null) {
		System.out.println("===== 출금 =====");
		System.out.print("계좌에서 출금하실 금액을 입력해주세요: ");
		double withdrawAmount = scanner.nextDouble();
		
		System.out.println("출금 전 잔고:" + AccountVO.userLoginVO.getBalance());
		AccountVO.userLoginVO.setBalance(AccountVO.userLoginVO.getBalance() - withdrawAmount);
		System.out.println("소유주명:" + AccountVO.userLoginVO.getUserName());
		System.out.println("출금 후 잔고:" + AccountVO.userLoginVO.getBalance());
		dao.doUpdate();
	} else {
		System.out.println("로그인 되어있는 계좌가 없습니다.");
	}

}
	
}
