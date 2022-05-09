package programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
/*문제 설명
추석 트래픽
이번 추석에도 시스템 장애가 없는 명절을 보내고 싶은 어피치는 서버를 증설해야 할지 고민이다. 장애 대비용 서버 증설 여부를 결정하기 위해 작년 추석 기간인 9월 15일 로그 데이터를 분석한 후 초당 최대 처리량을 계산해보기로 했다. 초당 최대 처리량은 요청의 응답 완료 여부에 관계없이 임의 시간부터 1초(=1,000밀리초)간 처리하는 요청의 최대 개수를 의미한다.

입력 형식
solution 함수에 전달되는 lines 배열은 N(1 ≦ N ≦ 2,000)개의 로그 문자열로 되어 있으며, 각 로그 문자열마다 요청에 대한 응답완료시간 S와 처리시간 T가 공백으로 구분되어 있다.
응답완료시간 S는 작년 추석인 2016년 9월 15일만 포함하여 고정 길이 2016-09-15 hh:mm:ss.sss 형식으로 되어 있다.
처리시간 T는 0.1s, 0.312s, 2s 와 같이 최대 소수점 셋째 자리까지 기록하며 뒤에는 초 단위를 의미하는 s로 끝난다.
예를 들어, 로그 문자열 2016-09-15 03:10:33.020 0.011s은 "2016년 9월 15일 오전 3시 10분 33.010초"부터 "2016년 9월 15일 오전 3시 10분 33.020초"까지 "0.011초" 동안 처리된 요청을 의미한다. (처리시간은 시작시간과 끝시간을 포함)
서버에는 타임아웃이 3초로 적용되어 있기 때문에 처리시간은 0.001 ≦ T ≦ 3.000이다.
lines 배열은 응답완료시간 S를 기준으로 오름차순 정렬되어 있다.
출력 형식
solution 함수에서는 로그 데이터 lines 배열에 대해 초당 최대 처리량을 리턴한다.
입출력 예제
예제1
입력: [
"2016-09-15 01:00:04.001 2.0s",
"2016-09-15 01:00:07.000 2s"
]

출력: 1

예제2
입력: [
"2016-09-15 01:00:04.002 2.0s",
"2016-09-15 01:00:07.000 2s"
]

출력: 2

설명: 처리시간은 시작시간과 끝시간을 포함하므로
첫 번째 로그는 01:00:02.003 ~ 01:00:04.002에서 2초 동안 처리되었으며,
두 번째 로그는 01:00:05.001 ~ 01:00:07.000에서 2초 동안 처리된다.
따라서, 첫 번째 로그가 끝나는 시점과 두 번째 로그가 시작하는 시점의 구간인 01:00:04.002 ~ 01:00:05.001 1초 동안 최대 2개가 된다.

예제3
입력: [
"2016-09-15 20:59:57.421 0.351s",
"2016-09-15 20:59:58.233 1.181s",
"2016-09-15 20:59:58.299 0.8s",
"2016-09-15 20:59:58.688 1.041s",
"2016-09-15 20:59:59.591 1.412s",
"2016-09-15 21:00:00.464 1.466s",
"2016-09-15 21:00:00.741 1.581s",
"2016-09-15 21:00:00.748 2.31s",
"2016-09-15 21:00:00.966 0.381s",
"2016-09-15 21:00:02.066 2.62s"
]

출력: 7

설명: 아래 타임라인 그림에서 빨간색으로 표시된 1초 각 구간의 처리량을 구해보면 (1)은 4개, (2)는 7개, (3)는 2개임을 알 수 있다. 따라서 초당 최대 처리량은 7이 되며, 동일한 최대 처리량을 갖는 1초 구간은 여러 개 존재할 수 있으므로 이 문제에서는 구간이 아닌 개수만 출력한다.*/
public class ThanksgivingDayTraffic {
	public static void main(String[] args) throws ParseException {
		String standardStartTime="2016-09-15 00:00:00.000";
		String standardEndTime="2016-09-16 00:00:00.000";
		
		int result = 0;
		int resultBox=0;
		int index = 0;
		
		String[] lines = new String[4];
		
		int processingTime; 
		final int aryLenth = lines.length;
		
		Date[] startTimes = new Date[aryLenth];
		Date[] endTimes = new Date[aryLenth];

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		
		//요청 시간을 구하기 위한 번수
		Calendar calStartTime = Calendar.getInstance();
		
		//초당 처리량을 계산하기 위해 기준이 되는 1초의 시작시간
		Calendar calStampTime = Calendar.getInstance();
		//초당 처리량을 계산하기 위해 기준이 되는 1초의 종료
		Calendar calStampEndTime = Calendar.getInstance();
		
		//처리중 플래그 배열
		Boolean [] processingFlags = new Boolean[aryLenth];
		
		
		calStampEndTime.setTime(calStampTime.getTime());
		
		//요청 시작시간 구하기
		for(int i=0; i<aryLenth; i++) {
			endTimes[i] = simpleDateFormat.parse(lines[i].split(" ")[0] + " " + lines[i].split(" ")[1]);
			
			processingTime = (int) ((Double.parseDouble(lines[i].split(" ")[2].substring(0, lines[i].split(" ")[2].length()-1)) - 0.001) * 1000);
			
			calStartTime.setTime(endTimes[i]);
			
			calStartTime.add(Calendar.MILLISECOND, -processingTime);
			
			startTimes[i] = calStartTime.getTime();
		}
		
		calStampTime.setTime(startTimes[0]);
		while(true){
			resultBox=0;
			calStampTime.add(Calendar.MILLISECOND, index);
			
			//플래그 초기화
			for(int i=0; i<aryLenth; i++) {
				processingFlags[i] = false;
			}
			
			//1초동안 처리가 있었던 개수 파악
			for(int j = index; j<=index + 999; index ++) {
				for(int i=0; i<aryLenth; i++) {
					calStampTime.add(Calendar.MILLISECOND, j);
					//만약 calStampTime이 요청 시작시간과 요청 종료시간의 사이일 때 true
					if((calStampTime.getTime().equals(startTimes[i]) || calStampTime.getTime().after(startTimes[i])) && (calStampTime.getTime().equals(endTimes[i]) || calStampTime.getTime().before(endTimes[i]))) {
						processingFlags[i] = true;
					}
				}
			}
			for(int i=0; i<aryLenth; i++) {
				if(processingFlags[i])
				resultBox++;
			}
			
			if(resultBox>result) {
				result = resultBox;
			}
			
			if(calStampTime.getTime().after(endTimes[aryLenth-1])) {
				break;
			}
			index++;
		}
		
//		SimpleDateFormat startTime =  new SimpleDateFormat("hh:mm:ss");
//		SimpleDateFormat simpleFormat =  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
//		
//		Date date = new Date();
//		
//		Date date2 = new Date();
//		
//		Date date3 = new Date();
//		double num = 2.555;
//		date = simpleFormat.parse("2016-09-15 21:00:02.000");
//		
//		date2 = simpleFormat.parse("2016-09-15 21:00:02.099");
//		
//		date3 = simpleFormat.parse("2016-09-15 21:00:02.097");
//		Calendar cal1 = Calendar.getInstance();
//		
//		cal1.setTime(date);
//		
//		cal1.add(Calendar.MILLISECOND, 999);
//		
//		date2 = cal1.getTime();
//		System.out.println("endTime : " + simpleFormat.format(date));
//		
//		System.out.println("startTime : " +simpleFormat.format(cal1.getTime()));
//		
//		if(date.before(date2)) {
//			System.out.println("date가 더 작다");
//			
//		}
//		if(date2.before(date)) {
//			System.out.println("date2가 더 작다");
//		}
//		
//		if(date3.before(date2)) {
//			System.out.println("date3이 date2보다 작다");
//		}
//		
//		if(date3.before(date)) {
//			System.out.println("date3이 date보다 작다");
//		}
//		
//		if(date2.before(date3)) {
//			System.out.println("date2가 date3보다 작다");
//		}
//		
//		//System.out.println(date);
//		//응답시간
//		Date [] startTimes = new Date[3];
//		//완료시간
//		Date [] endTimes = new Date[3];
//		System.out.println(startTime.format(date));
	}

	
}
