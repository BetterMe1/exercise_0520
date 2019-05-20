package exercise.exercise_0520;

/*
给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。

按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：

"123"
"132"
"213"
"231"
"312"
"321"
给定 n 和 k，返回第 k 个排列。
说明：

给定 n 的范围是 [1, 9]。
给定 k 的范围是[1,  n!]。
示例 1:
输入: n = 3, k = 3
输出: "213"
示例 2:
输入: n = 4, k = 9
输出: "2314"
 */

/*
分析：
可以使用全排列回溯到第k个排列返回，但是时间会很慢。
由于集合是1...n的数字，所以可以推出来第k个排列，以下对于n=4，k=15推出第15个全排列。
k从0开始，所以开始计算时k--; 以下index代表计算出寻找的数字在排列中的索引。

确定第一位：
index = k / （n-1）! = 2；（①中索引为2的数为3），第15个数的第一位是3；
k -= index *（n-1）!  = 2    (更新k的值)

确定第二位：
index = k / （n-2）! = 1；（②中索引为1的数为2），第15个数的第二位是2；
k -= index *（n-2）! = 0     (更新k的值)

确定第三位：
index = k / （n-2）! = 0；（③中索引为0的数为1），第15个数的第三位是1；
k -= index *（n-2）! = 0     (更新k的值)

确定第四位：
index = k / （n-2）! = 0；（④中索引为0的数为4），第15个数的第四位是4；

返回字符串"3214"
 */
import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] factorials = new int[n+1];//阶乘数
        List<Integer> candidates = new ArrayList<>();//剩余待选择的数
        factorials[0]=1;
        int d = 1;
        for(int i=1; i<=n; i++){
            candidates.add(i);
            d *= i;
            factorials[i]= d;
        }
        k--;
        for(int j=n-1; j>=0; j--){
            int index = k / factorials[j];
            sb.append(candidates.remove(index));
            k -= index*factorials[j];
        }
        return sb.toString();
    }
}


