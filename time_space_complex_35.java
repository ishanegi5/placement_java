public class time_space_complex_35 {
    public static void main(){
        /*
        O(n),O(log(n)),O(n^2) yeh sub TC and SC they 
        jo program mai time jyada lgta h and space jyada use hoti h wo km acha program hota h
        wahi jis program mai time and space km lage wo acha hota h comparitively 
        eg: ager koe code krne k liye humare pass time O(n^2) ka brute force approach hume pata tha but ab hume O(n) 
        approach bhi samajh aagyi h aur jyada deeply sochne se so isme konsi apprach better h time and space wise?
        obviously O(n) wala


        time complexity is a function of n where n is the input size of the program. bataungi one note pr 
        O(1) serach in arr for max element when it is sorted and O(n) linear time it takes when unsorted.


        time complexity mai ager unsorted array he h ek 6 elements ka h bs and ek 100 ka ek hazar ka and hum usme koe 
        number search kr re h toh kya hoga? 
        subme same he time complexity hogi chahe 6 element wala arr 2ms mai ho jaye and 100 wala 20ms and hazar wala 450ms mai
        but yeh time complexity ka mtlab dur dur tk ghadi k watch k time se ni hota 
        TC ka mtlab bs ek realtion h jo input size pr depend krta and wo badhega toh kya hoga for a particular algo
        like linear seach ager hum lagaye sorted ho ya unsorted ho array but yeh algo humesha O(n) TC deta h!


        O->Big O notation kehete h isse yeh hume upper bound deta h kisi bhi program ka toh isse worst case scenario m kitna 
        time complexity rahega yeh hume pata lg jata h basically,mtlab ager kisi algo ki TC O(n^2) hai toh yeh TC km ho skti h
        kabhi O(n^2) se like O(n) or O(log(n)) or O(1) but kabhi jyada ni ho skti like O(n^3) or O(2^n) etc because of O->Big O

        ab hum therotically TC nikalna sikhenge
        manlo we have a funcion: an^2 + bn + c
        ab isme har ek term (seperated by comma) mai se 
        1)ignore constants
        2)pick maximum
        so,
        n^2 + n + 1
        O(n^2)


        likewise: 2) an^3 + b(log(n)) + c
        n^3 + (log(n)) + 1
        O(n^3)


        //tip: interview m puchlenge ager koe question mai ki array ka size itna he hoga max manlo toh wo hint dete h
        ki 2^n wale recursion ho hum use kr skte h kisi na kisi tarike se

        space complexity: isme auxillary space aati h like mtlab extra space isme input m aane wale array ko ni count krte
        bs algo m ager koe sepearte array bna h ager like in merge sort then usse kehete h auxillary space.
        merge sort mai: SC:O(n)
        quick sort mai: SC: O(1) -> this is good in terms of space

        but time mai:
        merge sort mai: TC:O(nlog(n)) ->this is good in terms of time
        quick sort mai: TC: O(n^2)

        TC: work done=no. of recursive calls *work in each call
        SC= max depth*each level memory consumption


        Complete Complexity Cheat Sheet
Algorithm / Code	Time Complexity	     Space Complexity
Simple Loop	         O(n)	                O(1)
Nested Loop	         O(n²)	                O(1)
Nested Loop —        O(√n)		            O(1)
Nested Loop — i*=2	 O(n log n)	            O(1)
Bubble Sort Best	 O(n)	                O(1)
Bubble Sort Average	 O(n²)	                O(1)
Bubble Sort Worst	 O(n²)	                O(1)
Binary Search Iterative	O(log n)            O(1)
Factorial Recursion	  O(n)	                O(n)
Sum Recursion	      O(n)	                O(n)
Naive Fibonacci	      O(2ⁿ)	                O(n)
Merge Sort	         O(n log n)	            O(n)
Power 1	             O(n)	                O(n)
Power 2	             O(log n)	           O(log n)
Power 3	             O(log n)	           O(1)



Question : Find the Time Complexity of the following:
a)
a. int i, j, k = 0;
b. for (i = n / 2; i <= n; i++) {
c.  for (j = 2; j <= n; j = j * 2) {
d.      k = k + n / 2;
e.  }
f. }
A. O(n)
B. O(N log N)
C. O(n^2)
D. O(n^2Logn)
b)
for(int i=0;i<n;i++)
    i*=k
Here, k is some constant value
A. O(n)
B. O(k)
C. O(logkn) (= logn of base k)
D. O(lognk) (= logk of base n)
c)
Algorithm A and B have a worst-case running time of O(n) and O(logn), respectively. Therefore,
algorithm B always runs faster than algorithm A.
A. True
B. False
d) Find the time & space complexity of floorSqrt function in the following code to calculate
square root of a number :itsishanegi@gmail.com
class SqrtNum {
    static int floorSqrt(int x)
    {
        if (x == 0 || x == 1)
            return x;
        int i = 1, result = 1;
        while (result <= x) {
            i++;
            result = i * i;
        }
        return i - 1;
    }

    public static void main(String[] args)
    {
        int x = 11;
        System.out.print(floorSqrt(x));
    }
}
e) Find the time & space complexity of the following code:
int a = 0;
for (int i = 0; i < n; ++i) {
    for (int j = n; j > i; --j) {
        a = a + i + j;
    }
}
        */

    }
}
