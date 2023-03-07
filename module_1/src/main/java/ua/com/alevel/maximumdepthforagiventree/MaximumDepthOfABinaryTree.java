package ua.com.alevel.maximumdepthforagiventree;

import ua.com.alevel.EventProcessor;

import java.io.PrintStream;
import java.io.Reader;
import java.util.Scanner;

import static ua.com.alevel.maximumdepthforagiventree.Solution.maxDepth;

public class MaximumDepthOfABinaryTree implements EventProcessor {
    @Override
    public void process(final Reader reader, PrintStream writer) {

        Scanner str = new Scanner(System.in);

        TreeNode p = new TreeNode(5);
        p.left = new TreeNode(4);
        p.right = new TreeNode(6);
        p.left.left = new TreeNode(1);
        p.left.left.left = new TreeNode(0);
        p.left.right = new TreeNode(3);
        p.right.left = new TreeNode(7);
        p.right.right = new TreeNode(12);


        writer.println("Max depth is" + maxDepth(p));


    }
}


