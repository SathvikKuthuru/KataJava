class Solution {
	public static String rangeExtraction(int[] arr) {
		String s = "";
		int index1 = 0;
		int index2 = 1;
		if(arr.length == 0){
			return arr[0] + "";
		}
		while (index1 < arr.length && index2 < arr.length) {
			int count = 1;
			while(index2 < arr.length && arr[index2] - arr[index1] == count) {
				if(arr[index2] - arr[index1] == count) index2++;
				count++;
			}
			if(count > 1) index2--;
			if(index2 <= index1 + 1) {
				s += arr[index1] + ",";
				index1++;
				index2++;
				if(index2 == arr.length) s += arr[arr.length-1] + ",";
			}
			else {
				s += arr[index1] + "-" + arr[index2] + ",";
				index2+=2;
				index1 = index2-1;
				if(index2 == arr.length) s += arr[arr.length-1] + ",";
			}
		}
		return s.substring(0, s.length()-1);
	}
}
