import javassist.tools.rmi.Sample;

import java.awt.desktop.SystemSleepEvent;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.util.StringTokenizer;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) throws IOException {
        File file =new File ("input.txt");
        BufferedReader bf = new BufferedReader (new FileReader("input.txt"));
        int numberOfTeam = Integer.parseInt(bf.readLine());
        List<team>tempt1=new ArrayList<team>(Arrays.asList(new team[numberOfTeam]));
        List<team>teamList=new ArrayList<team>(numberOfTeam);

        tempt1.forEach(new Consumer<team>(){
            public void accept(team t) {
                StringTokenizer str= null;
                try {
                    str = new StringTokenizer(bf.readLine()," ");
                    String input_creature=str.nextToken();
                    String input_city=str.nextToken();
                    if(input_city.compareTo("New")==0)
                        input_city = input_city.concat(" ").concat(str.nextToken()).concat(" ").concat(str.nextToken());

                    teamList.add(new team(input_creature,input_city,str.nextToken(),str.nextToken()));

                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        });

        int numberOfMatch = Integer.parseInt(bf.readLine());
        List<match>tempt2=new ArrayList<match>(Arrays.asList(new match[numberOfMatch]));
        List<match>matchList=new ArrayList<match>(numberOfMatch);

        tempt2.forEach(s->{
            StringTokenizer str= null;
            try {
                str = new StringTokenizer(bf.readLine()," ");
                matchList.add(new match(str.nextToken(),str.nextToken(),str.nextToken(),str.nextToken(),str.nextToken(),str.nextToken()));

            } catch (IOException e) {
                e.printStackTrace();
            }

        });
//        matchList.forEach(s->{
//            System.out.println(s.getHome_Region()+" "+s.getGuest_Region());
//        });
System.out.println("Q1: 分別輸出北、中、南區之同區隊伍比賽場數及跨區比賽場數，輸出格式如下：");
//        Region NR_賽場數 CN_賽場數 SU_賽場數
//        Example:
//        NR CN SU
//        NR 15 10 12
//        CN 10 13 18
//        SU 12 18 11

System.out.println("Q1: 分別輸出北、中、南區之同區隊伍比賽場數及跨區比賽場數");
        ArrayList<String> column = new ArrayList<String>(Arrays.asList(new String[]{"NR", "CN", "SU"}));
        ArrayList<String> row = new ArrayList<String>(Arrays.asList(new String[]{"NR", "CN", "SU"}));
        System.out.printf("%10s%5s%5s\n","NR", "CN", "SU");

        List<String> GuestName =matchList.stream().map(s->s.getGuest_Region()).collect(Collectors.toList());
        List<String> HomeName =matchList.stream().map(s->s.getHome_Region()).collect(Collectors.toList());

        row.forEach(r->{
            System.out.printf("%-5s",r);
            column.forEach(c->{
             long result= matchList.stream()
                     .filter(l->l.getHome_Region().compareTo(c)==0&&l.getGuest_Region().compareTo(r)==0)
                     .count();
             System.out.printf("%5d",result);


            });
            System.out.println();

         });
        System.out.println("Q2:請依跨區勝場數高到底，依序印出所有隊伍勝負資訊，如勝場數相同，請依Team-ID排序，輸出格式如下：排名序(1~12) Team-ID    NameCity    Win_#    Loss_#");
        teamList.forEach(s->{

        int winMatch= matchList.stream()
                    .filter(k->k.getHome_Team().compareTo(s.getSymbolize())==0&&k.getHome_Score()>=k.getGuest_Score())
                    .mapToInt(l->l.getHome_Score()).sum();
             winMatch+= matchList.stream()
                    .filter(k->k.getGuest_Team().compareTo(s.getSymbolize())==0&&k.getHome_Score()<k.getGuest_Score())
                    .mapToInt(l->l.getGuest_Score()).sum();

            s.setWin(winMatch);

            int loseMatch= matchList.stream()
                    .filter(k->k.getHome_Team().compareTo(s.getSymbolize())==0&&k.getHome_Score()<k.getGuest_Score())
                    .mapToInt(l->l.getHome_Score()).sum();
            loseMatch+= matchList.stream()
                    .filter(k->k.getGuest_Team().compareTo(s.getSymbolize())==0&&k.getHome_Score()>=k.getGuest_Score())
                    .mapToInt(l->l.getGuest_Score()).sum();

            s.setLose(loseMatch);
            s.setCaculusScore();
        });

        System.out.printf("%5s%15s%15s%15s","Team-ID","NameCity","Win_#","Loss_#\n");
        teamList.stream().sorted((a,b)->a.getWin()-b.getWin()).forEach(s->System.out.printf("%5s%15s%15d%15d\n",s.getId(),s.getCity(),s.getWin(),s.getLose()));




System.out.println("Q3:根據積分高低，分別輸出北(NR)、中(CN)、南區(SU)之各區隊伍之分組排名順序，輸出格式如下：Region排名序(1~4) Team-ID    Name    City    Win_#    Loss_#   積分(高到底)");
        System.out.printf("%10s%10s%20s%10s%10s%10s\n","Team-ID","Name","City"," Win_#"," Loss_#"," 積分(高到底)");
        column.forEach(s->{
            System.out.println(s+": ");
            teamList.stream().filter(k->k.getRegion().compareTo(s)==0).forEach(k->System.out.printf("%10d%10s%20s%10d%10d\n",k.getId(),k.getCreature(),k.getCity(),k.getWin(),k.getLose()));
        });
System.out.println("Q4: 不分區域，根據積分排名順序(高到低)，依序輸出所有隊伍資訊，格式如下：排名序(1~12) Team-ID    Name    City    Win_#    Loss_#   積分(高到底)勝率勝率= Win_# / (Win_# + Loss_#)，小數點以下兩位");
System.out.printf("%15s%15s%15s%15s%15s%15s\n","Team-ID","Name","City","Win_# ","Loss_#","積分(高到底)勝率勝率= Win_# / (Win_# + Loss_#)");
teamList.forEach(s->{ s.setWinRate(); });

teamList.stream().sorted(compareByCaCuLus)
        .forEach(s->System.out.printf("%15d%15s%15s%15d%15d%15d%15.2f\n",s.getId(),s.getCreature(),s.getCity(),s.getWin(),s.getLose(),s.getCaculusScore(),s.getWinRate()));


System.out.println("Q5: 不分區域，根據勝率= Win_# / (Win_# + Loss_#)，依序輸出所有隊伍資訊，格式如下：排名序(1~12) Team-ID    Name    City    Win_#    Loss_#   勝率(高到底)");
        System.out.printf("%15s%15s%15s%15s%15s%15s\n","Team-ID","Name","City","Win_# ","Loss_#","積分(高到底)勝率勝率= Win_# / (Win_# + Loss_#)");

        teamList.stream().sorted(compareByWinRate)
                .forEach(s->System.out.printf("%15d%15s%15s%15d%15d%15d%15.2f\n",s.getId(),s.getCreature(),s.getCity(),s.getWin(),s.getLose(),s.getCaculusScore(),s.getWinRate()));

System.out.println("Q6: 請計算每支隊伍之平均得分與平均失分，(1) 輸出時依照平均得分高到低，(2)輸出時依照平均失分高到低(3) 輸出時依照得失分差(g = 平均得分-平均失分)高到低，輸出格式如下:(平均得分/失分取整數，四捨五入)Team-ID    Name City平均得分平均失分得失分差");
        System.out.println("依照平均得分高到低");
        System.out.printf("%15s%15s%15s%15s%15s%15s\n","Team-ID","Name","City","Win_# ","Loss_#","平均得分","平均失分","平均得分平均失分得失分差");
        teamList.forEach(s->s.setLoseRate());
        teamList.stream().sorted(compareByLoseRate)
                .forEach(s->System.out.printf("%15d%15s%15s%15d%15d%15d%15.2f\n",s.getId(),s.getCreature(),s.getCity(),s.getWin(),s.getLose(),s.getWinRate(),s.getLoseRate(),Math.abs(s.getWinRate()-s.getLose())));



//輸出每支隊伍與同區隊伍與跨區隊伍之勝場數與敗場數，每支隊伍之輸出格式如下:Team-ID NameCity   NR_Win#    NR_Loss#    CN_Win#    Cin_Loss#SU_Win# SU_Loss#



//        Q9: 使用Partitioning先將比賽場次分成同區比賽場次與跨區比賽場次(Map<Bool, List<Game>>)，TRUE為同區，FALSE為跨區，再輸出同區比賽場數與跨區比賽場數(Map<Bool, Int>)，輸出格式如下：TRUENumberFALSENumber

//        Q10: 請依主場區域(Region)，將比賽場次分場三群，再將每群比賽分成勝負兩群(Map<Region, Map<Bool, List<Game>>>)，請輸出各區(三群)比賽之勝負場數(Map<Region, Map<Bool, INT>>)，輸出格式如下：RegionWin_#     Loss_#




    }
   public static  Comparator<team> compareByWinRate = Comparator.comparing(team::getWinRate);
    public static  Comparator<team> compareByCaCuLus = Comparator.comparing(team::getCaculusScore);
    public static  Comparator<team> compareByLoseRate = Comparator.comparing(team::getLoseRate);
}
