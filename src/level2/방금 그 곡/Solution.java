import java.util.*;

public class Music {
    private int time;
    private String title;
    private String play;
    
    public Music(int time, String title, String play) {
        this.time = time;
        this.title = title;
        this.play = play;
    }
    
    public int getTime() {
        return time;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getPlay() {
        return play;
    }
}


class Solution {
    static Music[] musics;
    static List<Integer> index = new ArrayList<>();
    
    public String solution(String m, String[] musicinfos) {
        
        musics = new Music[musicinfos.length];
        
        makeMusicsArray(musicinfos);
        containsMelody(deleteSharp(m));
        
        int max = 0;
        int maxIdx = 0;
        
        if(index.isEmpty()) 
            return "(None)";
        
        for(int idx: index) {
            if(musics[idx].getTime() > max) {
                max = musics[idx].getTime();
                maxIdx = idx;
            }
        }
        
        return musics[maxIdx].getTitle();
    }
    
    private void containsMelody(String melody) {
        for(int i=0; i<musics.length; i++) {
            String play = musics[i].getPlay();
            
            for(int j=0; j<=play.length()-melody.length(); j++) {
                String part = play.substring(j, j+melody.length());
                
                if(part.equals(melody)) 
                    index.add(i);
            }
        }
    }
    
    private void makeMusicsArray(String[] musicinfos) {
        int idx = 0;
        
        for(String str: musicinfos) {
            String[] infos = str.split(",");
            
            int time = runningTime(infos[0], infos[1]);
            String title = infos[2];
            String play = howPlayed(time, deleteSharp(infos[3]));
            
            musics[idx++] = new Music(time, title, play);
        }
    }
    
    private int runningTime(String start, String end) {  
        int hour = Integer.parseInt(end.substring(0,2)) - Integer.parseInt(start.substring(0,2));
        int min = Integer.parseInt(end.substring(3,5)) - Integer.parseInt(start.substring(3,5));
        
        return hour*60 + min;
    }
    
    private String howPlayed(int time, String score) {
        StringBuilder sb = new StringBuilder();
        
        while(sb.length() < time) 
            sb.append(score);
        
        return sb.substring(0, time);
    }
    
    private String deleteSharp(String score) {
        score = score.replaceAll("C#", "c");
        score = score.replaceAll("D#", "d");
        score = score.replaceAll("F#", "f");
        score = score.replaceAll("G#", "g");
        score = score.replaceAll("A#", "a");
        
        return score;
    }
}