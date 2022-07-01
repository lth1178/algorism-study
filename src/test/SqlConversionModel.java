package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SqlConversionModel {
	public static void main(String[] args) throws IOException {
		/*
		 * 2022.06.09 ���� ���� ������
		 * DBeaver�� �̿��� model ���� 
		 * DBeaver���� ���̺� ��Ŭ�� > SQL���� > DDL > Copy > console �Է� �� Enter 2�� 
		 */
		
		
		//	-- kalisdtm.tb_data_usecase definition
		//
		//	CREATE TABLE `tb_data_usecase` (
		//	  `CASE_SEQ` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '��ʽ�����',
		//	  `CASE_SJ` varchar(500) DEFAULT NULL COMMENT '�������',
		//	  `THEMA_NO` varchar(30) DEFAULT NULL COMMENT '������ȣ',
		//	  `ANALS_UNT` varchar(100) DEFAULT NULL COMMENT '�м�����',
		//	  `ANALS_PURPS` varchar(1000) DEFAULT NULL COMMENT '�м�����',
		//	  `DATA_SET` varchar(1000) DEFAULT NULL COMMENT '�����ͼ�',
		//	  `BGNG_DT` datetime DEFAULT NULL COMMENT '�����Ͻ�',
		//	  `END_DT` datetime DEFAULT NULL COMMENT '�����Ͻ�',
		//	  `ORIGIN_NM` varchar(100) DEFAULT NULL COMMENT '��ó��',
		//	  `MAIN_CN` varchar(1000) DEFAULT NULL COMMENT '�ֿ䳻��',
		//	  `KWRD` varchar(100) DEFAULT NULL COMMENT 'Ű����',
		//	  `ANALS_REPRT_URL` varchar(200) DEFAULT NULL COMMENT '�м�����URL',
		//	  `CHARGER_DEPT_NM` varchar(100) DEFAULT NULL COMMENT '����ںμ��̸�',
		//	  `CHARGER_TELNO` varchar(20) DEFAULT NULL COMMENT '�������ȭ��ȣ',
		//	  `PIC_NM` varchar(100) DEFAULT NULL COMMENT '����ڸ�',
		//	  `LICE` varchar(100) DEFAULT NULL COMMENT '���̼���',
		//	  `RLS_YN` char(1) DEFAULT NULL COMMENT '��������',
		//	  `REG_USER_ID` varchar(20) DEFAULT NULL COMMENT '��ϻ����ID',
		//	  `REG_DT` datetime DEFAULT NULL COMMENT '����Ͻ�',
		//	  `UPDT_USER_ID` varchar(20) DEFAULT NULL COMMENT '���Ż����ID',
		//	  `UPDT_DT` datetime DEFAULT NULL COMMENT '�����Ͻ�',
		//	  PRIMARY KEY (`CASE_SEQ`)
		//	) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='������Ȱ����';
		
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
				type += "�����Է�";
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
