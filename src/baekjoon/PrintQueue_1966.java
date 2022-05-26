package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class PrintQueue_1966 {

	public static void main(String[] args) throws NumberFormatException, IOException  {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int totalCaseCount = 0;
		int documentCount = 0;
		int printDocumentNum = 0;
		String [] result = new String[2];
		
		totalCaseCount = Integer.valueOf(br.readLine());
		for(int i=0; i<totalCaseCount; i++) {
			result = br.readLine().split(" ");
			documentCount = Integer.valueOf(result[0]);
			printDocumentNum = Integer.valueOf(result[1]);
			
			String [] documents = new String[documentCount];
			Queue<Document> printQueue = new LinkedList<Document>();
			documents = br.readLine().split(" ");
			
			for(int j=0; j<documentCount;j++) {
				printQueue.add(new Document(Integer.valueOf(documents[j]), j));
			}
			Boolean printFlag = true; 
			int printCount = 0;
			while(true) {
				Document currenPrint =  printQueue.poll();
				Iterator<Document> iterator = printQueue.iterator();
				while(iterator.hasNext()) {
					if(currenPrint.getPriority() < iterator.next().getPriority()) {
						printFlag = false;
					}
				}
				if(printFlag) {
					printCount++;
					if(printDocumentNum == currenPrint.getDocumentSeq()) {
						sb.append(printCount + "\n");
						break;
					}
				} else {
					printQueue.offer(currenPrint);
					printFlag = true;
				}
			}
		}
		System.out.print(sb);
	}
}
class Document {
	private int priority, documentSeq;
	Document(int priority, int documentSeq){
		this.priority = priority;
		this.documentSeq = documentSeq;
	}
	public int getPriority() {
		return priority;
	}
	public int getDocumentSeq() {
		return documentSeq;
	}
}
