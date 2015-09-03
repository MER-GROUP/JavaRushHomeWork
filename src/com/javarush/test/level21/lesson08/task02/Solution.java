package com.javarush.test.level21.lesson08.task02;

import java.util.ArrayList;

/* Клонирование
Класс Plant не должен реализовывать интерфейс Cloneable
Реализуйте механизм глубокого клонирования для Tree.
*/
public class Solution {
    public static void main(String[] args) {
        Tree tree = new Tree("willow", new String[]{"s1", "s2", "s3", "s4"});
        Tree clone = null;
        try {
            clone = tree.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println(tree);
        System.out.println(clone);

        System.out.println(tree.branches);
        System.out.println(clone.branches);

        //test
        for (String s:tree.branches) System.out.print(s + " ");
        System.out.println();
        for (String s:clone.branches) System.out.print(s + " ");
        System.out.println();
    }

    public static class Plant{
        private String name;

        public Plant(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class Tree extends Plant {
        private String[] branches;

        public Tree(String name, String[] branches) {
            super(name);
            this.branches = branches;
        }

        public String[] getBranches() {
            return branches;
        }

        @Override
        protected Tree clone() throws CloneNotSupportedException {
            /*String name=this.getName();
            String[] array=new String[this.getBranches().length];
            Tree tree=null;

            if (this.branches!=null){
                tree=new Tree(name,array);
                for (int i = 0; i < this.getBranches().length; i++) {
                    tree.branches[i]=this.getBranches()[i];
                }
            }
            else tree=new Tree(name,null);

            return tree;*/

            if (this.getBranches() != null)
                return new Tree (this.getName(), this.getBranches().clone());
            else
                return new Tree (this.getName(), null);

            /*Tree newSolution = null;
            if (branches!=null)
            {
                ArrayList<String> branchesCopy = new ArrayList<>();
                for (String branch : branches)
                    branchesCopy.add(new String(branch));
                newSolution = new Tree(new String(getName()), branchesCopy.toArray(new String[branchesCopy.size()]));
            }
            else
                newSolution = new Tree(new String(getName()),null);

            return newSolution;*/
        }
    }
}
