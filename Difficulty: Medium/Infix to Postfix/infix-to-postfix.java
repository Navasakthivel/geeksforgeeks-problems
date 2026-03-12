class Solution {
    public static String infixToPostfix(String s) {
        Stack<Character> st = new Stack<>();
        Map<Character,Integer> prio = new HashMap<>();
        prio.put('^',3);
        prio.put('*',2);
        prio.put('/',2);
        prio.put('+',1);
        prio.put('-',1);
        StringBuilder result = new StringBuilder();
        for(char c : s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                result.append(c);
            }
            else if(c == '('){
                st.push(c);
            }
            else if(c == ')'){
                while(!st.isEmpty() && st.peek()!='('){
                    result.append(st.pop());
                }
                st.pop();
            }
            else{
                while(!st.isEmpty() && st.peek()!='(') {
                    char top = st.peek();
                    if(prio.get(top) > prio.get(c)) {
                        result.append(st.pop());
                        
                    }
                    else if(prio.get(top) == prio.get(c) && c != '^') {
                        result.append(st.pop());
                        
                    }
                    else {
                        break;
                        
                    }
                    
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            result.append(st.pop());
        }
        return result.toString();
    }
}