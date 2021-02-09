import java.util.*;

class Node {
    public double start;
    public double end;
    
    Node(double start, double end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    static List<Node> nodes = new ArrayList<>();
    static int max = 0;
    
    public int solution(String[] lines) {
        
        for(String str: lines) {
            String time = str.substring(11,23);
            String[] parse = time.split(":");
            
            double hour = Double.parseDouble(parse[0]);
            double minute = Double.parseDouble(parse[1]);
            double second = Double.parseDouble(parse[2]);
            
            double run = Double.parseDouble(str.substring(24, str.length()-1));
            double end = hour*3600 + minute*60 + second;
            double start = Double.parseDouble(String.format("%.3f",(end-run + 0.001)));
            
            nodes.add(new Node(start, end));
        }
        
        for(Node node: nodes) { 
            count(node.start);
            count(node.end);
        }
        
        return max;
    }
    
    private void count(double segStart) {
        double segEnd = Double.parseDouble(String.format("%.3f", segStart + 0.999));
        int cnt = 0;
        
        for(Node node: nodes) {
            /*
            if((segStart <= node.start && node.start <= segEnd) ||
               (segStart <= node.end && node.end <= segEnd))
                cnt++;
            */
            if((segEnd < node.start) || node.end < segStart) 
                continue;
            cnt++;
        }
        
        max = Math.max(max, cnt);
    }
}