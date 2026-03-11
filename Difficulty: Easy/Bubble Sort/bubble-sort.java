class Solution {
    public void bubbleSort(int[] arr) {
        // code here
        int length = arr.length;
        for(int i = 0 ;i < length;i++){
            boolean swap = false;
            for(int j = 0 ;j < length-i-1 ; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            if(!swap){
                break;
            }
        }
    }
}