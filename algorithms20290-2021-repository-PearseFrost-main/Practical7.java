public class Practical7 {
    public static int bruteForce(String txt, String pat) {//
        int n = txt.length();//Length of txt string
        int m = pat.length();//Length of pat string

        for (int pos = 0; pos <= n - m; pos++) {//For loop runs until pos becomes greater than n-m
            int i = 0;
            while ((i < m) && (txt.charAt(pos + i) == pat.charAt(i))) {//I is increments as long as while statement is true
                i++;
            }
            if (i == m) {
                return pos;//Returns index of pattern
            }
        }
        return -1;
    }
    public void knuthMorris(String pat,String txt){
        int M=pat.length();//Length of pat string
        int N=txt.length();//Length of txt string

        int lps[]=new int[M];//lps[]holds longest prefix suffix values for pattern
        int indexPat=0;//Index for pat

        computeLPSArray(pat,M,lps);//Calls this method to compute lps array

        int indexTxt=0;//Index for txt

        while(indexTxt<N){//while the index for txt is less than the length of txt
            if(pat.charAt(indexPat)==txt.charAt(indexTxt)){////Increments both indexes if the characters are equal
                indexPat++;
                indexTxt++;
            }
            if (indexPat==M){//if pattern is found prints the index at where the pattern is
                System.out.println("Pattern at index: "+(indexPat-indexTxt));
                indexPat=lps[indexPat-1];
            }
            else if(indexTxt<N && pat.charAt(indexPat)!=txt.charAt(indexTxt)){//else if they are not equal
                if(indexPat!=0) {//If pattern index is not equal 0
                    indexPat = lps[indexPat - 1];
                }
                    else{
                        indexTxt=indexTxt+1;
                    }
                }
            }

        }

        public static void computeLPSArray(String pat,int M,int lps[]){
        int length=0;//Length of previous longest prefix suffix
        int index=1;
        lps[0]=0;

        while(index<M){
            if(pat.charAt(index)==pat.charAt(length)){
                length++;
                lps[index]=length;
                index++;
            }
            else if(length!=0){
                    length=lps[length-1];
                }
            else{
                lps[index]=length;
                index++;
            }
        }

    }

    public static void main(String[] args) {
        String txt = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String pat = "ASDFGHJKL";
        new Practical7().knuthMorris(pat, txt);
    }
}

