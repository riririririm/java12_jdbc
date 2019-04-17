package com.rim.db.point;

import java.util.Scanner;

public class PointController {
	private Scanner sc;
	private PointInput input;
	private PointDTO dto;
	private PointDAO dao;
	private PointView pv;
	
	public PointController() {
		// TODO Auto-generated constructor stub
		sc = new Scanner(System.in);
		input = new PointInput();
		dto = new PointDTO(); 
		dao = new PointDAO();
		pv = new PointView();
	}

	public void start() throws Exception {
		
		while (true) {
			System.out.println("1.성적 등록 / 2.종료");
			int select = sc.nextInt();
			
			if (select == 1) {
				dto = input.setPoint();
				int result = dao.insert(dto);
				
				String message = "등록실패";
				if(result>0)
					message ="등록성공";
				pv.view(message);
					
				
			} else if (select == 2) {
				System.out.println("프로그램 종료");
				break;
			} else
				System.out.println("1,2번 중에 선택하세요");
		}//end of while
	}
}
