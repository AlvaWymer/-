


/******
 * 快速排序
 * 
 * 分治思想
 * fenshishanchu
 * 
 * 设要排序的数组是A[0]⋯⋯A[N-1]，首先任意选取一个数据（通常选用第1个数据）作为关键数据，
 * 然后将所有比它小的数都放到它前面，所有比它大的数都放到它后面，
 * 这个过程称为一趟快速排序。值得注意的是，快速排序不是一种稳定的排序算法，
 * 也就是说，多个相同的值的相对位置也许会在算法结束时产生变动。
一趟快速排序的算法是：
1）设置两个变量i、j，排序开始的时候：i=0，j=N-1；
2）以第一个数组元素作为关键数据，赋值给key，即key=A[0]；
3）从j开始向前搜索，即由后开始向前搜索（j -- ），找到第一个小于key的值A[j]，A[i]与A[j]交换；
4）从i开始向后搜索，即由前开始向后搜索（i ++ ），找到第一个大于key的A[i]，A[i]与A[j]交换；
5）重复第3、4、5步，直到 I=J； (3,4步是在程序中没找到时候j=j-1，i=i+1，直至找到为止。找到并交换的时候i，
 j指针位置不变。另外当i=j这过程一定正好是i+或j-完成的最后令循环结束。
 * 
 * **/
public class QuickSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int n = 10;
		int[] a = new int[n];
		for(int i = 0; i < a.length; i++)
			a[i] = (int)(Math.random() * 100);
		disp(a);
		sort(a, 0, a.length - 1);
		disp(a);
        System.out.println("yagnaihua "); System.out.println("yagnaihua好的话的反对 ");
	}

	private static void sort(int[] a, int left, int right) {		//分为两部分，一个是左部分，一个是右部分
		if (left >= right) return;
		
		int i = left, j = right + 1;
		while(true){
			do{
				i++;
			}while(i <= right && a[i] < a[left]);
			do{
				j--;
			}while(a[j] > a[left]);
			
			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, j, left);
		
		sort(a, left, j - 1);
		sort(a, j + 1, right);
	}
	
	private static void swap(int[] a, int i, int j) {
		int tem = a[i];
		a[i] = a[j];
		a[j] = tem;
	}

	private static void disp(int[] a) {
		for(int i = 0; i < a.length; i++)
			System.out.printf("%d ", a[i]);
		System.out.println();
	}

}
