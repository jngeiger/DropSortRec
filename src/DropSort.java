import java.sql.SQLOutput;
import java.util.Arrays;

public class DropSort {
    public static void main(String[] args)
    {
            int[] array = {1,2,5,4,3,7};
            DropSort ds = new DropSort();
            array = ds.dropSort(array);
            System.out.println(Arrays.toString(array));
    }

    public int[] dropSort(int[] array)
    {
        int[] result = new int[array.length];
        int resultIdx = 0;
        result[0] = array[0];
        resultIdx = dropSortRec(result,array,1,array.length-1,resultIdx);
        int[] newResult = new int[resultIdx+1];
        _finalizeArray(result,newResult,0,resultIdx);
        return newResult;
    }

    public int dropSortRec(int[] result, int[] array,int l, int r,int resultIdx)
    {
        if (l > r)
        {
            return resultIdx;
        }
        if (array[l] < result[resultIdx])
        {
            return dropSortRec(result,array,++l,r,resultIdx);
        }
        else {
            result[++resultIdx] = array[l];
            return dropSortRec(result,array,++l,r,resultIdx);
        }
    }
    private void _finalizeArray(int[] result, int[] cleanedResult,int l,int r)
    {
        if (l > r)
        return;
        else {
            cleanedResult[l] = result[l];
            _finalizeArray(result,cleanedResult,++l,r);
        }
    }
}
