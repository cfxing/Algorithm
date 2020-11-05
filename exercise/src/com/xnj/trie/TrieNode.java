package com.xnj.trie;

/**
 * @author chen xuanyi
 * @Date 2020/5/13 16:33
 */
public class TrieNode {
    public TrieNode[] nexts;
    public int path;
    public int end;

    public TrieNode() {
        path = 0;
        end = 0;
        nexts = new TrieNode[26];
    }
}
