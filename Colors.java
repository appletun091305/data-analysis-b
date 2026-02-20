// import java.util.ArrayList;

// public class Colors {
//   public static void swapColors(ArrayList<String> list) {
//     for (int i = 0; i < list.size() - 1 ; i+= 2) {
//         String temp = list.get(i);
//         list.set(i, list.get(i+1));
//         list.set(i+1, temp);
//     }
//   }

//   public static void main(String[] args) {
//       ArrayList<String> colorsOne = new ArrayList<>();
//       colorsOne.add("red");
//       colorsOne.add("blue");
//       colorsOne.add("green");
//       colorsOne.add("yellow");
//       colorsOne.add("orange");
//     //   colorsOne.add("purple");

//     //   Colors color = new Colors();
//     swapColors(colorsOne);
//       System.out.println(colorsOne);
//   }
// }


// import java.util.ArrayList;

// public class Colors{
//     public static void swapColors(ArrayList<String> list){
//         for (int i=0; i < list.size() -1; i+=2){
//             String temp = list.get(i);
//             list.set(i, list.get(i+1));
//             list.set(i+1, temp);
//         }
//     }

//     public static void main(String[] args) {
//         ArrayList<String> colors = new ArrayList<>();
//         colors.add("red");
//         colors.add("blue");
//         colors.add("yellow");
//         colors.add("green");
//         colors.add("purple");
//         colors.add("orange");

//         swapColors(colors);
//         System.out.println(colors);
//     }
// }

import java.util.ArrayList;

public class Colors{
    public static void swapColors(ArrayList<String> list){
        for (int i = 0; i < list.size() - 1; i+=2){
            String temp = list.get(i);
            list.set(i, list.get(i+1));
            list.set(i+1, temp);
        }
    }

    public static int getPeakIndex(ArrayList<Integer> a) {
    for (int i = 1; i < a.size() - 1; i++) {
        if (a.get(i) > a.get(i - 1) && a.get(i) > a.get(i + 1)) {
            return i;
        }
    }
    
    return -1;
}

    public static void main (String[] args){
        ArrayList<String> colors = new ArrayList<>();

        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("yellow");
        colors.add("purple");
        colors.add("orange");

        swapColors(colors);

        // System.out.println(colors);

        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(3);
        numbers.add(5);
        numbers.add(4);
        numbers.add(2);
        System.out.println(getPeakIndex(numbers));
    }   
}