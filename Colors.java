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

    public static void main (String[] args){
        ArrayList<String> colors = new ArrayList<>();

        colors.add("red");
        colors.add("green");
        colors.add("blue");
        colors.add("yellow");
        colors.add("purple");
        colors.add("orange");

        swapColors(colors);

        System.out.println(colors);
    }
}