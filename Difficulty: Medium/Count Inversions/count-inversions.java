class Solution {
    public static int merge(int[] arr,int left,int mid,int right){
        int n1 = mid - left +1;
        int n2 = right - mid;
        int[] l = new int[n1];
        int[] r = new int[n2];

        for(int i=0;i<n1;i++){
            l[i] = arr[left+i];
        }
        for(int j = 0;j < n2;j++){
            r[j] = arr[mid+1+j];
        }
        int i = 0 , j = 0, k = left,invCount = 0;
        while (i<n1 && j<n2){
            if(l[i]<=r[j]){
                arr[k++] = l[i++];
            }
            else{
                invCount += n1-i;
                arr[k++] = r[j++];
            }
        }
        while (i<n1){
            arr[k++] = l[i++];
        }
        while (j<n2){
            arr[k++] = r[j++];
        }
        return invCount;
    }
    static int mergeSort(int arr[] ,int left,int right){
        int mid,invCount = 0 ;
        if(left<right){
            mid = (left+right)/2;
            invCount += mergeSort(arr,left,mid);
            invCount += mergeSort(arr,mid+1,right);
            invCount += merge(arr,left,mid,right);
        }
        return invCount;
    }
    static int inversionCount(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }

}