/*
Insurance Policy Management System

Build a system for managing insurance policies where you have to:
Store and manage policies with unique identifiers.
Retrieve and manipulate policies based on different criteria.
Track policies by various attributes such as policyholder name and expiry date.

Requirements:
1. Store Policies in a Map:
Use HashMap to store policies with policy numbers as keys and policy
details as values.
Use LinkedHashMap to maintain the insertion order of policies.
Use TreeMap to store policies sorted by expiry date.

2. Retrieve and Manipulate Policies:
Implement methods to:
Retrieve a policy by its number.
List all policies expiring within the next 30 days.
List all policies for a specific policyholder.
Remove policies that are expired.
 */

package org.example.Management;

import java.time.LocalDate;
import java.util.*;

public class InsurancePolicyManagement {
    public static void main(String[] args) {
        InsurancePolicyManager manager = new InsurancePolicyManager();

        // Adding policies
        manager.addPolicy(new Policy("P101", "Nisha", LocalDate.of(2024, 5, 20)));
        manager.addPolicy(new Policy("P102", "Ajay", LocalDate.of(2024, 6, 10)));
        manager.addPolicy(new Policy("P103", "suraj", LocalDate.of(2024, 4, 15))); // Expired
        manager.addPolicy(new Policy("P104", "vivek", LocalDate.of(2024, 5, 25)));

        // fetching a policy
        System.out.println("Policy P101 details: " + manager.getPolicyByNumber("P101"));

        // Listing policies expiring in the next 30 days
        System.out.println("Policies expiring in the next 30 days:");
        for (Policy policy : manager.getPoliciesExpiringSoon()) {
            System.out.println(policy);
        }

        // Listing policies for a specific policyholder
        System.out.println("Policies for John Doe:");
        for (Policy policy : manager.getPoliciesByHolder("John Doe")) {
            System.out.println(policy);
        }

        // Removing expired policies
        System.out.println("Removing expired policies...");
        manager.removeExpiredPolicies();

        // Displaying all policies in insertion order
        System.out.println("Policies after removing expired ones (in insertion order):");
        manager.displayPoliciesInInsertionOrder();
    }
}

class InsurancePolicyManager {
    private Map<String, Policy> policyMap = new HashMap<>();
    private final LinkedHashMap<String, Policy> linkedPolicyMap = new LinkedHashMap<>();
    private TreeMap<LocalDate, List<Policy>> expiryPolicyMap = new TreeMap<>();

    // Adding a policy
    public void addPolicy(Policy policy) {
        policyMap.put(policy.getPolicyNumber(), policy);
        linkedPolicyMap.put(policy.getPolicyNumber(), policy);

        // Storing in TreeMap based on expiry date
        expiryPolicyMap.computeIfAbsent(policy.getExpiryDate(), k -> new ArrayList<>()).add(policy);
    }

    // Retrieveing policy by policy number
    public Policy getPolicyByNumber(String policyNumber) {
        return policyMap.get(policyNumber);
    }

    // Listing all policies expiring in the next 30 days
    public List<Policy> getPoliciesExpiringSoon() {
        List<Policy> expiringSoon = new ArrayList<>();
        LocalDate today = LocalDate.now();
        LocalDate thresholdDate = today.plusDays(30);

        for (Map.Entry<LocalDate, List<Policy>> entry : expiryPolicyMap.entrySet()) {
            if (!entry.getKey().isAfter(thresholdDate)) {
                expiringSoon.addAll(entry.getValue());
            }
        }
        return expiringSoon;
    }

    // Listing all policies for a specific policyholder
    public List<Policy> getPoliciesByHolder(String policyHolderName) {
        List<Policy> holderPolicies = new ArrayList<>();
        for (Policy policy : policyMap.values()) {
            if (policy.getPolicyHolderName().equalsIgnoreCase(policyHolderName)) {
                holderPolicies.add(policy);
            }
        }
        return holderPolicies;
    }

    // Removing expired policies
    public void removeExpiredPolicies() {
        LocalDate today = LocalDate.now();
        Iterator<Map.Entry<LocalDate, List<Policy>>> iterator = expiryPolicyMap.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<LocalDate, List<Policy>> entry = iterator.next();
            if (entry.getKey().isBefore(today)) {
                for (Policy policy : entry.getValue()) {
                    policyMap.remove(policy.getPolicyNumber());
                    linkedPolicyMap.remove(policy.getPolicyNumber());
                }
                iterator.remove();
            }
        }
    }
    public void displayPoliciesInInsertionOrder() {
        for (Policy policy : linkedPolicyMap.values()) {
            System.out.println(policy);
        }
    }
}

class Policy {
    private String policyNumber;
    private String policyHolderName;
    private LocalDate expiryDate;

    public Policy(String policyNumber, String policyHolderName, LocalDate expiryDate) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public String getPolicyHolderName() {
        return policyHolderName;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "Policy Number='" + policyNumber + '\'' +
                ", Policy Holder='" + policyHolderName + '\'' +
                ", Expiry Date=" + expiryDate +
                '}';
    }
}