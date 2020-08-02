package Algorithms;

import java.util.Arrays;

public class CountingSort extends Sort{
	final static int categoryMax = 5;
	final static int categoryMin = 1;  
	static int[] categoryArr;
	
	CountingSort(int[] data){
		super(data);
	}
	
	CountingSort(int lenOfArr){
		super(lenOfArr);
	}
	
	@Override
	void sort() {
		// category �ʱ�ȭ
		/*
		 * ������ ����̱� ������, ���� ��� 11~20�̶��
		 * 1~10�� 0���� �ʱ��U�ǰ� �̻��ȴ�.
		 * �������⵵�� ���� �Ű澲�� �ʴ´ٰ� �����ϸ�.. �̷��� ¥����.. �������̰� ���� �� ����.
		 */
		categoryArr = new int[categoryMax + 1];
		
		// val�� index, Ű���� �ƴ� value���̾�.
		for(int val : data) {
			for(int cnt = categoryMin ; cnt <= categoryMax ; cnt++) {
				if(val == cnt) {
					categoryArr[cnt]++;
					cnt_Swap++;
					continue;
				}
			}
		}
		
//		int[] result =  new int[categoryMax - categoryMin + 1];
//		result = Arrays.copyOfRange(data, categoryMin, categoryMax + 1);
		
		int[] result = new int[data.length];
		
		int i=0;
		for(int cnt = categoryMin ; cnt <= categoryMax ; cnt++) {
			for(int c=1 ; c <= categoryArr[cnt] ; c++) {
				result[i++] = cnt;
			}
		}
		data = result;
	}
	
	void testSortSpec(int trials) {
		System.out.println("Counting Sort");
		super.testSortSpec(trials, arrSize);
	}
}
