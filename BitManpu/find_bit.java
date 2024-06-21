public class find_bit {
    public static void main(String[] args) {
        int[] arr1={1,2,3};
        int[] arr2={4,5,6};
        int j=0;
       // int[] arr1=new arr1[arr1.length+arr2.length];
        for (int i=arr1.length;i<arr1.length+arr2.length;i++){
            arr1[i]=arr2[j];
            i++;
        }
        for(int i=0;i<arr1.length+arr2.length;i++){
            System.out.println(arr1[i]);
        }
    }
    
}
