//IntelliJ licensed to Harshit Chaurasia
public class MergeSortAnalytics
{
    void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        int i = 0, j = 0;

        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int m = (l+r)/2;

            sort(arr, l, m);
            sort(arr , m+1, r);

            merge(arr, l, m, r);
        }
    }
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }


    public static void main(String args[])
    {

        runSample(new int[]{10,9,8,7,6,5,1});
        runSample(new int[]{5,8,7,3,1,2,5,4});
        runSample(new int[]{8,9,5,2,4,8});
        runSample(new int[]{5,4,6,5,8,1,2});

        runSample(new int[]{10,9,8,7,6,5,1,10,9,8,7,6,5,1});
        runSample(new int[]{5,8,7,3,1,2,5,4,5,8,7,3,1,2,5,4});
        runSample(new int[]{8,9,5,2,4,8,8,9,5,2,4,8});
        runSample(new int[]{5,4,6,5,8,1,2,5,4,6,5,8,1,2});

    }
    static void runSample(int arr[])
    { long st=0,end=0;
      //  System.out.println("Before Sorting");
      //  printArray(arr);

        st=System.nanoTime();
        MergeSortAnalytics ob = new MergeSortAnalytics();
        ob.sort(arr, 0, arr.length-1);
        end=System.nanoTime();

       // System.out.println("After Soring");
      //  printArray(arr);
        end-=st;
        System.out.println(end);
    }
}

