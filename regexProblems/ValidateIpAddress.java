package org.example.regexProblems;

import java.util.regex.*;

public class ValidateIpAddress {
    public static void main(String[] args) {
        String[] testIPs = {
                "192.168.1.1",   // Valid
                "255.255.255.255", // Valid
                "256.100.50.25",  // Invalid (256 out of range)
                "192.168.1",      // Invalid (only 3 groups)
                "192.168.1.999",  // Invalid (999 out of range)
                "192.168..1",     // Invalid (missing number)
                "abc.def.ghi.jkl" // Invalid (not numbers)
        };

        for (String ip : testIPs) {
            System.out.println(ip + " → " + (isValidIPv4(ip) ? "Valid" : "Invalid"));
        }
    }

    public static boolean isValidIPv4(String ip) {
        String ipv4Pattern = "^(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\."  // First part (0-255)
                + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." // Second part (0-255)
                + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\." // Third part (0-255)
                + "(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$"; // Fourth part (0-255)

        return ip.matches(ipv4Pattern);
    }
}
