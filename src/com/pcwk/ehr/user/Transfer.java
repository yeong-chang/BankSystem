package com.pcwk.ehr.user;

import java.util.Scanner;

public class Transfer {

	AccountDao dao = new AccountDao();
	Scanner scanner = new Scanner(System.in);

	public Transfer() {

	}

	public void trasnfer() {
		if (AccountVO.userLoginVO != null) {
			System.out.print("송금할 계좌번호를 입력해주세요: ");
			String inputTransferAcc = scanner.nextLine();

			System.out.print("송금할 금액을 입력해주세요: ");
			double inputTransferAmount = scanner.nextDouble();

			scanner.nextLine();
			System.out.println("받는 분에게 표시될 이름: ");
			String message = scanner.nextLine();

			System.out.print("비밀번호를 입력해주세요: ");
			String userPw = scanner.nextLine();

			for (AccountVO account : AccountDao.accounts) {
				if (AccountVO.userLoginVO.getUserPw().equals(userPw)) {
					if (account.getAccountNo().equals(inputTransferAcc)) {
						
						account.setBalance(inputTransferAmount + account.getBalance());
						System.out.println(account.getUserName() + "님께 이체가 완료되었습니다.");
						System.out.println("이체 전 잔액: " + AccountVO.userLoginVO.getBalance());
						AccountVO.userLoginVO.setBalance(AccountVO.userLoginVO.getBalance() - inputTransferAmount);
						System.out.println("이체 금액: " + inputTransferAmount);
						System.out.println("이체 후 잔액: " + AccountVO.userLoginVO.getBalance());
						dao.doUpdate();
					}
				} else {
					System.out.println("비밀번호가 틀렸습니다. 다시 시도하세요.");
				}
			}

		} else {
			System.out.println("로그인 되어있는 계좌가 없습니다.");
		}
	}
}