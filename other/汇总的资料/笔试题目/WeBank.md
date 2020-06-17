Date 20200408

```java
/**
 * 微众 第 1 题，最小花费问题
 */
public static void main1(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt(); // n个小朋友
    int m = sc.nextInt(); // m份礼物
    int a = sc.nextInt(); // 每个红包的花费
    int b = sc.nextInt(); // 每个礼物的价值
    sc.close();
    System.out.println(minCost(n, m, a, b));
}
private static int minCost(int n, int m, int a, int b) {
    if (n > m) { // 当人数大于礼物数时
        // 此时对于 (人数和礼物数) 的差值，要么发红包，要么买新礼物，且 红包数+新礼物数 = n - m
        // 此时当然是选 单个红包和礼物中较便宜的那个。
        return (n - m) * Math.min(a, b);
 
    } else if (m % n == 0){ // 当可以完全均分时，不需要额外花钱
        return 0;
 
    } else { // 其他情况为：当人数小于礼物数时，且不能完全均分时
        // 列出线性规划方程
        // n：总客人数， m：总礼物数
        // x：离开多少人，y：买多少礼物，k的目的是：让礼物能完全均分，k必须是自然数
        // 方程1：k * (n - x) = m + y
        // 方程2：minCost = x * a + y * b，求能使minCost最小的 x 和 y。
        int res = Integer.MAX_VALUE;
 
        // redPacketNum代表发几个红包，最多只需要发 n-1 个红包
        for (int redPacketNum = 1; redPacketNum < n; redPacketNum++) {
            // 求出当发 redPacketNum 个红包时，需要买的礼物数 buyGiftNum
            if (m % (n - redPacketNum) == 0) {
                res = Math.min(res , redPacketNum * a);
            } else {
                int buyGiftNum = (m / (n - redPacketNum) + 1) * (n - redPacketNum) - m;
                res = Math.min(res , redPacketNum * a + buyGiftNum * b);
            }
        }
        return res;
    }
}
```



```java
/**
 * 微众 第 2 题，先手博弈问题
 */
public static void main2(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < t; i++) {
        String str = sc.nextLine();
        System.out.println(whoWin(str));
    }
    sc.close();
}
private static String whoWin(String str) {
    String p1 = "Cassidy", p2 = "Eleanore"; // p1先手
    // 判断奇数次字符的个数
    // 若该个数为 奇数次，则无论如何都是 Cassidy 赢；
    // 若该个数为 偶数次，则无论如何都是 Eleanore 赢
    return ((oddCharNum(str) & 1) != 0) ? p1 : p2;
}
 
// 判断一个字符串的出现奇数次字符的个数
private static int oddCharNum(String str) {
    int[] arr = new int[26];
    for (int i = 0; i < str.length(); i++) arr[str.charAt(i) - 'a'] += 1;
 
    int oddNum = 0; // 奇数次字符的个数
    for (int num : arr) {
        if ((num & 1) != 0) oddNum++; // 该字符出现了奇次
    }
    return oddNum;
}
 
//  该方法没有被使用
// 判断一个字符串串能否被重排成回文串
private  static boolean canPalindromic(String str) {
    int[] arr = new int[26];
    for (int i = 0; i < str.length(); i++) arr[str.charAt(i) - 'a'] += 1;
 
    int count = 0;
    // 若有两个以上字符出现了奇次，则一定不是回文串，否则是回文串
    for (int num : arr) {
        if ((num & 1) != 0) { // 出现奇次的字符
            count++;
            if (count >= 2) return false;
        }
    }
    return true;
}
```



```java
public static void webankQ3() {
        //n,代表卡片的数量。
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // n 组数据

        // 使用一个最大堆，排序规则为：
        //    先比较 卡片的额外抽卡次数， 额外抽卡次数最多的卡片 的优先级较高
        //    当 卡片的额外抽卡次数 相同时，再比较该卡能获得的钱数，能获得的钱数最多的卡片 的优先级较高
        PriorityQueue<Card> heap = new PriorityQueue<>((Card p1, Card p2) -> {
            if (p1.num.equals(p2.num)) {
                return p2.money - p1.money;
            } else {
                return p2.num - p1.num;
            }
        });

        for(int i = 0; i < n; i++){
            int money = in.nextInt();
            int num = in.nextInt();
            heap.offer(new Card(money,num));
        }

        int count = 1;
        int sum = 0;
        while (!heap.isEmpty() && count > 0){
            count --;
            Card card = heap.poll();
            count += card.num;
            sum += card.money;
        }
        System.out.println(sum);
    }

    static class Card{
        Integer money;
        Integer num;
        public Card(Integer money, Integer num) {
            this.money = money;
            this.num = num;
        }
    }
```

