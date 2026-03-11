import java.util.Stack;

class Solution {
    public int celebrity(int mat[][]) {
        int n = mat.length;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            st.push(i);
        }
        while(st.size() > 1) {
            int a = st.pop();
            int b = st.pop();
            if(mat[a][b] == 1) {
                if(mat[b][a]==0){
                    st.push(b);   
                }
            } else {
                if(mat[b][a]==1){
                    st.push(a);
                }
            }
        }
        int pc;
        if(!st.isEmpty()){
            pc=st.pop();
        }else{
            return -1;
        }
        for(int i = 0; i < n; i++) {
            if(i == pc) continue;
                if(mat[pc][i] != 0 || mat[i][pc] != 1) {
                    return -1;
                }
        }
        return pc;
    }
}
