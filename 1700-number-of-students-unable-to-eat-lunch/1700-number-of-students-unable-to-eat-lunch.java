class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        // int circleSandwiches = 0;
        // int squareSandwiches = 0;

        // for(int choice : students){
        //     if(choice == 0){
        //         circleSandwiches++;
        //     }else{
        //         squareSandwiches++;
        //     }
        // }
        // for(int sandwiche : sandwiches){
        //     if(sandwiche == 0 && circleSandwiches == 0){
        //         return squareSandwiches;
        //     }
        //     if(sandwiche ==1 && squareSandwiches == 0){
        //         return circleSandwiches;
        //     }
        //     if(sandwiche == 0){
        //         circleSandwiches--;
        //     }
        //     else{
        //         squareSandwiches--;
        //     }
        // }
        // return 0;

        Queue<Integer> q = new LinkedList<>();
        for(int student : students){
            q.offer(student);
        }
        int i =0;
        int count = 0;

        while(!q.isEmpty() && count<q.size()){
            if(q.peek() == sandwiches[i]){
                q.poll();
                i++;
                count = 0;
            }
            else{
                q.offer(q.poll());
                count++;
            }
        }
        return q.size();
    }
}