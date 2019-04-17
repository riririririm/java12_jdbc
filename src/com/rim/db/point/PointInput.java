package com.rim.db.point;

import java.util.Scanner;

public class PointInput {

	public PointDTO setPoint() throws Exception {
		Scanner sc = new Scanner(System.in);
		PointDTO dto = new PointDTO();
		
		System.out.println("학생번호:");
		dto.setNum(sc.nextInt());
		System.out.println("sid:");
		dto.setSid(sc.next());
		System.out.println("kor:");
		dto.setKor(sc.nextInt());
		System.out.println("eng:");
		dto.setEng(sc.nextInt());
		System.out.println("math:");
		dto.setMath(sc.nextInt());
		
		dto.setTotal(dto.getKor()+dto.getEng()+dto.getMath());
		dto.setAvg(dto.getTotal()/3.0);
		
		System.out.println("반번호:");
		dto.setBnum(sc.nextInt());
		
		return dto;
	}
}
