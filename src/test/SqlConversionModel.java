package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SqlConversionModel {
	public static void main(String[] args) throws IOException {
		/*
		 * 2022.06.09 최초 생성 이태희
		 * DBeaver을 이용한 model 추츨 
		 * DBeaver에서 테이블 우클릭 > SQL생성 > DDL > Copy > console 입력 후 Enter 2번 
		 */
		
		
		//	-- kalisdtm.tb_data_usecase definition
		//
		//	CREATE TABLE `tb_data_usecase` (
		//	  `CASE_SEQ` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '사례시퀀스',
		//	  `CASE_SJ` varchar(500) DEFAULT NULL COMMENT '사례제목',
		//	  `THEMA_NO` varchar(30) DEFAULT NULL COMMENT '주제번호',
		//	  `ANALS_UNT` varchar(100) DEFAULT NULL COMMENT '분석도구',
		//	  `ANALS_PURPS` varchar(1000) DEFAULT NULL COMMENT '분석목적',
		//	  `DATA_SET` varchar(1000) DEFAULT NULL COMMENT '데이터셋',
		//	  `BGNG_DT` datetime DEFAULT NULL COMMENT '시작일시',
		//	  `END_DT` datetime DEFAULT NULL COMMENT '종료일시',
		//	  `ORIGIN_NM` varchar(100) DEFAULT NULL COMMENT '출처명',
		//	  `MAIN_CN` varchar(1000) DEFAULT NULL COMMENT '주요내용',
		//	  `KWRD` varchar(100) DEFAULT NULL COMMENT '키워드',
		//	  `ANALS_REPRT_URL` varchar(200) DEFAULT NULL COMMENT '분석보고서URL',
		//	  `CHARGER_DEPT_NM` varchar(100) DEFAULT NULL COMMENT '담당자부서이름',
		//	  `CHARGER_TELNO` varchar(20) DEFAULT NULL COMMENT '담당자전화번호',
		//	  `PIC_NM` varchar(100) DEFAULT NULL COMMENT '담당자명',
		//	  `LICE` varchar(100) DEFAULT NULL COMMENT '라이선스',
		//	  `RLS_YN` char(1) DEFAULT NULL COMMENT '공개여부',
		//	  `REG_USER_ID` varchar(20) DEFAULT NULL COMMENT '등록사용자ID',
		//	  `REG_DT` datetime DEFAULT NULL COMMENT '등록일시',
		//	  `UPDT_USER_ID` varchar(20) DEFAULT NULL COMMENT '갱신사용자ID',
		//	  `UPDT_DT` datetime DEFAULT NULL COMMENT '갱신일시',
		//	  PRIMARY KEY (`CASE_SEQ`)
		//	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='데이터활용사례';
		
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		br.readLine();
		String type = new String();
		String[] request = new String[100];
		String line = "";
		for(int i=0; (line = br.readLine()).charAt(line.length()-1)!=';'; i++) {
			line = line.trim();
			if(line.charAt(0) != '`') {
				i--;
				continue;
			}
			request[i] = line;
		}
		for(int i=0; request[i] != null && request[i].length() != 0; i++) {
			request[i] = request[i].toLowerCase();
			int firstIndex = 0;
			int secondIndex = 0;
			type = "private ";
			for(int j=1; j<request[i].length()-2; j++) {
				if(request[i].charAt(j) == '`') {
					firstIndex = j;
				}
				if(request[i].charAt(j) == '\'') {
					secondIndex = j;
				}
			}
			if(request[i].substring(firstIndex + 2, firstIndex + 9 ).equals("varchar")){
				type += "String";
			} else if(request[i].substring(firstIndex + 2, firstIndex + 8 ).equals("bigint")) {
				if(request[i].contains("not null")) {
					type += "long";
				} else {
					type += "Long";
				}
			} else if(request[i].substring(firstIndex + 2, firstIndex + 6 ).equals("char")) {
				type += "String";
			} else if(request[i].substring(firstIndex + 2, firstIndex + 10 ).equals("datetime")) {
				type += "Date";
			} else if(request[i].substring(firstIndex + 2, firstIndex + 10 ).equals("smallint")) {
				if(request[i].contains("not null")) {
					type += "int";
				} else {
					type += "Integer";
				}
			} else {
				type += "직접입력";
			}
			request[i] = "/** " +request[i].substring(secondIndex+1, request[i].length()-2) + " */\n" + type +" " + request[i].substring(1, firstIndex);
			for(int j=0; j<request[i].length(); j++) {
				if(request[i].charAt(j) == '_') {
					request[i] = request[i].substring(0, j) +request[i].substring(j+1, j+2).toUpperCase()+ request[i].substring(j+2);
					j--;
				}
			}
			request[i] = request[i] + ";\n";
		}
		for(int i=0; request[i] != null && request[i].length() != 0; i++) {
			System.out.println(request[i]);
		}
	}

}
