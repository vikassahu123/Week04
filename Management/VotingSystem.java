
/*
Design a Voting System
Description: Design a system where:
Votes are stored in a HashMap (Candidate -> Votes).
TreeMap is used to display the results in sorted order.
LinkedHashMap is used to maintain the order of votes.
*/

package org.example.Management;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.LinkedHashMap;


public class VotingSystem {
    public static void main(String[] args) {
        VotingOperations1 ope = new VotingOperations1();
        ope.vote("Alice");
        ope.vote("Bob");
        ope.vote("Alice");

        VoteDisplay1.displayResults(ope.getVoteMap());
    }
}


class VoteDisplay {
    //method to displaty the votes
    public static void displayResults(HashMap<String, Integer> voteMap) {
        TreeMap<String, Integer> sortedVotes = new TreeMap<>(voteMap);

        System.out.println("Election Results:");
        for (Map.Entry<String, Integer> entry : sortedVotes.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}


class VotingOperations {
    // Stores candidate votes
    private HashMap<String, Integer> voteMap;
    // Maintains vote order
    private LinkedHashMap<String, Integer> voteOrder;

    public VotingOperations() {
        voteMap = new HashMap<>();
        voteOrder = new LinkedHashMap<>();
    }

    public void vote(String candidate) {
        voteMap.put(candidate, voteMap.getOrDefault(candidate, 0) + 1);
        voteOrder.put(candidate, voteMap.get(candidate));
    }
    //method to display get voting map
    public HashMap<String, Integer> getVoteMap() {
        return voteMap;
    }
    //method to get voting order
    public LinkedHashMap<String, Integer> getVoteOrder() {
        return voteOrder;
    }
}
