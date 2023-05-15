package com.programmers;

class L2_스킬트리 {
    public static int solution(String skill, String[] skill_trees) {
        int answer = 0;
        for(int i=0; i< skill_trees.length; i++){
            if(isAble(skill, skill_trees[i])) answer++;
        }
        return answer;
    }

    private static boolean isAble(String skill, String skill_tree) {
        int pre = Integer.MAX_VALUE;
        boolean isExist = false;
        for(int i=skill.length()-1; i>=0; i--){
            if (skill_tree.contains(skill.charAt(i)+"")){
                isExist = true;

                if(skill_tree.indexOf(skill.charAt(i)+"") < pre){
                    pre = skill_tree.indexOf(skill.charAt(i)+"");
                }else{
                    return false;
                }
            }else{
                if(isExist){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(solution(skill, skill_trees));
    }
}